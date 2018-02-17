package edu.matc.persistence;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {


    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }
    @Test
    void getAllUsersSuccess() {
        List<User> users = (List<User>)genericDao.getAll();
        assertEquals(6, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Curry", retrievedUser.getLastName());
    }

    @Test
    void saveOrUpdate() {
        String newName = "Wolfenstein";
        User thisUser = (User)genericDao.getById(3);
        thisUser.setLastName(newName);
        genericDao.saveOrUpdate(thisUser);
        User thatUser = (User)genericDao.getById(3);
        assertEquals(thisUser, thatUser);
    }

    @Test
    void insertSuccess() {
        User newUser = new User("Joe", "Trebek");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("Joe", insertedUser.getFirstName());

    }

    @Test
    void insertWithConnectionSuccess() {
        User newUser = new User("John", "TrebekConnect");
        Connection connection = new Connection(newUser);

        newUser.addConnection(connection);

        int id = genericDao.insert(newUser);

        assertEquals(1, newUser.getConnections().size());

        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("John", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getConnections().size());

    }

    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(5));
        assertNull(genericDao.getById(5));
    }


    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = (List<User>) genericDao.getByPropertyEqual("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<User> users = (List<User>) genericDao.getByPropertyLike("firstName", "ar");
        assertEquals(2, users.size());
    }




}