package com.myportfolio.portfolioms.api;

import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.service.PortfolioService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/portfolio")
@Slf4j
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio){
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios(){
        return portfolioService.getAllPortfolios();
    }

    @GetMapping("/{id}")
    //@CircuitBreaker(fallbackMethod = "getPortfolioByIdFallback", name = "stocks-service-cb")
    //@Retry(name = "stocks-service-cb", fallbackMethod = "getPortfolioByIdFallback")
    public Portfolio getPortFolioById(@PathVariable("id") String id)
    {
        return  portfolioService.getPortfolioById(id);
    }

//    public Portfolio getPortfolioByIdFallback(@PathVariable String id, Throwable error) {
//        log.error(error.toString());
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,error.getMessage());
//    }

}
