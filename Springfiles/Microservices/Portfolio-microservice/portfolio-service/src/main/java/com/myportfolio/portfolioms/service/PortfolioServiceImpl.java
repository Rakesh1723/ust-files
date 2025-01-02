package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.dto.MutualFunds;
import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.dto.StockInputList;
import com.myportfolio.portfolioms.dto.MutualFundInputList;
import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.repository.MutualFundFeignClient;
import com.myportfolio.portfolioms.repository.PortfolioRepository;
import com.myportfolio.portfolioms.repository.StockFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PortfolioServiceImpl implements PortfolioService{

    //restTemplate
    //webclient (reactive)
    //feign Client (3rd party remaining all  belongs to spring )
    //Http Client

    @Autowired
    private PortfolioRepository portfolioRepository;

    //    @Autowired
    //    @Qualifier("basicRestTemplate")
    //    private RestTemplate basicRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MutualFundFeignClient mutualFundFeignClient;

    @Autowired
    private StockFeignClient stockFeignClient;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        savedPortfolio.setTotalValue(fetchTotalValue(savedPortfolio));
        return savedPortfolio;
    }

    @Override
    @CircuitBreaker(fallbackMethod = "fetchValueFallback", name = "stocks-service-cb") // fault tolerance handling
    //@Retry(name = "stocks-service-cb", fallbackMethod = "getPortfolioByIdFallback")
    public Portfolio getPortfolioById(String id) {
        Portfolio portfolio=portfolioRepository.findById(id).orElseThrow(()->new RuntimeException("not found with given id"));
        portfolio.setTotalValue(fetchTotalValue(portfolio));
        return  portfolio;
    }

    @Override
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }


    public double fetchTotalValue(Portfolio portfolio){
        double totalValue=0;

         // calling api for each stock.
        for(int stockId:portfolio.getStocks()){
            //localhost:8100
            Stock stock=restTemplate.getForObject("http://STOCK-SERVICE/api/v1/stocks/"+stockId,Stock.class);
            totalValue+=stock.getPrice();
        }


        // calling api to get all stocks and then filter.
//        Stock[] al=restTemplate.getForObject("http://STOCK-SERVICE/api/v1/stocks",Stock[].class);
//        ArrayList<Integer> st=new ArrayList();
//        for(int stockId:portfolio.getStocks()){
//              st.add(stockId);
//        }
//              for(Stock i:al)
//               {  if(st.contains(i.getId()))
//                     totalValue+=i.getPrice();
//               }


        // calling api to get all required stocks.
//        StockInputList st=new StockInputList(portfolio.getStocks().stream().toList());

//         usage of rest template
//        Stock[] al=restTemplate.postForObject("http://STOCK-SERVICE/api/v1/stocks/AllStockWithIds",st,Stock[].class);
//        for(Stock i:al)
//        {
//            totalValue+=i.getPrice();
//        }

        // usage of feign client
//        List<Stock> al=stockFeignClient.getAllStocksByIds(st);
//             for(Stock i:al)
//               {
//                   totalValue+=i.getPrice();
//               }


//        for(int mutualFundId: portfolio.getMutualFunds()) {
//            //localhost:8080
//            MutualFunds mutualFunds = restTemplate.getForObject("http://MUTUAL-FUND-SERVICE/api/v1/MutualFunds/" + mutualFundId, MutualFunds.class);
//            totalValue += mutualFunds.getAmountInvested() * (1 + mutualFunds.getGrowthRate() / 100.0);
//        }


        MutualFundInputList mf=new MutualFundInputList(portfolio.getMutualFunds().stream().toList());

//           usage of rest  template
           MutualFunds[] funds=restTemplate.postForObject("http://MUTUAL-FUND-SERVICE/api/v1/MutualFunds/getAllMutualFundsWithIds",mf,MutualFunds[].class);
             for(MutualFunds i:funds) {
                 totalValue += i.getAmountInvested() * (1 + i.getGrowthRate() / 100.0);
            }

           // usage of feign client
//           List<MutualFunds> funds= mutualFundFeignClient.getAllMutualFundsByIds(mf);
//            for(MutualFunds i:funds) {
//                totalValue += i.getAmountInvested() * (1 + i.getGrowthRate() / 100.0);
//            }

        return  totalValue;
    }


    public Portfolio fetchValueFallback(String id,Throwable error) {
        log.error("Fallback response due to failure: " + error.getMessage());
         return new Portfolio();
    }

}
