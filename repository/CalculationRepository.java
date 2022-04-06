package com.example.firstapplication.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstapplication.entity.Result;

public interface CalculationRepository extends JpaRepository<Result,Integer> {


	 List<Result> findByidBetween(Integer start, Integer end);

	

	

}
