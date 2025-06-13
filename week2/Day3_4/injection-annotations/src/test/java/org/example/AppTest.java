package org.example;

import org.example.service.UserService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest extends TestCase {

    private UserService userService;
    private ApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialisation du contexte Spring et injection du service
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        userService = context.getBean(UserService.class);
    }

    public void testUserOperations() {
        // Test de création d'utilisateurs
        userService.createUser("Alice", "alice@example.com");
        userService.createUser("Bob", "bob@example.com");

        // Vérification que les utilisateurs ont été créés
        assertEquals(2, userService.getAllUsers().size());
        System.out.println("All users: " + userService.getAllUsers());

        // Test de récupération d'un utilisateur par ID
        assertNotNull(userService.getUserById(1L));
        System.out.println("User 1: " + userService.getUserById(1L));

        // Test de suppression
        userService.deleteUser(1L);
        assertEquals(1, userService.getAllUsers().size());
        System.out.println("All users after deletion: " + userService.getAllUsers());

        // Vérification que l'utilisateur supprimé n'existe plus
        assertNull(userService.getUserById(1L));
    }

    @Override
    protected void tearDown() throws Exception {
        // Nettoyage des ressources si nécessaire
        if (context instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) context).close();
        }
        super.tearDown();
    }
}