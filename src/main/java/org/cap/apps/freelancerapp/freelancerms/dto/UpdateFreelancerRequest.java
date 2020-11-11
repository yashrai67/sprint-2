package org.cap.apps.freelancerapp.freelancerms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateFreelancerRequest {
    private Long id;
    @NotBlank
    @NotBlank @Size(min =2, max = 20)
    private String firstname, lastname;

    @NotBlank
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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
