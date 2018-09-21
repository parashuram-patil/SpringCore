package com.cs.proto.person;

import com.cs.proto.compile.person.PersonProto.Person;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

public class PersonDemo {
  
  public static void main(String[] args) throws InvalidProtocolBufferException
  {
    Person.Builder person = Person.newBuilder();
    person.setAge(27);
    person.setEmail("a@a.a");
    person.setName("Psp");

    System.out.println(JsonFormat.printer().print(person));
    
    String personString = "{\r\n" + 
        "  \"name\": \"Psp\",\r\n" + 
        "  \"email\": \"a@a.a\",\r\n" + 
        "  \"age\": 27\r\n" + 
        "}";
    Person.Builder person1 = Person.newBuilder();
    JsonFormat.parser().merge(personString, person1);
    System.out.println(person1);
    
  }
}
