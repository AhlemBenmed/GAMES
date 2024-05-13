package constants;
import java.awt.Color;
public class CommonConstants {
    
    public static final Color PRIMARY_COLOR = Color.decode("#000814");
    public static final Color SECONDARY_COLOR = Color.WHITE;
    public static final Color TEXT_COLOR = new Color(255, 171, 63);

     //jdbc:mysql:ip_address/schema-name
    public static final String DB_URL = "jdbc:mysql:127.0.0.1:3308/loginschema";

    public static final String DB_USERNAME = "root";

    public static final String DB_PASSWORD = "ahlem123456789";
    public static final String DB_USERS_TABLE_NAME = "users";
}
