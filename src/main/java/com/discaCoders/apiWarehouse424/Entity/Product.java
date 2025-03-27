package com.discaCoders.apiWarehouse424.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private  String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public void increaseQuantity(int amount){
        if(amount < 0){
            throw new IllegalArgumentException("La cantidad debe ser positiva y mayor a cero");
        }
        this.quantity += amount;
    }
    public void decreaseQuantity(int amount){
        if(amount < 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        if ((this.quantity - amount) < 0){
            throw new IllegalArgumentException("No hay suficiente stock");
        }
        this.quantity -= amount;
    }
}
