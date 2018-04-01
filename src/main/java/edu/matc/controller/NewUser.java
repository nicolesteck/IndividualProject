package edu.matc.controller;

import edu.matc.entity.ActionItem;
import edu.matc.entity.Role;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import edu.matc.persistence.GenericDao;

/**
 * The type All Action Items.
 */
@WebServlet(
        urlPatterns = {"/newUser"}
)

/**
 *  Displays action items
 */


public class NewUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        logger.debug("email: " + req.getParameter("email"));
        logger.debug("first name: " + (req.getParameter("firstName")));
        logger.debug("last name: " + (req.getParameter("lastName")));
        logger.debug("password: " + (req.getParameter("password")));
        Role role = new Role();
        role.setUser(user);
        role.setRoleName("user");
        user.addRole(role);
        GenericDao<User> dao = new GenericDao<>(User.class);
        logger.info("(NEWUSER) USER INFO: " + user);
        dao.insert(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/newUser.jsp");
        dispatcher.forward(req, resp);
    }

}
