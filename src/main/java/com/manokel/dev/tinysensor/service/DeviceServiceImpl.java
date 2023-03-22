package com.manokel.dev.tinysensor.service;

import com.manokel.dev.tinysensor.dao.IDeviceDAO;
import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.DeviceDTO;
import com.manokel.dev.tinysensor.model.Device;
import com.manokel.dev.tinysensor.service.exceptions.DeviceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DeviceServiceImpl implements IDeviceService {
    private final IDeviceDAO deviceDAO;

    public DeviceServiceImpl(IDeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    @Override
    public Device insertDevice(DeviceDTO deviceToInsert) throws DAOException {
        if (deviceToInsert == null) return null;

        try {
            Device device = mapDevice(deviceToInsert);
            return deviceDAO.insert(device);

        } catch (DAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Device updateDevice(DeviceDTO deviceToUpdate) throws
            DAOException, DeviceNotFoundException {

        try {
            if (deviceDAO.getByDeviceId(deviceToUpdate.getId()) == null) {
                throw new DeviceNotFoundException("Device with id " + deviceToUpdate.getId()
                        + " not found");
            }

            Device device = mapDevice(deviceToUpdate);
            return deviceDAO.update(device);
        } catch (DAOException | DeviceNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteDevice(int id) throws DAOException, DeviceNotFoundException {
        try {
            if (deviceDAO.getByDeviceId(id) == null) {
                throw new DeviceNotFoundException("Device with id " + id + "not found");
            }
            deviceDAO.delete(id);

        } catch (DAOException | DeviceNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Device> getDevicesByName(String name) throws DAOException {
        List<Device> devices = new ArrayList<>();
        if (name == null) return devices;

        try {
            devices = deviceDAO.getByDeviceName(name);
            return devices;
        } catch (DAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Device mapDevice(DeviceDTO dto) {
        return new Device(dto.getId(), dto.getName(), dto.getMac());
    }
}
