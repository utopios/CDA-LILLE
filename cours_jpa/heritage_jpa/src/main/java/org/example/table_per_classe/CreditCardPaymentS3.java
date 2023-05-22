package org.example.table_per_classe;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "T_CreditCardPaymentsS3" )
public class CreditCardPaymentS3 extends PaymentS3 {

    private String cardNumber = "unknown";
    private String expirationDate = "mm/yy";

    public CreditCardPaymentS3() {
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
