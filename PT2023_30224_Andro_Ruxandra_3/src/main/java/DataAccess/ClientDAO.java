package DataAccess;

import Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionFactory;


public class ClientDAO extends AbstractDAO<Client>{
   protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String createInsertStatement="INSERT INTO client(nume,email,age)"+ "VALUES (?,?,?)";
    private static String createSelectStatement="SELECT * FROM client where id = ?";

   public static Client findByIdClient(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client=null;
        //String query = createSelectQuery("id");
        try {
            statement = connection.prepareStatement(createSelectStatement);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            client=new Client(id,resultSet.getString("nume"),resultSet.getString("email"),resultSet.getInt("age"));

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:findById" + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return client;
    }

    public static int insert1(Client client) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        int newId=0;
        Client c;
        try {
            statement = connection.prepareStatement(createInsertStatement);
            statement.setString(1, client.getNume());
            statement.setString(2, client.getEmail());
            statement.setInt(3,20);
            statement.executeUpdate();
            resultSet=statement.getGeneratedKeys();
            if(resultSet.next())
                newId=resultSet.getInt(1);
               // c=resultSet.getObject(Client);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert" + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return newId;
    }
}
