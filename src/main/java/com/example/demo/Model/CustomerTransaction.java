package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CustomerTransaction extends Transaction{

    @Id
    @GeneratedValue
    private long id;
    private long customerId;

    public CustomerTransaction(double paid, LocalDate date, String comment, long customerId) {
        super(paid, date, comment);
        this.customerId = customerId;
    }

    public CustomerTransaction() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerTransaction{" +
                "id=" + id +
                ", customerId=" + customerId + ", "+super.toString()+
                '}';
    }
}

