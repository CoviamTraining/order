package com.coviam.ecomm.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.ecomm.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	public ArrayList<Order> findOrderByUserEmail(String userEmail);
}