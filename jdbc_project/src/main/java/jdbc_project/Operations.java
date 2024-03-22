package jdbc_project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {

 private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_project";
 private static final String DB_USER = "root";
 private static final String DB_PASSWORD = "tiger@123";

 public static Connection getConnection() throws SQLException {
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
     } catch (ClassNotFoundException e) {
         throw new SQLException("Failed to establish database connection", e);
     }
 }

 public static void registration() {
     System.out.println("\n\t\t\t  Welcome to Jdbc_Project Registration\t\t\t");

     try (Connection connection = getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?)")) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter id");
         int id = scanner.nextInt();
         scanner.nextLine(); // Consume newline
         System.out.println("Enter name");
         String name = scanner.nextLine();
         System.out.println("Enter number");
         String number = scanner.nextLine();
         System.out.println("Enter email");
         String email = scanner.nextLine();
         System.out.println("Enter password");
         String password = scanner.nextLine();

         preparedStatement.setInt(1, id);
         preparedStatement.setString(2, name);
         preparedStatement.setString(3, number);
         preparedStatement.setString(4, email);
         preparedStatement.setString(5, password);

         int rowsAffected = preparedStatement.executeUpdate();
         if (rowsAffected > 0) {
             System.out.println("\n\n \t\t\t 'Registration Successful !!!!! '  ");
             DatabaseHandler.main(null);
         }
     } catch (SQLException e) {
         System.err.println("Registration failed: " + e.getMessage());
     }
 }

 public static void login() {
     System.out.println("\n\t\t\t  Welcome to Jdbc_Project Login\t\t\t");
     Scanner scanner = new Scanner(System.in);
     System.out.println("Enter email to get your details ");
     String email = scanner.nextLine();
     System.out.println("Enter password to get your details");
     String password = scanner.nextLine();

     try (Connection connection = getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email=? AND password=?")) {
         preparedStatement.setString(1, email);
         preparedStatement.setString(2, password);

         try (ResultSet resultSet = preparedStatement.executeQuery()) {
             if (resultSet.next()) {
                 System.out.println("You have logged in successfully.");
                 System.out.println("Choose \n\t 1 - View your details \n\t 2 - Logout");
                 int userChoice = scanner.nextInt();
                 if (userChoice == 1) {
                     // Retrieve and display user details
                     PreparedStatement userDetailsStatement = connection.prepareStatement("SELECT * FROM user WHERE id=?");
                     userDetailsStatement.setInt(1, resultSet.getInt("id"));
                     try (ResultSet userDetailsResultSet = userDetailsStatement.executeQuery()) {
                         while (userDetailsResultSet.next()) {
                             System.out.println(userDetailsResultSet.getInt(1) + " " + userDetailsResultSet.getString(2) + " " + userDetailsResultSet.getString(3) + " " + userDetailsResultSet.getString(4) + " " + userDetailsResultSet.getString(5));
                         }
                     }
                 }
             } else {
                 System.err.println("Sorry, your account is not found in our database.");
                 System.out.println("We request you to create a new account.");
                 registration(); // Call the registration method if the account is not found
             }
         }
     } catch (SQLException e) {
         System.err.println("Login failed: " + e.getMessage());
     }
 }
}


