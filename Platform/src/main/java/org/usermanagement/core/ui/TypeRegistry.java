package org.usermanagement.core.ui;

public interface TypeRegistry
{
  public void register(String paramString);
  
  public boolean isRegistered(String paramString);
  
  public void remove(String paramString);
}
