package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository{

    private static Connection connection = null;

    public static Connection createConnction() {
        try {
            if (connection != null) {
                return connection;
            }
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ust_db", "postgres", "postgres");
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Book> findAll() {
        Connection connection =BookRepositoryImpl.createConnction();
        String sql ="select * from book ";
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int publicationYear=resultSet.getInt("publicationYear");
                long isbn=resultSet.getLong("isbn");
                double price=resultSet.getDouble("price");
                Book book= new Book(id1,title,author,publicationYear,isbn,price);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Optional<Book> findById(int id) {
        Connection connection =BookRepositoryImpl.createConnction();
        String sql = "select * from book where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int publicationYear=resultSet.getInt("publicationYear");
                long isbn=resultSet.getLong("isbn");
                double price=resultSet.getDouble("price");
                Book book= new Book(id1,title,author,publicationYear,isbn,price);
                return Optional.of(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Book save(Book book) {
        Connection connection = BookRepositoryImpl.createConnction();
        String sql = "insert into book(id,title,author,publicationYear,isbn,price) values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,book.getId());
            statement.setString(2,book.getTitle());
            statement.setString(3,book.getAuthor());
            statement.setInt(4,book.getPublicationYear());
            statement.setLong(5,book.getIsbn());
            statement.setDouble(6,book.getPrice());
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount+" rows inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = BookRepositoryImpl.createConnction();
        String sql = "delete from book where id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rowCount  = ps.executeUpdate();
            if(rowCount != 0)
                System.out.println(rowCount + " row deleted");
            else
                System.out.println("id not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book update(Book book) {
        Connection connection = BookRepositoryImpl.createConnction();
        String sql = "update book set title = ? where id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"abc");
            ps.setInt(2,book.getId());
            int rowCount  = ps.executeUpdate();
            if(rowCount != 0)
                System.out.println(rowCount + " rows inserted");
            else
                System.out.println("id not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}
