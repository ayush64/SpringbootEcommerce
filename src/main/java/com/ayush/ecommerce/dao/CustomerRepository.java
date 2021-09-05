package com.ayush.ecommerce.dao;


import com.ayush.ecommerce.entity.order.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
