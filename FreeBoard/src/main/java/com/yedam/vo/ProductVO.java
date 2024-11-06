package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	private String prodCode;
	private String prodName;
	private String prodDesc;
	private String prodInfo;
	private int sellPrice;
	private double weight;
	private String uom;
	private Date creationDate;
	private Date lastUpdateDate;

}
