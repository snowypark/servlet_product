package com.study.product.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InsertUserReqDto {
	
	private String username;
	private String paswword;
	private String name;
	private String email;

}
