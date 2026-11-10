package practice;

import java.util.Scanner;

public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    public void printMovies() {
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            System.out.println(m.getDirector()+"\t"+m.getName()+"\t"+m.getPrice()+"\t"+m.getId());
        }
    }

    public void searchMovieById() {
        System.out.println("Searching for movie with id :");
        Scanner sc = new Scanner(System.in);
        int id=sc.nextInt();
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            if(id==movies[i].getId()){
                System.out.println(m.getDirector()+"\t"+m.getName()+"\t"+m.getPrice()+"\t"+m.getId());
                return;
            }
        }
        System.out.println("Movie not found");
    }
}
