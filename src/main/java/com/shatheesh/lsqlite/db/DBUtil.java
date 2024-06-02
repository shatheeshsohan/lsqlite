package com.shatheesh.lsqlite.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil
{
    public static void DBClose (Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
