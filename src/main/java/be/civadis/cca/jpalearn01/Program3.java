package be.civadis.cca.jpalearn01;

import be.civadis.cca.jpalearn01.model.Command;
import be.civadis.cca.jpalearn01.model.CommandLine;
import be.civadis.cca.jpalearn01.model.User;
import be.civadis.cca.jpalearn01.model.UserInformations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Program3 {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            List<Command> commands = entityManager.createQuery("from Command", Command.class).getResultList();
            for (Command command: commands) {
                System.out.println(command);
            }
//
//            User user = entityManager.find(User.class, 1);
//            System.out.println(user);
//            for (Command command: user.getCommands()) {
//                System.out.println(command);
//            }

//            List<CommandLine> commandLines = entityManager.createQuery("from CommandLine", CommandLine.class).getResultList();
//            for (CommandLine commandLine: commandLines) {
//                System.out.println(commandLine);
//            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
	}
}
