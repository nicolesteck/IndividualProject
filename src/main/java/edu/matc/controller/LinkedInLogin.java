package edu.matc.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import edu.matc.entity.LinkedIn;
import edu.matc.util.PropertiesLoaderInterface;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.scribejava.core.model.Response;


import static org.hibernate.boot.model.source.internal.hbm.CommaSeparatedStringHelper.split;

/**
 * The type Import connections.
 */
@WebServlet(
        name = "linkedInLogin",
        urlPatterns = {"/linkedInLogin"}
)

public class LinkedInLogin extends HttpServlet implements PropertiesLoaderInterface {
    private final Logger logger = LogManager.getLogger(this.getClass());



    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LinkedIn linkedIn = new LinkedIn();
       // OAuth20Service service = linkedIn.getService();
        String authorizationUrl = linkedIn.getAuthorizationUrl();
        final String prelimCode = req.getQueryString();
        String code = linkedIn.parseCode(prelimCode);
        logger.info(code);

        try {
            OAuth2AccessToken accessToken = linkedIn.retrieveAccessToken(code);
            String query = linkedIn.getQuery();
            Response profile = linkedIn.getProfile(accessToken, query);

            req.setAttribute("profile", profile);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/linkedInLogin.jsp");
            dispatcher.forward(req, resp);
        } catch (InterruptedException ie) {
            logger.error("ERROR: Interrupted exception " + ie);
        } catch (ExecutionException ee) {
            logger.error("ERROR: Execution Exception " + ee);
        } catch (ServletException se) {
            logger.error("ERROR: Servlet Exception " + se);
        }


    }


}
