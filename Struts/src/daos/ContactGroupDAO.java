package daos;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.Groupe;

public class ContactGroupDAO {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
	public String addContactGroup(final ContactGroup pContactGroup) {
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            //System.out.println("DAO GroupID : "+pContactGroup.getGroupId()+" ContactId : "+pContactGroup.getContactId());
            // adding a new ContactGroup
            /*final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement("INSERT INTO ContactGroup (`groupId`,`contactId`) VALUES(?,?)");
            lPreparedStatementCreation.setInt(1, pContactGroup.getGroupId());
            lPreparedStatementCreation.setInt(2, pContactGroup.getContactId());
            lPreparedStatementCreation.executeUpdate();
            lPreparedStatementCreation.close();*/
            String lReq = "INSERT INTO ContactGroup (`groupId`,`contactId`) VALUES("+pContactGroup.getGroupId()+", "+pContactGroup.getContactId()+")";
            //System.out.println(lReq);
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
	
	
    public Integer deleteContactGroup(ContactGroup lContactGroup) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // delete a new ContactGroup
            final Statement lStatement = lConnection.createStatement();
			String requete = "DELETE FROM ContactGroup WHERE groupId ='" + lContactGroup.getGroupId() + "' AND contactId ='" + lContactGroup.getContactId() + "'";		
			nbLigne =  lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
    
    public ArrayList<Groupe> readGroupeById(Integer pId) {
		ArrayList<Groupe> listGroupe = new ArrayList<Groupe>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
            String requete = "select g.groupId, groupName FROM contactGroup cg, groupe g where cg.groupId = g.groupId and contactId = "+pId+"";	
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Groupe lGroupe = new Groupe();
				lGroupe.setGroupId(lResulset.getInt("g.groupId"));
				lGroupe.setGroupName(lResulset.getString("groupName"));
				listGroupe.add(lGroupe);
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listGroupe;
    }    
    
}
