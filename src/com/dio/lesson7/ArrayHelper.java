package com.dio.lesson7;

import java.util.ArrayList;
import java.util.HashSet;


public class ArrayHelper {


    public ArrayList <Person> merge(ArrayList <Person> leftArray, ArrayList <Person> rightArray) {
        HashSet<Person> result = new HashSet<Person>(leftArray);
        result.addAll(rightArray);
        return new ArrayList<Person>(result);
    }

    public ArrayList <Person> innerUnion(ArrayList <Person> leftArray, ArrayList <Person> rightArray) {
        HashSet <Person> result = new HashSet<Person>();

        for(Person person : leftArray){
            if(rightArray.contains(person)){
                result.add(person);
            }
        }
        for(Person person : rightArray){
            if(leftArray.contains(person)){
                result.add(person);
            }
        }

        return new ArrayList<Person>(result);
    }

    public ArrayList <Person> outerUnion (ArrayList <Person> leftArray,  ArrayList <Person> rightArray) {
        HashSet <Person> result = new HashSet<Person>();

        for(Person person : leftArray){
            if(!rightArray.contains(person)){
                result.add(person);
            }
        }
        for(Person person : rightArray){
            if(!leftArray.contains(person)){
                result.add(person);
            }
        }

        return new ArrayList<Person>(result);
    }
}
