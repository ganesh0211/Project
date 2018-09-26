package org.usermanagement.core.ui.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.usermanagement.core.db.PersistenceHandler;
import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Simple;
import org.usermanagement.core.ui.ObjectConstructor;
import org.usermanagement.core.ui.TypeRegistry;

@Component
public class ObjectConstructorImpl
  implements ObjectConstructor
{
  private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
  private static final String DOT = ".";
  private static final String JAVALANG = "java.lang";
  private static final int LOWERINDEX = 0;
  private static final int UPPERINDEX = 9;
  private static Logger logger = Logger.getLogger(ObjectConstructor.class.getName());
  @Autowired
  private PersistenceHandler persistenceHandler;
  @Autowired
  private TypeRegistry typeRegistry;
  
  public ObjectConstructorImpl() {}
  
  public Object constructObject(HttpServletRequest request)
  {
    try
    {
      String className = request.getParameter("entityName");
      if (className == null) {
        throw new Exception("No entityName known");
      }
      return constructObject(request, Class.forName(className));
    }
    catch (Exception ex)
    {
      logger.error(ex);
    }
    return null;
  }
  
  public void populateFormDetails(Object obj, ModelMap modelMap)
  {
    List<Field> fields = getFields(obj.getClass());
    for (Field descriptor : fields)
    {
      descriptor.setAccessible(true);
      try
      {
        if ((descriptor.getType().isAssignableFrom(List.class)) || (this.typeRegistry.isRegistered(descriptor.getType().getName())))
        {
          if (descriptor.getType().isAssignableFrom(Date.class))
          {
            Date date = (Date)descriptor.get(obj);
            if (date != null) {
              modelMap.put(descriptor.getName(), sdf.format(descriptor.get(obj)));
            }
          }
          else
          {
            modelMap.put(descriptor.getName(), descriptor.get(obj));
          }
        }
        else if (Core.class.isAssignableFrom(descriptor.getType()))
        {
          Core core = (Core)descriptor.get(obj);
          if (core != null)
          {
            modelMap.put(descriptor.getName() + "_id", Long.valueOf(core.getId()));
            modelMap.put(descriptor.getName() + "_name", core.getName());
          }
        }
        else if (Simple.class.isAssignableFrom(descriptor.getType()))
        {
          Simple simple = (Simple)descriptor.get(obj);
          if (simple != null) {
            modelMap.put(descriptor.getName() + "_id", Long.valueOf(simple.getId()));
          }
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  
  private Class<?> getClazz(String className)
  {
    try
    {
      return Class.forName(className);
    }
    catch (Exception ex) {}
    return null;
  }
  
  private List<Field> getFields(Class<?> entityClass)
  {
    List<Field> fieldList = new LinkedList();
    try
    {
      Field[] fields = entityClass.getDeclaredFields();
      for (Field field : fields) {
        fieldList.add(field);
      }
      for (entityClass = entityClass.getSuperclass(); (entityClass != null) && (!entityClass.getName().substring(0, 9).equals("java.lang")); entityClass = entityClass.getSuperclass())
      {
        Field[] superClassFields = entityClass.getDeclaredFields();
        List<Field> superClassFieldList = new ArrayList();
        for (Field field : superClassFields) {
          superClassFieldList.add(field);
        }
        fieldList.addAll(0, superClassFieldList);
      }
    }
    catch (Exception ex)
    {
      logger.error(ex.getMessage());
    }
    return fieldList;
  }
  
  private List<?> getList(HttpServletRequest request, String propertyName, Class<?> elementClazz)
  {
    String[] values = request.getParameterValues(propertyName);
    
    List<Object> list = new ArrayList();
    if (values == null) {
      return list;
    }
    for (int i = 0; i < values.length; i++) {
      try
      {
        Object obj = elementClazz.newInstance();
        PropertyUtils.setSimpleProperty(obj, "id", ConvertUtils.convert(values[i], Long.TYPE));
        
        list.add(obj);
      }
      catch (Exception ex)
      {
        logger.error(ex.getMessage());
      }
    }
    return list;
  }
  
  public Object constructObject(HttpServletRequest request, Class clazz)
  {
    List<Field> fields = getFields(clazz);
    Object obj = null;
    try
    {
      obj = clazz.newInstance();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    for (Field descriptor : fields) {
      try
      {
        descriptor.setAccessible(true);
        if (descriptor.getType().isAssignableFrom(List.class))
        {
          Type type = descriptor.getGenericType();
          Type elementType = null;
          if ((type instanceof ParameterizedType))
          {
            ParameterizedType pt = (ParameterizedType)type;
            elementType = pt.getActualTypeArguments()[0];
          }
          List<?> values = getList(request, descriptor.getName(), elementType.getClass());
          PropertyUtils.setSimpleProperty(obj, descriptor.getName(), values);
        }
        else if (this.typeRegistry.isRegistered(descriptor.getType().getName()))
        {
          obj = populateField(obj, descriptor, request.getParameter(descriptor.getName()));
        }
        else
        {
          Class<?> compositeClass = getClazz(descriptor.getType().getName());
          try
          {
            Object componentObj = this.persistenceHandler.getObjectById(compositeClass, Long.parseLong(request.getParameter(descriptor.getName() + ".id")));
            
            PropertyUtils.setSimpleProperty(obj, descriptor.getName(), componentObj);
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
        }
      }
      catch (Exception ex)
      {
        logger.error(ex.getMessage());
      }
    }
    return obj;
  }
  
  private static Object populateField(Object obj, Field field, String value)
    throws Exception
  {
    if (field.getType().getName().equals("boolean"))
    {
      if ((value == null) || (value.equals("false")) || (value.equals(""))) {
        PropertyUtils.setNestedProperty(obj, field.getName(), Boolean.valueOf(false));
      } else {
        PropertyUtils.setNestedProperty(obj, field.getName(), Boolean.valueOf(true));
      }
    }
    else if ((field.getType().isPrimitive()) || (field.getType().getName().substring(0, 9).equals("java.lang")) || (field.getType().getName().substring(0, 9).equals("java.util")))
    {
      if (field.getType().getName().equals("java.util.Date"))
      {
        if ((value != null) && (!value.equals("")))
        {
          Pattern dateOnlyPattern = Pattern.compile("([0-9]{1,2})(-)([a-zA-Z]{3})(-)([0-9]{4})");
          Matcher dateOnlyMatcher = dateOnlyPattern.matcher(value);
          if (dateOnlyMatcher.find()) {
            value = value + " 00:00:00";
          }
          PropertyUtils.setNestedProperty(obj, field.getName(), sdf.parseObject(value));
        }
      }
      else if (field.getType().getName().equals("java.lang.Long")) {
        try
        {
          PropertyUtils.setNestedProperty(obj, field.getName(), new Long(value));
        }
        catch (NumberFormatException ex)
        {
          logger.error(ex);
        }
      } else if (field.getType().getName().equals("java.lang.Double")) {
        try
        {
          PropertyUtils.setNestedProperty(obj, field.getName(), new Double(value));
        }
        catch (NumberFormatException ex)
        {
          logger.error(ex.getMessage());
        }
      } else {
        PropertyUtils.setNestedProperty(obj, field.getName(), ConvertUtils.convert(value, field.getType()));
      }
    }
    else if (field.getType().isEnum())
    {
      Object[] enumConstants = field.getType().getEnumConstants();
      for (Object enumConstant : enumConstants) {
        if (enumConstant.toString().equals(value)) {
          PropertyUtils.setNestedProperty(obj, field.getName(), enumConstant);
        }
      }
    }
    return obj;
  }
}
