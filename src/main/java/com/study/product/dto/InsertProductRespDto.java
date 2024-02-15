package com.study.product.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InsertProductRespDto {

	private int successCount;
	private int productId;
	private String productName;
	private int productPrice;
	private String productSize;
	
	
	
}
