package practiceJDBC;

import utilities.HighSchoolUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HighSchoolHomeWork {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT CONCAT(w.day_of_the_week,' we have ',s.subject_name,' class with Mrs/Mr ',te.teacher_name)\n" +
                "AS subjects_of_week\n" +
                "FROM subjects s\n" +
                "INNER JOIN week w ON s.day_id=w.day_id\n" +
                "INNER JOIN teachers te ON s.teacher_id=te.teacher_id";

        HighSchoolUtils.establishConnection();
        List<Map<String,Object>> tableData = HighSchoolUtils.runQuery(query);
       for(int i =0; i<tableData.size(); i++){
           System.out.println(tableData.get(i).get("subjects_of_week"));
       }
    }
}
