import java.sql.*;

public class DataBaseRPG {
	
	
	public static Connection Connection() {
		// Va stocker la connection a la base
	    Connection c = null;
	    // Va Stocker les requetes
	    //Statement stmt = null;
	    
	    try {
	  	 //Ligne Obligatoire, je ne sais pas encore pourquoi...
	       Class.forName("org.sqlite.JDBC");
	       // On se connecte a la base de donnée RPG
	       c = DriverManager.getConnection("jdbc:sqlite:RPG");
	       
	       
	       //stmt = c.createStatement();
	       //ResultSet rs = stmt.executeQuery( "SELECT * FROM Personnage;" );
	       
	       /*while ( rs.next() ) {
	           String nom = rs.getString("Nom");
	           int Vie = rs.getInt("Vie");
	           
	           System.out.println( "NOM = " + nom );
	           System.out.println( "VIE = " + Vie );
	        } */
	       	
	       	
	        //rs.close();
	        //stmt.close();
	        //c.close();
	       
	    } catch ( Exception e ) {
	       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       System.exit(0);
	    }
	    
	    return c;
	}
	
	public static void selectMonstre(String niveau) {
		
		Connection c = Connection();
		Statement stmt = null;
		
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Monstres WHERE Niveau =" + niveau);
			
			while ( rs.next()) {
				String nom = rs.getString("Nom");
				int vie = rs.getInt("Vie");
				
				System.out.println("Nom = " + nom);
				System.out.println("Vie = " + vie);
			}
			
			rs.close();
			stmt.close();
			c.close();
			
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		
		
		
		
		
		
		
		
	}
    
}
