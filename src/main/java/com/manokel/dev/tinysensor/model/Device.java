package com.manokel.dev.tinysensor.model;

/**
 * User Javabean
 */
public class Device {
    private int id;
    private String name;
    private String mac;

    public Device() {}

    public Device(int id, String name, String mac) {
        this.id = id;
        this.name = name;
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}

