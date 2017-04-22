package com.nme.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nme.account.Account;
import com.nme.address.Address;
import com.nme.payee.Payee;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chakra.bhandari on 20/03/2017.
 */
@Document(collection = "customers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    private Long customerId;

    private Long userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String dob;

    private String passportnumber;

    private String nationality;

    private String driverlicense;

    private Address address;

    private Account account;

    private List<Payee> payees;

    public Customer() {
        // default
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Payee> getPayees() {
        if (CollectionUtils.isEmpty(payees)) {
            payees = new ArrayList<>();
        }
        return payees;
    }

    public void setPayees(List<Payee> payees) {
        this.payees = payees;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDriverlicense() {
        return driverlicense;
    }

    public void setDriverlicense(String driverlicense) {
        this.driverlicense = driverlicense;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
