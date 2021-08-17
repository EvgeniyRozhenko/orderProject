package com.solvd.orderProject.connectionPool;

public class DBConnectionPool {
    private static DBConnectionPool instance = null;

    public static DBConnectionPool getInstance() {
        if (instance == null)
            instance = new DBConnectionPool();
        return instance;
    }
}
