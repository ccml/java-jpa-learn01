package be.civadis.cca.jpalearn01;

import be.civadis.cca.jpalearn01.model.Command;
import be.civadis.cca.jpalearn01.model.Role;
import be.civadis.cca.jpalearn01.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Program4 {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

//            User user = entityManager.find(User.class, 1);
//            System.out.println(user);
//            for (Role role: user.getRoles()) {
//                System.out.println(role);
//            }

            Role role = entityManager.find(Role.class, 1);
            System.out.println(role);
            for (User user: role.getUsers()) {
                System.out.println(user);
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
	}
}
