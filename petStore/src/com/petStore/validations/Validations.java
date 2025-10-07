package com.petStore.validations;



import com.petStore.core.CaTegory;
import com.petStore.core.Pet;
import com.petStore.core.Status;
import com.petStore.exceptions.OutOfStockException;
import com.petStore.exceptions.PetSysExceptions;

public class Validations {

	public static Pet validatePet(int id,String name,String category, double unitPrice, int stock) throws PetSysExceptions {
		CaTegory c = validateCategory(category);
		validateUnitPrice(unitPrice);
		validateStock(stock);
		return new Pet(id, name, c, unitPrice, stock);
		
		
		
	}

	public static CaTegory validateCategory(String cat) throws PetSysExceptions {
		try {
			CaTegory c = CaTegory.valueOf(cat.toUpperCase());
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			throw new PetSysExceptions(" Invalid Category of Pet");
		}

	}

	public static void validateUnitPrice(double unitPrice) throws PetSysExceptions {
		if (unitPrice <= 0) {
			throw new PetSysExceptions("Unit price cannot be zero or negative!!");
		}
	}
	public static void validateStock(int stock) throws PetSysExceptions{
		if(stock<=0) {
			throw new PetSysExceptions("Stock value cannot be zero or negative ");
		}
	}
	
	public static void valdiateQuantity(int pid,int quantity, int stock) throws PetSysExceptions {
		if(quantity<=0) {
			throw new PetSysExceptions(" Quantity cannot be zero or Negative")	;
		}
		if(stock-quantity<0) {
			throw new OutOfStockException("Cannot Place Order with current Avaliable Stock,Lower the Quantity");
		}
		
	}
	public static Status validateStatus(String status) throws PetSysExceptions {
		try {
			Status c = Status.valueOf(status.toUpperCase());
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			throw new PetSysExceptions(" Invalid Status of Order");
		}
	}
	
}
