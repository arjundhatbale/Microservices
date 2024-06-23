package com.main.Exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	String resourceName;
	String fieldName;
	long fieldValue;
	Integer userId;
	

	public ResourceNotFoundException(String resourceName, String fieldName) {
		// TODO Auto-generated constructor stub
		super(String.format("%s not found with %s : %s" , resourceName, fieldName));

		this.fieldName = resourceName; 
		this.fieldName = fieldName; 
		
	}

	
	public ResourceNotFoundException(String resourceName, String fieldName, long  fieldValue) {
		super(String.format("%s not found with %s : %s",  resourceName, fieldName, fieldValue));
		
		this.resourceName = resourceName;
		this.fieldName = fieldName; 
		this.fieldValue = fieldValue; 
		
	}


	public ResourceNotFoundException(String string) {
		super(String.format("%s not found with %s : %s" ,   string));
		this.fieldName = fieldName; 

		
 	}


	public ResourceNotFoundException( Integer userId) {
		// TODO Auto-generated constructor stub
		super(String.format("%s not found with %s : %s" ,   userId));
		this.userId = userId; 

	}

 


}
