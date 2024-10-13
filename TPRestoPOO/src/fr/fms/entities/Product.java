package fr.fms.entities;

public class Product {

	long IdProduct;
	String name;
	double Price;
	
	public Product(long idProduct, String name, double price) {
		IdProduct = idProduct;
		this.name = name;
		Price = price;
	}

	@Override
	public String toString() {
		return "Product [IdProduct=" + IdProduct + ", name=" + name + ", Price=" + Price + "]";
	}



	public long getIdProduct() {
		return IdProduct;
	}

	public void setIdProduct(long idProduct) {
		IdProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	
	
}
