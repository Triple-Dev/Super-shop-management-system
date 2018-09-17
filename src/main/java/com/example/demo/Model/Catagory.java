package com.example.demo.Model;



import javax.persistence.*;
import java.util.List;

@Entity
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String catagoryName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    private String discription;


    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    @Override
    public String toString() {
        return "Catagory{" +
                "id=" + id +
                ", catagoryName='" + catagoryName + '\'' +
                ", productList=" + productList +
                ", discription='" + discription + '\'' +
                '}';
    }

    public Catagory(String catagoryName, List<Product> productList, String discription) {
        this.catagoryName = catagoryName;
        this.productList = productList;
        this.discription = discription;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Catagory() {

    }


}
