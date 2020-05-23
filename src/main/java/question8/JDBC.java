package question8;
import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        JDBCOperations operations = new JDBCOperations(new UserConfig(), new DatabaseConfig());
        ResultSet rs = operations.select("*", "students");
        ArrayList<String> db_list = new ArrayList<String>();
        while (rs.next()) {
            String student = "{\"id\": "+rs.getString("id")+", \"name\": \""+rs.getString("name")+ "\"}";
            db_list.add(student);
        }
        System.out.println(db_list.toString());
        rs.close();
        operations.close("state");
        operations.close("connection");
    }
}