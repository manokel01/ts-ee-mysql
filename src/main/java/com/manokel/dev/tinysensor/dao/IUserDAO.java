package com.manokel.dev.tinysensor.dao;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.model.User;
import com.manokel.dev.tinysensor.service.exceptions.UserNotFoundException;


import java.util.List;

/**
 * Public DAO API methods for  {@link User} class.
 */
public interface IUserDAO {
    /**
     * Inserts a {@link User} based on the data carried by the
     * {@link User}.
     *
     * @param user
     * 			object that contains the data.
     * @return
     *          The inserted user instance.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    User insert(User user) throws DAOException;
    /**
     * Updates a {@link User} based on the data carried by the
     * {@link User}.
     *
     * @param user
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
    User update(User user) throws DAOException;
    /**
     * Deletes a {@link User} based on the data carried by the
     * {@link User}.
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
    void delete(int id) throws DAOException;
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
    List<User> getByUserLastname(String lastname) throws DAOException;
    /**
     * Searches and gets back the {@link User} objects identified
     * by their id.
     *
     * @param id
     * 			an int that is the id of the {@link User}
     * 			objects we are looking for.
     * @return
     * 			The {@link User} objects with the id we
     * 		    are looking for.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server.
     */
    User getByUserId(int id) throws DAOException;
}
