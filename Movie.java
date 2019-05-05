/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovie;

/**
 *
 * @author Brijian
 */
public class Movie {
    private String name;
    private int year;
    private double price;
    private String genre;
    private String poster;
    
    public Movie() {
        name = "";
        year = 0;
        price = 0;
        genre = "";
        poster = "";
    }
    
    public Movie(String nameIn, int yearIn, double priceIn, String genreIn, String posterIn) {
        name = nameIn;
        year = yearIn;
        price = priceIn;
        genre = genreIn;
        poster = posterIn;
    }
    
    public String getName() {
        return name;
    }
    
     public int getYear() {
        return year;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getGenre() {
        return name;
    }
    
    public String getPoster() {
        return name;
    }
    
    public void setName(String nameIn) {
        name = nameIn;
    }
    
     public void setYear(int yearIn) {
        year = yearIn;
    }
    
    public void setPrice(double priceIn) {
        price = priceIn;
    }
    
    public void setGenre(String genreIn) {
        genre = genreIn;
    }
    
    public void setPoster(String posterIn) {
        poster = posterIn;
    }
    
    @Override
    public String toString() {
        return getName() + "  " + "$" + getPrice();
    }
}
