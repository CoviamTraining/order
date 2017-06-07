package com.coviam.ecomm.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.coviam.ecomm.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	@Query("select o from Order o where o.userEmail = :userEmail")
	public ArrayList<Order> findOrderByuserEmail(@Param("userEmail") String userEmail);
}