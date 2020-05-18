package com.btt.service;

import java.sql.Date;

public interface productService {
	String getAllProducts();
	String getProductById(int id);
	String pInsertProduct(
			String productname,
			String productcode,
			int maindivisionid,
			int divisionid,
			int categoryid,
			String productapplicationarea,
			String productspecification,
			String productvideourl,
			String productfileurl,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid
	);
	String pUpdateProduct(
			int id,
			String productname,
			String productcode,
			int maindivisionid,
			int divisionid,
			int categoryid,
			String productapplicationarea,
			String productspecification,
			String productvideourl,
			String productfileurl,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid
	);

	String deleteProductById(int id);
}

