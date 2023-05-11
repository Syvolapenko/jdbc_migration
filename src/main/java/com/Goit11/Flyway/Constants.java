package com.Goit11.Flyway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String FLYWAY_CONNECTION_URL = "org.flywaydb.url";
    public static final String FLYWAY_USER = "org.flywaydb.user";
    public static final String FLYWAY_PASSWORD = "org.flywaydb.password";

//    public static final String FLYWAY_CONNECTION_URL = "jdbc:h2:~/GoIt11/Projects/Gradle/JDBC/jdbc-migration/jdbc-migr/migration";
//    public static final String FLYWAY_USER = "admin";
//    public static final String FLYWAY_PASSWORD = "asd";
}
