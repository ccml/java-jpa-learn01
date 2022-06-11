package be.civadis.cca.jpalearn01;

import be.civadis.cca.jpalearn01.model.User;
import be.civadis.cca.jpalearn01.model.UserInformations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program2 {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            UserInformations userInformations = entityManager.find(UserInformations.class, 1);
            System.out.println(userInformations.getUser());
            System.out.println(userInformations);

            User user = entityManager.find(User.class, 1);
            System.out.println(user);
            System.out.println(user.getUserInformations());

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
	}
}
