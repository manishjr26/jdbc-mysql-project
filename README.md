# JDBC MySQL Project

This is a Java project that demonstrates basic operations using JDBC (Java Database Connectivity) with MySQL. It includes functionalities for user registration, login, and logout.

## Prerequisites

- Java Development Kit (JDK) installed
- Eclipse IDE (or any Java IDE of your choice)
- Maven installed
- MySQL Server installed and running

## Setup

1. Clone this repository to your local machine.
2. Open Eclipse IDE and import the project as an existing Maven project.
3. Make sure to have MySQL Connector Java dependency added to the project's `pom.xml` file:

    ```xml
    <dependencies>
        <!-- MySQL Connector Java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.28</version>
        </dependency>
    </dependencies>
    ```

4. Create a MySQL database named `jdbc_project` with a table named `user`. The table should have the following schema:

    ```sql
    CREATE TABLE user (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(45),
        number VARCHAR(45),
        email VARCHAR(45),
        password VARCHAR(45)
    );
    ```

5. Update the MySQL connection details in the `DatabaseHandler` class according to your MySQL setup (e.g., URL, username, password).

## Usage

1. Run the `DatabaseHandler` class which contains the `main` method.
2. You'll be presented with options to register a new user, login, or exit the program.
3. Follow the prompts to perform the desired operation.
4. Once done, you can exit the program.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

