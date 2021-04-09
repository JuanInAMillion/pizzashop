package com.revature.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
@Table(name = "order" , schema = "pizzashop")
public class Orders {

	@Id
	@Column(name = "order_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNo;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private List<Item> order_items;
	
	@OneToOne
	@JoinColumn(name = "user_email")
	private User user;

	@Column(name = "shipping_address")
	private String shippingAddress;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "arrival_date")
	private Date arrivalDate;

}
