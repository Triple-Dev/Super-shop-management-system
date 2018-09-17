package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Supplier {

    @Id
    private String supplierName;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Address> supplierAddress;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Phone> phoneList;
    private double totalProductPrice;
    private double totalPaid;
    private double due;

    public Supplier(String supplierName, List<Address> supplierAddress, List<Phone> phoneList, double totalProductPrice, double totalPaid, double due) {
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.phoneList = phoneList;
        this.totalProductPrice = totalProductPrice;
        this.totalPaid = totalPaid;
        this.due = due;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<Address> getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(List<Address> supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public double getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(double totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierName='" + supplierName + '\'' +
                ", supplierAddress=" + supplierAddress +
                ", phoneList=" + phoneList +
                ", totalProductPrice=" + totalProductPrice +
                ", totalPaid=" + totalPaid +
                ", due=" + due +
                '}';
    }
}
