package com.movie.service;

import com.movie.exceptions.MovieSysExceptions;

public interface MovieSys {
	public void displayRatingHigherThan5();

	public void removeMoviesRatings();

	public void sortMoviesByDate();

	public void sortMoviesByname();

	void addMovie(int id, String name, double ratings, String Movietype, String date, boolean inCinemas)
			throws MovieSysExceptions;

	void searchMovieByType(String movietype) throws MovieSysExceptions;

	

	

	void updateDateByid(int Id, String date) throws MovieSysExceptions;

	public void displayAll();

}
