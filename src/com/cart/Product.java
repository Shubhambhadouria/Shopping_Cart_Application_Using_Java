package com.cart;

import java.util.Comparator;

public class Product {

	String productName;
	double productPrice;
	int productQuantity;
	
	public Product() {
		super();
	}

	public Product(String productName, double productPrice, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + "]";
	}
	
	class nameComparataor implements Comparator<Product>{
		@Override
		public int compare(Product o1, Product o2) {
			return o1.productName.compareToIgnoreCase(o2.productName);
		}
	}
	
	class priceComparataor implements Comparator<Product>{
		@Override
		public int compare(Product o1, Product o2) {
			return o1.productPrice < o2.productPrice ? -1 : o1.productPrice == o2.productPrice? 0 : 1;
		}
	}
	
	class QuantityComparataor implements Comparator<Product>{

		@Override
		public int compare(Product o1, Product o2) {
			return o1.productQuantity < o2.productQuantity ? -1 : o1.productQuantity == o2.productQuantity ? 0 : 1;
		}
	}
}
