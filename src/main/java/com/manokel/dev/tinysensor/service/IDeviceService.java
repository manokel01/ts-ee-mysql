package com.manokel.dev.tinysensor.service;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.DeviceDTO;
import com.manokel.dev.tinysensor.model.Device;
import com.manokel.dev.tinysensor.service.exceptions.DeviceNotFoundException;

import java.util.List;

public interface IDeviceService {
    /**
     * Inserts a {@link Device} based on the data carried by the
     * {@link DeviceDTO}.
     *
     * @param deviceToInsert
     * 			DTO object that contains the data.
     * @return
     *          The inserted data instance.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    Device insertDevice(DeviceDTO deviceToInsert) throws DAOException;
    /**
     * Updates a {@link Device} based on the data carried by the
     * {@link DeviceDTO}.
     *
     * @param deviceToUpdate
     * 			DTO object that contains the data
     * 			of the new {@link Device}.
     * @return
     *          the update instance of the {@link Device}.
     * @throws DeviceNotFoundException
     * 			if any Device identified by their id
     * 			was not found.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    Device updateDevice(DeviceDTO deviceToUpdate) throws DAOException, DeviceNotFoundException;
    /**
     * Deletes a {@link Device} based on the data carried by the
     * {@link DeviceDTO}.
     *
     * @param id
     * 			the id of the device to be deleted
     * @throws DeviceNotFoundException
     * 			if any Device needed to be deleted
     * 			has not found.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server at the DAO Level.
     */
    void deleteDevice(int id) throws DAOException, DeviceNotFoundException;
    /**
     * Searches and gets back to the caller a list
     * of the {@link Device} objects identified
     * by their name or name's initial letters.
     *
     * @param name
     * 			a String object that contains the
     * 			name or the letters that the
     * 			name starts with, of the {@link Device}
     * 			objects we are looking for.
     * @return
     * 			a List that contains the results of
     * 			the search, that is a List of {@link Device}
     * 			objects.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server.
     */
    List<Device> getDevicesByName(String name) throws DAOException;
}
