package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");


    }

    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(6, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getUserById(3);
        assertNotNull(retrievedUser);
        assertEquals("Curry", retrievedUser.getLastName());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insertSuccess() {
        User newUser = new User("Joe", "Trebek");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getUserById(id);
        assertEquals("Joe", insertedUser.getFirstName());

    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getUserById(5));
        assertNull(dao.getUserById(5));
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }




}