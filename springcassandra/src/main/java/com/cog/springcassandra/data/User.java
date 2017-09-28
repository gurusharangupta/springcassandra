package com.cog.springcassandra.data;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("users")
public class User {
	@PrimaryKeyColumn(ordinal=1)
    private UUID id;
	 
	@PrimaryKeyColumn(value="user_name",ordinal=2,type=PrimaryKeyType.PARTITIONED)
	private String username;
	
	@Column(value="password")
	private String password;
	
	@Column(value="address")
	private String address;
	
	@Column(value="mobile")
	private String mobile;
	
	@Column(value="email")
	private String email;
	
	@Column(value="dob")
	private Date birthDate;
	
	
	
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
