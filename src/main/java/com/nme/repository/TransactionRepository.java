package com.nme.repository;

import com.nme.transaction.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chakra.bhandari on 29/03/2017.
 */
public interface TransactionRepository extends MongoRepository<Transaction, Long> {
        //Transaction findById(String transactionid);
}

