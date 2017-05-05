import java.util.*;
import java.io.*;

public class Database{

    ArrayList<Movie> movieList = new ArrayList<Movie>();
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    File costumerLibary = new File("CostumerLibary.txt");
    File movieLibary = new File("MovieLibary.txt");
    File historieList = new File("HistorieList.txt");
    File favouriteList = new File("FavouriteList.txt");

    public ArrayList<Movie> movieList(){
        return movieList;
    }

    public ArrayList<Customer> customerList(){
        return customerList;
    }

    @SuppressWarnings("unchecked")

// ADD MOVIE TO FILES METODE
    public void addMovieToFile(){
        try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(movieLibary));
                oos.writeObject(movieList);
                oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")

// READ FROM MOVIE FILE METODE
    public void readFromMovieFile(){
        try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(movieLibary));
                movieList = (ArrayList<Movie>)ois.readObject();
                ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")

// ADD CUSTOMER TO CUSTOMERLIST METODE
    public void addCustomerToFile(){
        try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(costumerLibary));
                oos.writeObject(customerList);
                oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")

// READ CUSTOMER METODE
    public void readCustomerFromFile(){
        try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(costumerLibary));
                customerList = (ArrayList<Customer>)ois.readObject();
                ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
// ADD NEW MOVIE TO MOVIE LIST METODE 
    public void setMovieList(ArrayList<Actor> actorList){
        
        Scanner scan = new Scanner(System.in);
            System.out.println("Title?");
            String title = scan.nextLine();
            System.out.println("Genre?");
            String genre = scan.nextLine();
            System.out.println("Year?");
            int year = scan.nextInt();
        movieList.add(new Movie(title, genre, year, actorList));
    }
// SEARCH FOR MOVIE METODE
    public Movie searchForMovie(){
        Scanner scan = new Scanner(System.in);
        System.out.println("search");
        String search = scan.nextLine();
            for(Movie movie : movieList){
                if (movie.getTitle().contains(search)){
                    System.out.println(movie);
                    return movie;
                }
            }
            System.out.println("We dont have that movie");
            return null;
    }
// DELETE MOVIE METODE
    public void deleteMovie(){
        
        for(int i = 0; i < movieList.size(); i++) {
            System.out.println("NR: " + i);
            System.out.println(movieList.get(i));
        }        
                
        System.out.println("which movie");
        int deleteNr = Integer.parseInt(System.console().readLine());
        movieList.remove(deleteNr);
    }
// DISPLAY ALL MOVIES METODE
    public void displayMovieList(){
        
        for(int i = 0; i < movieList.size(); i++) {
            System.out.println("NR: " + i);
            System.out.println(movieList.get(i));
        }
    }
//REGISTER METODE
    public void register(){

        try{
            Scanner scan = new Scanner(System.in);
                    
            System.out.println("UserName?");
            String userName = scan.nextLine();
            System.out.println("Code?");
            String code = scan.nextLine();
            customerList.add(new Customer(userName,code));
        }catch(Exception e)
        {
        System.out.println(e);
        }
    }
// LOGIN METODE
    public Customer login(String userName, String code){       

        for (Customer c : customerList){
            if (userName.equals(c.getUserName()) && code.equals(c.getLoginCode())){
                return c;
            }
        }
        System.out.println("Please try again");
        return null;
    }    

}