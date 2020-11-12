package com.baton.azhar.tradematchingservice.model;


public class Order {
    private String party;
    private String stock;
    private String type;
    private int price;
    private String status = "pending";

    public Order() {
    }

    public Order(String party, String stock, String type, int price) {
        this.party = party;
        this.stock = stock;
        this.type = type;
        this.price = price;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
