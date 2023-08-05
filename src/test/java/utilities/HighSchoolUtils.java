package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighSchoolUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void establishConnection() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("HighSchoolURL"),
                ConfigReader.getProperty("HighSchoolUserName"),
                ConfigReader.getProperty("HighSchoolPsw")
        );
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    public static List<Map<String,Object>> runQuery(String query) throws SQLException {
        rs = statement.executeQuery(query);
        List<Map<String,Object>> tableData = new ArrayList<>();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        while (rs.next()){
            Map<String,Object> rowData = new HashMap<>();
            for(int columnIndex = 1; columnIndex<=rsMetaData.getColumnCount(); columnIndex++){
                rowData.put(rsMetaData.getColumnName(columnIndex),rs.getString(rsMetaData.getColumnName(columnIndex)));
            }
            tableData.add(rowData);
        }
        return tableData;
    }
    public static void closeData() throws SQLException {
        if(connection!=null){
            connection.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(rs!=null){
            rs.close();
        }
    }
}
