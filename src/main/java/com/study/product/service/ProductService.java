package com.study.product.service;

import com.study.product.dao.ProductDao;
import com.study.product.dto.InsertProductReqDto;
import com.study.product.vo.ProductVo;

public class ProductService {
	
	private static ProductService instance;
	private ProductDao productDao;
	
	private ProductService() {
		productDao = ProductDao.getInstance();
	}
	
	public static ProductService getInstance() {
		if(instance == null) {
			instance = new ProductService();
		}
		return instance;
	}
	
	public boolean isduplicatedProductName(String productName) {
				
		return productDao.findProductByProductName(productName) != null;
	}
	
	public InsertProductRespDto addProduct(InsertProductReqDto insertProductReqDto) {
		ProductVo productVo = insertProductReqDto.toVo();
		int successCount = productDao.save(productVo);
		
		return productVo.toDto(successCount);
				
	}

}
