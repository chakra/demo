package com.nme.customer;

import com.nme.repository.CustomerRepository;
import com.nme.utils.NMEUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chakra.bhandari on 20/03/2017.
 */
@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customer/list")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping("/customer/id/{userId}")
    public Customer getCustomer(@PathVariable Long userId) {
        return customerRepository.findOne(userId);
    }

    @PostMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {

        if (null == customer.getCustomerId()) { // if new customer
            try {
                Double customerId = (Double) NMEUtils.getNextSequence("customerId");
                customer.setCustomerId(customerId.longValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        customerRepository.save(customer);
        return customerRepository.findOne(customer.getCustomerId());
    }

}
