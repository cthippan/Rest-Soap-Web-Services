package com.chaitra.errorhandling;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessageClass {
private int errorcode;
private String errormessage;
private String documentation;


public ErrorMessageClass(int errorcode, String errormessage,String documentation) {
	
	this.errorcode = errorcode;
	this.errormessage = errormessage;
	this.documentation = documentation;

}
public void setErrorcode(int errorcode) {
	this.errorcode = errorcode;
}
public String getDocumentation() {
	return documentation;
}

public void setDocumentation(String documentation) {
	this.documentation = documentation;
}

public int getErrorcode() {
	return errorcode;
}
public ErrorMessageClass() {
	super();
	// TODO Auto-generated constructor stub
}
public String getErrormessage() {
	return errormessage;
}
public void setErrormessage(String errormessage) {
	this.errormessage = errormessage;
}
}

