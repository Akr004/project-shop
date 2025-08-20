package com.shoping.app.practice;

import java.util.List;

public class Order {

    private int orderId;
    private String customerName;
    private String orderDate;
    private List<Item> items; // One-to-many relationship

    // Constructors
    public Order() {}

    public Order(int orderId, String customerName, String orderDate, List<Item> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.items = items;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", items=" + items +
                '}';
    }
}
