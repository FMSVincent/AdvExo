package fr.fms.tools;


public class Utils {
	
	// properties
		static String[] menuMain = {"1 - Creer clients", "2 - Creer un compte client", "3 - Faire une transaction(versement, retrait, transfert)","4 - Afficher la liste des comptes", "5 - Afficher la liste des transactions", "6 - Quitter"};

		// methodes
		public static void displayMenu() {
			System.out.println("*****************************");
			System.out.println("\r\n"
					+ " |  \\/  |                 \r\n"
					+ " | \\  / | ___ _ __  _   _ \r\n"
					+ " | |\\/| |/ _ \\ '_ \\| | | |\r\n"
					+ " | |  | |  __/ | | | |_| |\r\n"
					+ " |_|  |_|\\___|_| |_|\\__,_|\r\n");
			for (String title : menuMain) {
				System.out.println(title);
			}
			System.out.println("*****************************");
		}
		

}
