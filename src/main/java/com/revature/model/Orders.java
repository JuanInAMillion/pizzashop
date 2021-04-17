package com.revature.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

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
@Table(name = "order" , schema = "pizzashop")
public class Orders {

	@Id
	@Column(name = "order_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNo;
	
	@OneToMany(targetEntity = Items.class, mappedBy="itemId", fetch = FetchType.EAGER)
	private List<Item> order_items;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_email")
	private User user;

	@Column(name = "shipping_address")
	private String shippingAddress;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "arrival_date")
	private Date arrivalDate;

}
