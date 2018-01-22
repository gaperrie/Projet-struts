/**
 * 
 */
package daos;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Contact;
import domain.Address;

/**
 * @author gaelp
 *
 */
public class AddressDAO {
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
    
    public String addAddress(final Address pAddress) {
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            //System.out.println(pAddress.getStreet()+" "+pAddress.getCity()+ " "+pAddress.getCountry()+" "+pAddress.getZip()+" "+pAddress.getContact().getId());
            // adding a new Address
            /*final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement("INSERT INTO `address`(`street`, `city`, `country`, `zip`,`contactId`) VALUES(?, ?, ?, ?, ?)");
            lPreparedStatementCreation.setString(1, pAddress.getStreet());
            lPreparedStatementCreation.setString(2, pAddress.getCity());
            lPreparedStatementCreation.setString(3, pAddress.getCountry());
            lPreparedStatementCreation.setString(4, pAddress.getZip());
            lPreparedStatementCreation.setInt(5, pAddress.getContact().getId());
            lPreparedStatementCreation.executeUpdate();*/
            System.out.println("lAddress DAO : "+pAddress.toString());
            String lReq = "INSERT INTO `address`(`street`, `city`, `country`, `zip`,`contactId`) VALUES('"+pAddress.getStreet()+"', '"+pAddress.getCity()+"', '"+pAddress.getCountry()+"', '"+pAddress.getZip()+"', "+pAddress.getContact().getId()+")";
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

    
    public ArrayList<Address> readAddress() {
		ArrayList<Address> listAddress = new ArrayList<Address>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
            String requete = "SELECT a.`id`,`street`,`city`,`country` FROM `address` a,`contact` c WHERE a.contactId = c.id";	
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Address lAddress = new Address();
				lAddress.setId(lResulset.getInt("Address.id"));
				lAddress.setCity(lResulset.getString("city"));
				lAddress.setStreet(lResulset.getString("street"));
				lAddress.setCountry(lResulset.getString("country"));
				Contact lContact = new Contact(lResulset.getInt("contactId"), lResulset.getString("firstName"), lResulset.getString("lastName"), lResulset.getString("email"));
				lAddress.setContact(lContact);
				listAddress.add(lAddress);
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listAddress;
    }
    
    
    public Address showAddressByContact(Integer lContactId) {
		Address lAddress = new Address();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
            String requete = "SELECT a.`id`,`street`,`city`,`country`, `zip` FROM `address` a,`contact` c WHERE a.contactId = c.id AND contactId =" + lContactId + "";	
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			Contact lContact = new Contact();

			while (lResulset.next()) {
				lAddress.setId(lResulset.getInt("a.id"));
				lAddress.setCity(lResulset.getString("city"));
				lAddress.setStreet(lResulset.getString("street"));
				lAddress.setCountry(lResulset.getString("country"));
				lAddress.setZip(lResulset.getString("zip"));
				lAddress.setContact(lContact);
			}
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
        return lAddress;
    }
    

    public Address showAddress(Integer pId) {
		Address lAddress = new Address();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
            
            String requete = "SELECT a.`id`,`street`,`city`,`country` FROM `address` a,`contact` c WHERE a.contactId = c.id AND id ='" + pId + "'";	
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
			lAddress.setId(lResulset.getInt("Address.id"));
			lAddress.setCity(lResulset.getString("city"));
			lAddress.setStreet(lResulset.getString("street"));
			lAddress.setCountry(lResulset.getString("country"));
			Contact lContact = new Contact(lResulset.getInt("contactId"), lResulset.getString("firstName"), lResulset.getString("lastName"), lResulset.getString("email"));
			lAddress.setContact(lContact);
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return lAddress;
    }    
    
    public Integer deleteAddress(Integer pId) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
			String requete = "DELETE FROM Address WHERE id ='" + pId + "'";		
			nbLigne =  lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
    
    public Integer updateAddress(Address pAddress) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
			String requete = "UPDATE Address SET city ='" + pAddress.getCity() + "', country ='" + pAddress.getCountry() + "', zip ='" + pAddress.getZip() + "', street = '"+pAddress.getStreet() +"' WHERE id ='" + pAddress.getId() + "'";			
			nbLigne = lStatement.executeUpdate(requete);
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
}
