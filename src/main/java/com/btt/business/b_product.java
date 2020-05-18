package com.btt.business;


import java.sql.Date;


import com.btt.service.productService;
import com.btt.util.ApplicationContextProvider;

public class b_product {
	public String getAllProducts() {

		productService ps = ApplicationContextProvider.getBean("productService", productService.class);
		return ps.getAllProducts();
	}
	public String getProductById(int id) {

		productService ps = ApplicationContextProvider.getBean("productService", productService.class);
		return ps.getProductById(id);
	}
	public String pInsertProduct(
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
	) {
		
		productService ps = ApplicationContextProvider.getBean("productService", productService.class);
		return ps.pInsertProduct(
				productname,
				productcode,
				maindivisionid,
				divisionid,
				categoryid,
				productapplicationarea,
				productspecification,
				productvideourl,
				productfileurl,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid
		);
}
	public String pUpdateProduct(
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
	) {
		
		productService ps = ApplicationContextProvider.getBean("productService", productService.class);
		return ps.pUpdateProduct(
				id,
				productname,
				productcode,
				maindivisionid,
				divisionid,
				categoryid,
				productapplicationarea,
				productspecification,
				productvideourl,
				productfileurl,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid
				);
}
	public String deleteProductById(int id) {

		productService ps = ApplicationContextProvider.getBean("productService", productService.class);
		return ps.deleteProductById(id);
	}
	


}

