package com.manokel.dev.tinysensor.dao.dbutil;

/**
 * This Class is used during testing.
 */

import com.manokel.dev.tinysensor.service.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    /**
     * No instances of this class should be available
     */
    private DBHelper() {}

    public static void eraseData() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        ResultSet rs = null;
//        PreparedStatement pst = null;

        try {
            conn = DBUtil.getConnection();
            // disables foreign key checks to be able to delete users
            conn.prepareStatement("SET @@foreign_key_checks = 0").executeUpdate();
            // checks all the tables of this database
            // (information_schema.tables is a table with all databases and their tables)
            rs = conn.prepareStatement("SELECT TABLE_NAME FROM information_schema.tables " +
                    "WHERE TABLE_SCHEMA = 'tinysensordb'").executeQuery();

            List<String> tables = mapRSToList(rs);

            for (String table : tables) {
                conn.prepareStatement("DELETE FROM " + table).executeUpdate();
                // initializes surrogate key ID to "1"
                conn.prepareStatement("ALTER TABLE " + table + " AUTO_INCREMENT=1").executeUpdate();
            }

            // re-enable FOREIGN KEY CONSTRAINS
            conn.prepareStatement("SET @@foreign_key_checks = 1").executeUpdate();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static List<String> mapRSToList(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<>();

        while (rs.next()) {
            list.add(rs.getString("TABLE_NAME"));
        }

        return list;
    }
}
