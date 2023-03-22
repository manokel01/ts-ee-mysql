package com.manokel.dev.tinysensor.service;

import com.manokel.dev.tinysensor.dao.IUserDAO;
import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.UserDTO;
import com.manokel.dev.tinysensor.model.User;
import com.manokel.dev.tinysensor.service.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User insertUser(UserDTO userToInsert) throws DAOException {
        if (userToInsert == null) return null;

        try {
            User user = mapUser(userToInsert);
            return userDAO.insert(user);

        } catch (DAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User updateUser(UserDTO userToUpdate) throws
            DAOException, UserNotFoundException {

        try {
            if (userDAO.getByUserId(userToUpdate.getId()) == null) {
                throw new UserNotFoundException("User with id " + userToUpdate.getId()
                + " not found");
            }

            User user = mapUser(userToUpdate);
            return userDAO.update(user);
        } catch (DAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUser(int userId) throws DAOException, UserNotFoundException {
        try {
            if (userDAO.getByUserId(userId) == null) {
                throw new UserNotFoundException("User with id " + userId + "not found");
            }
            userDAO.delete(userId);

        } catch (DAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> getUsersByLastname(String lastname) throws DAOException {
        List<User> users = new ArrayList<>();
        if (lastname == null) return users;

        try {
            users = userDAO.getByUserLastname(lastname);
//            if (users.size() == 0) throw new UserNotFoundException("User with lastname " + lastname + " was not found.");
            return users;
        } catch (DAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private User mapUser(UserDTO dto) {
        return new User(dto.getId(), dto.getFirstname(), dto.getLastname(),
                dto.getEmail(), dto.getAddress());
    }
}
