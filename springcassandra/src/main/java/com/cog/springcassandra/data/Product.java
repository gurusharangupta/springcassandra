package com.cog.springcassandra.data;

import java.util.List;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("products")
public class Product {
	@PrimaryKeyColumn(ordinal = 1)
	private UUID id;

	@PrimaryKeyColumn(value = "product_id", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
	private int productId;
	
	@Column(value = "tag")
	private String tag;
	
	
	@Column(value = "name")
	private String name;
	
	@Column(value = "detail")
	private String detail;

	@Column(value = "main_features")
	private List<String> mainFeatures;

	@Column(value = "more_detail")
	private String moreDetail;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<String> getMainFeatures() {
		return mainFeatures;
	}

	public void setMainFeatures(List<String> mainFeatures) {
		this.mainFeatures = mainFeatures;
	}

	public String getMoreDetail() {
		return moreDetail;
	}

	public void setMoreDetail(String moreDetail) {
		this.moreDetail = moreDetail;
	}

	

}
