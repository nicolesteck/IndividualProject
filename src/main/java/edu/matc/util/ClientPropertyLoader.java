package edu.matc.persistence;

import java.io.IOException;
import java.util.Properties;

public class ClientPropertyLoader {

    private Properties properties;

    public ClientPropertyLoader() {
        loadProperties();
    }

    public void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/clientKey.properties"));
        } catch (IOException ioe) {
            System.out.println("ClientPropertyLoader.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("ClientPropertyLoader.loadProperties()..." + e);
            e.printStackTrace();
        }

    }
    }
}
