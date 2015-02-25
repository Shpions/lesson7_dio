package com.dio.lesson7;

public class Person implements Comparable<Person>{
    private final String name;
    private final String mail;
    private final int age;
    private final int number;

    private Person(Builder builder) {
        this.name = builder.name;
        this.mail = builder.mail;
        this.age = builder.age;
        this.number = builder.number;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (number != person.number) return false;
        if (mail != null ? !mail.equals(person.mail) : person.mail != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }

    public static class Builder{
        private String name;
        private String mail;
        private int age;
        private int number;

        public Builder() {
        }

        public Builder(Person person) {
            this.mail = person.mail;
            this.name = person.name;
            this.age = person.age;
            this.number = person.number;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
