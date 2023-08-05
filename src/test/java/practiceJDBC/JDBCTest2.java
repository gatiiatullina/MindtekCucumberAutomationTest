package practiceJDBC;

import io.cucumber.java.it.Ma;

import java.sql.*;
import java.util.*;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Project2",
                "postgres",
                "Admin123"
        );
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      //  ResultSet resultSet = statement.executeQuery("select * from employees");
//        List<Map<String, Object>> table = new ArrayList<>();
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        while(resultSet.next()){
//            Map<String,Object> rowData = new HashMap<>();
//            for (int columnIndex =1; columnIndex<=metaData.getColumnCount(); columnIndex++){
//                rowData.put(metaData.getColumnName(columnIndex), resultSet.getString(metaData.getColumnName(columnIndex)));
//            }
//            table.add(rowData);
//        }
//        for (Map columnData: table){
//            System.out.println(columnData.get("first_name"));
//        }
        /**
         * Get min and max salary for sales manager
         */

//        ResultSet rs = statement.executeQuery("select * from jobs");
//        List<Map<String,Object>> tableData = new ArrayList<>();
//        ResultSetMetaData metaData = rs.getMetaData();
//        while (rs.next()){
//            Map<String,Object> rowData = new HashMap<>();
//            for(int columnIndex = 1; columnIndex<=metaData.getColumnCount(); columnIndex++){
//                rowData.put(metaData.getColumnName(columnIndex), rs.getString(metaData.getColumnName(columnIndex)));
//            }
//            tableData.add(rowData);
//        }
//        for (Map columnData: tableData){
//            if(columnData.get("job_title").equals("Sales Manager")){
//                System.out.println("Min and Max salary for "+columnData.get("job_title")+ " is "+
//                        columnData.get("min_salary")+" "+columnData.get("max_salary"));
//            }
//        }

        System.out.println(minAndMaxSalaryForJob("select * from jobs","Sales Manager"));
    }
    public static String minAndMaxSalaryForJob (String query, String jobTitle) throws SQLException {Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/Project2",
            "postgres",
            "Admin123"
    );
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery(query);
        List<Map<String,Object>> tableData = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()){
            Map<String,Object> rowData = new HashMap<>();
            for(int columnIndex = 1; columnIndex<=metaData.getColumnCount(); columnIndex++){
                rowData.put(metaData.getColumnName(columnIndex), rs.getString(metaData.getColumnName(columnIndex)));
            }
            tableData.add(rowData);
        }
        String result = "";
        for (Map columnData: tableData){
            if(columnData.get("job_title").toString().equalsIgnoreCase(jobTitle)){
                result = "Min and Max salary for "+columnData.get("job_title")+ " is "+
                        columnData.get("min_salary")+" "+columnData.get("max_salary");
                System.out.println("Job is done");
                break;
            }
        }
        return result;
    }

}
