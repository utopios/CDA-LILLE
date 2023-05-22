package org.example.table_per_classe;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class PaymentS3 {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idPayment = 0;
    private double amount = 0;
    private Date paymentDate = new Date();

    public PaymentS3() {
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