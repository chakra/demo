package com.nme.repository;

import com.nme.customer.Customer;
import com.nme.transaction.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by chakra.bhandari on 20/03/2017.
 */
public interface CustomerRepository extends MongoRepository<Customer, Long>, QueryDslPredicateExecutor<Customer> {

    //Customer findByName(String customerId);

}
