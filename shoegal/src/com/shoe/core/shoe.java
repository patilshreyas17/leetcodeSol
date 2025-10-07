	package com.shoe.core;

public class shoe{

	private int id;
	private String name;
	 private  String brand;
	 private double rating;
	 private double price;
	 private boolean availableInGallery;
	private shoeType shoeType;
	private static int counter=0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailableInGallery() {
		return availableInGallery;
	}
	public void setAvailableInGallery(boolean availableInGallery) {
		this.availableInGallery = availableInGallery;
	}
	public shoeType getShoeT₹ype() {
		return shoeType;
	}
	public void setShoeT₹ype(shoeType shoeT₹ype) {
		this.shoeType = shoeT₹ype;
	}
	public shoe(String name, String brand, double rating, double price, boolean availableInGallery,
			shoeType shoeType) {
		super();
		this.id = ++counter;
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
		this.availableInGallery = availableInGallery;
		this.shoeType = shoeType;
	}
	@Override
	public String toString() {
		return "shoe [id=" + id + ", name=" + name + ", brand=" + brand + ", rating=" + rating + ", price=" + price
				+ ", availableInGallery=" + availableInGallery + ", shoeT₹ype=" + shoeType + "]";
	}
	
//	@Override
//	public boolean equals(Object o) {
//		shoe other = (shoe) o;
//		return this.name.equalsIgnoreCase(other.name);
//	}
	

}
