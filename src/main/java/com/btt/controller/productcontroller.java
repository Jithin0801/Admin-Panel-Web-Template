package com.btt.controller;

import java.sql.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import com.btt.business.b_product;



@RestController
@RequestMapping("/api")

public class productcontroller {
	@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

	public String getAllProducts() {
		return new b_product().getAllProducts();
	}
	
	@RequestMapping(value = "/productbyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getProductById(@RequestParam("id") int id) {
		return new b_product().getProductById(id);
	}
	
	@RequestMapping(value = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String pInsertProduct(
			@RequestParam("productname") String productname,
			@RequestParam("productcode")	String productcode,
			@RequestParam("maindivisionid") int maindivisionid,
			@RequestParam("divisionid")	int divisionid,
			@RequestParam("categoryid")	int categoryid,
			@RequestParam("productapplicationarea")	String productapplicationarea,
			@RequestParam("productspecification")	String productspecification,
			@RequestParam("productvideourl")	String productvideourl,
			@RequestParam("productfileurl")	String productfileurl,
			@RequestParam("createdby")	String createdby,
			@RequestParam("createdat")	Date createdat,
			@RequestParam("modifiedby")	String modifiedby,
			@RequestParam("modifiedat")	Date modifiedat,
			@RequestParam("statusid")	int statusid
			) {
		
		return new b_product().pInsertProduct(
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
	@RequestMapping(value = "/modifyproduct", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String pUpdateProduct(
			@RequestParam("id") int id,
			@RequestParam("productname")String productname,
			@RequestParam("productcode")String productcode,
			@RequestParam("maindivisionid")int maindivisionid,
			@RequestParam("divisionid")int divisionid,
			@RequestParam("categoryid")int categoryid,
			@RequestParam("productapplicationarea")String productapplicationarea,
			@RequestParam("productspecification")String productspecification,
			@RequestParam("productvideourl")String productvideourl,
			@RequestParam("productfileurl")	String productfileurl,
			@RequestParam("createdby")String createdby,
			@RequestParam("createdat")Date createdat,
			@RequestParam("modifiedby")String modifiedby,
			@RequestParam("modifiedat")Date modifiedat,
			@RequestParam("statusid")int statusid
			) {
		
		return new b_product().pUpdateProduct(
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
	@RequestMapping(value = "/deleteproduct", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String deleteProductById(@RequestParam("id") int id) {
		return new b_product().deleteProductById(id);
	}	
			
}
