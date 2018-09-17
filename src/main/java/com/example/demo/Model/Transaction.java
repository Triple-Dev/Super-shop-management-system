package com.example.demo.Model;


import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Transaction {

    private double paid;
    private LocalDate date;
    private String comment;

    public Transaction(double paid, LocalDate date, String comment) {
        this.paid = paid;
        this.date = date;
        this.comment = comment;
    }

    public Transaction() {
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "paid=" + paid +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }
}
