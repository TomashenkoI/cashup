package com.cashup.repository;

import com.cashup.entity.Client;
import com.cashup.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByClient(Client client);
}
