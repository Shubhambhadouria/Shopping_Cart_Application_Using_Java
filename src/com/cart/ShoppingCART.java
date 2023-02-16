package com.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ShoppingCART {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		List<Product> cart = new ArrayList<>();
		Boolean flag = true;
		while(flag) {
			System.out.println();
			System.out.println("********** SHOPPING CART ***********");
			System.out.println();
			System.out.println("Press 1 to Add Items to Cart");
			System.out.println("Press 2 to Show All Items in Cart");
			System.out.println("Press 3 to Remove Item from Cart");
			System.out.println("Press 4 to Sort Items in Cart based on Price");
			System.out.println("Press 5 to Change Item Quantity");
			System.out.println("Press 6 to List All Items in the Cart");
			System.out.println("Press 7 to Filter items based on Properties");
			System.out.println("Press 8 to Delete all items from the Cart");
			System.out.println("Press 9 to Exit from Application");
			System.out.println();
			System.out.print("Enter your Choice : ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
				// Adding Product in cart
				case 1:      
					System.out.println("--------------------------------------");
					System.out.println("You have chosen to add items into cart");
					System.out.println("--------------------------------------");
					System.out.println();
					TimeUnit.SECONDS.sleep(1);
					sc.nextLine();  
					System.out.print("Enter Product Name : ");
					String productName = sc.nextLine();        															   
					System.out.print("Enter Product Price : ");
					Double productPrice = sc.nextDouble();
					System.out.print("Enter Product Quantity : ");
					int productQuantity = sc.nextInt();
					
					Product product = new Product();
					product.setProductName(productName);
					product.setProductPrice(productPrice);
					product.setProductQuantity(productQuantity);
					
					cart.add(product);
					TimeUnit.SECONDS.sleep(1);
					System.out.println();
					System.out.println("Item Added Successfully!");
					TimeUnit.SECONDS.sleep(1);
					System.out.println();
					continue;
					
				//	Showing all products from cart
				case 2:
					System.out.println("-----------------------------------------");
					System.out.println("You have chosen to show all items in cart");
					System.out.println("-----------------------------------------");
					System.out.println();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("------------CART-----------");
					if(cart.size()==0) {
						System.out.println("No items are available in Cart");
						TimeUnit.SECONDS.sleep(2);
						System.out.println();
					}else {
						for(int i=0; i<cart.size(); i++) {
							System.out.println("Product Name is : "+cart.get(i).getProductName());
							System.out.println("Product Quantity is : "+cart.get(i).getProductQuantity());
							System.out.println("Product Price is : "+cart.get(i).getProductPrice());
							System.out.println("----------------------------");	
						}
						System.out.println();
						TimeUnit.SECONDS.sleep(2);
					}
					continue;
					
				// Removing item from cart
				case 3:
					System.out.println("---------------------------------------------");
					System.out.println("You have chosen to remove an items from cart");
					System.out.println("---------------------------------------------");
					System.out.println();
					
					if(cart.size()==0) {
						TimeUnit.SECONDS.sleep(2);
						System.out.println("Cart is already Empty!");
						break;
					}else {
						System.out.print("Choose Product Name : ");
						sc.nextLine();
						String productName2 = sc.nextLine();
						for(int i=0; i<cart.size(); i++) {
							if(cart.get(i).getProductName().equalsIgnoreCase(productName2)) {
								cart.remove(i);
								System.out.println();
								System.out.println("Product has been removed");
								System.out.println();
								break;
							}else {
								System.out.println();
								System.out.println("Product with the given name is not present in cart");
								System.out.println();
								break;
							}
						}
					}
					System.out.println();
					TimeUnit.SECONDS.sleep(2);
					continue;
					
				// Sorting All items in cart	
				case 4:
					System.out.println("----------------------------------------------------");
					System.out.println("You have chosen to Sort Items in Cart based on Price");
					System.out.println("----------------------------------------------------");
					Collections.sort(cart, Comparator.comparingDouble(Product :: getProductPrice));
					
					if(cart.size()==0) {
						TimeUnit.SECONDS.sleep(1);
						System.out.println("Cart is Empty!");
					}else {
						TimeUnit.SECONDS.sleep(1);
						for(int i=0; i<cart.size(); i++) {
							System.out.println("Product Name is :"+cart.get(i).getProductName());
							System.out.println("Product Quantity is :"+cart.get(i).getProductQuantity());
							System.out.println("Product Price is :"+cart.get(i).getProductPrice());
							System.out.println("----------------------------");	
						}
					}
					continue;
		
				// Changing Item Quantity in cart	
				case 5:
					System.out.println("---------------------------------------");
					System.out.println("You have chosen to Change Item Quantity");
					System.out.println("---------------------------------------");
					
					System.out.print("Choose Product Name : ");
					sc.nextLine();
					String productName1 = sc.nextLine();
					
					for(int i=0; i<cart.size(); i++) {
						if(cart.get(i).getProductName().equalsIgnoreCase(productName1)) {
							System.out.println("Current Quantity of Product is : "+cart.get(i).getProductQuantity());
							System.out.println();
							System.out.print("Enter the Quantity : ");
							int qty = sc.nextInt();
							System.out.println();
							Product product2 = new Product(cart.get(i).getProductName(), cart.get(i).getProductPrice(), qty);
							cart.add(product2);
							cart.remove(i);
							System.out.println("Product Quantity is Updated!");
							System.out.println();
							break;
						}else {
							System.out.println();
							System.out.println("Product with the given name is not present in cart");
							System.out.println();
						}
					}
					continue;
					
				// 	Listing All Items in the cart
				case 6:
					System.out.println("-----------------------------------------");
					System.out.println("You have chosen to List All Items available in the Cart");
					System.out.println("-----------------------------------------");
					System.out.println();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("------------CART-----------");
					if(cart.size()==0) {
						System.out.println("No items are available in Cart");
						TimeUnit.SECONDS.sleep(2);
						System.out.println();
					}else {
						for(int i=0; i<cart.size(); i++) {
							System.out.println("Product Name is :"+cart.get(i).getProductName());
							System.out.println("Product Quantity is :"+cart.get(i).getProductQuantity());
							System.out.println("Product Price is :"+cart.get(i).getProductPrice());
							System.out.println("----------------------------");	
						}
						System.out.println();
						TimeUnit.SECONDS.sleep(2);
					}
					continue;
					
				//	Filtering based on properties
				case 7:
					System.out.println("---------------------------------------------------");
					System.out.println("You have chosen to Filter items based on Properties");
					System.out.println("---------------------------------------------------");
					System.out.println();
					
					Boolean value = true;
					while(value) {
						System.out.println("Press 1 to Filter based on Name");
						System.out.println("Press 2 to Filter based on Price");
						System.out.println("Press 3 to Filter based on Quantity");
						System.out.println("Press 4 to exit out of Filter Method");
						System.out.println();
						System.out.print("Enter your Choice : ");
						int choice1 = sc.nextInt();
						System.out.println();
						switch(choice1) {
						
							//	Sort Items in Cart based on Name
							case 1:
								System.out.println("*******************************************");
								System.out.println("You have chosen to Sort Items based on Name");
								System.out.println("*******************************************");
								Collections.sort(cart, Comparator.comparing(Product :: getProductName));
								if(cart.size()==0) {
									TimeUnit.SECONDS.sleep(1);
									System.out.println("Cart is Empty!");
								}else {
									System.out.println("-----------Cart is Updated-------");
									TimeUnit.SECONDS.sleep(1);
									for(int i=0; i<cart.size(); i++) {
										System.out.println("Product Name is :"+cart.get(i).getProductName());
										System.out.println("Product Quantity is :"+cart.get(i).getProductQuantity());
										System.out.println("Product Price is :"+cart.get(i).getProductPrice());
										System.out.println("----------------------------");	
									}
								}
								continue;
								
							//	Sort Items in Cart based on Price
							case 2:
								System.out.println("****************************************************");
								System.out.println("You have chosen to Sort Items in Cart based on Price");
								System.out.println("****************************************************");
								Collections.sort(cart, Comparator.comparingDouble(Product :: getProductPrice));
								if(cart.size()==0) {
									TimeUnit.SECONDS.sleep(1);
									System.out.println("Cart is Empty!");
								}else {
									System.out.println("-----------Cart is Updated-------");
									TimeUnit.SECONDS.sleep(1);
									for(int i=0; i<cart.size(); i++) {
										System.out.println("Product Name is :"+cart.get(i).getProductName());
										System.out.println("Product Quantity is :"+cart.get(i).getProductQuantity());
										System.out.println("Product Price is :"+cart.get(i).getProductPrice());
										System.out.println("----------------------------");	
									}
								}
								continue;
								
							//	Sort Items based on Quantity		
							case 3:
								System.out.println("***********************************************");
								System.out.println("You have chosen to Sort Items based on Quantity");
								System.out.println("***********************************************");
								Collections.sort(cart, Comparator.comparingInt(Product :: getProductQuantity));
								if(cart.size()==0) {
									TimeUnit.SECONDS.sleep(1);
									System.out.println("Cart is Empty!");
								}else {
									System.out.println("-----------Cart is Updated-------");
									TimeUnit.SECONDS.sleep(1);
									for(int i=0; i<cart.size(); i++) {									
										System.out.println("Product Name is :"+cart.get(i).getProductName());
										System.out.println("Product Quantity is :"+cart.get(i).getProductQuantity());
										System.out.println("Product Price is :"+cart.get(i).getProductPrice());
										System.out.println("----------------------------");	
									}
								}
								continue;
								
							//	Exiting from Filter Method	
							case 4:
								break;
						}
						break;
					}
					continue;
					
				//	Deleting all items in the cart	
				case 8:
					System.out.println("---------------------------------------------");
					System.out.println("You have chosen to Delete all items from the Cart");
					System.out.println("---------------------------------------------");
					System.out.println();
					
					if(cart.size()==0) {
						TimeUnit.SECONDS.sleep(2);
						System.out.println("Cart is already Empty!");
					}else {
						cart.removeAll(cart);
						TimeUnit.SECONDS.sleep(2);
						System.out.println("All Items have been Removed");
					}
					System.out.println();
					TimeUnit.SECONDS.sleep(2);
					continue;
					
				//	Exiting the Application	
				case 9:
					System.out.println("----------------------------------------");
					System.out.println("You have chosen to Exit from Application");
					System.out.println("----------------------------------------");
					TimeUnit.SECONDS.sleep(2);
					System.out.println();
					System.out.println("Thank you for using Shopping Cart Application!");
					break;
				default:
					System.out.println("Invalid Response Please try again");
					continue;
			}
			break;
		}
		sc.close();
		
	}
	
}
