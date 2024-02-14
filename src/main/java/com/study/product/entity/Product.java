package com.study.product.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
	private int product_id;
	private String product_name;
	private int product_price;
	private String product_size;
}
