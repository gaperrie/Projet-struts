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

import domain.Groupe;

public class GroupeDAO {
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
    
    public String addGroupe(final Groupe pGroupe) {
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Groupe
/*            final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement("INSERT INTO Groupe (`groupName`) VALUES(?)");
            lPreparedStatementCreation.setString(1, pGroupe.getGroupName());
            lPreparedStatementCreation.executeUpdate();
            lPreparedStatementCreation.close();*/
            String lReq = "INSERT INTO Groupe (`groupName`) VALUES('"+pGroupe.getGroupName()+"')";
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

    
    public ArrayList<Groupe> readGroupe() {
		ArrayList<Groupe> listGroupe = new ArrayList<Groupe>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Groupe
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT g.groupId, groupName, count(cg.contactId) FROM Groupe g LEFT JOIN ContactGroup cg ON g.groupId = cg.groupId  GROUP BY g.groupId";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Groupe lGroupe = new Groupe();
				lGroupe.setGroupId(lResulset.getInt("groupId"));
				lGroupe.setGroupName(lResulset.getString("groupName"));
				lGroupe.setNbContact(lResulset.getInt("count(cg.contactId)"));
				listGroupe.add(lGroupe);
			}

        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return listGroupe;
    }

    public Groupe showGroupe(Integer pId) {
		Groupe lGroupe = new Groupe();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Groupe
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT groupeId, groupName FROM Groupe WHERE groupId ='" + pId + "'";	
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			lGroupe.setGroupId(lResulset.getInt("groupId"));
			lGroupe.setGroupName(lResulset.getString("groupName"));


        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return lGroupe;
    }    
    
    public Integer deleteGroupe(Integer pId) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Groupe
            final Statement lStatement = lConnection.createStatement();
			String requete = "DELETE FROM Groupe WHERE groupId ='" + pId + "'";		
			nbLigne =  lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }
    
    public Integer updateGroupe(Groupe pGroupe) {
		Integer nbLigne = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Groupe
            final Statement lStatement = lConnection.createStatement();
			String requete = "UPDATE Groupe SET groupName ='" + pGroupe.getGroupName() + "' WHERE groupId ='" + pGroupe.getGroupId() + "'";
			nbLigne = lStatement.executeUpdate(requete);
			
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
		return nbLigne;
    }


	public ArrayList<Groupe> readGroupeByContactId(Integer id) {
		ArrayList<Groupe> listGroupe = new ArrayList<Groupe>();
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Groupe
            final Statement lStatement = lConnection.createStatement();
			String requete = "SELECT g.groupId, g.groupName FROM Groupe g WHERE groupId NOT IN(SELECT groupId FROM ContactGroup where contactId = "+id+")";
			
			final ResultSet lResulset=  lStatement.executeQuery(requete);
			
			while (lResulset.next()) {
				Groupe lGroupe = new Groupe();
				lGroupe.setGroupId(lResulset.getInt("groupId"));
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
