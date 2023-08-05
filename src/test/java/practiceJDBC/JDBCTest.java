package practiceJDBC;

import java.sql.*;

public class JDBCTest {
    /**
     * We need 3 things to connect to Data Base:
     *
     * 1. Connection object
     * 2. Statement object
     * 3. ResulSet object
     *
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Project2",
                "postgres",
                "Admin123"
        );
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");
//        resultSet.next();
//        System.out.println(resultSet.getString(1));
//        int count =0;
//        while (resultSet.next()){
//            count++;
//            System.out.println(resultSet.getString(1));
//            System.out.println(count + " " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
//        }
        /**
         * ResultSetMetaData --> It holds data about data;
         */
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(metaData.getColumnCount());
        System.out.println("Table name: " + metaData.getTableName(1));
        System.out.println(metaData.getColumnType(1));
        for(int i=1; i<metaData.getColumnCount();i++){
            System.out.println("Table: "+metaData.getTableName(i)+"Column number: "+i+".Column name: "
                    +metaData.getColumnName(i));
        }
    }
}
