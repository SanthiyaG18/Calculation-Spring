package com.example.firstapplication;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.firstapplication.entity.Calculation;
import com.example.firstapplication.entity.Result;
import com.example.firstapplication.repository.CalculationRepository;
import com.example.firstapplication.service.CalculationService;


@SpringBootTest
 class FirstApplicationTest {

	@Autowired
	private CalculationService service;
	
	@MockBean
	private CalculationRepository repository;
	Date createdDate = new Date(System.currentTimeMillis());
	Time  createdTime = new Time(System.currentTimeMillis());
	
	
	
	@Test
	public void getCalculationTest() {
		Date createdDate = new Date(System.currentTimeMillis());
		Time  createdTime = new Time(System.currentTimeMillis());
		
		when(repository.findAll()).thenReturn(Stream.of(new Result(0,10,10,"addition",20,"success",createdDate,createdTime),
				new Result(1,20,10,"addition",30,"success",createdDate,createdTime)).collect(Collectors.toList()));
		
		
		assertEquals(2,service.getCalculation().size());
		
	}
	@Test
	public void registerCalculationTest() {
		Result result=new Result(1,10,30,"addition",40,"success",createdDate,createdTime);
		when(repository.save(result)).thenReturn(result);
		assertEquals(result,service.registerCalculation(result));
	}
}
