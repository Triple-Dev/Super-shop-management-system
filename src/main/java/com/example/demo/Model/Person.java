package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

@MappedSuperclass
public class Person {

    private String firstname;
    private String lastName;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Address> addressList;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Phone> phoneList;
    private String emailAddress;
    private Gender gender;

    public Person(String firstname, String lastName, List<Address> addressList, List<Phone> phoneList, String emailAddress, Gender gender) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.addressList = addressList;
        this.phoneList = phoneList;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public Person() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressList=" + addressList +
                ", phoneList=" + phoneList +
                ", gender=" + gender +
                '}';
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
