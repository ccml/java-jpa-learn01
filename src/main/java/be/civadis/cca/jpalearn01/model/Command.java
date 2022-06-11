package be.civadis.cca.jpalearn01.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="T_Commands")
public class Command {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idCommand;

    @ManyToOne( cascade = CascadeType.PERSIST )
    @JoinColumn(name="idUser", nullable=false)
    private User user;

    private Date commandDate;

    @OneToMany( targetEntity=CommandLine.class, mappedBy="command", cascade = { CascadeType.PERSIST, CascadeType.REMOVE } )
    private List<CommandLine> commandLines = new ArrayList<>();

    public Command() {}

    public Command( User user, Date commandDate ) {
        this.setUser( user );
        this.setCommandDate( commandDate );
    }

    public int getIdCommand() {
        return idCommand;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCommandDate() {
        return commandDate;
    }

    public void setCommandDate(Date commandDate) {
        this.commandDate = commandDate;
    }

    public List<CommandLine> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLine> commandLines) {
        this.commandLines = commandLines;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Commande de >> " ).append( this.user )
                .append( " - " ).append( this.commandDate ).append( "\n" );
        for (CommandLine commandLine: commandLines) {
            builder.append(commandLine.getArticle().getDescription())
                    .append(" : ")
                    .append(commandLine.getQuantity())
                    .append( "\n" );
        }
        return builder.toString();
    }

}