package com.medilink.backend.DatabaseConnection;

import java.sql.*;

public class DBConnection extends ServerProperties  {

//{call cihaz_altxidmetlist_barcode(?,?)}


    public  ResultSet DBConnection  (String storeProcedure) throws SQLException{
        String dbURL = props.getProperty("spring.datasource.url1");
        String user = props.getProperty("spring.datasource.username");
        String password = props.getProperty("spring.datasource.password");

        try (
                Connection conn = DriverManager.getConnection(dbURL, user, password);
                CallableStatement statement = conn.prepareCall(storeProcedure);
        ) {
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (!rs.next()){
                System.out.println(rs.getString(1));
            }
            statement.close();
            System.out.println(storeProcedure+" --Stored procedure called successfully!");
        } catch (SQLException ex) {


           ex.printStackTrace();
        }
         ResultSet x=null;
        return x;
    }





}
