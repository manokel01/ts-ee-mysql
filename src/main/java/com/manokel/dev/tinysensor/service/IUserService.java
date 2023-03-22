package com.manokel.dev.tinysensor.service;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.UserDTO;
import com.manokel.dev.tinysensor.model.User;
import com.manokel.dev.tinysensor.service.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {
    /**
     * Inserts a {@link User} based on the data carried by the
     * {@link UserDTO}.
     *
     * @param userToInsert
     * 			DTO object that contains the data.
     * @return
     *          The inserted user instance.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    User insertUser(UserDTO userToInsert) throws DAOException;
    /**
     * Updates a {@link User} based on the data carried by the
     * {@link UserDTO}.
     *
     * @param userToUpdate
     * 			DTO object that contains the data
     * 			of the new {@link User}.
     * @return
     *          the update instance of the {@link User}.
     * @throws UserNotFoundException
     * 			if any user identified by their id
     * 			was not found.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    User updateUser(UserDTO userToUpdate) throws DAOException, UserNotFoundException;
    /**
     * Deletes a {@link User} based on the data carried by the
     * {@link UserDTO}.
     *
     * @param id
     * 			the id of the user to be deleted
     * @throws UserNotFoundException
     * 			if any User needed to be deleted
     * 			has not found.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server at the DAO Level.
     */
    void deleteUser(int id) throws DAOException, UserNotFoundException;
    /**
     * Searches and gets back to the caller a list
     * of the {@link User} objects identified
     * by their lastname or lastname's initial letters.
     *
     * @param lastname
     * 			a String object that contains the
     * 			surname or the letters that the
     * 			surname starts with, of the {@link User}
     * 			objects we are looking for.
     * @return
     * 			a List that contains the results of
     * 			the search, that is a List of {@link User}
     * 			objects.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server.
     */
    List<User> getUsersByLastname(String lastname) throws DAOException;
}
