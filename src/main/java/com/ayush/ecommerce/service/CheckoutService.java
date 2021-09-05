package com.ayush.ecommerce.service;


import com.ayush.ecommerce.dto.Purchase;
import com.ayush.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
