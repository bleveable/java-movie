package sample;

public class Movie {
    private String name;
    private int year;
    private double price;
    private String genre;
    private String poster;
    private int id;

    public Movie() {
        name = "";
        year = 0;
        price = 0;
        genre = "";
        poster = "";
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie(String nameIn, int yearIn, double priceIn, String genreIn, String posterIn, int id) {
        name = nameIn;
        year = yearIn;
        price = priceIn;
        genre = genreIn;
        poster = posterIn;
        this.id = id;
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

    public String toString() {
        return getName() + "  " + "$" + getPrice();
    }
}
