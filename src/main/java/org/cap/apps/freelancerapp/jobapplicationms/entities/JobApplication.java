package org.cap.apps.freelancerapp.jobapplicationms.entities;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "JobApplication")
public class JobApplication {
	@GeneratedValue
	@Id
	private Long id;
	@ManyToOne
	private Job job;

	private LocalDate appliedDate;

	private String coverLetter;

	@ManyToOne
	private Freelancer freelancer;

	public JobApplication() {
		super();

	}

	public JobApplication(Job job, LocalDate appliedDate, String coverLetter, Freelancer freelancer) {
		super();
		this.job = job;
		this.appliedDate = appliedDate;
		this.coverLetter = coverLetter;
		this.freelancer = freelancer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		JobApplication that = (JobApplication) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}