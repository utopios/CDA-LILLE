package org.example.joined_table;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "T_PaypalPaymentsS1" )
@PrimaryKeyJoinColumn( name = "idPayment" )
public class PaypalPaymentS1 extends PaymentS1 {

    private String accountNumber = "unknown";

    public PaypalPaymentS1() {
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