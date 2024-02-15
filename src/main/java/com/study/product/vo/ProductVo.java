package com.study.product.vo;


import com.study.product.dto.InsertProductRespDto;
import com.study.product.dto.SearchProductRespDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductVo {

	private int ProductId;
	private String productName;
	private int productPrice;
	private String productSize;
	
	public InsertProductRespDto toInsertDto(int successCount) {
		return InsertProductRespDto.builder()
				.successCount(successCount)
				.productName(productName)
				.productPrice(productPrice)
				.productSize(productSize)
				.build();
	}
	
	public SearchProductRespDto toSearchDto() {
		return SearchProductRespDto.builder()
				.productId(ProductId)
				.productName(productName)
				.productPrice(productPrice)
				.productSize(productSize)
				.build();
		
	}
	
}
