package org.cap.apps.freelancerapp.exceptions;

public class JobNotActiveException extends RuntimeException{

	
	public JobNotActiveException() {

	}

	public JobNotActiveException(String msg) {
		super(msg);
	}
}
