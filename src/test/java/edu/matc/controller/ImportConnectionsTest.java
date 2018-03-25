package edu.matc.controller;

import com.github.scribejava.apis.LinkedInApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import edu.matc.util.PropertiesLoaderInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ImportConnectionsTest implements PropertiesLoaderInterface {
/*
    @BeforeEach
    void setUp() {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String NETWORK_NAME = "LinkedIn";
    private static final String PROTECTED_RESOURCE_URL = "https://api.linkedin.com/v1/people/~:(%s)";

    }

    @Disabled
    @Test
    void doGet() {
        Properties properties;
        properties = loadProperties("/resources/clientKey.properties");
        final String clientId = properties.getProperty("clientKey");
        final String clientSecret = properties.getProperty("clientSecret");
        final OAuth20Service service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .scope("r_basicprofile r_emailaddress") // replace with desired scope
                // .callback("http://example.com/callback")
                // .state("some_params")
                .build(LinkedInApi20.instance());
    }
    */

}