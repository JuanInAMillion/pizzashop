package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.OrderNotFoundException;
import com.revature.model.Orders;
import com.revature.repo.OrderRepo;

@RestController
@CrossOrigin(origins = "http://localhost:9095")
@RequestMapping("/orderpage")
public class OrderController {
	@Autowired
	private OrderRepo orderRepo;
	
	@PostMapping("/orders")
	public Orders createOrder(@Valid @RequestBody Orders order) {
		return orderRepo.save(order);
	}
	
	@GetMapping("/orders/all")
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}
	
	@GetMapping("/orders/{userEmail}")
	public ResponseEntity<List<Orders>> getOrdersById(@PathVariable(value = "userEmail") String userEmail)
	throws OrderNotFoundException{
		Example<Orders> ordersExample = Example.of(new Orders(userEmail));
		List<Orders> orders = orderRepo.findAll(ordersExample);
	
		return ResponseEntity.ok().body(orders);
	}
}