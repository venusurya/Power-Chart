package com.ty.com.ty.springboot_hospital_eb9.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByEncounterException;
import com.ty.com.ty.springboot_hospital_eb9.dao.EncounterDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedItemsDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedOrderDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.dto.Person;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao dao;

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private MedItemsDao itemsDao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {

		Encounter encounter = encounterDao.getEncounterById(eid);

		if (encounter != null) {

			medOrder.setEncounter(encounter);

			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setMessage("saved Encounter");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveMedOrder(medOrder));

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByEncounterException("Id Not Found Either Person or branch Are not exist");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int mid) {

		MedOrder orderdb = dao.getMedOrderById(mid);

		if (orderdb != null) {

			medOrder.setEncounter(orderdb.getEncounter());

			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setMessage("sucessfully updated MEdOrderr");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.updatemedOrder(medOrder, mid));

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByEncounterException("Id Not Found Either Encounte or Meditems Are not exist");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int mid) {

		MedOrder orderdb = dao.getMedOrderById(mid);

		if (orderdb != null) {
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setMessage("saved MedOrder");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.deleteMedOrder(mid));

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByEncounterException("Id Not Found Are not exist");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int mid) {

		MedOrder orderdb = dao.getMedOrderById(mid);

		if (orderdb != null) {
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setMessage("SucessFully Found MedOrder");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(orderdb);

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByEncounterException("Id Not Found Are not exist");
		}
	}

}
