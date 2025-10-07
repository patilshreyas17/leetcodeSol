package com.shoe.validations;

import com.shoe.core.shoe;
import com.shoe.core.shoeType;
import com.shoe.exceptions.shoeCustomException;

public class shoeValidations {

	public static shoe validateInputs(String name, String brand, double rating, double price,
			boolean availableInGallery, String shoetype) throws shoeCustomException {
		validateName(name);
		validrating(rating);
		shoeType s = validateShoeType(shoetype);

		return new shoe(name, brand, rating, price, availableInGallery, s);
	}

	private static void validateName(String name) throws shoeCustomException {
		if (3 <= name.length() && name.length() <= 20) {

		} else {
			throw new shoeCustomException("Name must be greater 3 and less than 20");
		}

	}

	private static void validrating(double rating) throws shoeCustomException {
		if (!(rating >= 1 && rating <= 10)) {
			throw new shoeCustomException("Rating must be greater than 1 and less than 10");
		}

	}

	private static shoeType validateShoeType(String shoetype) throws shoeCustomException {

		try {
			return shoeType.valueOf(shoetype.toUpperCase());
		} catch (Exception e) {
			throw new shoeCustomException("Invalid shoe type selected");
		}
	}
}
