package com.movie.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.movie.core.Movie;
import com.movie.core.MovieType;
import com.movie.exceptions.MovieSysExceptions;
import com.movie.validations.validations;

public class MovieSysServiceImpl implements MovieSys {
	private Map<String, Movie> movieMap;

	public MovieSysServiceImpl() {
		this.movieMap = new HashMap<>(100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMovie(int id, String name, double ratings, String Movietype, String date, boolean inCinemas)
			throws MovieSysExceptions {
		// TODO Auto-generated method stub
		Movie m = validations.validateAllInputs(id, name, ratings, Movietype, date, inCinemas, movieMap);
		movieMap.put(m.getName(), m);
		System.out.println("Movie added");

	}

	@Override
	public void displayRatingHigherThan5() {
		System.out.println("Movies with Rating greater than 5: ");
		movieMap.values().stream().filter((m) -> m.getRatings() >= 5).forEach(System.out::println);
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMoviesRatings() {
		// TODO Auto-generated method stub
		System.out.println("removed Movies with rating less than 3.5");
		movieMap.values().removeIf((m) -> m.getRatings() <= 3.5);
		System.out.println("New List");

		displayAll();

	}

	@Override
	public void sortMoviesByDate() {
		// TODO Auto-generated method stub
		System.out.println("Movies Sorted By Date");
		movieMap.values().stream().sorted(Comparator.comparing(Movie::getRealeaseDate)).forEach(System.out::println);

	}

	@Override
	public void sortMoviesByname() {
		System.out.println("Movies Sorted based on Name");
		movieMap.values().stream().sorted(Comparator.comparing(Movie::getName)).forEach(System.out::println);
		// TODO Auto-generated method stub

	}

	@Override
	public void searchMovieByType(String movietype) throws MovieSysExceptions {
		MovieType m = validations.validateMovieType(movietype);
		movieMap.values().stream().filter(movie -> movie.getMovietype() == m).forEach(System.out::println);

	}

	@Override
	public void updateDateByid(int Id, String date) throws MovieSysExceptions {
		// TODO Auto-generated method stub
		LocalDate d = null;
		try {
			d = LocalDate.parse(date);
		} catch (Exception e) {
			throw new MovieSysExceptions("Date must be in Format of YYYY-MM-DD");
		}
		Iterator<Movie> it = movieMap.values().iterator();
		while (it.hasNext()) {
			Movie m = it.next();
			if (m.getId() == Id) {
				m.setRealeaseDate(d);
				System.out.println("Upadated" + "\n" + m);
				break;
			}
		}

	}

	public void displayAll() {
		movieMap.values().forEach(System.out::println);
	}

}
