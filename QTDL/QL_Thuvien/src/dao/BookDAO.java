/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import database.JDBCUtil;
import java.util.ArrayList;
import model.Book;


/**
 *
 * @author phamh
 */
public class BookDAO implements DAOInterface<Book>{
    public static BookDAO getInstance(){
        return new BookDAO();
    }

    @Override
    public int insert(Book t) {
        int ketqua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "CALL AddNewBook('" + t.getName() + "', " + t.getAuthor_id() + ", " + t.getRelease() + ")";
            ketqua = st.executeUpdate(sql);
            System.out.println("Them " +ketqua+ " Sach thanh cong.");
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua;
    }

    @Override
    public int update(Book t) {
        int ketqua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "CALL UpdateBookDetails(" + t.getID() + ", '" + t.getName() + "', " + t.getAuthor_id() + ", " + t.getRelease() + ")";
            ketqua = st.executeUpdate(sql);
            
            System.out.println("Sua " +ketqua+ " Sach thanh cong.");
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        return ketqua; 
    }

    @Override
    public int delete(Book t) {
        int ketqua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "CALL DeleteBook("+t.getID()+")";
            ketqua = st.executeUpdate(sql);
            
            System.out.println("Xoa " +ketqua+ " Sach thanh cong.");
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua; 
    }

    @Override
    public Book selectByID(Book t) {
        Book ketqua = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            String sql = "CALL FindBookByID("+t.getID()+")";
            ResultSet result = st.executeQuery(sql);

            while(result.next()) {
                    int ID = result.getInt("ID");
                    String name = result.getString("name");
                    int au_id = result.getInt("author_id");
                    int realese_year = result.getInt("release_year");
                    
                    ketqua = new Book(ID, name, au_id, realese_year);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        return ketqua;
    }

    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book> ketqua = new ArrayList<Book>();
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Books";
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()) {
                    int ID = result.getInt("ID");
                    String name = result.getString("name");
                    int au_id = result.getInt("author_id");
                    int realese_year = result.getInt("release_year");
                    
                    Book tacgia = new Book(ID, name, au_id, realese_year);
                    ketqua.add(tacgia); 
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua; 
    }
    
    @Override
    public ArrayList<Book> selectByCondition(String condition) {
        ArrayList<Book> ketqua = new ArrayList<Book>();
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            String sql = "CALL FindBookByYear(" +condition+ ")";
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()) {
                    int ID = result.getInt("ID");
                    String name = result.getString("name");
                    int au_id = result.getInt("author_id");
                    int realese_year = result.getInt("release_year");
                    
                    Book tacgia = new Book(ID, name, au_id, realese_year);
                    ketqua.add(tacgia); 
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua; 
    }




    
}
