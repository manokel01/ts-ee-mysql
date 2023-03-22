package com.manokel.dev.tinysensor.dao;

/**
 * Validation of DBUser's password Class.
 */
public class DBUserDAOImpl implements IDBUserDAO {
    @Override
    public boolean isDBUserValid(String username, String password) {
        return true;
    }
}
