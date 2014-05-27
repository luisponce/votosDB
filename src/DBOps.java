
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DBOps {

    private static final String nombreDB = "votos";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection c = ConnectDB();
            
            
            
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBOps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection ConnectDB(){
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" 
                  + nombreDB + ".db");


        } catch ( ClassNotFoundException | SQLException e ) {
          System.err.println(e);
          System.exit(0);
        }
        System.out.println("Connected to database votos successfully");
        
        return c;
    }
    
}
