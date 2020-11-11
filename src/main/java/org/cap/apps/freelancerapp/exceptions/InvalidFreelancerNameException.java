package org.cap.apps.freelancerapp.exceptions;

public class InvalidFreelancerNameException extends RuntimeException{
	public InvalidFreelancerNameException() {		
	}
	
	public InvalidFreelancerNameException(String msg) {
		super(msg);
	}
}
