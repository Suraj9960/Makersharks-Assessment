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
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Supplier;
import com.demo.serviceLayer.ServiceLayer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
	
	@Autowired
	private ServiceLayer serviceLayer;
	
	@GetMapping("getAll")
	public ResponseEntity<List<Supplier>> getAllSupplier() {

		List<Supplier> allSuppliers = serviceLayer.getAllSupplier();

		return new ResponseEntity<List<Supplier>>(allSuppliers, HttpStatus.OK);
	}
	
	@PostMapping("create-supplier")
	public ResponseEntity<Supplier> createSupplier(@Valid @RequestBody Supplier supplier , BindingResult result) {

			Supplier supplier2 = serviceLayer.createSupplier(supplier);

		return new ResponseEntity<Supplier>(supplier2, HttpStatus.OK);
	}

}
