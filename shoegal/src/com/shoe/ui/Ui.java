package com.shoe.ui;

import java.util.Scanner;

import com.shoe.service.shoeService;
import com.shoe.service.shoeServiceImpl;

public class Ui {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;

			shoeService service = new shoeServiceImpl(100);
			while (!exit) {
				try {

					System.out.println("Main Menu");
					System.out.println("01.add shoe");
					System.out.println("02 display all");
					System.out.println("03 display sort by id");
					System.out.println("04 expensive shoe");
					System.out.println("05 remove not alivalbke");
					System.out.println("06 update brand");
					System.out.println("07 sort by proce in desc");
					System.out.println("08 Dummy data");
					System.out.println("Enter Choice");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						System.out.println(
								"String name, String brand, double rating, double price, boolean availableInGallery"
										+ "String shoeType)");
						sc.nextLine();
						String input = sc.nextLine();
						String[] parts = input.split("\\s*,\\s*", -1);
						String name = parts[0].trim();
						String brand = parts[1].trim();
						double rating = Double.parseDouble(parts[2].trim());
						double price = Double.parseDouble(parts[3].trim());
						boolean availableInGallery = Boolean.parseBoolean(parts[4].trim());
						String shoeType = parts[5].trim();
						service.addShoe(name, brand, rating, price, availableInGallery, shoeType);
						System.out.println("added");
						break;
					}
					case 2:
						service.displayAll();
						break;
					case 3:
						service.displaySortById();
						break;
					case 4:
						service.expensiveShoe();
						break;
					case 5:
						service.removeNotAvailable();
						break;
					case 6:
						System.out.println("Enter Brand and New Price");
						String id = sc.next();
						double s = sc.nextDouble();
						service.updateShoePricebyBrand(id, s);
						break;
					case 7:
						service.sortShoePriceDesc();
						break;
					case 8:
						service.addShoe("Air Jordan", "Nike", 4.5, 12000, true, "Sports");
						service.addShoe("Ultraboost", "Adidas", 4.7, 15000, true, "Sports");
						service.addShoe("Classic Leather", "Reebok", 4.0, 8000, false, "Casual");
						service.addShoe("Chuck Taylor", "Converse", 3.9, 5000, true, "Casual");
						service.addShoe("Gel-Kayano", "Asics", 4.8, 14000, true, "Sports");
						service.addShoe("Formal Oxford", "Clarks", 4.3, 9000, true, "Formal");
						service.addShoe("Loafers", "Cole Haan", 4.1, 11000, true, "Formal");
						service.addShoe("Stan Smith", "Adidas", 4.2, 7500, true, "Casual");
						service.addShoe("Pegasus", "Nike", 4.6, 13000, true, "Sports");
						service.addShoe("Boat Shoes", "Sperry", 4.0, 6500, true, "Casual");
						service.addShoe("Derby", "Clarks", 4.4, 9500, true, "Formal");
						service.addShoe("Gel-Lyte", "Asics", 4.5, 8500, true, "Sports");
						service.addShoe("Superstar", "Adidas", 4.1, 7200, true, "Casual");
						service.addShoe("Wingtip", "Allen Edmonds", 4.7, 20000, true, "Formal");
						service.addShoe("ZoomX", "Nike", 4.8, 16000, true, "Sports");
						service.addShoe("Slippers", "Birkenstock", 3.8, 3000, true, "Casual");
						service.addShoe("Cap Toe", "Johnston & Murphy", 4.2, 12000, true, "Formal");
						service.addShoe("Air Max", "Nike", 4.5, 14000, true, "Sports");
						service.addShoe("Court Royale", "Reebok", 4.0, 7000, true, "Casual");
						service.addShoe("Monk Strap", "Magnanni", 4.6, 18000, true, "Formal");
						break;
					case 0:
						exit = true;
						System.out.println("Exiting application");
						break;
					default:
						System.out.println("Inavlid Menu Option");
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();

					// TODO: handle exception
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
