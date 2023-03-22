package com.manokel.dev.tinysensor.dao;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.model.Device;
import com.manokel.dev.tinysensor.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAOImpl implements IDeviceDAO {
    @Override
    public Device insert(Device device) throws DAOException {
        String sql = "INSERT INTO DEVICES (NAME, MAC)" +
                "VALUES (?, ?)";
        int n;  // count row entries affected
        // close with resources to close connection and prepared statement.
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            String name = device.getName();
            String mac = device.getMac();

            if (name.equals("")) {
                System.err.println("Please enter all fields.");
                return null;
            }

            p.setString(1, name);
            p.setString(2, mac);
            p.executeUpdate();
            return device;
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in Device" + device + "insertion.");
        }
    }

    @Override
    public Device update(Device device) throws DAOException {
        // search with unique key (surrogate opr natural key)
        String sql = "UPDATE DEVICES SET NAME = ?, MAC = ?, WHERE ID = ?";
        // close with resources to close connection and prepared statement.
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            String name = device.getName();
            String mac = device.getMac();
            int id = device.getId();

            if (name.equals("")) {
                System.err.println("Please enter new device name.");
                return null;
            }

            p.setString(1, name);
            p.setString(2, mac);
            p.setInt(3, id);
            p.executeUpdate();
            return device;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in Device" + device + "update.");
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        // search with unique key (surrogate or natural key)
        String sql = "DELETE FROM DEVICES WHERE ID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, id);
            p.executeUpdate();

        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in Device with id" + id + "deletion.");
        }
    }

    @Override
    public List<Device> getByDeviceName(String name) throws DAOException {
        String sql = "SELECT ID, NAME, MAC FROM DEVICES WHERE NAME LIKE ?";
        ResultSet rs;
        List<Device> devices = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setString(1, name + '%');
            rs = p.executeQuery();

            while (rs.next()) {
                Device device = new Device(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("MAC")
                );
                // add to the arraylist
                devices.add(device);
            }

            return devices;

        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in Device with name = " + name);
        }
    }

    @Override
    public Device getByDeviceId(int id) throws DAOException {
        Device device = null;
        ResultSet rs;
        String sql = "SELECT * FROM DEVICES WHERE ID = ?";

        try  (Connection conn = DBUtil.getConnection();
              PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, id);
            rs = p.executeQuery();

            if (rs.next()) {
                device = new Device(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("MAC")
                );
            }
            return device;

        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("SQL Error in Devices with id = " + id);
        }
    }
}
