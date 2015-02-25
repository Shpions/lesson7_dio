package com.dio.lesson7;

import java.util.ArrayList;

public class ServiceDelegate {
    private final ArrayHelper resourse;
    private final Validate_Person valid;

    public ServiceDelegate(ArrayHelper resourse, Validate_Person valid) {
        this.resourse = resourse;
        this.valid = valid;
    }

    public ArrayList <Person> merge(ArrayList<Person> leftArray, ArrayList <Person> rightArray) {
        valid.validarePerson(leftArray);
        valid.validarePerson(rightArray);

        ArrayList<Person> result = resourse.merge(leftArray, rightArray);

        return result;
    }

    public ArrayList <Person> innerUnion(ArrayList <Person> leftArray, ArrayList <Person> rightArray) {
        valid.validarePerson(leftArray);
        valid.validarePerson(rightArray);

        ArrayList<Person> result = resourse.innerUnion(leftArray, rightArray);

        return result;
    }

    public ArrayList <Person> outerUnion (ArrayList <Person> leftArray,  ArrayList <Person> rightArray) {
        valid.validarePerson(leftArray);
        valid.validarePerson(rightArray);

        ArrayList<Person> result = resourse.outerUnion(leftArray, rightArray);

        return result;
    }
}

