package com.myportfolio.portfolioms.repository;

import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.dto.StockInputList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("STOCK-SERVICE")
public interface StockFeignClient {
    @PostMapping("/api/v1/stocks/AllStockWithIds")
    public List<Stock> getAllStocksByIds(@RequestBody StockInputList stockInputList);
}
