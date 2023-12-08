/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import database.JDBCUtil;
import java.util.ArrayList;
import model.Author;

/**
 *
 * @author phamh
 */
public class AuthorDAO implements DAOInterface<Author>{
    public static AuthorDAO getInstance(){
        return new AuthorDAO();
    }

    @Override
    public int insert(Author t) {
        int ketqua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "CALL AddAuthor('"+t.getName()+"','" +t.getBirth()+"')";
            ketqua = st.executeUpdate(sql);
            
            System.out.println("Them " +ketqua+ " Tac gia thanh cong.");
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua;
    }                    
                    
    @Override
    public int update(Author t) {
        int ketqua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "CALL UpdateAuthorDetails(" + t.getID() + ", '" + t.getName() + "', '" + t.getBirth() + "')";
            ketqua = st.executeUpdate(sql);
            
            System.out.println("Sua " +ketqua+ " Tac gia thanh cong.");
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        return ketqua;    
    }

    @Override
    public int delete(Author t) {
        int ketqua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "CALL DeleteAuthor(" +t.getID()+ ");";
            ketqua = st.executeUpdate(sql);
            
            System.out.println("Xoa " +ketqua+ " Tac gia thanh cong.");
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua; 
    }
    
    @Override
    public ArrayList<Author> selectAll() {
        ArrayList<Author> ketqua = new ArrayList<Author>();
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Authors";
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()) {
                    int ID = result.getInt("ID");
                    String name = result.getString("name");
                    int birth = result.getInt("birth");
                    
                    Author tacgia = new Author(ID, name, birth);
                    ketqua.add(tacgia); 
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua; 
    }

    @Override
    public  Author selectByID(Author t) {
        Author ketqua = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            String sql = "CALL FindAuthorById(" + t.getID()+ ")";
            ResultSet result = st.executeQuery(sql);

            while(result.next()) {
                    int ID = result.getInt("ID");
                    String name = result.getString("name");
                    int birth = result.getInt("birth");
                    
                    ketqua = new Author(ID, name, birth); 
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        return ketqua;
    }

    @Override
    public ArrayList<Author> selectByCondition(String condition) {
        ArrayList<Author> ketqua = new ArrayList<Author>();
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            String sql = "CALL FindAuthorByBirthYear(" + condition+ ")";
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()) {
                    int ID = result.getInt("ID");
                    String name = result.getString("name");
                    int birth = result.getInt("birth");
                    
                    Author tacgia = new Author(ID, name, birth);
                    ketqua.add(tacgia); 
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
        }
        
        return ketqua;     }
    
}
