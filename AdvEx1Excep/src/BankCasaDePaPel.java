


import java.util.ArrayList;
import java.util.List;

public class BankCasaDePaPel {
	
	private static List<Customer> customers = new ArrayList<Customer>();
	private static String bankName = "Casa Del Papel";
	
	public static String  getbankName() {
		return bankName;
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(Customer customer) {
		BankCasaDePaPel.customers.add(customer);
	}
	

}