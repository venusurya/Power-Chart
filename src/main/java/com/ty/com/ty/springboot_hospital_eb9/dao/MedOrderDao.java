package com.ty.com.ty.springboot_hospital_eb9.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.repository.MedOrderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepository repository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public MedOrder updatemedOrder(MedOrder medOrder, int mid) {
		if (repository.findById(mid).isPresent()) {
			medOrder.setId(mid);
			return repository.save(medOrder);
		} else {
			return null;
		}

	}

	public MedOrder deleteMedOrder(int mid) {
		if (repository.findById(mid).isPresent()) {
			MedOrder medOrder = repository.findById(mid).get();
			repository.delete(medOrder);
			return medOrder;
		} else {
			return null;
		}

	}

	public MedOrder getMedOrderById(int mid) {
		if (repository.findById(mid).isPresent()) {
			MedOrder medOrder = repository.findById(mid).get();
			return medOrder;
		} else {
			return null;
		}

	}

}
