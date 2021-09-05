package com.ayush.ecommerce.dto;


import com.ayush.ecommerce.entity.order.Address;
import com.ayush.ecommerce.entity.order.Customer;
import com.ayush.ecommerce.entity.order.Order;
import com.ayush.ecommerce.entity.order.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
