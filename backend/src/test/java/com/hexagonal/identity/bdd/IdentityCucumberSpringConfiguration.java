package com.hexagonal.identity.bdd;

import com.hexagonal.meditationbuilder.MeditationBuilderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import io.cucumber.java.Before;

/**
 * Spring Boot test context configuration for Identity BC Cucumber BDD tests.
 *
 * <p>Phase 1 (BDD-First): context is active but step definitions are PENDING
 * until Phase 6 (Controllers) completes them.</p>
 *
 * <p>Minimal setup — external adapters (Google JWKS, DB) will be mocked in Phase 6.</p>
 */
@CucumberContextConfiguration
@SpringBootTest(
        classes = MeditationBuilderApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
public class IdentityCucumberSpringConfiguration {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.basePath = "";
    }
}
