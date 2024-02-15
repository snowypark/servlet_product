package com.study.product.vo;


import com.study.product.service.InsertProductRespDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductVo {

	private int ProductId;
	private String productName;
	private int productPrice;
	private String productSize;
	
	public InsertProductRespDto toDto(int successCount) {
		return InsertProductRespDto.builder()
				.successCount(successCount)
				.productName(productName)
				.productPrice(productPrice)
				.productSize(productSize)
				.build();
	}
	
}
