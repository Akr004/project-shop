package com.shoping.app.practice;

import java.util.Arrays;
import java.util.List;

public class OrderTest {

    public static void main(String[] args) {

        // Items for first order
        Item i1 = new Item(1, "Laptop", 1, 75000);
        Item i2 = new Item(2, "Mouse", 2, 500);

        // Items for second order
        Item i3 = new Item(3, "Keyboard", 1, 1200);
        Item i4 = new Item(4, "Monitor", 2, 15000);

        // Items for third order
        Item i5 = new Item(5, "Pen Drive", 5, 600);
        Item i6 = new Item(6, "Headphones", 1, 2000);

        // Items for fourth order
        Item i7 = new Item(7, "Chair", 1, 5000);
        Item i8 = new Item(8, "Desk", 1, 12000);

        // Items for fifth order
        Item i9 = new Item(9, "Notebook", 10, 200);
        Item i10 = new Item(10, "Stapler", 2, 300);

        // Items for sixth order
        Item i11 = new Item(11, "Tablet", 1, 25000);
        Item i12 = new Item(12, "Stylus", 1, 1500);

        // Orders
        Order o1 = new Order(101, "Alice", "2025-08-18", Arrays.asList(i1, i2));
        Order o2 = new Order(102, "Bob", "2025-08-18", Arrays.asList(i3, i4));
        Order o3 = new Order(103, "Charlie", "2025-08-18", Arrays.asList(i5, i6));
        Order o4 = new Order(104, "David", "2025-08-18", Arrays.asList(i7, i8));
        Order o5 = new Order(105, "Eve", "2025-08-18", Arrays.asList(i9, i10));
        Order o6 = new Order(106, "Frank", "2025-08-18", Arrays.asList(i11, i12));

        List<Order> orders = Arrays.asList(o1, o2, o3, o4, o5, o6);


    }
}
