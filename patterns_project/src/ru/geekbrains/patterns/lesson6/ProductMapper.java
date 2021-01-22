package ru.geekbrains.patterns.lesson6;

import java.sql.*;

public class ProductMapper {
    private final Connection connection;

    public ProductMapper(Connection connection) {
        this.connection  = connection;
    }

    public Product findById(int idProduct) throws SQLException, RecordNotFoundException {
        PreparedStatement statement = connection.prepareStatement("SELECT id, name, price FROM products WHERE id = ?");
        statement.setInt(1, idProduct);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setIdProduct(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getInt(3));
                return product;
            }
        }
        throw new RecordNotFoundException(idProduct);
    }

    public int insert(String name, int price) throws SQLException, RecordNotFoundException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);
        statement.setInt(2, price);
        int id = 0;
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    return id;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        throw new RecordNotFoundException();
    }

    public int update(int id, String name, int price) throws SQLException, RecordNotFoundException {
        PreparedStatement statement = connection.prepareStatement("UPDATE products SET name=?, price=? WHERE id=?");
        statement.setString(1, name);
        statement.setInt(2, price);
        statement.setInt(3, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            System.out.println(affectedRows + " строк обновлено");
            return affectedRows;
        }
        throw new RecordNotFoundException();
    }

    public int delete(int id) throws SQLException, RecordNotFoundException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id=?");
        statement.setInt(1, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            System.out.println(affectedRows + " строк удалено");
            return affectedRows;
        }
        throw new RecordNotFoundException();
    }

}
