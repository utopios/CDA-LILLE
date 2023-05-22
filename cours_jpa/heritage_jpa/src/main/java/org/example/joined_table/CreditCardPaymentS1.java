package org.example.joined_table;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "T_CreditCardPaymentsS1" )
@PrimaryKeyJoinColumn( name = "idPayment" )
public class CreditCardPaymentS1 extends PaymentS1 {

    private String cardNumber = "unknown";
    private String expirationDate = "mm/yy";

    public CreditCardPaymentS1() {
        super();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate;
    }
}
