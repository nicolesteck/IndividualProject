package edu.matc.persistence;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionDaoTest {

    ConnectionDao dao;

    @BeforeEach
    void setUp() {
        dao = new ConnectionDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllConnectionsSuccess() {
        List<Connection> connections = dao.getAllConnections();
        assertEquals(4, connections.size());
    }

    @Test
    void getByIdSuccess() {
        Connection retrievedConnection = dao.getConnectionById(3);
        assertNotNull(retrievedConnection);
        assertEquals("Carpenter", retrievedConnection.getLastName());
    }

    @Test
    void saveOrUpdate() {
        String newName = "Wolfenstein";
        String newFirst = "Cattenberg";
        Connection thisConnection = dao.getConnectionById(4);
        thisConnection.setLastName(newName);
        thisConnection.setFirstName(newFirst);
        dao.saveOrUpdate(thisConnection);
        Connection thatConnection = dao.getConnectionById(4);
        assertEquals(newName, thatConnection.getLastName());
    }

    @Test
    void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(1);
        Connection newConnection = new Connection(user, "Woolf", "theCat");
        user.addConnection(newConnection);

        int id = dao.insert(newConnection);
        assertNotNull(newConnection);
        assertNotEquals(0,id);
        Connection insertedConnection = dao.getConnectionById(id);
        assertEquals("Woolf", insertedConnection.getFirstName());
        assertEquals("Joe", insertedConnection.getUser().getFirstName());

    }

    @Test
    void getConnectionIdSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(3);
        Connection newConnection = new Connection(user, "Major", "theDog");
        int connectionId = newConnection.getConnectionId();
        assertNotNull(connectionId);
        user.addConnection(newConnection);

        int id = dao.insert(newConnection);


    }

    @Test
    void getLinkedInIdSuccess() {
        Connection connection = dao.getConnectionById(3);
        assertEquals(753475775, connection.getLinkedInId());

    }

    @Test
    void setLinkedInIdSuccess() {
        Connection connection = dao.getConnectionById(4);
        connection.setLinkedInId(923459883);
        assertEquals(923459883, connection.getLinkedInId());
    }

    @Test
    void getNumberOfConnectionsSuccess() {
        Connection connection = dao.getConnectionById(3);
        assertEquals(333, connection.getNumberOfConnections());

    }

    @Test
    void setNumberOfConnectionsSuccess() {
        Connection connection = dao.getConnectionById(4);
        connection.setNumberOfConnections(99);
        assertEquals(99, connection.getNumberOfConnections());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getConnectionById(2));
        assertNull(dao.getConnectionById(2));
    }


    @Test
    void getByPropertyEqual() {
        List<Connection> connections = dao.getByPropertyEqual("firstName", "Julie");
        assertNotNull(connections);
        assertEquals(1, connections.size());
    }

    @Test
    void getByPropertyLike() {
        List<Connection> connections = dao.getByPropertyLike("firstName", "J");
        assertEquals(3, connections.size());
    }




}