package com.Goit11.Flyway;

import org.flywaydb.core.Flyway;

import org.flywaydb.core.api.Location;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class FlywayApplication {
    private static final String DEFAULT_FILE_NAME = "application.properties";
    private Flyway flyway;

    public FlywayApplication setup() throws IOException {
        Properties properties = new Properties();
        properties.load(FlywayApplication.class.getClassLoader().getResourceAsStream(DEFAULT_FILE_NAME));
        String url = properties.getProperty(Constants.FLYWAY_CONNECTION_URL);
        String user = properties.getProperty(Constants.FLYWAY_USER);
        String password = properties.getProperty(Constants.FLYWAY_PASSWORD);

        Location migrations = new Location("db/migration");
        Location mixture = new Location("db/mixture");
        flyway = Flyway.configure()
                .encoding(StandardCharsets.UTF_8)
                .locations(migrations,mixture)
                .dataSource(url, user, password)
                .placeholderReplacement(false)
                .failOnMissingLocations(true)
                .load();
        return this;
    }

    public void migrate() {
        flyway.migrate();
    }
}
