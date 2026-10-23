package com.snr.aop.service;

import org.springframework.stereotype.Service;

@Service 
public class OrderService {
    
    public void placeOrder() {
        // Simulate order placement logic
        System.out.println("Placing order...");
        try {
            Thread.sleep(2000); // Simulate time taken to place an order
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order placed successfully!");
    }

    public void proceedPayment(){
        System.out.println("Proceeding with payment...");
        try {
            Thread.sleep(2000);
            throw new RuntimeException("Unable to proceed for payment");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
