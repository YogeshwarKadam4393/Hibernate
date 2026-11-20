package com.controller;

import java.util.List;

import com.entity.FoodItem;
import com.service.FoodService;

public class Application {
	
	public static void main(String[] args) {
		
		System.out.println("Application Started");
		
		FoodService fs = new FoodService();
		
		//fs.deleteItemById(4);   // To Delete Food Item By Id
		
		//fs.updateFoodDetails(2, 35); // To Update Food Items Price
		
		//getAllFoodDetails(fs); // To Get all Food Details
		
		//getItemById(fs);   // To Get Food Item By Id
		
		//FoodItem foodItem = AddFoodDetails();  // To Add Food Details
		// fs.addFood(foodItem);		// To Add Food Details in Service Class

	}

	private static void getAllFoodDetails(FoodService fs) {
		List<FoodItem> foodItem = fs.getAllDetails();
		
		for (FoodItem foodItem2 : foodItem) {
			System.out.println(foodItem2);
		}
	}
	

	private static void getItemById(FoodService fs) {
		int id = 2;
		
		FoodItem foodItem = fs.getItemById(id);	 
		System.out.println(foodItem);
	}
	

	private static FoodItem AddFoodDetails() {
		
		FoodItem foodItem = new FoodItem();
		
		foodItem.setName("Samosa");
		foodItem.setPrice(50);
		foodItem.setCategory("Breakfast");
		foodItem.setQuantity(2);
		
		return foodItem;
	}

}
