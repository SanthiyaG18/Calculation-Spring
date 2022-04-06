package com.example.firstapplication.entity;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;*/
public class Calculation {
    

	private Integer num1;
	private Integer num2;
	private String type;
	 

	public  Calculation() {
	    }

	    public Calculation(int num1, int num2,String type) {
	        this. num1= num1;
	        this.num2 = num2;
	        this. type= type;
	    }
	    
	
		
	
	
	
	public Integer getNum1() {
		return num1;
	}
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	public Integer getNum2() {
		return num2;
	}
	public void setNum2(Integer num2) {
		this.num2 = num2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}

