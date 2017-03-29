package com.nme.transaction;

import com.nme.repository.CustomerRepository;
import com.nme.utils.NMEUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chakra.bhandari on 20/03/2017.
 */
@RestController
public class TransactionRestController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("/transactions/list")
    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }

    @RequestMapping("/transactions/customer/list")
    public List<Transaction> listCustomerTransactions() {
        return transactionRepository.findAll();// transactions of a customer
    }

    @PutMapping("/transaction")
    public List<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return transactionRepository.findAll();
    }

    @PostMapping("/transaction")
    public List<Transaction> addTransaction(@RequestBody Transaction transaction) {
        try {
            Double transactionId = (Double) NMEUtils.getNextSequence("transactionId");
            transaction.setTransactionId(transactionId.longValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        transactionRepository.save(transaction);
        return transactionRepository.findAll();
    }

    @DeleteMapping("/transaction")
    public List<Transaction> deleteTransaction(@RequestBody Transaction transaction) {
        transactionRepository.delete(transaction.getTransactionId());
        return transactionRepository.findAll();
    }

}
