package org.usermanagement.core.ui;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

public interface ObjectConstructor{
  public Object constructObject(HttpServletRequest paramHttpServletRequest, Class paramClass);
  public Object constructObject(HttpServletRequest paramHttpServletRequest);
  public void populateFormDetails(Object paramObject, ModelMap paramModelMap);
}
