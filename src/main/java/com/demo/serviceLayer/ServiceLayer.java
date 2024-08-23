package com.demo.serviceLayer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.entity.Response;
import com.demo.entity.Supplier;
import com.demo.repository.SupplierRepo;

@Service
public class ServiceLayer {

	@Autowired
	private SupplierRepo repo;

	public List<Supplier> getAllSupplier() {
		return repo.findAll();
	}

	public Supplier createSupplier(Supplier supplier) {
		Supplier supplier2 = new Supplier();
		supplier2.setCompanyName(supplier.getCompanyName());
		supplier2.setWebsite(supplier.getWebsite());
		supplier2.setLocation(supplier.getLocation());
		supplier2.setNatureOfBusiness(supplier.getNatureOfBusiness());
		supplier2.setManufacturingProcess(supplier.getManufacturingProcess());

		return repo.save(supplier2);
	}

	public Response findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(String location,
			String natureOfBusiness, String manufacturingProcess , Integer pageNumber , Integer pageSize) {
		
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		Page<Supplier> pageSupplier = repo.findByLocationAndNatureOfBusinessAndManufacturingProcess(location,
				natureOfBusiness, manufacturingProcess, pageable);
		
		Response response = new Response();
		response.setSupplier(pageSupplier.getContent());
		response.setPageNumber(pageSupplier.getNumber());
		response.setPageSize(pageSupplier.getSize());
		response.setTotalPages(pageSupplier.getTotalPages());
		
		
		return response;
	}

}
