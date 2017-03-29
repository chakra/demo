package com.nme.account;

import com.nme.address.Address;
import org.springframework.data.annotation.Id;

/**
 * Created by chakra.bhandari on 20/03/2017.
 */
public class Account {

    @Id
    private Long accountId;

    private Long customerId;

    private String bsbNumber;

    private String accountNumber;

    private Address address;

    public Account() {
        // default
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getBsbNumber() {
        return bsbNumber;
    }

    public void setBsbNumber(String bsbNumber) {
        this.bsbNumber = bsbNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
