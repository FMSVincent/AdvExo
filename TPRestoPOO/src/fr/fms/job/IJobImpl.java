package fr.fms.job;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import fr.fms.entities.Product;
import fr.fms.exception.ProductNotFoundException;

public class IJobImpl implements IJob {
	/**
	 * key est la commande et son numero.
	 * value est lla liste des produits sélectionnée.
	 */
	Map<String, List<Product>> command = new LinkedHashMap<String, List<Product>>();
	
	/**
	 * Méthode qui vérifie si la liste de produits existe
	 * en prenant comme parametre un HashMap de type Produit
	 * et le nom de la catégorie en string.
	 * Renvoi la liste des produits de la catégorie
	 * @param Map<String, List<Product>>
	 * @param String
	 * @return List<Product> 
	 * @throws ProductNotFoundException 
	 */
	
	public List<Product> consultListProducts(Map<String, List<Product>> listProduct, String categorie) throws ProductNotFoundException {
		if (listProduct.get(categorie) == null) {
			throw new ProductNotFoundException("Pas de liste de produits");
		}
		return listProduct.get(categorie);
	}
	
	/**
	 * méthode qui prend en paramètre le numéro de commande et le produit.
	 * La méthode devra ajouter un produit au HashMap avec comme clé "commande + numéro" et comme valeur le produit.
	 * @param numberCommand le numero de la commande en cours
	 * @product product le produit selectionné
	 */
	
	public void addProductToCommand(String numberCommand, Product product) {
		if(command.containsKey(numberCommand)) {
			command.get(numberCommand).add(product);
		} else {
			command.put(numberCommand, new ArrayList<Product>() {{add(product);}});
		}
	}
	
	/**
	 * méthode qui affiche le numero de la commande
	 * la liste des produits
	 * et le montant total à payer
	 */
	
	public void displayCommandAndTotal() {
		command.entrySet().stream().forEach(entry -> {
			double totalPrice = 0;
			System.out.println("******" + entry.getKey() + "****** \n");
			entry.getValue().forEach(product -> System.out.println(product.getName()));
			for (Product product : entry.getValue()) {
				totalPrice += product.getPrice();
			}
			System.out.println("* Total de la commande : " + totalPrice + " * \n");
			System.out.println("-------------------------------------- \n");
		});
	}
	
	/**
	 * methode qui permet d'enregistrer la commande dans un fichier
	 * @throws IOException 
	 */
	
	public void writeIntoFile() throws IOException {
		try (BufferedWriter file = new BufferedWriter(new FileWriter("orders.txt"))) {
			command.entrySet().stream().forEach(entry -> {
				double totalPrice = 0;
				try {
					file.write("******" + entry.getKey() + "****** \n");
					entry.getValue().forEach(product -> {
						try {
							file.write(product.getName());
							file.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
					for (Product product : entry.getValue()) {
						totalPrice += product.getPrice();
					}
					file.write("* Total de la commande : " + totalPrice + " * \n");
					file.write("-------------------------------------- \n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}
}
