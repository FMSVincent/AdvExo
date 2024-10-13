package fr.fms.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.fms.entities.Product;

public class DataProduct {

    private static Map<String, List<Product>> productMap = new LinkedHashMap<String, List<Product>>();
    private static List<String> categories = new ArrayList<String>();
    
    /**
     * Méthode qui sert à initialiser les produits dans un HashMap avec 
     * comme clé la catégorie des produits et retourne un HashMap de listes de produits.
     * @return Map<String, ArrayList<Product>>
     */
    
    public static Map<String, List<Product>> initDataProduct() {
    	
        productMap.put("entrées", new ArrayList<Product>() {{
            add(new Product(1, "salade", 5.50));
            add(new Product(2, "soupe", 4.00));
            add(new Product(3, "quiche", 6.00));
            add(new Product(4, "aucune entrée", 0.00));
        }});

        productMap.put("plats", new ArrayList<Product>() {{
            add(new Product(1, "poulet", 12.00));
            add(new Product(2, "boeuf", 15.00));
            add(new Product(3, "poisson", 14.00));
            add(new Product(4, "végétarien", 10.00));
            add(new Product(5, "vegan", 11.00));
            add(new Product(6, "aucun plat", 0.00));
        }});

        productMap.put("accompagnements", new ArrayList<Product>() {{
            add(new Product(1, "riz", 3.00));
            add(new Product(2, "pâtes", 3.50));
            add(new Product(3, "frites", 2.50));
            add(new Product(4, "légumes", 4.00));
            add(new Product(5, "aucun accompagnement", 0.00));
        }});

        productMap.put("boissons", new ArrayList<Product>() {{
            add(new Product(1, "eau plate", 1.00));
            add(new Product(2, "eau gazeuse", 1.50));
            add(new Product(3, "soda", 2.00));
            add(new Product(4, "vin", 5.00));
            add(new Product(5, "aucune boisson", 0.00));
        }});

        productMap.put("desserts", new ArrayList<Product>() {{
            add(new Product(1, "tarte maison", 4.50));
            add(new Product(2, "mousse au chocolat", 5.00));
            add(new Product(3, "tiramisu", 5.50));
            add(new Product(4, "aucun dessert", 0.00));
        }});

        return productMap;
    }
    
    /**
     * Méthode qui sert à initialiser les categories dans un ArrayList 
     * @return ArrayList<Product>
     */
    
    public static List<String> initDataCategorie() {
    	
    	for (String categorie : productMap.keySet()) {
			categories.add(categorie);
		}
    	
    	return categories;
    }
}
