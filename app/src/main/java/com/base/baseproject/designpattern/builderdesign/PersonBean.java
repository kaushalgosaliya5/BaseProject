package com.base.baseproject.designpattern.builderdesign;

public class PersonBean {

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String fatherName;
    private String motherName;
    private double height;
    private double weight;

    public static class Builder{

        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private String fatherName;
        private String motherName;
        private double height;
        private double weight;

        public Builder(String firstName,String lastName,int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }


        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setFatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder setMotherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public PersonBean build(){
            return  new PersonBean(this);
        }
    }

    public PersonBean(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}


//    public PersonBean(String firstName, String middleName, String lastName, int age) {
//        // this(firstName,middleName,lastName,age);
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//
//    public PersonBean(String firstName,String lastName,int age){
//        this(firstName,null,lastName,age);
//    }
//
//    public PersonBean(String firstName,int age){
//        this(firstName,null,age);
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
