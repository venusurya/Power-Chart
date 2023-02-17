package com.ty.com.ty.springboot_hospital_eb9.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.repository.MedItemsRepository;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepository repository;

	@Autowired
	private MedOrderDao dao;

	public MedItems saveMedItems(MedItems medItems, int medOrderid) {

		MedOrder medOrder = dao.getMedOrderById(medOrderid);
		medItems.setMedOrder(medOrder);
		return repository.save(medItems);
	}

	public MedItems updateMedItems(MedItems items, int mid) {
		if (repository.findById(mid).isPresent()) {
			MedItems medItemsdb = repository.findById(mid).get();
			items.setId(mid);
			return repository.save(items);
		} else {
			return null;
		}

	}

	public MedItems deleteMedItems(int mid) {
		if (repository.findById(mid).isPresent()) {
			MedItems medItems = repository.findById(mid).get();
			repository.delete(medItems);
			return medItems;
		} else {
			return null;
		}

	}

	public MedItems getMedItemsrById(int mid) {
		if (repository.findById(mid).isPresent()) {
			MedItems medItems = repository.findById(mid).get();
			return medItems;
		} else {
			return null;
		}

	}

}
