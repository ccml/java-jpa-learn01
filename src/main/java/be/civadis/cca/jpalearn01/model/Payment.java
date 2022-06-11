package be.civadis.cca.jpalearn01.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table( name = "T_Payments" )
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class Payment {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPayment = 0;
    private double amount = 0;
    private Date paymentDate = new Date();

    public Payment() {
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment: idPayment=" + idPayment + ", amount=" +
                amount + ", paymentDate=" + paymentDate;
    }

}