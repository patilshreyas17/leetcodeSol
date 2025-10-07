package com.petStore.core;

public class OrderId {
	private int id;
	private int petId;

	private int quantity;
	private Status status;
	private static int counter =0;

	public OrderId() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object obj) {
		OrderId other = (OrderId) obj;
		return id == other.id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public OrderId(int petId, int quantity, Status status) {
		super();
		this.id = ++counter;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderId [id=" + id + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}

}
