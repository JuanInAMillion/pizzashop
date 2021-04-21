package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users", schema = "pizzashop")
public class User {
	
	
	@Id
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_address")
	private String address;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "phone_number")
	private String phonenumber;
	
	@Column(name = "cc_number")
	private String ccnumber;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	@Column(name = "orders", nullable = true)
//	private List<Orders> orders;
	
	public User() {
		
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCcnumber() {
		return ccnumber;
	}

	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}

//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}

//	@Override
//	public String toString() {
//		return "User [email=" + email + ", password=" + password + ", address=" + address + ", firstname=" + firstname
//				+ ", lastname=" + lastname + ", phonenumber=" + phonenumber + ", ccnumber=" + ccnumber + ", orders="
//				+ orders + "]";
//	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((address == null) ? 0 : address.hashCode());
//		result = prime * result + ((ccnumber == null) ? 0 : ccnumber.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
//		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
//		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (address == null) {
//			if (other.address != null)
//				return false;
//		} else if (!address.equals(other.address))
//			return false;
//		if (ccnumber == null) {
//			if (other.ccnumber != null)
//				return false;
//		} else if (!ccnumber.equals(other.ccnumber))
//			return false;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (firstname == null) {
//			if (other.firstname != null)
//				return false;
//		} else if (!firstname.equals(other.firstname))
//			return false;
//		if (lastname == null) {
//			if (other.lastname != null)
//				return false;
//		} else if (!lastname.equals(other.lastname))
//			return false;
//		if (orders == null) {
//			if (other.orders != null)
//				return false;
//		} else if (!orders.equals(other.orders))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (phonenumber == null) {
//			if (other.phonenumber != null)
//				return false;
//		} else if (!phonenumber.equals(other.phonenumber))
//			return false;
//		return true;
//	}
//	
//	
//	
}
