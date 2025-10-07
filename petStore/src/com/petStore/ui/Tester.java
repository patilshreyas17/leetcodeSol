package com.petStore.ui;

import java.util.Scanner;

import com.petStore.core.User;
import com.petStore.exceptions.AuthorizationException;
import com.petStore.service.PetSysService;
import com.petStore.service.petSysServiceImpl;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			User user = null;
			PetSysService service = new petSysServiceImpl();
			while (!exit) {

				if (user == null) {
					System.out.println("Loggin in the System");
					System.out.print("Enter ID");
					String id = sc.nextLine().trim();

					System.out.println("Enter Password");

					String password = sc.nextLine().trim();
					try {
						user = User.login(id.toUpperCase().trim(), password.toUpperCase().trim());

					} catch (Exception e) {

						System.out.println(e);
						continue;
						// TODO: handle exception
					}
				}

				try {

					System.out.println("Pet Store Menu");
					System.out.println("01 Login");
					System.out.println("02 Add New pet");
					System.out.println("03 Update Pet Details");
					System.out.println("04 Display All Pets");
					System.out.println("05 Order A Pet");
					System.out.println("06 Check Order By Status");
					System.out.println("07 Update Order Status");
					System.out.println("08 AddDummy data(admin)");
					System.out.println("");
					System.out.println("Logged In User: " + user.name());
					System.out.println("Enter Choice:");
					int choice = Integer.parseInt(sc.nextLine().trim());
					switch (choice) {
					case 1: {
						user = null;
						break;
					}
					case 2: {
						if (user == User.ADMIN) {
							System.out.println("m");
							System.out.println("Enter Id for Pet");
							int id = Integer.parseInt(sc.nextLine().trim());
							System.out.println("Enter Name for Pet");
							String name = sc.nextLine().trim();
							System.out.println("Enter Category of pet");
							String category = sc.nextLine().toUpperCase().trim();
							System.out.println("Enter Price of pet");
							double unitPrice = Double.parseDouble(sc.nextLine().trim());
							System.out.println("Enter Stock value");
							int stock = Integer.parseInt(sc.nextLine().trim());
							service.addNewPet(id, name, category, unitPrice, stock);

						} else {
							throw new AuthorizationException(" Invalid  user logged in ");
						}

						break;
					}
					case 4: {
						if (user != null) {
							service.displayAllpets();

						}
						break;
					}
					case 5: {
						if (user == User.C1) {

							System.out.println("Enter id of pet u want to Order");
							int id = Integer.parseInt(sc.nextLine().trim());
							System.out.println("Enter Quantity to want to order");
							int quantity = Integer.parseInt(sc.nextLine().trim());

							service.orderApet(id, quantity);

						} else {
							throw new AuthorizationException(" Invalid  user logged in");
						}
						break;
					}

					case 6: {
						if (user != null) {
							service.checkOrderByStatus();
						}
						break;
					}

					case 7: {
						if (user == User.ADMIN) {
							System.out.println("Enter orderId");
							int Oid = Integer.parseInt(sc.nextLine().trim());
							System.out.println("Enter Status");
							String status = sc.nextLine().trim().trim();

							service.updateOrderStatus(Oid, status);

						} else {
							throw new AuthorizationException(" Invalid  user logged in");
						}
						break;
					}
					case 3: {
						if (user == User.ADMIN) {
							System.out.println("Enter id of Pet");
							int id = Integer.parseInt(sc.nextLine().trim());
							System.out.println("Enter Unitprice");
							double unitPrice = Double.parseDouble(sc.nextLine().trim());

							service.updatePetDetails(id, unitPrice);

						} else {
							throw new AuthorizationException(" Invalid  user logged in");
						}
						break;
					}
					case 8: {

						if (user == User.ADMIN) {
							service.addNewPet(1, "Siamese", "cat", 8000.00, 10);
							service.addNewPet(2, "Persian", "cat", 9500.00, 6);
							service.addNewPet(3, "Maine Coon", "cat", 10000.00, 5);
							service.addNewPet(4, "Bengal", "cat", 12000.00, 4);
							service.addNewPet(5, "British Shorthair", "cat", 8500.00, 8);

							service.addNewPet(6, "Labrador Retriever", "dog", 12000.00, 7);
							service.addNewPet(7, "German Shepherd", "dog", 15000.00, 5);
							service.addNewPet(8, "Golden Retriever", "dog", 15500.00, 6);
							service.addNewPet(9, "Beagle", "dog", 11000.00, 9);
							service.addNewPet(10, "Pug", "dog", 9500.00, 10);

							service.addNewPet(11, "Holland Lop", "rabbit", 4500.00, 12);
							service.addNewPet(12, "Netherland Dwarf", "rabbit", 4800.00, 9);
							service.addNewPet(13, "Lionhead", "rabbit", 5200.00, 7);
							service.addNewPet(14, "Mini Rex", "rabbit", 5000.00, 8);
							service.addNewPet(15, "English Angora", "rabbit", 5500.00, 6);

							service.addNewPet(16, "Goldfish", "fish", 1500.00, 25);
							service.addNewPet(17, "Betta", "fish", 2200.00, 20);
							service.addNewPet(18, "Angelfish", "fish", 3000.00, 14);
							service.addNewPet(19, "Guppy", "fish", 1800.00, 18);
							service.addNewPet(20, "Koi", "fish", 3500.00, 12);

						} else {
							throw new AuthorizationException(" Invalid  user logged in");
						}
						break;
					}
					case 0:
						exit = true;
						System.out.println("Exiting system");
						break;
					default:
						System.out.println("Invalid Choice of Operation ");
						break;
					}

				} catch (NumberFormatException e) {
					System.out.println(e);

				} catch (Exception e) {

					System.out.println(e);
					user = null;
					// TODO: handle exception
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
