package com.example.firstapplication.controller;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapplication.entity.Result;
import com.example.firstapplication.repository.CalculationRepository;
/*import com.example.demo.calculation.calculation;
import com.example.demo.calculator.democalculator;
import com.example.demo.exception.calculatornotfound;*/
import com.example.firstapplication.entity.Calculation;
import com.example.firstapplication.service.CalculationService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CalculationController {

	@Autowired
	CalculationService calculationService;

	
	  @Autowired 
	  CalculationRepository calculationRepository;	  
		/*
		 * @GetMapping("/list")
		 * 
		 * public Page<Result> showPage(@RequestParam(defaultValue="0")int page){ Sort
		 * sort; return (Page<Result>) ((JpaRepository) calculationService).findAll(new
		 * PageRequest(page,4, sort));
		 * 
		 * }
		 */
	 
	  
		/*
		 * @GetMapping("/calculate") public ResponseEntity<List<Result>>
		 * findAllWithCreationRange(@RequestParam("start") Integer
		 * start, @RequestParam("end") Integer end) {
		 * 
		 * List<Result> appointments =
		 * calculationService.findAllWithCreationRange(start, end);
		 * 
		 * return ResponseEntity.ok(appointments); }
		 */
	
		
		  @GetMapping("/table") 
			public ResponseEntity<List<Result>> getListbyRange (@RequestParam Integer start,@RequestParam Integer end)
		  {
			  	return new ResponseEntity<List<Result>>(calculationRepository.findByidBetween(start, end), HttpStatus.OK);
		  }
		 

	

	/*
	 * @ModelAttribute public void addAttributes(Model model) {
	 * model.addAttribute("msg", "Welcome to the Netherlands!"); }
	 */
 @GetMapping("/list")
      
      public Page<Result> Pagination(@RequestParam(value="page" ,defaultValue="1") int page,@RequestParam(value="limit",defaultValue="10") int limit) {
		  
    
      return calculationRepository.findAll( PageRequest.of(page,limit));
     
      }

	


	@GetMapping("/calculate")

	public List<Result> getCalculation() {

		return calculationService.getCalculation();
	}

	@PostMapping("/calculate/cal")
	public ResponseEntity<Result> addcal(@RequestBody Calculation calc) {

		String message = "success";
		Date createdDate = new Date(System.currentTimeMillis());
		Time createdTime = new Time(System.currentTimeMillis());
		Integer id=0;
		Integer result = 0;

		Integer num1 = calc.getNum1();
		Integer num2 = calc.getNum2();
		String type = calc.getType();

		switch (calc.getType())

		{

		case "addition":
			result = num1 + num2;

			break;
		case "subtraction":
			result = num1 - num2;

			break;
		case "multiplication":
			result = num1 * num2;

			break;
		case "division":
			if (num2 != 0) {
				result = num1 / num2;
			} else {
				message = "Infinity";
			}
			break;
		default:
			result = 0;
			message = "Wrong Entry";

		}

		//	res.setNum1(num1);
//	res.setNum2(num2);
//	res.setResult(result);
//	String type = calc.getType();
//	res.setType(type);
//	res
		Result res = new Result(id,num1, num2, type, result, message, createdDate, createdTime);
		System.out.println(result);
		calculationService.registerCalculation(res);

		return new ResponseEntity<Result>(res, HttpStatus.OK);

	}

}
