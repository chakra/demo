package com.nme.payee;

import com.nme.customer.Customer;
import com.nme.repository.CustomerRepository;
import com.nme.utils.NMEUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chakra.bhandari on 21/03/2017.
 */
@RestController
public class PayeeRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customer/{customerId}/payees")
    public List<Payee> getPayeeList(@PathVariable String customerId) {
        Customer customer = customerRepository.findOne(Long.valueOf(customerId));
        return customer.getPayees();
    }

    @PutMapping("/customer/payee")
    public List<Payee> updatePayee(@RequestBody Payee payee) {

        Customer customer = customerRepository.findOne(payee.getCustomerId());

        List<Payee> payees = customer.getPayees();
        for ( Payee payeee : payees) {
            if (payeee.getPayeeId().equals(payee.getPayeeId())) {
                payees.remove(payeee);
                payees.add(payee);
            }
        }

        customer.setPayees(payees);
        customerRepository.save(customer);

        return customer.getPayees();
    }

    @PostMapping("/customer/payee")
    public List<Payee> addPayee(@RequestBody Payee payee) {
        Customer customer = customerRepository.findOne(payee.getCustomerId());

        try {
            Double payeeId = (Double) NMEUtils.getNextSequence("payeeId");
            payee.setPayeeId(payeeId.longValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        customer.getPayees().add(payee);
        customerRepository.save(customer);

        return customer.getPayees();
    }

    @DeleteMapping("/customer/payee")
    public List<Payee> deletePayee(@RequestBody Payee payee) {
        Customer customer = customerRepository.findOne(payee.getCustomerId());
       // customer.getPayees().remove(payee);

        List<Payee> payees = new ArrayList<>();
        for (Payee payeee : customer.getPayees()) {
            if (!payee.getPayeeId().equals(payeee.getPayeeId())) {
                payees.add(payeee);
            }
        }

        customer.setPayees(payees); // new payee list

        customerRepository.save(customer);

        return customer.getPayees();
    }



}
