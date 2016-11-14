import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by myrlin on 11/13/2016.
 */
public class Main {

    // setup the database driver
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/cube";
    static final String USER = "myrlin";
    static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception { //TODO handle exceptions properly

        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);


        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS CubeInfo (THING VARCHAR(50), SECSOLVE FLOAT)");
        statement.execute("INSERT INTO CubeInfo VALUES ('Cubestormer II robot', 5.27) ");
        statement.execute("INSERT INTO CubeInfo VALUES ('Fakhri Raihaan (using his feet)', 27.93) ");
        statement.execute("INSERT INTO CubeInfo VALUES ('Ruxin Liu (age 3)', 99.33) ");
        statement.execute("INSERT INTO CubeInfo VALUES ('Mats Valk (human record holder)', 6.27) ");


        ResultSet rs = statement.executeQuery("SELECT * FROM CubeInfo");
        while (rs.next()) {
            System.out.println("The Thing is " + rs.getString(1));
            System.out.println("The Time taken is " + rs.getFloat(2));
            System.out.println();
        }


        System.out.println("");



        statement.execute("DROP TABLE CubeInfo");
        rs.close();
        statement.close();
        connection.close();
    }


}
