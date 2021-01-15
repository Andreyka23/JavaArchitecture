package ru.geekbrains.patterns.lesson6;

import java.sql.*;

public class Main {

    // Data Mapper & Identity Map
    public static void main(String[] args) {
        try {
            Connection connection = getConnectionInstance();
            ProductMapper productMapper = new ProductMapper(connection);
            ProductService productService = new ProductService(productMapper);

            // добавление
            Product product = productService.addProduct("Chair", 500);
            System.out.println("Добавлен товар: " + product.getName());
            Product table = productService.addProduct("Table", 999);
            System.out.println("Добавлен товар: " + table.getName());

            // обновление
            product = productService.editProduct(product.getIdProduct(),"Chair2", 5000);
            System.out.println("Обновлен товар: " + product.getName());

            // получение
            Product product2 = productService.getProduct(product.getIdProduct());
            System.out.println("Получен товар: " + product2.getName());

            // удаление
            productService.removeProduct(product.getIdProduct());

            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } catch (RecordNotFoundException e) {
            System.out.println("Запись в базе не найдена: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionInstance() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_products", "root", "");
        return connection;
    }

}
