package com.myportfolio.stockms.repository;

import com.myportfolio.stockms.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksRepository extends JpaRepository<Stock,Integer> {
}
