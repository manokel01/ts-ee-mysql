package com.manokel.dev.tinysensor.dao;

import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.model.DBUser;

import java.util.ArrayList;
import java.util.List;

public interface IDBUserDAO {
//    DBUser insert(DBUser user) throws DAOException;
//    DBUser update(DBUser user) throws DAOException;
//    void delete(int id) throws DAOException;
//    List<DBUser> getAll();
//    DBUser getByDBUserLastname(String name) throws DAOException;
    boolean isDBUserValid(String name, String password);
}
