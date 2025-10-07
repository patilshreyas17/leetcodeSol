package com.movie.validations;

import java.time.LocalDate;
import java.util.Map;

import com.movie.core.Movie;
import com.movie.core.MovieType;
import com.movie.exceptions.MovieSysExceptions;

public class validations {

	public validations() {
		// TODO Auto-generated constructor stub
	}

	public static Movie validateAllInputs(int id, String name, double ratings, String Movietype, String date,
			boolean inCinemas, Map<String, Movie> movieMap) throws MovieSysExceptions {
		validateName(name, movieMap);
		MovieType m = validateMovieType(Movietype);
		LocalDate d= validateDate(date);
		return new Movie(id, name, ratings, m, d, inCinemas);

	};

	// Map<String, Movie> movieMap
	private static void validateName(String name, Map<String, Movie> movieMap) throws MovieSysExceptions {
		if (movieMap.containsKey(name)) {
			throw new MovieSysExceptions("Duplicate Movie Detected: " + name);
		}
	};

	public static MovieType validateMovieType(String Movietype) throws MovieSysExceptions {
		try {
			MovieType m = MovieType.valueOf(Movietype.toUpperCase());
			return m;
		} catch (Exception e) {
			throw new MovieSysExceptions("Not A valid Type for Movie: " + Movietype); // TODO: handle exception
		}
	}

	private static LocalDate validateDate(String date) throws MovieSysExceptions {
			
			try {
				LocalDate d = LocalDate.parse(date);
				
				LocalDate d2 = LocalDate.now();
				if(d.isBefore(d2)) {
					return d;
				}
				else {
					throw new MovieSysExceptions("Release Date must be before Current Date")	;
				}
			} catch (Exception e) {
				throw new MovieSysExceptions("Date Entered is In wr");				// TODO: handle exception
			}
	};
}
