package com.shoe.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.shoe.core.shoe;
import com.shoe.exceptions.shoeCustomException;
import com.shoe.validations.shoeValidations;

public class shoeServiceImpl implements shoeService {
	private Map<Integer, shoe> map;

	public shoeServiceImpl(int capacity)

	{
		this.map = new HashMap<>(capacity);
	}

	@Override
	public void displayAll() {
		for (shoe s : map.values()) {
			System.out.println(s);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void displaySortById() {
		// TODO Auto-generated method stub

		map.values().stream().sorted(( s1,  s2) -> Integer.compare(s1.getId(), s2.getId()))
				// .forEach(System.out::println);
				.forEach((s) -> System.out.println(s));

		// alternate method below entry set based

//		map.entrySet().stream().sorted((s1, s2) ->
//
//		Integer.compare(s1.getValue().getId(), s2.getValue().getId())
//
//		).forEach(System.out::println);

	}

	@Override
	public void expensiveShoe() {
		// TODO Auto-generated method stub

		map.values().stream().sorted((s1,  s2) -> Double.compare(s2.getPrice(), s1.getPrice())).limit(1)
				.forEach(s -> {
					System.out.print(s.getName() + " is the most expensive shoe with price: " + s.getPrice());

				});
		map.values().stream().max(Comparator.comparing(shoe::getPrice)).ifPresentOrElse((e) -> System.out.println(e),
				() -> System.out.println("No such shoe"));

	}

	@Override
	public void removeNotAvailable() {
		// Iterator<shoe> it = map.values().iterator();
		// Iterator<Map.Entry<Integer, shoe>> i2 = map.entrySet().iterator();

		// lhs iteator <UDT>
		// rhs map.values = collection , collection iterator mehtod call, it valirable
//		while (it.hasNext()) {
////			shoe s = it.next();
////			if (!s.isAvailableInGallery()) {
////				it.remove();
//
//			boolean a = it.next().isAvailableInGallery();
//			if (!a) {
//				it.remove();
//			}
//		}
		map.values().removeIf((s) -> {
			return !s.isAvailableInGallery();
		});
	}

	@Override
	public void updateShoePricebyBrand(String brand, double price) {
		// TODO Auto-generated method stub
//		Iterator<shoe> it = map.values().iterator();
//		while (it.hasNext()) {
//			shoe s = it.next();
//			if (s.getId() == id) {
//				s.setBrand(newBrand);
//			}
//		}
		Iterator<shoe> it = map.values().iterator();
		while (it.hasNext()) {
			shoe s = it.next();
			if (s.getBrand().equalsIgnoreCase(brand)) {
				s.setPrice(price);
			}
		}

	}

	@Override
	public void sortShoePriceDesc() {

//		map.values().stream().sorted((shoe s1, shoe s2) -> Double.compare(s2.getPrice(), s1.getPrice()))
//				.forEach(System.out::println);
		map.values().stream().sorted(Comparator.comparing(shoe::getPrice).reversed().thenComparing(shoe::getId))

				.forEach(System.out::println);

	}

	@Override
	public void addShoe(String name, String brand, double rating, double price, boolean availableInGallery,
			String shoeType) throws shoeCustomException {

		shoe s = shoeValidations.validateInputs(name, brand, rating, price, availableInGallery, shoeType);
		map.put(s.getId(), s);

		// TODO Auto-generated method stub

	}

}
