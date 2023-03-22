package com.manokel.dev.tinysensor.authentication;

import com.manokel.dev.tinysensor.dao.DBUserDAOImpl;
import com.manokel.dev.tinysensor.dao.IDBUserDAO;
import com.manokel.dev.tinysensor.dto.DBUserDTO;
import com.manokel.dev.tinysensor.model.DBUser;

public class AuthenticationProvider {
    private static final IDBUserDAO userDao = new DBUserDAOImpl();

    private AuthenticationProvider() {}

    public static DBUser authenticate(DBUserDTO userDTO) {
        if (!userDao.isDBUserValid(userDTO.getUsername(), userDTO.getPassword())) {
            return null;
        }

        return new DBUser(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword());
    }
}
