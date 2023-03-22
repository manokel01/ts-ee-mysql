package com.manokel.dev.tinysensor.service.exceptions;

import com.manokel.dev.tinysensor.model.DBUser;

public class DBUserNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public DBUserNotFoundException(DBUser user) {
        super("Database user with id " + user.getId() + "does not exist");
    }

    // in case for a custom message
    public DBUserNotFoundException(String s) {
        super(s);
    }
}
