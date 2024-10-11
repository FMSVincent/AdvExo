
import java.util.List;


public class FoudException {
	

	public static void main(String[] args) throws Exception {
		
		// 1.1
//		Date date = null;
//		Date toDay = new Date();
//		
//			try {
//				System.out.println(date.getClass().getName());
//			}
//			catch(Exception e) {
//				System.out.println(e.getMessage());
//			}
//			System.out.println(toDay.getClass().getName());
		
		// 1.2
		// init object customer
		Customer client1 = new Customer(1, "Tokyo", "oiveira", "tokyo.oliveira@mail.com");
		BankCasaDePaPel.setCustomers(client1);
		// init account client 1
		CurrentAccount currentAccountClient1 = new CurrentAccount(1, 54514.00, client1.getCustomerId(), "20-08-2024", 500);
		client1.setListAccount(currentAccountClient1);
		
		try {
			findCustomer(0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Suite du programme");

	}
	
	// 1.2
	public static Customer findCustomer(long customerId) throws Exception {
		List<Customer> customers = BankCasaDePaPel.getCustomers();
		for (Customer customer : customers) {
			if (customer.getCustomerId() == customerId) {
				return customer;
			} 
		}
		throw new Exception("pas de client"); // J'aurais du creer une classe ? a faire si j'ai le temps
	} 
		
}
