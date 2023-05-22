package org.example.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class PaypalPaymentS2 extends PaymentS2 {

    private String accountNumber = "unknown";

    public PaypalPaymentS2() {
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
