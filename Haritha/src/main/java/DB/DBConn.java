package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author milinda
 */
public class DBConn {

    private static Connection conn;

    private DBConn() {
    }

    public static Connection getConn() throws Exception{
        if (conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:google:mysql://haritha-8f53e:us-central1:harithadb/haritha", "root", "IronMan@123");

//            conn = DriverManager.getConnection("jdbc:google:mysql://haritha-8f53e:us-central1:harithadb/haritha?user=root&amp;password=IronMan@123");

        }
        return conn;
    }
}
