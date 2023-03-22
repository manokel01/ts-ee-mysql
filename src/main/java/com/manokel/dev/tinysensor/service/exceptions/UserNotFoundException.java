package com.manokel.dev.tinysensor.service.exceptions;

import com.manokel.dev.tinysensor.model.User;

public class UserNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public UserNotFoundException(User user) {
        super("User with id " + user.getId() + "does not exist");
    }

    // in case for a custom message
    public UserNotFoundException(String s) {
        super(s);
    }
}
