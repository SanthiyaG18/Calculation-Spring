package com.example.firstapplication.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="calculation")


public class Result {
	
	@Id 
	@GeneratedValue
    private Integer id;
	private Integer num1;
	private Integer num2;
	private String type;
	private Integer result ;
	private String message;
	@Column(name="created_date")
    private Date createdDate;
    private Time  createdTime;
	
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(nullable=false) private Date LastUpdate;
	 * 
	 * @PrePersist private void onCreate() { LastUpdate = new Date(0); }
	 */
	
	
	 
	  
	 
	
	public  Result() {
	    }
	public Result(Integer id,Integer num1, Integer num2, String type, Integer result, String message, Date createdDate,
		Time createdTime) {
		this.id=id;
		this.num1 = num1;
		this.num2 = num2;
		this.type = type;
		this.result = result;
		this.message = message;
		this.createdDate=createdDate;
		this.createdTime=createdTime;
	}







		public Integer getNum1() {
		return num1;
	}
	public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	public Time getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Time createdTime) {
		this.createdTime = createdTime;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	

	
	

	
}

