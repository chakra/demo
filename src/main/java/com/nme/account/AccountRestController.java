package com.nme.account;

import com.nme.customer.Customer;
import com.nme.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chakra.bhandari on 21/03/2017.
 */
@RestController
public class AccountRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("/customer/account")
    public Account updateAccount(@RequestBody Account account) {
        Customer customer = customerRepository.findOne(account.getCustomerId());
        customer.setAccount(account);
        customerRepository.save(customer);

        return customerRepository.findOne(account.getCustomerId()).getAccount();
    }

    @DeleteMapping("/customer/account")
    public ResponseEntity<String> deleteAccount(@RequestBody Account account) {
        Customer customer = customerRepository.findOne(account.getCustomerId());
        customer.setAccount(null);
        customerRepository.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
