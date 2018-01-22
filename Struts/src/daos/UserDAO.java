package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
    public Integer check(String login, String password) {
		Integer i = 0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            
            // adding a new Address
            final Statement lStatement = lConnection.createStatement();
            String requete = "SELECT * FROM User WHERE login = '"+login+"' AND password = '"+password+"'";	
			final ResultSet lResulset=  lStatement.executeQuery(requete);

			while (lResulset.next()) {
				i+=1;
			}
        } catch (NamingException e) {
        
            e.getMessage();
        
        } catch (SQLException e) {

            e.getMessage();
            
        }
        return i;
    }
}
