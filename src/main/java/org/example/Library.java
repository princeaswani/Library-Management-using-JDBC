package org.example;

import java.sql.*;

public class Library {

    private Connection con;
    private Statement st;

    public Library() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/librarydb", "root", "root");
            st = con.createStatement();
            System.out.println("Database Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(book book) {
        try {
            String sql = "INSERT INTO book VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book.getBookid());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getBookname());
            ps.setBoolean(4, false);
            ps.setString(5, book.getBookType());
            ps.executeUpdate();
            System.out.println("Book Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayBooks() throws SQLException {
        try {
            String sql = "SELECT * FROM book";
            ResultSet rs = st.executeQuery(sql);
            boolean found = false;
            while (rs.next()) {
                found = true;
                book book = new book(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getString("book_type")
                );
                book.setIssued(
                        rs.getBoolean("is_issued")
                );
                book.displayBook();
                System.out.println("----------------");
            }
            if (!found) {
                System.out.println("No Books Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void displayAvailableBooks() {
        try {
            String sql = "SELECT * FROM book WHERE is_issued=false";
            ResultSet rs = st.executeQuery(sql);
            boolean found = false;
            while (rs.next()) {
                found = true;
                book book = new book(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getString("book_type")
                );
                book.setIssued(
                        rs.getBoolean("is_issued")
                );
                book.displayBook();
                System.out.println("----------------");
            }
            if (!found) {
                System.out.println("No Available Books Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public book searchBookById(int bookId) {
        try {
            String sql = "SELECT * FROM book WHERE book_id=" + bookId;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                book book = new book(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getString("book_type")
                );
                book.setIssued(
                        rs.getBoolean("is_issued")
                );
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public book searchBookByTitle(String bookName) {
        try {
            String sql = "SELECT * FROM book WHERE book_name='" + bookName +
                    "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                book book = new book(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getString("book_type")
                );
                book.setIssued(
                        rs.getBoolean("is_issued")
                );
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void issueBook(int bookId) {
        try {
            String sql = "SELECT * FROM book WHERE book_id=" + bookId;
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("Book Not Found");
                return;
            }
            if (rs.getBoolean("is_issued")) {
                System.out.println("Book Already Issued");
                return;
            }
            String updateSql = "UPDATE book SET is_issued=true " + "WHERE book_id= "+ bookId;
            st.executeUpdate(updateSql);
            System.out.println("Book Issued Successfully");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void returnBook(int bookId) {
        try {
            String sql = "SELECT * FROM book WHERE book_id=" + bookId;
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("Book Not Found");
                return;
            }
            if (!rs.getBoolean("is_issued")) {
                System.out.println("Book Already Returned");
                return;
            }
            String updateSql = "UPDATE book SET is_issued=false WHERE book_id=" + bookId;
            st.executeUpdate(updateSql);
            System.out.println("Book Returned Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeBook(int bookId) {
        try {
            String sql = "SELECT * FROM book WHERE book_id=" + bookId;
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("Book Not Found");
                return;
            }

            String deleteSql = "DELETE FROM book WHERE book_id=" + bookId;
            st.executeUpdate(deleteSql);
            System.out.println("Book Removed Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}