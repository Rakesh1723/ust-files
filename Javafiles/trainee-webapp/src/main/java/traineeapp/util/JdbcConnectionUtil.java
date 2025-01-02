package traineeapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {

    private static final String url="jdbc:postgresql://localhost:5432/ust_db";
    private static final String username="postgres";
    private static final String password="postgres";
    private static Connection connection = null;

    public static Connection createConnction(){
        try {
            if(connection!=null){
                return connection;
            }
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,username,password);
            return connection;
        }
        catch (SQLException ex){
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
