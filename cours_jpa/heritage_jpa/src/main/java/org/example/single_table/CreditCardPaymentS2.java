package org.example.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class CreditCardPaymentS2 extends PaymentS2 {

    private String cardNumber = "unknown";
    private String expirationDate = "mm/yy";

    public CreditCardPaymentS2() {
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
