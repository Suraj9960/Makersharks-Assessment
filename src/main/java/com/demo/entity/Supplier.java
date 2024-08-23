package com.demo.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplier_id;
	
	@Size(min = 3, message = "company name contain at least 3 character")
	private String companyName;
	@NotBlank(message = "Website is mandatory")
	private String website;
	@NotBlank(message = "Location is mandatory")
	private String location;
	@NotBlank(message = "Please, enter at least one nature of business")
	private String natureOfBusiness;
	
	@NotEmpty(message = "Company contain at least one manufacturing process")
	@ElementCollection
	private List<String> manufacturingProcess;

	
}
