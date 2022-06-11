package be.civadis.cca.jpalearn01;

import be.civadis.cca.jpalearn01.model.Payment;
import be.civadis.cca.jpalearn01.model.Role;
import be.civadis.cca.jpalearn01.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Program5 {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<Payment> query = entityManager.createQuery("from Payment", Payment.class);
            var payments = query.getResultList();
            for (var payment: payments) {
                System.out.println(payment.getClass().getName());
                System.out.println("\t" + payment);
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
	}
}
