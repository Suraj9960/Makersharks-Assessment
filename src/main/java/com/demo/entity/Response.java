package com.demo.entity;



import java.util.List;

import lombok.Data;

@Data
public class Response {

	private List<Supplier> supplier;
	private Integer pageNumber;
	private Integer pageSize;
	private Integer totalPages;
}
