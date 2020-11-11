package org.cap.apps.freelancerapp.exceptions;

public class JobNotFoundException extends RuntimeException {
	
	
	public JobNotFoundException() {

	}

	public JobNotFoundException(String msg) {
		super(msg);
	}

}
