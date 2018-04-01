package edu.matc.entity;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.apis.LinkedInApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import edu.matc.util.PropertiesLoaderInterface;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * The type Linked in.
 */
@Getter
@Setter
public class LinkedIn implements PropertiesLoaderInterface {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String NETWORK_NAME = "LinkedIn";
    private static final String PROTECTED_RESOURCE_URL = "https://api.linkedin.com/v1/people/~:(%s)";
    private Properties properties;
    String query;
    /**
     * The Client id.
     */
    final String clientId;
    /**
     * The Client secret.
     */
    final String clientSecret;
    /**
     * The Service.
     */
    final OAuth20Service service;


    /**
     * Instantiates a new Linked in.
     *
     * @throws IOException the io exception
     */
    public LinkedIn() throws IOException {
        //query = "firstName,lastName,headline,id,location,industry,currentShare,numConnections,summary,specialties,positions";
        //query = "firstName,lastName";
        // temporarily removing id and location
        query = "firstName,lastName,industry,headline,numConnections,summary,specialties";
        properties = loadProperties("/clientKey.properties");
        clientSecret = properties.getProperty("clientSecret");
        clientId = properties.getProperty("clientKey");
        service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .scope("r_basicprofile") // replace with desired scope
                .callback("http://localhost:8080/nsindieproject/linkedInLogin")
                .state("13378675309")
                .debug()
                .build(LinkedInApi20.instance());
    }

    /**
     * Gets authorization url.
     *
     * @return the authorization url
     */
    public String getAuthorizationUrl() {
        final String authorizationUrl = service.getAuthorizationUrl();
        logger.info("authorization url: " + authorizationUrl);
        return authorizationUrl;
    }

    // after clicking on the link returned by the getAuthorizationUrl, the user will be redirected to
    // the callback url with a code appended to it. This method takes that code as a param here and returns the access token.
    public OAuth2AccessToken retrieveAccessToken(String code) throws InterruptedException, ExecutionException, IOException {
        OAuth2AccessToken accessToken = service.getAccessToken(code);
        return accessToken;
    }

    /**
     * Gets access token handled.
     *
     * @param service the service
     * @param code    the code
     * @return the access token handled
     */
    public OAuth2AccessToken getAccessTokenHandled(OAuth20Service service, String code) {


            try {
                OAuth2AccessToken accessToken = service.getAccessToken(code);
                logger.info("Got the Access Token!");
                logger.info("(The raw response looks like this: " + accessToken.getRawResponse() + "')");
                logger.info("access token: " + accessToken);

                // Now let's go and ask for a protected resource!
                logger.info("Now we're going to access a protected resource...");
                while (true) {
                    logger.info("Paste profile query for fetch (firstName, lastName, etc) or 'exit' to stop example");
                    getProfile(accessToken, query);
                    return accessToken;
                }

            } catch (InterruptedException ie) {
                logger.error("Interrupted exception");
            } catch (IOException io) {
                logger.error("IO exception");
            } catch (ExecutionException ee) {
                logger.error("execution exception");
            }

    return null;
    }

    /**
     * Parse code string.
     *
     * @param prelimCode the prelim code
     * @return the string
     */
    public String parseCode(Object prelimValue) {
        String stringCode = (String)prelimValue;
        String delims = "[ &=]+";
        String[] stringItems = stringCode.split(delims);
        if (prelimValue instanceof String) {
            String code = stringItems[1];
            return code;
        } else if (prelimValue instanceof Response) {
            String profileContents = stringItems[1];
            return profileContents;
        }
        return null;
    }

    public User buildUser(String profileContents) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{'name' : 'mkyong'}";

    //JSON from String to Object
        User user = new User();
        user = mapper.readValue(profileContents, User.class);

        return user;
    }

    /**
     * Gets profile.
     *
     * @param accessToken the access token
     * @param query       the query
     * @return the profile
     * @throws InterruptedException the interrupted exception
     * @throws ExecutionException   the execution exception
     * @throws IOException          the io exception
     */
    public Response getProfile(OAuth2AccessToken accessToken, String query) throws InterruptedException, ExecutionException, IOException {
        final OAuthRequest request = new OAuthRequest(Verb.GET, String.format(PROTECTED_RESOURCE_URL, query));
        request.addHeader("x-li-format", "json");
        request.addHeader("Accept-Language", "en-US");
        service.signRequest(accessToken, request);
        final Response response = service.execute(request);
        logger.info("");
        logger.info(response.getCode());
        logger.info(response.getBody());

        logger.info("");
        return response;
    }
}