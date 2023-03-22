package com.manokel.dev.tinysensor.service;

import com.manokel.dev.tinysensor.dao.IDBUserDAO;
import com.manokel.dev.tinysensor.dao.IUserDAO;
import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.DBUserDTO;
import com.manokel.dev.tinysensor.dto.UserDTO;
import com.manokel.dev.tinysensor.model.DBUser;
import com.manokel.dev.tinysensor.model.User;
import com.manokel.dev.tinysensor.service.exceptions.DBUserNotFoundException;

import java.util.List;

public class DBUserServiceImpl implements IDBUsersService {
    private final IDBUserDAO userDAO;

    public DBUserServiceImpl(IDBUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public DBUser insertDBUser(DBUserDTO userToInsert) throws DAOException {
        return null;
    }

    @Override
    public DBUser updateDBUser(DBUserDTO userToUpdate) throws DAOException, DBUserNotFoundException {
        return null;
    }

    @Override
    public void deleteDBUser(int id) throws DAOException, DBUserNotFoundException {

    }

    @Override
    public List<DBUser> getDBUsersByName(String name) throws DAOException {
        return null;
    }

    private DBUser mapUser(DBUserDTO dto) {
        return new DBUser(dto.getId(), dto.getUsername(), dto.getPassword());
    }
}
