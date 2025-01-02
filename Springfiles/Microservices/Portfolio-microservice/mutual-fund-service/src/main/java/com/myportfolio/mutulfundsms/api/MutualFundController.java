package com.myportfolio.mutulfundsms.api;

import com.myportfolio.mutulfundsms.dto.MutualFundInputList;
import com.myportfolio.mutulfundsms.model.MutualFunds;
import com.myportfolio.mutulfundsms.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/MutualFunds")
public class MutualFundController {
    @Autowired
    private MutualFundRepository mutualFundRepository;

    @PostMapping
    public MutualFunds createMutualFund(@RequestBody MutualFunds mutualFunds){
        return mutualFundRepository.save(mutualFunds);
    }
    @GetMapping("/{id}")
    public MutualFunds getMutualFundById(@PathVariable("id") int id)
    {
        return  mutualFundRepository.findById(id).get();
    }
    @GetMapping
    public List<MutualFunds> getAllMutualFunds(){
        return mutualFundRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/getAllMutualFundsWithIds")
    public List<MutualFunds> getAllMutualFundsWithIds(@RequestBody MutualFundInputList mutualFundInputList){
        return mutualFundRepository.findAllById(mutualFundInputList.ids());
    }

}
