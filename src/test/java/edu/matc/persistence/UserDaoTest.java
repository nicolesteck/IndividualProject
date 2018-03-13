package edu.matc.persistence;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * The Generic dao.
     */
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        logger.info("BeforeEach");
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = (List<User>)genericDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Curry", retrievedUser.getLastName());
    }

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        String newName = "Wolfenstein";
        User thisUser = (User)genericDao.getById(3);
        thisUser.setLastName(newName);
        genericDao.saveOrUpdate(thisUser);
        User thatUser = (User)genericDao.getById(3);
        assertEquals(thisUser, thatUser);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Joe", "Trebek");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);

    }

    /**
     * Insert with connection success.
     */
    @Test
    void insertWithConnectionSuccess() {
        User newUser = new User("John", "TrebekConnect");
        Connection connection = new Connection(newUser);

        newUser.addConnection(connection);

        int id = genericDao.insert(newUser);

        assertEquals(1, newUser.getConnections().size());

        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);

    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(5));
        assertNull(genericDao.getById(5));
    }


    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = (List<User>) genericDao.getByPropertyEqual("lastName", "Hensen");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<User> users = (List<User>) genericDao.getByPropertyLike("firstName", "ar");
        assertEquals(2, users.size());
    }




}