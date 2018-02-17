package edu.matc.controller;

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
@WebServlet(
        urlPatterns = {"/allUsers"}
)

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */


public class AllUsers extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao dao = new GenericDao(User.class);
        req.setAttribute("users", dao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allUsers.jsp");
        dispatcher.forward(req, resp);
        logger.info("In the doGet of allUsers");
    }

}
