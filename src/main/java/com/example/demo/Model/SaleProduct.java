package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class SaleProduct {

    @Id
    @GeneratedValue
    private long saleProductId;
    private long productId;
    private double quantity;

    public long getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(long saleProductId) {
        this.saleProductId = saleProductId;
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
}
