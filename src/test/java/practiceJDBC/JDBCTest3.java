package practiceJDBC;

import utilities.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {
        JDBCUtils.establishConnection();
        List<Map<String,Object>> tableData = JDBCUtils.runQuery("select * from jobs");
        for (Map<String,Object> data: tableData){
            System.out.println(data.get("job_title"));
        }
        JDBCUtils.closeDataBase();
    }
}
