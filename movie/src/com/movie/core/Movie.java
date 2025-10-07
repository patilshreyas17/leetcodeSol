package com.movie.core;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {
	private int id;
	private String name;
	private double ratings;
	private MovieType movietype;
	private LocalDate realeaseDate;
	private boolean inCinemas;

	public Movie(int id, String name, double ratings, MovieType movietype, LocalDate realeaseDate, boolean inCinemas) {
		super();
		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.movietype = movietype;
		this.realeaseDate = realeaseDate;
		this.inCinemas = inCinemas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public MovieType getMovietype() {
		return movietype;
	}

	public void setMovietype(MovieType movietype) {
		this.movietype = movietype;
	}

	public LocalDate getRealeaseDate() {
		return realeaseDate;
	}

	public void setRealeaseDate(LocalDate realeaseDate) {
		this.realeaseDate = realeaseDate;
	}

	public boolean isInCinemas() {
		return inCinemas;
	}

	public void setInCinemas(boolean inCinemas) {
		this.inCinemas = inCinemas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {

		Movie other = (Movie) obj;
		return this.getName().equalsIgnoreCase(other.getName());
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", ratings=" + ratings + ", movietype=" + movietype
				+ ", realeaseDate=" + realeaseDate + ", inCinemas=" + inCinemas + "]";
	}

}
