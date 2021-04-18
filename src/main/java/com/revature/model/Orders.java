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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
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
	
	@Column(name = "is_pending")
	private boolean isPending;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public List<Item> getOrder_items() {
		return order_items;
	}

	public void setOrder_items(List<Item> order_items) {
		this.order_items = order_items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public boolean isPending() {
		return isPending;
	}

	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}

	public Orders(int orderNo, List<Item> order_items, User user, String shippingAddress, Date orderDate,
			Date arrivalDate, boolean isPending) {
		super();
		this.orderNo = orderNo;
		this.order_items = order_items;
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.arrivalDate = arrivalDate;
		this.isPending = isPending;
	}
	
	public Orders() {
		
	}

	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", order_items=" + order_items + ", user=" + user + ", shippingAddress="
				+ shippingAddress + ", orderDate=" + orderDate + ", arrivalDate=" + arrivalDate + ", isPending="
				+ isPending + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + (isPending ? 1231 : 1237);
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderNo;
		result = prime * result + ((order_items == null) ? 0 : order_items.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (isPending != other.isPending)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (order_items == null) {
			if (other.order_items != null)
				return false;
		} else if (!order_items.equals(other.order_items))
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
