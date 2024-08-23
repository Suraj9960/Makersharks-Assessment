package com.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

	@Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.natureOfBusiness = :natureOfBusiness AND :manufacturingProcess MEMBER OF s.manufacturingProcess")
	public Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcess(String location,
			String natureOfBusiness, String manufacturingProcess , Pageable pageable);

}
