import java.util.*;
import java.io.*;

public class Movie implements java.io.Serializable{

    private String title;
    private String genre;
    private int year;
    private ArrayList<Actor> actorList = new ArrayList<Actor>();

    public Movie(String title, String genre, int year, ArrayList<Actor> actorList){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.actorList = actorList;
    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public int getYear(){
        return year;
    }

    public void setActorlist(){            
        Scanner scan = new Scanner(System.in);
            System.out.println("How many Actors?");
            int actorAmount = scan.nextInt();                
                for(int i = 0; i < actorAmount; i++){
                    System.out.println("Actor Name?"); 
                    String name = System.console().readLine();
                    System.out.println("Role?");
                    String role = System.console().readLine();
                    actorList.add(new Actor(name, role));
                }
    }

    public ArrayList<Actor> getActorList(){
         return actorList;
    }

    public String toString(){
        System.out.println();
        System.out.println("Title of Movie: " + title);
        System.out.println("Production Year of Movie: " + year);
        System.out.println("Genre of Movie: " + genre);
        System.out.println();
        System.out.println("Actors in Movie:");
        System.out.println(actorList);
        return "";
    }
}