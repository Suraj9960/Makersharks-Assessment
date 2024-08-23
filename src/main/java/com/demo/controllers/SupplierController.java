package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Response;
import com.demo.entity.Supplier;
import com.demo.serviceLayer.ServiceLayer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private ServiceLayer serviceLayer;

	@PostMapping("/query")
	public ResponseEntity<Response> querySuppliers(
			@RequestParam String location,
	        @RequestParam String natureOfBusiness,
	        @RequestParam String manufacturingProcess ,
	        @RequestParam(value = "pageNumber" ,defaultValue = "0",required = false) Integer pageNumber,
	        @RequestParam(value = "pageSize",defaultValue = "2",required = false) Integer pageSize
			) {
		
		
		Response suppliers = serviceLayer.
				findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(location,natureOfBusiness,manufacturingProcess , pageNumber,pageSize);
		if(suppliers == null) {
			return new ResponseEntity<>(suppliers, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Response>(suppliers, HttpStatus.OK);
	}

}
