package com.example.demo.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String productGroup;
    private double parchasePrice;
    private double salePrice;
    private Type quantityType;
    private double quantity;
    private double discountAmount;
    private double discountParsentage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public double getParchasePrice() {
        return parchasePrice;
    }

    public void setParchasePrice(double parchasePrice) {
        this.parchasePrice = parchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public Type getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Type quantityType) {
        this.quantityType = quantityType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountParsentage() {
        return discountParsentage;
    }

    public void setDiscountParsentage(double discountParsentage) {
        this.discountParsentage = discountParsentage;
    }
}
