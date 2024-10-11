package fr.fms;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import exception.AccountExeptionNotFound;
import exception.NotEnoughCashException;
import exception.TransfertExceptiion;
import fr.fms.business.IBankImpl;
import fr.fms.entities.Account;
import fr.fms.entities.Current;
import fr.fms.entities.Customer;
import fr.fms.entities.Saving;
import fr.fms.entities.Transaction;

public class MyBankApp {
    public static void main(String[] args) {
        IBankImpl bankJob = new IBankImpl();

        Customer robert = new Customer(1, "dupont", "robert", "robert.dupont@xmail.com");
        Customer julie = new Customer(2, "jolie", "julie", "julie.jolie@xmail.com");
        Current firstAccount = new Current(100200300, new Date(), 1500, 200, robert);
        Saving secondAccount = new Saving(200300400, new Date(), 2000, 5.5, julie);

        bankJob.addAccount(firstAccount);
        bankJob.addAccount(secondAccount);

        Scanner sc = new Scanner(System.in);
        long inputChoice = 0;

        while (inputChoice != 6) {
            try {
                System.out.println("Saisissez un numéro de compte valide");
                inputChoice = sc.nextLong();

                Account isAccount = bankJob.consultAccount(inputChoice);
                if (isAccount != null) {
                 
                    System.out.println("Bienvenue " + isAccount.getCustomer().getName() + ", que souhaitez-vous faire ?");
                    System.out.println("1:versement - 2:retrait, - 3:virement - 4:information sur ce compte - 5:liste des opération - 6:sortir");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Saisissez le montant à verser : ");
                            double depositAmount = sc.nextDouble();
                            bankJob.pay(isAccount.getAccountId(), depositAmount);
                            System.out.println("Versement de " + depositAmount + "€ effectué avec succès !");
                            break;

                        case 2:
                            System.out.println("Saisissez le montant à retirer : ");
                            double withdrawAmount = sc.nextDouble();
                            try {
                                bankJob.withdraw(isAccount.getAccountId(), withdrawAmount);
                                System.out.println("Retrait de " + withdrawAmount + "€ effectué avec succès !");
                            } catch (NotEnoughCashException e) {
                                System.err.println("Pas assez d'argent sur le compte " + e.getMessage());
                            }
                            break;

                        case 3:
                            System.out.println("Saisissez l'ID du compte destinataire : ");
                            long destAccountId = sc.nextLong();
                            System.out.println("Saisissez le montant à transférer : ");
                            double transferAmount = sc.nextDouble();
                            try {
                                bankJob.transfert(isAccount.getAccountId(), destAccountId, transferAmount);
                                System.out.println("Virement de " + transferAmount + "€ effectué avec succès !");
                            } catch (TransfertExceptiion | NotEnoughCashException e) {
                                System.err.println("Vous avez dépacé vos capacité de retrait : " + e.getMessage());
                            }
                            break;

                        case 4:
                            System.out.println("Le solde de votre compte est : " + isAccount.getBalance() + "€");
                            break;

                        case 5:
                            System.out.println("Voici la liste des transactions :");
                            for (Transaction trans : bankJob.listTransactions(isAccount.getAccountId())) {
                                System.out.println(trans);
                            }
                            break;
                        case 6:
                        	System.out.println("sortie");
                        	return;

                        default:
                            System.out.println("Option non valide, veuillez réessayer.");
                            break;
                    }
                }
            } catch (AccountExeptionNotFound e) {
                System.err.println("Erreur : " + e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println("Erreur de saisie, veuillez entrer des données valides.");
                sc.next();
            }
        }
        sc.close();
    }
}
