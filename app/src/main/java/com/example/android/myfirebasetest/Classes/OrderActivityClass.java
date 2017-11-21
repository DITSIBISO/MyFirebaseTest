package com.example.android.myfirebasetest.Classes;

/**
 * Created by eKasiLab Alex CDTB on 2017/10/24.
 */

public class OrderActivityClass {
    private String name;
    private int Orderquantity;

    public OrderActivityClass() {
    }

    public OrderActivityClass(String name, int orderquantity) {
        this.name = name;
        Orderquantity = orderquantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderquantity() {
        return Orderquantity;
    }

    public void setOrderquantity(int orderquantity) {
        Orderquantity = orderquantity;
    }
}
