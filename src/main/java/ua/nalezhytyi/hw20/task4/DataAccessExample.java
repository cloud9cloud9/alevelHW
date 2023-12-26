package ua.nalezhytyi.hw20.task4;

import java.sql.*;

public class DataAccessExample {
    public static void main(String[] args) {

        createTable();
        create("Vasyl", 33);
        read(1);

        update(4, "matriona", "33");
        delete(5);

    }

    private static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/alevel";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTable() {
        try (Connection connection = getConnection()) {
            // SQL-запит для створення таблиці
            String createTableSQL = "CREATE TABLE IF NOT EXISTS person ("
                    + "id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "age INT NOT NULL)";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Таблиця 'person' успішно створена");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void create(String name, int age) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO person (name, age) VALUES(? , ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read(long id) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM person where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, (int) id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int idPerson = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        System.out.println("id: " + idPerson + " name: " + name +
                                " age: " + age);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void update(long id, String newName, String newAge) {
        try (Connection connection = getConnection()) {
            String updateSQL = "UPDATE person SET name = ?, age = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                if (newName != null) {
                    preparedStatement.setString(1, newName);

                    if (newAge != null) {
                        preparedStatement.setInt(2, Integer.parseInt(newAge));
                    }
                    preparedStatement.setLong(3, id);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void delete(long id) {
        try (Connection connection = getConnection()) {
            String SQL = "DELETE FROM person WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
