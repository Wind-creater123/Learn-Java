package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private static List<Movie> movies=new ArrayList<Movie>();
    private static Scanner sc=new Scanner(System.in);

    public void start(){
        while(true) {
            System.out.println("1.上架");
            System.out.println("2.下架电影");
            System.out.println("3.查询电影");
            System.out.println("4.下架导演");
            System.out.println("输入命令:");
            String command=sc.next();
            switch (command){
                case "1":
                    addMovie();
                    break;
                case "2":

                    break;
                case "3":
                    searchMovie();
                    break;
                case "4":
                    deleteByDirector();
                    break;
                case "5":
                    queryAllMovie();
                    break;
                case "6":
                    System.out.println("quit");
                    return;
                default:
                    System.out.println("wrong,again");
            }
        }
    }

    private void queryAllMovie() {
        for(Movie m:movies){
            System.out.println(m);
        }
    }

    private void deleteByDirector() {
        System.out.println("Delete by director:");
        String director=sc.next();

        for(int i=0;i<movies.size();i++){
            Movie movie=movies.get(i);
            if(movie.getDirector().contains(director)){
                movies.remove(movie);
                i--;
            }
            System.out.println("delete success");
        }
    }

    private void searchMovie() {
        System.out.println("输入名称:");
        String name=sc.next();
        Movie movie = queryMovie(name);
        if(movie!=null){
            System.out.println(movie);
        }else{
            System.out.println("no match");
        }
    }

    private Movie queryMovie(String name){
        for(Movie m:movies){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    private void addMovie(){
        //new对象
        Movie movie=new Movie();
        //对象注入数据
        System.out.println("name:");
        movie.setName(sc.next());
        System.out.println("score:");
        movie.setScore(sc.nextDouble());
        System.out.println("director:");
        movie.setDirector(sc.next());
        System.out.println("price:");
        movie.setPrice(sc.nextDouble());
        //添加到集合
        movies.add(movie);
        System.out.println("complete");
    }
}
