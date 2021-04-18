package com.revature.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "order_no")
		private Orders orderItems;
		
		public Items() {
			
		}

		public Items(int itemId, String image, double price, String description, int stock, Orders orderItems) {
			super();
			this.itemId = itemId;
			this.image = image;
			this.price = price;
			this.description = description;
			this.stock = stock;
			this.orderItems = orderItems;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public Orders getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(Orders orderItems) {
			this.orderItems = orderItems;
		}

		@Override
		public String toString() {
			return "Items [itemId=" + itemId + ", image=" + image + ", price=" + price + ", description=" + description
					+ ", stock=" + stock + ", orderItems=" + orderItems + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((image == null) ? 0 : image.hashCode());
			result = prime * result + itemId;
			result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + stock;
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
			Items other = (Items) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (image == null) {
				if (other.image != null)
					return false;
			} else if (!image.equals(other.image))
				return false;
			if (itemId != other.itemId)
				return false;
			if (orderItems == null) {
				if (other.orderItems != null)
					return false;
			} else if (!orderItems.equals(other.orderItems))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (stock != other.stock)
				return false;
			return true;
		}
		
}
