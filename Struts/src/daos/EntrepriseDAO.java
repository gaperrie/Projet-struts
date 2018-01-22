/**
 * 
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Contact;
//import domain.Groupe;
import domain.Entreprise;

/**
 * @author gaelp
 *
 */
public class EntrepriseDAO {
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
    
    public String addEntreprise(Contact lContact, Integer lNumSiret) {
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            String lReq = "INSERT INTO Entreprise (`numSiret`,`contactId`) VALUES("+lNumSiret+","+lContact.getId()+")";
            System.out.println(lReq);
            Statement lStatement = lConnection.createStatement(); 
            lStatement.executeUpdate(lReq);
            lStatement.close();
            return null;
        } catch (NamingException e) {
        
            return "NamingException : " + e.getMessage();
        
        } catch (SQLException e) {

            return "SQLException : " + e.getMessage();
        }
    }

	public String readNumSiret(Integer id) {
		String numSiret = null;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT numSiret FROM entreprise WHERE contactid =" + id + "";	
			//System.out.println("REQ : "+requete);
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				numSiret = (lResulset.getString("numSiret"));
			}
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return numSiret;
	}

	public Integer updateEntreprise(Entreprise lEntreprise) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            final Statement lStatement = lConnection.createStatement();
			String requete = "UPDATE Entreprise SET numSiret ='" + lEntreprise.getNumSiret()+"' WHERE contactId ='" + lEntreprise.getContact().getId() + "'";
			System.out.println("Requete : "+requete);
			nbLigne = lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
	}
	
}
