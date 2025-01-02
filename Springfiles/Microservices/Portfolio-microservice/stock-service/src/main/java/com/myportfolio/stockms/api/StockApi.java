package com.myportfolio.stockms.api;

import com.myportfolio.stockms.dto.StockInputList;
import com.myportfolio.stockms.model.Stock;
import com.myportfolio.stockms.repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockApi {

    @Autowired
    private StocksRepository stocksRepository;

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable("id") int id){
        return   stocksRepository.findById(100).orElseThrow(()->new RuntimeException("stock not found with id"+id));
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock)
    {
        return stocksRepository.save(stock);
    }

    @GetMapping
    public List<Stock> getAllStocks(){
        return stocksRepository.findAll();
    }

    @PostMapping("/AllStockWithIds")
    public List<Stock> findAllByIds(@RequestBody StockInputList stockInputs){
        return  stocksRepository.findAllById(stockInputs.ids());
    }

}
