package com.ty.com.ty.springboot_hospital_eb9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByAddressException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByMedItemsException;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedItemsDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedOrderDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Address;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDao dao;

	@Autowired
	private MedOrderDao medOrderDao;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int medorder_id) {

		MedOrder medOrder = medOrderDao.getMedOrderById(medorder_id);
		if (medOrder != null) {
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<MedItems>();
			responseStructure.setMessage("MedItems Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveMedItems(medItems,medorder_id));
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByMedItemsException();
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMeditems(MedItems items, int mid) {

		MedItems itemsdb = dao.getMedItemsrById(mid);
		if (items != null) {
			items.setMedOrder(itemsdb.getMedOrder());
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<MedItems>();
			responseStructure.setMessage("MedItems Updated  Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.updateMedItems(items, mid));

			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByMedItemsException("No Such Id Present in MedIte,ms");
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMeditems(int mid) {

		MedItems items = dao.getMedItemsrById(mid);

		if (items != null) {
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<MedItems>();
			responseStructure.setMessage("MedItems Deleted Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.deleteMedItems(mid));

			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByMedItemsException("No Such Id Present in MedIte,ms");
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> getMeditemsById(int mid) {

		MedItems items = dao.getMedItemsrById(mid);

		if (items != null) {
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<MedItems>();
			responseStructure.setMessage("MedItems Deleted Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(items);

			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByMedItemsException("No Such Id Present in MedIte,ms");
		}
	}
}
