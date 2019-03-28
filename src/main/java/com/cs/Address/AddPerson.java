package com.cs.Address;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import com.cs.Address.AddressBookProtos.AddressBook;
import com.cs.Address.AddressBookProtos.Person;

class AddPerson {
  // This function fills in a Person message based on user input.
  static Person PromptForAddress(BufferedReader stdin,
                                 PrintStream stdout) throws IOException {
    Person.Builder person = Person.newBuilder();

    stdout.print("Enter person ID: ");
    //person.setId(Integer.valueOf(stdin.readLine()));
    person.setId(123);

    stdout.print("Enter name: ");
    //person.setName(stdin.readLine());
    person.setName("Parashuram");

    stdout.print("Enter email address (blank for none): ");
    String email = "parashuram.patil@contentserv.com";//stdin.readLine();
    if (email.length() > 0) {
      person.setEmail(email);
    }
    
    Person.PhoneNumber.Builder phoneNumber1 =
        Person.PhoneNumber.newBuilder().setNumber("8147417170");
    phoneNumber1.setType(Person.PhoneType.MOBILE);
    Person.PhoneNumber.Builder phoneNumber2 =
        Person.PhoneNumber.newBuilder().setNumber("9156012367");
    phoneNumber2.setType(Person.PhoneType.HOME);
    
    person.addPhones(phoneNumber1);
    person.addPhones(phoneNumber2);

    /*while (true) {
      stdout.print("Enter a phone number (or leave blank to finish): ");
      String number = stdin.readLine();
      if (number.length() == 0) {
        break;
      }

      Person.PhoneNumber.Builder phoneNumber =
        Person.PhoneNumber.newBuilder().setNumber(number);

      stdout.print("Is this a mobile, home, or work phone? ");
      String type = stdin.readLine();
      if (type.equals("mobile")) {
        phoneNumber.setType(Person.PhoneType.MOBILE);
      } else if (type.equals("home")) {
        phoneNumber.setType(Person.PhoneType.HOME);
      } else if (type.equals("work")) {
        phoneNumber.setType(Person.PhoneType.WORK);
      } else {
        stdout.println("Unknown phone type.  Using default.");
      }

      person.addPhones(phoneNumber);
    }*/

    return person.build();
  }

  // Main function:  Reads the entire address book from a file,
  //   adds one person based on user input, then writes it back out to the same
  //   file.
  public static void main(String[] args) throws Exception {
    
    //System.out.println(System.getProperty("user.dir"));
    
    if (args.length != 1) {
      System.err.println("Usage:  AddPerson ADDRESS_BOOK_FILE");
      System.exit(-1);
    }

    AddressBook.Builder addressBook = AddressBook.newBuilder();

    // Read the existing address book.
    try {
      addressBook.mergeFrom(new FileInputStream(args[0]));
    } catch (FileNotFoundException e) {
      System.out.println(args[0] + ": File not found.  Creating a new file.");
    }

    // Add an address.
    /*addressBook.addPeople(
      PromptForAddress(new BufferedReader(new InputStreamReader(System.in)),
                       System.out));*/

    // Write the new address book back to disk.
    FileOutputStream output = new FileOutputStream(args[0]);
    addressBook.build().writeTo(output);
    output.close();
    
    System.out.println("\n\n****************************\n" + addressBook);
    
    String adressString = "people {\r\n" + 
        "  name: \"Osho\"\r\n" + 
        "  id: 321\r\n" + 
        "  email: \"Osho.sahil@contentserv.com\"\r\n" + 
        "  phones {\r\n" + 
        "    number: \"7760896521\"\r\n" + 
        "    type: MOBILE\r\n" + 
        "  }\r\n" + 
        "  phones {\r\n" + 
        "    number: \"8986524135\"\r\n" + 
        "    type: HOME\r\n" + 
        "  }\r\n" + 
        "}";
    
    AddressBook.Builder addressBookString = AddressBook.newBuilder();
    addressBookString.mergeFrom(adressString.getBytes());
    
    
 
  }
}