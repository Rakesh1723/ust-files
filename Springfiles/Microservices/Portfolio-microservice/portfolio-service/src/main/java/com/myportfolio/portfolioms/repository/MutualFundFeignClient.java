package com.myportfolio.portfolioms.repository;

import com.myportfolio.portfolioms.dto.MutualFundInputList;
import com.myportfolio.portfolioms.dto.MutualFunds;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("MUTUAL-FUND-SERVICE")
public interface MutualFundFeignClient {

    @PostMapping("/api/v1/MutualFunds/getAllMutualFundsWithIds")
    List<MutualFunds> getAllMutualFundsByIds(@RequestBody MutualFundInputList mutualFundInputList);
}
