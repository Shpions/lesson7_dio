package com.dio.lesson7;

import java.util.ArrayList;

public class Validate_Person {
    public void validarePerson(ArrayList <Person> list){
        //local code review (vtegza): use readable names @ 3/2/2015
        String s ="";
        boolean b = false;
        for(Person p : list){
            if(p.getName().isEmpty() || p.getName() == null){
                s += "not valid name\n";
                b = true;
            }
            if(p.getAge() <= 0){
                s += "not valid age\n";
                b = true;
            }
            if(p.getMail().isEmpty() || p.getMail() == null){
                s += "not valid mail\n";
                b = true;
            }
            if(p.getNumber() <= 0){
                s += "not valid number\n";
                b = true;
            }
        }
        if(b){
            throw new ArrayIndexOutOfBoundsException(s);
        }
    }
}
