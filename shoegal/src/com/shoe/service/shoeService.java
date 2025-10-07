package com.shoe.service;

import com.shoe.exceptions.shoeCustomException;

public interface shoeService {

	public void addShoe(String name, String brand, double rating, double price, boolean availableInGallery,
			String shoeType) throws shoeCustomException;

	public void displayAll();

	public void displaySortById();

	public void expensiveShoe();

	public void removeNotAvailable();

	public void updateShoePricebyBrand(String brand,double price);

	public void sortShoePriceDesc();


}
