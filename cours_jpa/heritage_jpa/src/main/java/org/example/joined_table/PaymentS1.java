package org.example.joined_table;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "T_PaymentsS1" )
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class PaymentS1 {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPayment = 0;
    private double amount = 0;
    private Date paymentDate = new Date();

    public PaymentS1() {
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