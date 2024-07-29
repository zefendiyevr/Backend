package com.medilink.backend.CheckConnection;

import com.medilink.backend.DatabaseConnection.DBConnection;
import com.medilink.backend.ModelDto.CheckConnectionRespons;
import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/")
public class CheckConnectionController {


      @Autowired
      private CheckConnectionService checkConnectionService;

      @GetMapping("/checkconnection")
      public MedilinkResponsTmp CheckConnection(@RequestHeader String CurrentDatetime, @RequestHeader String Token, @RequestBody CheckConnection checkConnection){
            //CheckConnectionRespons checkConnectionRespons=new CheckConnectionRespons();
           // checkConnectionRespons.setVal(1);

            return checkConnectionService.CheckConnectionAnswer();
      }



      @GetMapping("/test")
      public MedilinkResponsTmp test(){
            String dbURL = "jdbc:mysql://172.16.6.2:3306/medilink_db?noAccessToProcedureBodies=true";

            String user = "medilink_app_user";
            String password = "cQpV&wqPff!6dgdH13";


            MedilinkResponsTmp medilinkResponsTmp= new MedilinkResponsTmp();
            medilinkResponsTmp.code="200";
            medilinkResponsTmp.message="Succesuful";
            Data data= new Data();
            medilinkResponsTmp.response=data;
            ArrayList<CheckConnectionRespons> customErrors=new ArrayList<CheckConnectionRespons>();

            //connection = jdbcTemplate.getDataSource().getConnection();



            try (
                    Connection conn = DriverManager.getConnection(dbURL, user, password);
                    CallableStatement statement = conn.prepareCall("select RegisterDevice(?,?)");
            ) {
                  statement.setString(1, "03126703");
                  statement.setString(2, "cvxvdfgdf");
                  statement.execute();
                  int No=0;
                  ResultSet rs = statement.getResultSet();
                  while (rs.next()) {
                        No=No+1;
                        Integer supplier = rs.getInt(1);
                        String coffee ="sALAM";
                        customErrors.add(new CheckConnectionRespons(supplier));
                        System.out.println(supplier + ": " + coffee);
                  }
                  statement.close();
                  System.out.println("Stored procedure called successfully!");
            } catch (SQLException ex) {
                  ex.printStackTrace();
            }
            data.data=customErrors;

           DBConnection dbConnection=new DBConnection();
        //   System.out.println(dbConnection.getServerURL());

         return medilinkResponsTmp;

      }


}
