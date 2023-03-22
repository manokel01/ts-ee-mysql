package com.manokel.dev.tinysensor.service.exceptions;

import com.manokel.dev.tinysensor.model.Device;

public class DeviceNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public DeviceNotFoundException(Device device) {
        super("Device with id " + device.getId() + "does not exist");
    }

    // in case for a custom message
    public DeviceNotFoundException(String s) {
        super(s);
    }
}
