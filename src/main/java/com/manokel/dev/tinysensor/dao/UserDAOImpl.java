package com.manokel.dev.tinysensor.dao;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.model.User;
import com.manokel.dev.tinysensor.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    @Override
    public User insert(User user) throws DAOException {
        String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, ADDRESS)" +
                "VALUES (?, ?, ?, ?)";
        // close with resources to close connection and prepared statement.
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String email = user.getEmail();
            String address = user.getAddress();

            if ((firstname.equals("")) || (lastname.equals(""))
                || (email.equals("")) || (address.equals(""))) {
                System.err.println("Please enter all fields.");
                return null;
            }

            p.setString(1, firstname);
            p.setString(2, lastname);
            p.setString(3, email);
            p.setString(4, address);
            p.executeUpdate();
            return user;

        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in User" + user + "insertion.");
        }
    }

    @Override
    public User update(User user) throws DAOException {
        // search with unique key (surrogate opr natural key)
        String sql = "UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?," +
                "EMAIL = ?, ADDRESS = ? WHERE ID = ?";
        // close with resources to close connection and prepared statement.
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            int id = user.getId();
            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String email = user.getEmail();
            String address = user.getAddress();

            if ((firstname.equals("")) || (lastname.equals(""))
                    || (email.equals("")) || (address.equals(""))) {
                System.err.println("Please enter all fields.");
                return null;
            }

            p.setString(1, firstname);
            p.setString(2, lastname);
            p.setString(3, email);
            p.setString(4, address);
            p.setInt(5, id);
            p.executeUpdate();
            return user;

        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in User "+ user + "update.");
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        // search with unique key (surrogate or natural key)
        String sql = "DELETE FROM USERS WHERE ID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in User with id" + id + "deletion.");
        }
    }

    @Override
    public List<User> getByUserLastname(String lastname) throws DAOException {
        String sql = "SELECT ID, FIRSTNAME, LASTNAME, EMAIL, ADDRESS FROM USERS WHERE LASTNAME LIKE ?";
        ResultSet rs;
        List<User> users = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1, lastname + '%');
            rs = p.executeQuery();
            while (rs.next()) {
                User user = new User(
                            rs.getInt("ID"),
                            rs.getString("FIRSTNAME"),
                            rs.getString("LASTNAME"),
                            rs.getString("EMAIL"),
                            rs.getString("ADDRESS")
                );
                // add to the arraylist
                users.add(user);
            }
            return users;
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in User with lastname = " + lastname);
        }
    }

    @Override
    public User getByUserId(int id) throws DAOException {
        User user = null;
        ResultSet rs;
        String sql = "SELECT * FROM USERS WHERE ID = ?";

        try  (Connection conn = DBUtil.getConnection();
              PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, id);
            rs = p.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("ADDRESS")
                );
            }
            return user;
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in Users with id = " + id);
        }
    }
}
