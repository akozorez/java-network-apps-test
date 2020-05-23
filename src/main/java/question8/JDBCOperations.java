/*
 * At success object create:
 * 1. Init Connection & statement
 * 2. Migrate queries
 * At use:
 * .select(what, from) - simple select from db
 * .close(which) - close connection/statement
 */
package question8;
import java.sql.*;
import java.util.ArrayList;

public class JDBCOperations {
    private Statement state;
    private Connection connection = null;
    JDBCOperations(UserConfig user, DatabaseConfig db_cfg) throws SQLException, ClassNotFoundException {
        initConnection(user, db_cfg);
        state = getStatement(user, db_cfg);
        flushMigrations();
    }
    private void initConnection(UserConfig user, DatabaseConfig db_cfg) throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName(db_cfg.getDriver());
            connection = DriverManager.getConnection(db_cfg.getUrl(), user.getUser(), user.getPass());
        }
    }
    private Statement getStatement(UserConfig user, DatabaseConfig db_cfg) throws ClassNotFoundException, SQLException {
        if(connection == null) initConnection(user, db_cfg);
        if(state == null){
            state = connection.createStatement();
        }
        return state;
    }

    private void flushMigrations() throws SQLException {
        ArrayList<String> migrations = new ArrayList<String>();
        migrations.add("DROP DATABASE IF EXISTS `main`;");
        migrations.add("CREATE DATABASE `main`;");
        migrations.add("USE `main`;");
        migrations.add("CREATE TABLE IF NOT EXISTS `students`(`id` int NOT NULL AUTO_INCREMENT, `name` varchar(255), PRIMARY KEY (`id`));");
        migrations.add("INSERT INTO `students` (`name`) VALUES ('student1');");
        migrations.add("INSERT INTO `students` (`name`) VALUES ('student2');");
        migrations.add("INSERT INTO `students` (`name`) VALUES ('student3');");
        for (String migration: migrations){
            state.execute(migration);
        }
    }

    public ResultSet select(String what, String from) throws SQLException {
        String query = "SELECT "+what+" FROM "+from+";";
        return state.executeQuery(query);
    }
    public void close(String which) throws SQLException {
        if(which.equals("state")){
            state.close();
        }else if(which.equals("connection")){
            connection.close();
        }else{
            System.out.println("Available to close: state, connection!");
        }
    }
}
