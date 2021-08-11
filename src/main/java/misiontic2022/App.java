package misiontic2022;

import java.sql.SQLException;

import misiontic2022.util.JDBCUtilities;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        try {
            var coon = JDBCUtilities.getConnection();
            System.out.println("listu");
            coon.close();
        } catch (SQLException e) {
            System.err.println(":c malu"+ e);
            e.printStackTrace();
        }
        
        
    }
}
