package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "items", schema = "pizzashop")
public class Items {

		@Id
		@Column(name = "item_id")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int itemId;
		
		@Column(name = "image")
		private String image;
		
		@Column(name = "price")
		private double price;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "stock")
		private int stock;
		
}
