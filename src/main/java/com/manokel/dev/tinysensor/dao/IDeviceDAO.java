package com.manokel.dev.tinysensor.dao;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.model.Device;

import java.util.List;

/**
 * Public DAO API methods for {@link Device} class.
 */
public interface IDeviceDAO {
    Device insert(Device device) throws DAOException;
    Device update(Device device) throws DAOException;
    void delete(int id) throws DAOException;
    List<Device> getByDeviceName(String name) throws DAOException;
    Device getByDeviceId(int id) throws DAOException;
}
