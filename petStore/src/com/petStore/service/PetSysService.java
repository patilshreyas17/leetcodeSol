package com.petStore.service;

import com.petStore.exceptions.PetSysExceptions;

public interface PetSysService {

	public void addNewPet(int id, String name, String category, double unitPrice, int stock) throws PetSysExceptions;

	public void updatePetDetails(int id, double unitPrice) throws PetSysExceptions;

	public void displayAllpets();

	public void orderApet(int id, int quantity) throws PetSysExceptions;

	public void checkOrderByStatus();

	

	public void updateOrderStatus(int Oid, String status) throws PetSysExceptions;
}
