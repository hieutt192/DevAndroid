package com.example.test26_04.models;

import java.io.Serializable;

public class Order implements Serializable {
    String maOrder, nameCus,status;
    int quantity;
    float total;

    public Order(String maOrder, String nameCus, String status, int quantity, float total) {
        this.maOrder = maOrder;
        this.nameCus = nameCus;
        this.status = status;
        this.quantity = quantity;
        this.total = total;
    }

    public String getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(String maOrder) {
        this.maOrder = maOrder;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
