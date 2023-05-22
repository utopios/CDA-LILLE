package org.example.table_per_classe;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "T_PaypalPaymentsS3" )
public class PaypalPaymentS3 extends PaymentS3 {

    private String accountNumber = "unknown";

    public PaypalPaymentS3() {
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