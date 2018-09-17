package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer extends Person{

    @Id
    @GeneratedValue
    private long id;
    private double openingBalance;
    private double totalPurchased;
    private double totalpaid;
    private double balance;
    private LocalDate startingDate;

    public Customer(String firstname, String lastName, List<Address> addressList, List<Phone> phoneList, String emailAddress, Gender gender, double openingBalance, double totalPurchased, double totalpaid, double balance, LocalDate startingDate) {
        super(firstname, lastName, addressList, phoneList, emailAddress, gender);
        this.openingBalance = openingBalance;
        this.totalPurchased = totalPurchased;
        this.totalpaid = totalpaid;
        this.balance = balance;
        this.startingDate = startingDate;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public double getTotalPurchased() {
        return totalPurchased;
    }

    public void setTotalPurchased(double totalPurchased) {
        this.totalPurchased = totalPurchased;
    }

    public double getTotalpaid() {
        return totalpaid;
    }

    public void setTotalpaid(double totalpaid) {
        this.totalpaid = totalpaid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", openingBalance=" + openingBalance +
                ", totalPurchased=" + totalPurchased +
                ", totalpaid=" + totalpaid +
                ", balance=" + balance +
                ", startingDate=" + startingDate + ", "+super.toString()+
                '}';
    }

}
