package com.coviam.ecomm.entity;

public class RatingReview {
	private Integer rating;
	private String review;

	public Integer getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "RatingReview [rating=" + rating + ", review=" + review + "]";
	}
}