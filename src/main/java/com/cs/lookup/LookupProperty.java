package com.cs.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class LookupProperty {
  
  private String  propertyOne;
  private Integer propertyTwo;
  
  public String getPropertyOne()
  {
    return propertyOne;
  }
  
  public Integer getPropertyTwo()
  {
    return propertyTwo;
  }
  
}
