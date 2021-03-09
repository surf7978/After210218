package com.company.temp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	String productId;
	String productName;
	String productPrice;
	String productInfo;
	String productdate;
	String company;
	String managerId;
}
