package fr.fms.job;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import fr.fms.entities.Product;
import fr.fms.exception.ProductNotFoundException;

public interface IJob {
	List<Product> consultListProducts(Map<String, List<Product>> listProduct, String categorie) throws ProductNotFoundException;
	void addProductToCommand(String numberCommand, Product product);
	void displayCommandAndTotal();
	public void writeIntoFile() throws IOException;
}
