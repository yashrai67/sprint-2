package org.cap.apps.freelancerapp.exceptions;

public class FreelancerNotFoundException extends RuntimeException{
	public FreelancerNotFoundException() {		
	}
	
	public FreelancerNotFoundException(String msg) {
		super(msg);
	}
}
