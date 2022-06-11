package be.civadis.cca.jpalearn01.model;

import javax.persistence.*;

@Entity
@Table(name="T_CommandLines")
public class CommandLine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCommandLine;

    @ManyToOne( cascade =  CascadeType.PERSIST )
    @JoinColumn(name="idCommand", nullable=false)
    private Command command;

    @ManyToOne( cascade =  CascadeType.PERSIST )
    @JoinColumn(name="idArticle", nullable=false)
    private Article article;

    private int quantity;

    public int getIdCommandLine() {
        return idCommandLine;
    }

    public void setIdCommandLine(int idCommandLine) {
        this.idCommandLine = idCommandLine;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CommandLine{" +
                "\n command=" + command +
                "\n, article=" + article +
                "\n, quantity=" + quantity +
                "\n}";
    }
}
