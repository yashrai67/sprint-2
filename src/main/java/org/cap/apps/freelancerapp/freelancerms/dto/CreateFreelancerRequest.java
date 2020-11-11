package org.cap.apps.freelancerapp.freelancerms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateFreelancerRequest {
    @NotBlank
    @Size(min =2, max = 20)
    private String firstname;
    private String lastname;

    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
