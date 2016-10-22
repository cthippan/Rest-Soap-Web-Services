package org.chaitra.twitter;

public class InvalidInputException extends Exception{
	
private String errorDetails;

public InvalidInputException(String reason,String errorDetails) {
	super(reason);
	this.errorDetails=errorDetails;
	
}
public String getfaultInfo(){
	return errorDetails;
}


}
