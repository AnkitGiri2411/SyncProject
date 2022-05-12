package com.Sync.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="DataList")
public class SyncEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String timestamp;

	private String ver;

	private String product_family;

	private String country;

	private String device_type;

	private String os;

	private String checkout_failure_count;

	private String payment_api_failure_count;

	private String purchase_count;

	private String revenue;

	public SyncEntity(String timestamp, String ver, String product_family, String country, String device_type,
			String os, String checkout_failure_count, String payment_api_failure_count, String purchase_count,
			String revenue) {
		super();
		this.timestamp = timestamp;
		this.ver = ver;
		this.product_family = product_family;
		this.country = country;
		this.device_type = device_type;
		this.os = os;
		this.checkout_failure_count = checkout_failure_count;
		this.payment_api_failure_count = payment_api_failure_count;
		this.purchase_count = purchase_count;
		this.revenue = revenue;
	}



}
