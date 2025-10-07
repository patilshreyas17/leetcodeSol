package com.petStore.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.petStore.core.OrderId;
import com.petStore.core.Pet;
import com.petStore.core.Status;
import com.petStore.exceptions.PetSysExceptions;
import com.petStore.validations.Validations;

public class petSysServiceImpl implements PetSysService {
	private Map<Integer, OrderId> orderMap;
	private Map<Integer, Pet> petMap;

	public petSysServiceImpl() {
		this.orderMap = new HashMap<>(100);
		this.petMap = new HashMap<>(100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addNewPet(int id, String name, String category, double unitPrice, int stock) throws PetSysExceptions {
		Pet p = Validations.validatePet(id, name, category, unitPrice, stock);
		// TODO Auto-generated method stub

		petMap.put(id, p);
		System.out.println(name + " was added to Store");

	}

	@Override
	public void updatePetDetails(int id, double unitPrice) throws PetSysExceptions {
		// Bhai konsa details update karna hai nai pata islye price karra hoon
		Pet p = petMap.get(id);
		if (p == null) {
			throw new PetSysExceptions(" No such Pet with " + id + " exists in the system");
		}
		Validations.validateUnitPrice(unitPrice);
		p.setUnitprice(unitPrice);
		System.out.println("Price Updated");
		System.out.println(p);
	}

	@Override
	public void displayAllpets() {
		petMap.values().forEach(System.out::println);
		// TODO Auto-generated method stub

	}

	@Override
	public void orderApet(int id, int quantity) throws PetSysExceptions {
		
		
		Pet p = petMap.get(id);
		if (p == null) {
			throw new PetSysExceptions(" No such Pet with " + id + " exists in the system");
		}
		Validations.valdiateQuantity(p.getId(),quantity, p.getStock());
		p.setStock(p.getStock()-quantity);
		OrderId o = new OrderId(p.getId(), quantity, Status.PLACED);
		orderMap.put(o.getId(), o);
		System.out.println("Order Placed");
		
		// TODO Auto-generated method stub

	}

	@Override
	public void checkOrderByStatus() {
		orderMap.values().stream()
		.sorted(Comparator.comparing(OrderId::getStatus))
		
		
		.forEach(System.out::println);
		// TODO Auto-generated method stub
		
		Optional.ofNullable(orderMap.values())
	    .filter(vals -> !vals.isEmpty())
	    .ifPresentOrElse(
	        vals -> vals.stream()
	                    .sorted(Comparator.comparing(OrderId::getStatus))
	                    .forEach(System.out::println),
	        () -> System.out.println("No orders found")
	    );


	}

	@Override
	public void updateOrderStatus(int Oid, String status) throws PetSysExceptions {
		OrderId o = orderMap.get(Oid);
		
		if (o == null) {
			throw new PetSysExceptions(" No such order with " + Oid + " exists in the system");
		}
		Status s = Validations.validateStatus(status);
		o.setStatus(s);
		System.out.println("Status Updated");

		// TODO Auto-generated method stub

	}
}


