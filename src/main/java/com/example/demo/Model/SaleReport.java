package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class SaleReport {

    @Id
    @GeneratedValue
    private long invoice;
    private LocalDate dueDate;
    private LocalDate saleDate;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<SaleProduct> saleProductList;
    private long salesmanId;
    private long customerId;
    private double totalCost;
    private double discountAmount;
    private double discountPersentage;
    private double paid;

    public long getInvoice() {
        return invoice;
    }

    public void setInvoice(long invoice) {
        this.invoice = invoice;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public List<SaleProduct> getSaleProductList() {
        return saleProductList;
    }

    public void setSaleProductList(List<SaleProduct> saleProductList) {
        this.saleProductList = saleProductList;
    }

    public long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(long salesmanId) {
        this.salesmanId = salesmanId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPersentage() {
        return discountPersentage;
    }

    public void setDiscountPersentage(double discountPersentage) {
        this.discountPersentage = discountPersentage;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }
}
