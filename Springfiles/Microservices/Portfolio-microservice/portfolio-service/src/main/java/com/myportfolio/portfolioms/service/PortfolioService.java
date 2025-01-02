package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.model.Portfolio;

import java.util.List;

public interface PortfolioService {
    public Portfolio createPortfolio(Portfolio portfolio);
    public Portfolio getPortfolioById(String id);
    List<Portfolio> getAllPortfolios();
}
