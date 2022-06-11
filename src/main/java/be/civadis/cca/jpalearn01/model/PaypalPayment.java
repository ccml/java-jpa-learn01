package be.civadis.cca.jpalearn01.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "T_PaypalPayments" )
@PrimaryKeyJoinColumn( name = "idPayment" )
public class PaypalPayment extends Payment {

    private String accountNumber = "unknown";

    public PaypalPayment() {
        super();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", accountNumber=" + accountNumber;
    }
}