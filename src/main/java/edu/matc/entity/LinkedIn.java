package edu.matc.entity;


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
    private static final String PROTECTED_RESOURCE_URL = "https%3A%2F%2Fapi.linkedin.com%2Fv1%2Fpeople%2F~%3A%28%25s%29%22%0D%0A";
    private Properties properties;
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
        properties = loadProperties("/clientKey.properties");
        clientSecret = properties.getProperty("clientSecret");
        clientId = properties.getProperty("clientKey");
        service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .scope("r_basicprofile") // replace with desired scope
                .callback("http%3A%2F%2Flocalhost%3A8080%2Fnsindieproject%2F")
                .state("13378675309")
                .debug()
                .build(LinkedInApi20.instance());
        final Scanner in = new Scanner(System.in);
    }

    /**
     * Gets authorization url.
     *
     * @return the authorization url
     */
    public String getAuthorizationUrl() {
        final String authorizationUrl = service.getAuthorizationUrl();
        return authorizationUrl;
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
                    final String query = "id,num-connections,picture-url,first-name,last-name,summary,specialties,industry,location,headline,positions";
                    getProfile(accessToken, query);

                }
                return accessToken;
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
    public String parseCode(String prelimCode) {
        String delims = "[ &=]+";
        String[] stringItems = prelimCode.split(delims);
        String code = stringItems[1];
        return code;
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
    public String getProfile(OAuth2AccessToken accessToken, String query) throws InterruptedException, ExecutionException, IOException {
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