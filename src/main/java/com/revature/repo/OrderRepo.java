package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, String>{

}
