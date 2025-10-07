package com.petStore.core;

public class Pet {
	private int id;
	private String name;
	private CaTegory category;
	private double unitprice;
	private int stock;

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

	public CaTegory getCategory() {
		return category;
	}

	public void setCategory(CaTegory category) {
		this.category = category;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Pet(int id, String name, CaTegory category, double unitprice, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.unitprice = unitprice;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", category=" + category + ", unitprice=" + unitprice + ", stock="
				+ stock + "]";
	}

	public Pet() {
		// TODO Auto-generated constructor stub
	}

}
