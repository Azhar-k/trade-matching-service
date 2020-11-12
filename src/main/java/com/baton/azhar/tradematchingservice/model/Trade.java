package com.baton.azhar.tradematchingservice.model;

import java.util.Date;

public class Trade {
    private String buyer;
    private String seller;
    private String stock;
    private int price;
    private Date date;

    public Trade(String buyer, String seller, String stock, int price, Date date) {
        this.buyer = buyer;
        this.seller = seller;
        this.stock = stock;
        this.price = price;
        this.date = date;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
