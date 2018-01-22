package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Contact;

public class ContactDAO {
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
    
    public String addContact(final Contact pContact) {
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            /*PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement("INSERT INTO CONTACT(firstName, lastName, email) VALUES(?, ?, ?)",lPreparedStatementCreation.RETURN_GENERATED_KEYS);
            lPreparedStatementCreation.setString(1, pContact.getFirstName());
            lPreparedStatementCreation.setString(2, pContact.getLastName());
            lPreparedStatementCreation.setString(3, pContact.getEmail());
            lPreparedStatementCreation.executeUpdate();
            final ResultSet lResulset= lPreparedStatementCreation.getGeneratedKeys();
            System.out.println("dernier id :"+ lResulset.getLong(1));
            lPreparedStatementCreation.close();*/
            String lReq = "INSERT INTO CONTACT(firstName, lastName, email) VALUES('"+pContact.getFirstName()+"', '"+pContact.getLastName()+"', '"+pContact.getEmail()+"')";
            Integer lLastId = 0;
            Statement lStatement = lConnection.createStatement(); 
            lStatement.executeUpdate(lReq, Statement.RETURN_GENERATED_KEYS);
            ResultSet lResulset = lStatement.getGeneratedKeys();
            if (lResulset.next()){
            	lLastId = lResulset.getInt(1);
            }
            lResulset.close();
            lStatement.close();
            return ""+lLastId;
        } catch (NamingException e) {
        
            return "NamingException : " + e.getMessage();
        
        } catch (SQLException e) {

            return "SQLException : " + e.getMessage();
        }
    }

    
    public ArrayList<Contact> readContact() {
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		ArrayList<Integer> listNbGroupe = new ArrayList<Integer>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT c.id, c.firstName, c.lastName, c.email, count(cg.groupId) FROM `contact` c LEFT JOIN contactGroup cg ON c.id = cg.contactId GRoup by id";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Contact lContact = new Contact();
				lContact.setId(lResulset.getInt("c.id"));
				lContact.setFirstName(lResulset.getString("c.firstName"));
				lContact.setLastName(lResulset.getString("c.lastName"));
				lContact.setEmail(lResulset.getString("c.email"));
				lContact.setNbGroupe(lResulset.getInt("count(cg.groupId)"));
				listContact.add(lContact);
				
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listContact;
    }

    public Contact showContact(Integer pId) {
		Contact lContact = new Contact();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT id, firstName, lastName, email FROM contact WHERE id =" + pId + "";	
			//System.out.println("REQ : "+requete);
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				lContact.setId(lResulset.getInt("id"));
				lContact.setFirstName(lResulset.getString("firstName"));
				lContact.setLastName(lResulset.getString("lastName"));
				lContact.setEmail(lResulset.getString("email"));
			}
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return lContact;
    }    
    
    public Integer deleteContact(Integer pId) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "DELETE FROM contact WHERE id ='" + pId + "'";		
			nbLigne =  lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
    
    public Integer updateContact(Contact pContact) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "UPDATE contact SET lastName ='" + pContact.getLastName() + "', firstName ='" + pContact.getFirstName() + "', email='" + pContact.getEmail() + "' WHERE id ='" + pContact.getId() + "'";			
			nbLigne = lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage(); 
        }
		return nbLigne;
    }
    
    public ArrayList<Contact> readContactE() {
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		ArrayList<Integer> listNbGroupe = new ArrayList<Integer>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT c.id, c.firstName, c.lastName, c.email, count(cg.groupId) FROM `contact` c LEFT JOIN contactGroup cg ON c.id = cg.contactId RIGHT JOIN Entreprise e ON c.id = e.contactid GRoup by id";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Contact lContact = new Contact();
				lContact.setId(lResulset.getInt("c.id"));
				lContact.setFirstName(lResulset.getString("c.firstName"));
				lContact.setLastName(lResulset.getString("c.lastName"));
				lContact.setEmail(lResulset.getString("c.email"));
				lContact.setNbGroupe(lResulset.getInt("count(cg.groupId)"));
				listContact.add(lContact);
				
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listContact;
    }
    
    public ArrayList<Contact> readContactByGroupe(Integer groupeId) {
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		ArrayList<Integer> listNbGroupe = new ArrayList<Integer>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new contact
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT c.id, c.firstName, c.lastName, c.email FROM `contact` c JOIN contactGroup cg ON c.id = cg.contactId WHERE cg.groupId ="+groupeId+"";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Contact lContact = new Contact();
				lContact.setId(lResulset.getInt("c.id"));
				lContact.setFirstName(lResulset.getString("c.firstName"));
				lContact.setLastName(lResulset.getString("c.lastName"));
				lContact.setEmail(lResulset.getString("c.email"));
				listContact.add(lContact);
				
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listContact;
    }

}

