import java.io.BufferedWriter;
import java.io.FileWriter;

public class TpResto {

	public static void main(String[] args) {
		System.out.println();
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("order.text"));
			
			file.write("*****Résumer de la commande numéro 1***** \n boeuf \n salade \n frite  ");
			file.newLine();
			file.write("*****Résumer de la commande numéro 2***** \n quiche \n poulet \n legume \n poisson  ");
			
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
