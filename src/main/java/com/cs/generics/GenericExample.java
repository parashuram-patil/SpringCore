package com.cs.generics;

import java.util.List;

class GenericExample implements IChildInterface1 {
  
  @Override
  public void myGenericMethod(List<String> param) throws Exception
  {
    
  }
}

class Class2 implements IChildInterface2 {
  
  @Override
  public void myGenericMethod(List<Integer> param) throws Exception
  {
    
  }
}

interface IChildInterface1 extends IParentInterface<List<String>> {
  
}

interface IChildInterface2 extends IParentInterface<List<Integer>> {
  
}

interface IParentInterface<P extends List<?>> {
  
  public void myGenericMethod(P param) throws Exception;
  
}
