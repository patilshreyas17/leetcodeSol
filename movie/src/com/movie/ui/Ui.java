package com.movie.ui;

import java.util.Scanner;

import com.movie.service.MovieSys;
import com.movie.service.MovieSysServiceImpl;

public class Ui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			MovieSys service = new MovieSysServiceImpl();
			while (!exit) {
				try {
					System.out.println("Movie Service System");
					System.out.println("01 Add Movie");
					System.out.println("02 Display Movies with ratings >5");
					System.out.println("03 Remove Movies with ratings <3.5");
					System.out.println("04 Sort By Date");
					System.out.println("05 Sory Movies By Name");
					System.out.println("06 Search Movies By Type");
					System.out.println("07 Update Date By Id");
					System.out.println("08 ADD DummyData");
					System.out.println("09 Display ALL");
					System.out.println("Enter Choice");
					int choice = Integer.parseInt(sc.nextLine().trim());
					switch (choice) {
					case 1: {
						System.err.println("here");

						System.out.println("Enter Movie Id");
						int id = Integer.parseInt(sc.nextLine().trim());
						System.out.println("Enter Movie Name: ");
						String name = sc.nextLine().trim();
						System.out.println("Enter Movie Ratings 0 to 5");
						double ratings = Double.parseDouble(sc.nextLine().trim());
						System.out.println("Enter MovieType (Hollywood, Bollywood or Tollywood)");
						String Movietype = sc.nextLine().trim();
						System.out.println("Enter Date in format (YYYY-MM-DD)");
						String date = sc.nextLine().trim();
						System.out.println("Enter in Cinemas Status (true or false)");
						boolean inCinemas = Boolean.parseBoolean(sc.nextLine().trim());
						service.addMovie(id, name, ratings, Movietype, date, inCinemas);
						//service.addMovie(10,"some name",8.9,"boolywood","2000-02-02",true);
						break;
					}
					case 2: {
						service.displayRatingHigherThan5();

						break;

					}
					case 3: {
						service.removeMoviesRatings();
						break;

					}
					case 4: {
						service.sortMoviesByDate();
						break;

					}
					case 5: {
						service.sortMoviesByname();
						break;

					}
					case 6: {
						System.out.println("Enter Movie Type");
						String movietype = sc.nextLine().trim();
						service.searchMovieByType(movietype);
						break;

					}
					case 7: {
						System.out.println("Enter ID For movie");
						int id = Integer.parseInt(sc.nextLine().trim());
						System.out.println("Enter New Date For movie");
						String date = sc.nextLine().trim();
						service.updateDateByid(id, date);
						break;

					}
					case 8: {

						service.addMovie(1, "Inception", 9.0, "Hollywood", "2010-07-16", true);
						service.addMovie(2, "Titanic", 8.5, "Hollywood", "1997-12-19", true);
						service.addMovie(3, "3 Idiots", 8.9, "Bollywood", "2009-12-25", true);
						service.addMovie(4, "Avengers: Endgame", 8.4, "Hollywood", "2019-04-26", true);
						service.addMovie(5, "Lagaan", 8.1, "Bollywood", "2001-06-15", true);
						service.addMovie(6, "The Dark Knight", 9.0, "Hollywood", "2008-07-18", true);
						service.addMovie(7, "Dangal", 8.4, "Bollywood", "2016-12-23", true);
						service.addMovie(8, "Bahubali: The Beginning", 8.0, "Tollywood", "2015-07-10", true);
						service.addMovie(9, "Bahubali: The Conclusion", 8.2, "Tollywood", "2017-04-28", true);
						service.addMovie(10, "Interstellar", 8.6, "Hollywood", "2014-11-07", true);
						service.addMovie(11, "Sholay", 8.2, "Bollywood", "1975-08-15", true);
						service.addMovie(12, "Joker", 8.5, "Hollywood", "2019-10-04", true);
						service.addMovie(13, "Bahubali 3", 7.8, "Tollywood", "2020-12-25", true);
						service.addMovie(14, "Kabhi Khushi Kabhie Gham", 7.5, "Bollywood", "2001-12-14", true);
						service.addMovie(15, "The Matrix", 8.7, "Hollywood", "1999-03-31", true);
						service.addMovie(16, "Spider-Man: No Way Home", 8.3, "Hollywood", "2021-12-17", true);
						service.addMovie(17, "Padmaavat", 7.8, "Bollywood", "2018-01-25", true);
						service.addMovie(18, "War", 7.6, "Bollywood", "2019-10-02", true);
						service.addMovie(19, "RRR", 8.0, "Tollywood", "2022-03-25", true);
						service.addMovie(20, "Doctor Strange", 7.9, "Hollywood", "2016-11-04", true);
						service.addMovie(21, "Kabir Singh", 7.1, "Bollywood", "2019-06-21", true);
						service.addMovie(22, "Baahubali: The Rise", 7.9, "Tollywood", "2015-07-10", true);
						service.addMovie(23, "Guardians of the Galaxy", 8.0, "Hollywood", "2014-08-01", true);
						service.addMovie(24, "Bajrangi Bhaijaan", 8.0, "Bollywood", "2015-07-17", true);
						service.addMovie(25, "Eega", 7.8, "Tollywood", "2012-07-06", true);

						break;

					}
					case 9: {
						service.displayAll();

						break;

					}
					case 0: {
						exit = true;
						System.out.println("Exit App");
						break;

					}
					default:
						System.out.println("INvalid input option for choice");
						break;
					}

				} catch (Exception e) {
					
					System.err.println(e);
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			
			System.err.println(e);
			// TODO: handle exception
		}

	}

}
