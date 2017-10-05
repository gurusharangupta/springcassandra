package com.cog.springcassandra.model;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class ProductForm {
	
	private UUID id;
	private int productId;
	private String tag;
	private String name;
	private String detail;
	private List<String> mainFeatures;
	private String moreDetail;
	
	
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
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
}
