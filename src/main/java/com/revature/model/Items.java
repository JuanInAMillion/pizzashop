package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items", schema = "pizzashop")
public class Items {

		@Id
		@Column(name = "item_id")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String userEmail;
		
		@Column(name = "image")
		private String password;
		
		@Column(name = "price")
		private double userAddress;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "stock")
		private int lastName;
		

}
