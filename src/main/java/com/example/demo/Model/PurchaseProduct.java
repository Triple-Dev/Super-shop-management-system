package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PurchaseProduct {

    @Id
    @GeneratedValue
    private long purchaseProductId;
    private long productId;
    private double quantity;

    public PurchaseProduct(long productId, double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public PurchaseProduct() {
    }

    public long getPurchaseProductId() {
        return purchaseProductId;
    }

    public void setPurchaseProductId(long purchaseProductId) {
        this.purchaseProductId = purchaseProductId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PurchaseProduct{" +
                "purchaseProductId=" + purchaseProductId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
