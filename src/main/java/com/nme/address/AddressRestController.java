package com.nme.address;

import com.nme.customer.Customer;
import com.nme.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chakra.bhandari on 21/03/2017.
 */
@RestController
public class AddressRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer/address")
    public Address updateCustomerAddress(@RequestBody Address address) {
        Customer customer = customerRepository.findOne(address.getCustomerId());
        customer.setAddress(address);
        customerRepository.save(customer);

        return customerRepository.findOne(address.getCustomerId()).getAddress();
    }

    @DeleteMapping("/customer/address")
    public ResponseEntity<String> deleteCustomerAddress(@RequestBody Address address) {
        Customer customer = customerRepository.findOne(address.getCustomerId());
        customer.setAddress(null);
        customerRepository.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
