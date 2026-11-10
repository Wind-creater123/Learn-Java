package practice;

public class Test_Movie {
    public static void main(String[] args) {
        Movie[] movies = new Movie[3];
        movies[0]=new Movie(1,"1",1,"1");
        movies[1]=new Movie(2,"2",2,"2");
        movies[2]=new Movie(3,"2",3,"3");

        MovieOperator movieOperator = new MovieOperator(movies);

        movieOperator.printMovies();
        movieOperator.searchMovieById();
    }
}
