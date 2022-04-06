package com.example.firstapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.firstapplication.entity.Result;
import com.example.firstapplication.repository.CalculationRepository;


@Service
public class CalculationService {
	
     @Autowired
	CalculationRepository calculationRepository;
     
     
     public Result registerCalculation(Result res)
     {
    	 return calculationRepository.save(res);
     }
		
  public List<Result> getCalculation()
 {
		
		 return (List<Result>) calculationRepository.findAll();
		 

	  
	} 
	











	
	/*
	 * public List<Result> getByValue(Integer num1) {
	 * 
	 * 
	 * return calculationRepository.findByValue(num1); }
	 */
}
 
	
		 

