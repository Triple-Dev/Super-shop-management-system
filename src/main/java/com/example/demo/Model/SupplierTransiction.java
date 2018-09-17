package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class SupplierTransiction extends Transaction{

    @Id
    @GeneratedValue
    private long id;
    private String supplierName;

    public SupplierTransiction(double paid, LocalDate date, String comment, String supplierName) {
        super(paid, date, comment);
        this.supplierName = supplierName;
    }

    public SupplierTransiction() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "SupplierTransiction{" +
                "id=" + id +
                ", supplierId=" + supplierName +", "+super.toString()+
                '}';
    }
}
