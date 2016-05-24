package com.margin.game_guide_server.msql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Martha on 5/13/2016.
 */
public class DBConnection {

    public Connection getConnection() throws Exception
    {
        try
        {
            String connectionURL = "jdbc:mysql://localhost:3306/gameguide";
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "");
            return connection;
        }
        catch (SQLException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

}