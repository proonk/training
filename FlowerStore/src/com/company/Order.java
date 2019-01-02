package com.company;

import flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> orderList = new ArrayList<Product>();
    private List<Integer> orderQuantity = new ArrayList<Integer>();
    private boolean flowersAsBouquet = false;

    private static Order ourInstance = new Order();

    public static Order access() {
        return ourInstance;
    }

    private Order() {
    }

    public List<Product> getOrderList() {
        return orderList;
    }

    public List<Integer> getOrderQuantity() {
        return orderQuantity;
    }

    public void setFlowersAsBouquet(boolean flowersAsBouquet) {
        this.flowersAsBouquet = flowersAsBouquet;
    }

    public void viewOrderInfo(){
        System.out.println("Your order is ");
        String bouquetInfo = "Bouquet - ";
        if (flowersAsBouquet == true) {
            for (Product product : orderList) {
                if (product instanceof Flower) {
                    bouquetInfo += product.getName() + " (" + orderQuantity.get(orderList.indexOf(product)) + ") ";
                } else {
                    System.out.println(product.getName() + " - " + orderQuantity.get(orderList.indexOf(product)) + " pcs");
                }
            }
            System.out.println(bouquetInfo);
            System.out.println("Total price is " + Discount.calculatePriceWithBouquet(orderList) + "\n");
        } else {
            for (Product product : orderList) {
                System.out.println(product.getName() + " - " + orderQuantity.get(orderList.indexOf(product)) + " pcs");
            }
            System.out.println("Total price is " + Discount.calculateNewPrice(orderList) + "\n");
        }
    }

    public void addToOrderList(Product product, int quantity){
        orderList.add(product);
        orderQuantity.add(quantity);
    }

    public void clearOrderList(){
        orderList.clear();
        orderQuantity.clear();
    }
}