package com.cs.model;

enum GenderEnum
{
  MALE, FEMALE
}

public class Person {
  
  String  name;
  String  gender;
  Integer mobileNumber;
  
  public Person(String name, String gender, Integer mobileNumber)
  {
    this.name = name;
    this.gender = gender;
    this.mobileNumber = mobileNumber;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getGender()
  {
    return gender;
  }
  
  public void setGender(String gender)
  {
    this.gender = gender;
  }
  
  public Integer getMobileNumber()
  {
    return mobileNumber;
  }
  
  public void setMobileNumber(Integer mobileNumber)
  {
    this.mobileNumber = mobileNumber;
  }
}