package fr.fms;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.fms.data.DataProduct;
import fr.fms.entities.Product;
import fr.fms.exception.ProductNotFoundException;
import fr.fms.job.IJobImpl;

public class App {

	public static Map<String, List<Product>> listProducts = DataProduct.initDataProduct();
	public static List<String> listCategories = DataProduct.initDataCategorie();

	public static void main(String[] args) throws ProductNotFoundException {

		Scanner sc = new Scanner(System.in);
		IJobImpl iJob = new IJobImpl();
		int inputChoice = 0;
		int command = 1;
		boolean isCommand = true;

		while (isCommand) {

			System.out.println("Commande numero : " + command + "\n");

			for (int i = 0; i < listCategories.size(); i++) {

				System.out.println("***** faite otre choix ***** \n");

				try {

					List<Product> products = iJob.consultListProducts(listProducts, listCategories.get(i));

					for (Product product : products) {
						System.out.print(product.getIdProduct() + " - " + product.getName() + " : " + product.getPrice()
								+ " £ - ");
					}
					System.out.println();
					inputChoice = sc.nextInt();

					if (inputChoice < 1 || inputChoice > products.size()) {
						System.out.println("Choix invalide, veuillez réessayer.");
						i--;
						continue;
					}

					Product product = listProducts.get(listCategories.get(i)).get(inputChoice - 1);
					iJob.addProductToCommand("commande : " + command, product);
					System.out.println(product.getName() + " choisi");

				} catch (ProductNotFoundException e) {
					throw new ProductNotFoundException("Pas de produit à  afficher " + e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("il faut rentrer un chiffre !");
					i--;
					sc.nextLine();
				}
			}

			sc.nextLine();
			command++;

			System.out.println("passer une autre commande ? o ou n");
			String commadnAgain = sc.nextLine();
			if (!commadnAgain.equalsIgnoreCase("o")) {

				isCommand = false;
				iJob.displayCommandAndTotal();
				System.out.println("Merci d'avoir passé commande");

			}
		}

		try {
			iJob.writeIntoFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
