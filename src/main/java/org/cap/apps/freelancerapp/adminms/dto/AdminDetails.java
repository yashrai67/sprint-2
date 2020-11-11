package org.cap.apps.freelancerapp.adminms.dto;

public class AdminDetails {
    private Long id;
    private String firstname;
    private String lastname;
    private String password;

    public AdminDetails(){

    }

    public AdminDetails(Long id, String firstname, String lastname, String password){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.password = password;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
