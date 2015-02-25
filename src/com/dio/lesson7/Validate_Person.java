package com.dio.lesson7;

import java.util.ArrayList;
import java.util.ServiceConfigurationError;

public class Validate_Person {
    public void validarePerson(ArrayList <Person> list){
        for(Person p : list){
            if(p.getName().isEmpty() || p.getName() == null){
                throw new ArrayIndexOutOfBoundsException("not valid name");
            }
            else if(p.getAge() <= 0){
                throw new NumberFormatException("not valid Age");
            }
            if(p.getMail().isEmpty() || p.getMail() == null){
                throw new ServiceConfigurationError("not valid Mail");
            }
            if(p.getNumber() <= 0){
                throw new ArithmeticException("not valid Number");
            }
        }
    }
}
