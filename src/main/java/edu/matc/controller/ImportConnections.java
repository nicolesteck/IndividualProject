package edu.matc.controller;

import edu.matc.entity.LinkedIn;
import edu.matc.util.PropertiesLoaderInterface;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static org.hibernate.boot.model.source.internal.hbm.CommaSeparatedStringHelper.split;

/**
 * The type Import connections.
 */
@WebServlet(
        name = "importConnections",
        urlPatterns = {"/importConnections"}
)

public class ImportConnections extends HttpServlet implements PropertiesLoaderInterface {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Import connections.
     *
     * @throws ServletException     the servlet exception
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     * @throws ExecutionException   the execution exception
     */
    public ImportConnections() throws ServletException, IOException, InterruptedException, ExecutionException {
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LinkedIn linkedIn = new LinkedIn();
        logger.info("=== OAuth Workflow ===");
        logger.info("");

        // Obtain the Authorization URL
        logger.info("Fetching the Authorization URL...");
        String authorizationUrl = linkedIn.getAuthorizationUrl();
        logger.info("Got the Authorization URL!");
        logger.info("Now go and authorize ScribeJava here:");
        logger.info("auth URL: " + authorizationUrl);
        logger.info("authorization code: the authorization code here");
        // REPLACING the in.nextLine() for code with the auth URL again
        final String prelimCode = req.getQueryString();

        String code = linkedIn.parseCode(prelimCode);

        logger.info("CODE:" + code);

        // Trade the Request Token and Verifier for the Access Token
        logger.info("Trading the Request Token for an Access Token...");
        OAuth20Service service = linkedIn.getService();
        try {
            linkedIn.retrieveAccessToken(code);
        } catch (InterruptedException ie) {
            logger.error("ERROR: INterrupted exception " + ie);
        } catch (ExecutionException ee) {
            logger.error("ERROR: Execution Exception " + ee);
        }


    }


}
