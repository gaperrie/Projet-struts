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
import domain.PhoneNumber;

public class PhoneNumberDAO {
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
    
    public String addPhoneNumber(final PhoneNumber pPhoneNumber) {
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            /*final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement("INSERT INTO `phonenumber`(`phoneKind`, `phoneNumber`, `contactId`) VALUES (?,?,?");
            lPreparedStatementCreation.setString(1, pPhoneNumber.getPhoneKind());
            lPreparedStatementCreation.setString(2, pPhoneNumber.getPhoneNumber());
            lPreparedStatementCreation.setInt(3, pPhoneNumber.getContact().getId());
            lPreparedStatementCreation.executeUpdate();
            lPreparedStatementCreation.close();*/
            String lReq = "INSERT INTO `phonenumber`(`phoneKind`, `phoneNumber`, `contactId`)  VALUES('"+pPhoneNumber.getPhoneKind()+"', '"+pPhoneNumber.getPhoneNumber()+"', "+pPhoneNumber.getContact().getId()+")";
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

    
    public ArrayList<PhoneNumber> readPhoneNumber() {
		ArrayList<PhoneNumber> listPhoneNumber = new ArrayList<PhoneNumber>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT `id`,`phoneKind`,`phonenumber`,`contactId`, c.* FROM PhoneNumber p, Contact c WHERE p.contactId = c.id";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				PhoneNumber lPhoneNumber = new PhoneNumber();
				lPhoneNumber.setId(lResulset.getInt("p.id"));
				lPhoneNumber.setPhoneKind(lResulset.getString("phoneKind"));
				lPhoneNumber.setPhoneNumber(lResulset.getString("phonenumber"));
				Contact lContact = new Contact(lResulset.getInt("contactId"), lResulset.getString("firstName"),lResulset.getString("lastName"),lResulset.getString("email"));
				lPhoneNumber.setContact(lContact);
				listPhoneNumber.add(lPhoneNumber);
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listPhoneNumber;
    }

    public ArrayList<PhoneNumber> readPhoneNumberByContact(Integer pId) {
		ArrayList<PhoneNumber> listPhoneNumber = new ArrayList<PhoneNumber>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT p.`id`,`phoneKind`,`phonenumber`,`contactId`, c.* FROM PhoneNumber p, Contact c WHERE p.contactId = c.id and contactId = "+pId+"";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				PhoneNumber lPhoneNumber = new PhoneNumber();
				lPhoneNumber.setId(lResulset.getInt("p.id"));
				lPhoneNumber.setPhoneKind(lResulset.getString("phoneKind"));
				lPhoneNumber.setPhoneNumber(lResulset.getString("phonenumber"));
//				Contact lContact = new Contact(lResulset.getInt("contactId"), lResulset.getString("firstName"),lResulset.getString("lastName"),lResulset.getString("email"));
//				lPhoneNumber.setContact(lContact);
				listPhoneNumber.add(lPhoneNumber);
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listPhoneNumber;
    }    
    
    public PhoneNumber showPhoneNumber(Integer pId) {
		PhoneNumber lPhoneNumber = new PhoneNumber();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT `id`,`phoneKind`,`phonenumber`,`contactId`, c.* FROM PhoneNumber p, Contact c WHERE p.contactId = c.id AND p.contactId ='" + pId + "'";	
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			lPhoneNumber.setId(lResulset.getInt("p.id"));
			lPhoneNumber.setPhoneKind(lResulset.getString("phoneKind"));
			lPhoneNumber.setPhoneNumber(lResulset.getString("phonenumber"));
			Contact lContact = new Contact(lResulset.getInt("contactId"), lResulset.getString("firstName"),lResulset.getString("lastName"),lResulset.getString("email"));
			lPhoneNumber.setContact(lContact);


        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return lPhoneNumber;
    }    
    
    public Integer deletePhoneNumber(Integer pId) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            final Statement lStatement = lConnection.createStatement();
			String requete = "DELETE FROM PhoneNumber WHERE id ='" + pId + "'";		
			nbLigne =  lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
    
    public Integer updatePhoneNumber(PhoneNumber pPhoneNumber) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new PhoneNumber
            final Statement lStatement = lConnection.createStatement();
			String requete = "UPDATE PhoneNumber SET phoneNumber ='" + pPhoneNumber.getPhoneNumber() + "', phoneKind ='" + pPhoneNumber.getPhoneKind() + "', contactId ='"+pPhoneNumber.getContact().getId()+"' WHERE id ='" + pPhoneNumber.getId() + "'";
			nbLigne = lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
}
