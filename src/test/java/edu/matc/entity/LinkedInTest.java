package edu.matc.entity;

import com.github.scribejava.core.oauth.OAuth20Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedInTest {

    LinkedIn linkedIn;

    @BeforeEach
    void setUp()throws Exception {
        linkedIn = new LinkedIn();

    }

    @Test
    void parseCode() {
    }




        @Test
        void getAuthorizationURLSuccess() throws Exception{

           // assertEquals("https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=789qxnkiciz8ny&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fnsindieproject%2F&scope=r_basicprofile&state=13378675309", linkedIn.getAuthorizationUrl());
    assertEquals("    :)    ", linkedIn.getAuthorizationUrl());
        }

    @Test
    void getServiceSuccess() {

        OAuth20Service service = linkedIn.getService();
        assertNotNull(service);
    }


    @Test
    void retrieveAccessTokenSuccess() throws Exception {

        assertEquals("???", linkedIn.retrieveAccessToken("AQS9moCUybDXAk7QtKu-NPtFCJn8aMVajmElY8C-zKJsBYVX8_ap9w0aP1miMMa3WZgAwy-vI3oYAA-z2WfGochKjp584IT5lo2ydPgwuqFSZWHWy6MzaFdNIdfupcDJNaWjb0kpRrHoXyRZbMUBfXmtQ41AOQ"));

/*
    @Disabled
    @Test
    void getProfileSuccess() throws Exception{
        assertEquals("???", linkedIn.getProfile("AQWoJ21dldW1YvGsHHxQf5O_SSlO3g224xsnpSwYEMoHSZdsQuqNfA9O5W_DJ6ni8k4dlga8Hbk3Hp-seJim7h62yR9k0YyB-wRptwQ_M0EnSkUtWGNYe5hNPfxq4OEG27BHhKu1ahkmLspPOi_DLWZRsGb8QFEIvwvkiBrwyeDa82rhlOplED_zFOTFXY3DV6fJ1r6CnTlazH5obC9PBqj_7cZvFj-sl4JAXw8zF6NA1sVTeqmyHap25l7lpG2w5_uzrC-iaMHSH2EP34RADDwkFgkmE5gBSl6sTzB5py3v3jy_xCTT7Z5mUHhX-lGMH33K6zr-rYhNDXkJ5-s5pTEj8QlD-A",""));
    }
*/

    }

}