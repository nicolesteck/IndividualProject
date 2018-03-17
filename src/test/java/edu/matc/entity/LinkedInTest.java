package edu.matc.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedInTest {
    @Test
    void getAuthorizationUrl() {
    }

    @Test
    void parseCode() {
    }

    LinkedIn linkedIn;

    @BeforeEach
    void setUp()throws Exception {
        linkedIn = new LinkedIn();

    }

    @Test
    void getAuthorizationURLSuccess() throws Exception{

       // assertEquals("https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=789qxnkiciz8ny&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fnsindieproject%2F&scope=r_basicprofile&state=13378675309", linkedIn.getAuthorizationUrl());
assertEquals("https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=789qxnkiciz8ny&redirect_uri=http%253A%252F%252Flocalhost%253A8080%252Fnsindieproject%252F&scope=r_basicprofile&state=13378675309", linkedIn.getAuthorizationUrl());
    }
    /*
    @Disabled
    @Test
    void retrieveAccessTokenSuccess() throws Exception{

        assertEquals("???", linkedIn.getAccessTokenHandled("Your stuff here. ",""));
    }
    @Disabled
    @Test
    void getProfileSuccess() throws Exception{
        assertEquals("???", linkedIn.getProfile("Result from access token"));
    }
    */


}