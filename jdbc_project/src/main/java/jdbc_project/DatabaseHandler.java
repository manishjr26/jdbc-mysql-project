package jdbc_project;

import java.util.Scanner;

public class DatabaseHandler 
{

 public static void main(String[] args) 
 {
     System.out.println("\n\n\t\t 'Welcome to Jdbc_Project ' \t\t\n Enter your choice : \n\t 1 - Register \n\t 2 - Login \n\t 3 - Exit   ");
     Scanner scanner = new Scanner(System.in);
     int userChoice = scanner.nextInt();
     if (userChoice == 1) {
         Operations.registration();
     } else if (userChoice == 2) {
         Operations.login();
     } else 
     {
         System.out.println("\t\t\t   Thank you for visiting !!! \t\t\t ");
         System.err.println(" \t\t\tYou failed to choose options .");
     }
 }
}
