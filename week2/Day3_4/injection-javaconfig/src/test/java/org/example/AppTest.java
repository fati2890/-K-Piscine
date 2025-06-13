package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppTest extends TestCase {

    private UserService userService;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialisation du contexte Spring avant chaque test
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        userService = context.getBean(UserService.class);
    }

    /**
     * Test des fonctionnalités du UserService
     */
    public void testUserServiceOperations() {
        // Test de création d'utilisateurs
        userService.createUser("Alice", "alice@example.com");
        userService.createUser("Bob", "bob@example.com");

        // Vérification du nombre d'utilisateurs
        assertNotNull("La liste des utilisateurs ne devrait pas être null", userService.getAllUsers());
        assertEquals("Il devrait y avoir 2 utilisateurs", 2, userService.getAllUsers().size());

        // Test de récupération d'un utilisateur
        assertNotNull("L'utilisateur avec l'ID 1 devrait exister", userService.getUserById(1L));

        // Test de suppression
        userService.deleteUser(1L);
        assertEquals("Il ne devrait rester qu'un seul utilisateur après suppression", 1, userService.getAllUsers().size());
    }

    /**
     * Test basique pour vérifier que les tests fonctionnent
     */
    public void testApp() {
        assertTrue(true);
    }
}