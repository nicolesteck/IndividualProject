package edu.matc.persistence;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Connection dao test.
 */
class ConnectionDaoTest {

    /**
     * The Generic dao.
     */
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Connection.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets all connections success.
     */
    @Test
    void getAllConnectionsSuccess() {
        List<Connection> connections = (List<Connection>)genericDao.getAll();
        assertEquals(4, connections.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Connection retrievedConnection = (Connection)genericDao.getById(3);
        assertNotNull(retrievedConnection);
        assertEquals("Carpenter", retrievedConnection.getLastName());
    }

    /**
     * Save or update.
     */
    @Test // Genericized
    void saveOrUpdate() {
        String newName = "Wolfenstein";
        String newFirst = "Cattenberg";
        Connection thisConnection = (Connection)genericDao.getById(4);
        thisConnection.setLastName(newName);
        thisConnection.setFirstName(newFirst);
        genericDao.saveOrUpdate(thisConnection);
        Connection thatConnection = (Connection)genericDao.getById(4);
        assertEquals(thisConnection, thatConnection);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        GenericDao genericDao = new GenericDao(User.class);
        GenericDao genericConnectionDao = new GenericDao(Connection.class);
        User user = (User)genericDao.getById(1);
        Connection newConnection = new Connection(user, "Woolf", "theCat");
        user.addConnection(newConnection);


        int id = genericConnectionDao.insert(newConnection);
        assertNotNull(newConnection);
        assertNotEquals(0,id);
        Connection insertedConnection = (Connection)genericConnectionDao.getById(id);
        assertEquals(newConnection, insertedConnection);

    }

    /**
     * Gets connection id success.
     */
    @Test
    void getConnectionIdSuccess() {
        GenericDao genericDao = new GenericDao(User.class);
        User user = (User)genericDao.getById(3);
        Connection newConnection = new Connection(user, "Major", "theDog");
        int connectionId = newConnection.getConnectionId();
        assertNotNull(connectionId);
        user.addConnection(newConnection);

        int id = genericDao.insert(newConnection);


    }

    /**
     * Gets linked in id success.
     */
    @Test
    void getLinkedInIdSuccess() {
        Connection connection = (Connection)genericDao.getById(3);
        assertEquals(753475775, connection.getLinkedInId());

    }

    /**
     * Sets linked in id success.
     */
    @Test
    void setLinkedInIdSuccess() {
        Connection connection = (Connection)genericDao.getById(4);
        connection.setLinkedInId(923459883);
        assertEquals(923459883, connection.getLinkedInId());
    }

    /**
     * Gets number of connections success.
     */
    @Test
    void getNumberOfConnectionsSuccess() {
        Connection connection = (Connection)genericDao.getById(3);
        assertEquals(333, connection.getNumberOfConnections());

    }

    /**
     * Sets number of connections success.
     */
    @Test
    void setNumberOfConnectionsSuccess() {
        Connection connection = (Connection)genericDao.getById(4);
        connection.setNumberOfConnections(99);
        assertEquals(99, connection.getNumberOfConnections());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }


    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        List<Connection> connections = (List<Connection>)genericDao.getByPropertyEqual("firstName", "Julie");
        assertNotNull(connections);
        assertEquals(1, connections.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<Connection> connections = (List<Connection>)genericDao.getByPropertyLike("firstName", "J");
        assertEquals(3, connections.size());
    }




}