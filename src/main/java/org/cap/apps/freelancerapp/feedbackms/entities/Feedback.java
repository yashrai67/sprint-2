package org.cap.apps.freelancerapp.feedbackms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@GeneratedValue
	@Id
	private Long id;
	private Integer rating;
	private String comment;

	public Feedback(Integer rating, String comment) {

		this.rating = rating;
		this.comment = comment;
	}

	public Feedback() {

	}

	/* Getter and Setter */

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}