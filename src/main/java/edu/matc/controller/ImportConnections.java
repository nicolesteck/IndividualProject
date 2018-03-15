package edu.matc.controller;

import com.github.scribejava.apis.LinkedInApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.core.oauth.OAuthService;
import edu.matc.util.PropertiesLoaderInterface;
import java.util.Scanner;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.apis.LinkedInApi20;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "importConnections",
        urlPatterns = {"/importConnections"}
)

public class ImportConnections extends HttpServlet implements PropertiesLoaderInterface {


    /**
     * https://api.linkedin.com/v1/people/~:(id,num-connections,picture-url,first-name,last-name,summary,specialties,industry,location,headline,positions)?format=json
     */

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String NETWORK_NAME = "LinkedIn";
    private static final String PROTECTED_RESOURCE_URL = "https://api.linkedin.com/v1/people/~:(%s)";
    Properties properties;

    public ImportConnections() throws ServletException, IOException, InterruptedException, ExecutionException {
        properties = loadProperties("/clientKey.properties");
        completeImport();

    }


    public void completeImport() throws IOException, InterruptedException, ExecutionException {
        final String clientId = properties.getProperty("clientKey");
        final String clientSecret = properties.getProperty("clientSecret");
        final OAuth20Service service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .scope("r_basicprofile r_emailaddress") // replace with desired scope
                .callback("http://localhost:8080/nsindieproject/")
                .state("13378675309")
                .build(LinkedInApi20.instance());
        final Scanner in = new Scanner(System.in);

        logger.info("=== OAuth Workflow ===");
        logger.info("");

        // Obtain the Authorization URL
        logger.info("Fetching the Authorization URL...");
        final String authorizationUrl = service.getAuthorizationUrl();
        logger.info("Got the Authorization URL!");
        logger.info("Now go and authorize ScribeJava here:");
        logger.info("auth URL: " + authorizationUrl);
        logger.info("And paste the authorization code here");
        // REPLACING the in.nextLine() for code with the auth URL again
        final String code = authorizationUrl;
       // final String code = in.nextLine();
        logger.info("");

        // Trade the Request Token and Verifier for the Access Token
        logger.info("Trading the Request Token for an Access Token...");
        final OAuth2AccessToken accessToken = service.getAccessToken(code);
        logger.info("Got the Access Token!");
        logger.info("(The raw response looks like this: " + accessToken.getRawResponse() + "')");
        logger.info("[newline]");

        // Now let's go and ask for a protected resource!
        logger.info("Now we're going to access a protected resource...");
        while (true) {
            logger.info("Paste profile query for fetch (firstName, lastName, etc) or 'exit' to stop example");
            final String query = "https://api.linkedin.com/v1/people/~:(id,num-connections,picture-url,first-name,last-name,summary,specialties,industry,location,headline,positions)?format=json";
          //  final String query = in.nextLine();
            logger.info("");

            if ("exit".equals(query)) {
                break;
            }

            final OAuthRequest request = new OAuthRequest(Verb.GET, String.format(PROTECTED_RESOURCE_URL, query));
            request.addHeader("x-li-format", "json");
            request.addHeader("Accept-Language", "ru-RU");
            service.signRequest(accessToken, request);
            final Response response = service.execute(request);
            logger.info("");
            logger.info(response.getCode());
            logger.info(response.getBody());

            logger.info("");
        }
    }

}
