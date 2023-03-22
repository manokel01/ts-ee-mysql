package com.manokel.dev.tinysensor.service;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.DBUserDTO;
import com.manokel.dev.tinysensor.model.DBUser;
import com.manokel.dev.tinysensor.service.exceptions.DBUserNotFoundException;

import java.util.List;

public interface IDBUsersService {
    /**
     * Inserts a {@link DBUser} based on the data carried by the
     * {@link DBUserDTO}.
     *
     * @param userToInsert
     * 			DTO object that contains the data.
     * @return
     *          The inserted data instance.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    DBUser insertDBUser(DBUserDTO userToInsert) throws DAOException;
    /**
     * Updates a {@link DBUser} based on the data carried by the
     * {@link DBUserDTO}.
     *
     * @param userToUpdate
     * 			DTO object that contains the data
     * 			of the new {@link DBUser}.
     * @return
     *          the update instance of the {@link DBUser}.
     * @throws DBUserNotFoundException
     * 			if any Database user identified by their id
     * 			was not found.
     * @throws DAOException
     * 			if any DAO exception happens.
     */
    DBUser updateDBUser(DBUserDTO userToUpdate) throws DAOException, DBUserNotFoundException;
    /**
     * Deletes a {@link DBUser} based on the data carried by the
     * {@link DBUserDTO}.
     *
     * @param id
     * 			the id of the Database user to be deleted
     * @throws DBUserNotFoundException
     * 			if any Database user needed to be deleted
     * 			has not found.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server at the DAO Level.
     */
    void deleteDBUser(int id) throws DAOException, DBUserNotFoundException;
    /**
     * Searches and gets back to the caller a list
     * of the {@link DBUser} objects identified
     * by their name or name's initial letters.
     *
     * @param name
     * 			a String object that contains the
     * 			name or the letters that the
     * 			name starts with, of the {@link DBUser}
     * 			objects we are looking for.
     * @return
     * 			a List that contains the results of
     * 			the search, that is a List of {@link DBUser}
     * 			objects.
     * @throws DAOException
     * 			if any error happens between the driver
     * 			and the server.
     */
    List<DBUser> getDBUsersByName(String name) throws DAOException;
}
