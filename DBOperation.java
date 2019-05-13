/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Brijian
 */
public class DBOperation {
    private final Connection con;
    
    public DBOperation() throws Exception {
        con = getConnection();
    } 
    
    /**
     *
     * @throws Exception
     */
    public void insertData() throws Exception {
        try {
            PreparedStatement insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Avengers: Age of Ultron', 2015, 8.50, 'Action, Adventure, Sci-Fi', 'age_of_ultron')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Avatar', 2009, 8.50, 'Action, Adventure, Fantasy, Sci-Fi', 'avatar')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Lord of the Rings: The Two Towers', 2002, 8.50, 'Adventure, Drama, Fantasy', '2towers')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Avengers', 2012, 8.50, 'Action, Adventure, Sci-Fi', 'avengers')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Beauty and the Beast', 2017, 8.50, 'Family, Fantasy, Musical, Romance', 'beauty_beast')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Black Panther', 2018, 8.50, 'Action, Adventure, Sci-Fi', 'black_panther')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Captain America: Civil War', 2016, 8.50, 'Action, Adventure, Sci-Fi', 'civil_war')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Da Vinci Code', 2006, 8.50, 'Mystery, Thriller', 'da_vinci')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Dark Knight', 2008, 8.50, 'Action, Crime, Drama, Thriller', 'dark_knight')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Dark Knight Rises', 2012, 8.50, 'Action, Thriller', 'dark_knight_rises')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Despicable Me 2', 2013, 8.50, 'Animation, Adventure, Comedy, Family, Fantasy, Sci-Fi', 'des_me_2')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Despicable Me 3', 2017, 8.50, 'Animation, Adventure, Comedy, Family, Fantasy, Sci-Fi', 'des_me_3')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Finding Dory', 2016, 8.50, 'Animation, Adventure, Comedy, Family', 'dory')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Avengers: Endgame', 2016, 8.50, 'Action, Adventure, Fantasy, Sci-Fi', 'endgame')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Fate of the Furious', 2017, 8.50, 'Action, Crime, Thriller', 'fate_of_furious')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Star Wars: Episode VII - The Force Awaken', 2015, 8.50, 'Action, Adventure, Fantasy, Sci-Fi', 'force_awakens')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Frozen', 2013, 8.50, 'Animation, Adventure, Comedy, Family, Fantasy, Musical', 'frozen')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Furious 7', 2015, 8.50, 'Action, Crime, Thriller', 'furious7')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Harry Potter and the Deathly Hallows: Part 1', 2010, 8.50, 'Adventure, Fantasy, Mystery', 'hp_hallows1')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Harry Potter and the Deathly Hallows: Part 2', 2011, 8.50, 'Adventure, Drama, Fantasy, Mystery', 'hp_hallows2')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Harry Potter and the Order of the Phoenix', 2007, 8.50, 'Adventure, Family, Fantasy, Mystery', 'hp_phoenix')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Harry Potter and the Sorcerer''s Stone', 2001, 8.50, 'Adventure, Family, Fantasy', 'hp_stone')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Inception', 2010, 8.50, 'Action, Adventure, Sci-Fi, Thriller', 'inception')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Incredibles 2', 2018, 8.50, 'Animation, Action, Adventure, Comedy, Family, Sci-Fi', 'incredibles2')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Independence Day', 1996, 8.50, 'Action, Adventure, Sci-Fi', 'independence_day')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Avenger: Infinity War', 2018, 8.50, 'Action, Adventure, Sci-Fi', 'infinitywar')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Inside Out', 2015, 8.50, 'Animation, Adventure, Comedy, Drama, Family, Family', 'insideout')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Iron Man 3', 2013, 8.50, 'Action, Adventure, Sci-Fi', 'ironman3')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Jumanji: Welcome to the Jungle', 2017, 8.50, 'Action, Adventure, Comedy, Fantasy', 'jumanji_welcome')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Jungle Book', 2016, 8.50, 'Adventure, Drama, Family, Fantasy', 'junglebook')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Jurassic Park', 1993, 8.50, 'Adventure, Sci-Fi Thriller', 'jurassicpark')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Jurassic World', 2015, 8.50, 'Action, Adventure, Sci-Fi', 'jurassicworld')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Jurassic World: Fallen Kingdom', 2016, 8.50, 'Action, Adventure, Sci-Fi', 'jurassicworld_fk')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Lion King', 1994, 8.50, 'Animation, Adventure, Drama, Family, Musical', 'lionking')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Minions', 2015, 8.50, 'Animation, Action, Adventure, Comedy, Family', 'minions')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Finding Nemo', 2003, 8.50, 'Animation, Adventure, Comedy, Family', 'nemo')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Pirates of the Caribbean: Dead Man''s Chest', 2006, 8.50, 'Action, Adventure, Fantasy', 'pirates_deadmanchest')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Pirates of the Caribbean: At World''s End', 2007, 8.50, 'Action, Adventure, Fantasy', 'pirates_worlds_end')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Pirates of the Caribbean: On Stranger Tides', 2011, 8.50, 'Action, Adventure, Fantasy', 'pirates_stranger_tides')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('The Lord of the Rings: The Return of the King', 2003, 8.50, 'Adventure, Drama, Fantasy', 'returnofking')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Rogue One: A Star Wars Story', 2016, 8.50, 'Action, Adventure, Sci-Fi', 'rogue1')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Shrek 2', 2004, 8.50, 'Animation, Adventure, Comedy, Family, Fantasy, Romance', 'shrek2')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Skyfall', 2012, 8.50, 'Action, Adventure, Thriller', 'skyfall')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Star Wars: Episode I - The Phantom Menace', 1999, 8.50, 'Action, Adventure, Fantasy, Sci-Fi', 'sw_phantom_menace')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Star Wars: Episode VIII - The Last Jedi', 2016, 8.50, 'Action, Adventure, Fantasy, Sci-Fi', 'the_last_jedi')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Titanic', 1997, 8.50, 'Action, Adventure, Sci-Fi', 'titanic')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Toy Story 3', 2010, 8.50, 'Animation, Adventure, Comedy, Family, Fantasy', 'toystory3')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Toy Story 4', 2019, 8.50, 'Animation, Adventure, Comedy, Family, Fantasy', 'toystory4')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Alice in Wonderland', 2010, 8.50, 'Action, Adventure, Sci-Fi', 'wonderland')");
            insert.executeUpdate();
            insert = con.prepareStatement("INSERT INTO movies (name, year, price, genre, poster) VALUES"
                    + " ('Zootopia', 2016, 8.50, 'Animation, Adventure, Comedy, Crime, Family, Mystery', 'zootopia')");
            insert.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * @throws Exception
     */
    public void createTables() throws Exception {
        try {
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS movies("
                    + "MovieID int Auto_Increment not null, name varchar(255) not null, year int not null, price double not null, "
                    + "genre varchar(255) not null, poster varchar(50) not null,"
                    + " PRIMARY KEY(MovieID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS customers("
                    + "CustomerID int Auto_Increment not null, firstName varchar(50) not null, "
                    + "lastName varchar(255) not null, dob varchar(20) not null, email varchar(40),"
                    + " PRIMARY KEY(CustomerID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS transactions("
                    + "TransactionID int Auto_Increment not null, CustomerID int not null, MovieID int not null, "
                    + "TransactionDate date not null,"
                    + " PRIMARY KEY(TransactionID), FOREIGN KEY (MovieID) REFERENCES movies(MovieID),"
                    + " FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS inventory("
                    + "InventoryID int Auto_Increment not null, MovieID int not null, copies int not null,"
                    + " PRIMARY KEY(InventoryID), FOREIGN KEY (MovieID) REFERENCES movies(MovieID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS memberships("
                    + "MemberID int Auto_Increment not null, CustomerID int not null,"
                    + " PRIMARY KEY(MemberID), FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS logins("
                    + "UserID int Auto_Increment not null, CustomerID int not null, LoginName varchar(15) not null,"
                    + "PassHash varchar(50) not null, PRIMARY KEY(UserID), "
                    + "FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS cart("
                    + "ItemID int Auto_Increment not null, CustomerID int not null,"
                    + " MovieID int not null, PRIMARY KEY(ItemID), "
                    + "FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID), "
                    + "FOREIGN KEY (MovieID) REFERENCES movies(MovieID))");
            create.executeUpdate();
        }   
        catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    //public boolean addToCart(Customer cust, )
    
    public boolean createAccount(Customer cust, String login, String pass) throws Exception {
        String insertedPass = hashPass(pass);
        int custID;
        PreparedStatement logCheck = con.prepareStatement("SELECT UserID from logins "
                + "WHERE LoginName = '" + login + "'");
        ResultSet result = logCheck.executeQuery();
        if (result.next()) {
            return false;
        }
        else {
            logCheck = con.prepareStatement("INSERT INTO customers (firstName, lastName, dob, email) VALUES"
                    + "('" + cust.getFirst() + "', '" + cust.getLast() + "', '" + cust.getDob() + "', '"
                            + cust.getEmail() + "')");
            logCheck.executeUpdate();
            logCheck = con.prepareStatement("SELECT CustomerID from customers WHERE firstName = '"
                    + cust.getFirst() + "' AND lastName = '" + cust.getLast() + "'");
            result = logCheck.executeQuery();
            result.next();
            custID = result.getInt("CustomerID");
            logCheck = con.prepareStatement("INSERT INTO logins (CustomerID, LoginName, PassHash) VALUES"
                    + "(" + custID + ", '" + login + "', '" + insertedPass + "')");
            logCheck.executeUpdate();
            return true;
        }        
    }
    
    public Customer logIn(String login, String pass) throws Exception {
        Customer customer = null;
        int custID;
        String insertedPass = hashPass(pass);
        PreparedStatement logCheck = con.prepareStatement("SELECT CustomerID from logins "
                + "WHERE LoginName = '" + login + "' AND PassHash = '" + insertedPass + "'");
        ResultSet result = logCheck.executeQuery();
        if (result.next()) {
            customer = new Customer();
            custID = result.getInt("CustomerID");
            PreparedStatement custCheck = con.prepareStatement("SELECT firstname, lastname, dob, email from customers "
                + "WHERE customerid = " + custID + "");
            result = custCheck.executeQuery();
            result.next();
            customer = new Customer();
            customer.setCustomerId(custID);
            customer.setFirst(result.getString("firstname"));
            customer.setLast(result.getString("lastname"));
            customer.setDob(result.getString("dob"));
            customer.setEmail(result.getString("email"));
            return customer;
        }
        return null;
    }
    
    public Customer logIn(String search) throws Exception {
        Customer customer = null;
        PreparedStatement customerCheck = con.prepareStatement("SELECT customerid, firstname, lastname, dob, email from customers "
                + "WHERE firstname = '" + search + "'");
        ResultSet result = customerCheck.executeQuery();
        if(result.next()) {
            customer = new Customer();
            customer.setCustomerId(result.getInt("customerId"));
            customer.setFirst(result.getString("firstname"));
            customer.setLast(result.getString("lastname"));
            customer.setEmail(result.getString("email"));
        }
        return customer;
    }
    
    public ArrayList<Movie> searchMovie(String search) throws Exception {
        ArrayList<Movie> retArray = new ArrayList<>();
        Movie insMovie;
        PreparedStatement movieCheck = con.prepareStatement("SELECT movieid, name, year, price, genre, poster from movies "
                + "WHERE name like '%" + search + "%'");
        ResultSet result = movieCheck.executeQuery();
        while (result.next()) {
            insMovie = new Movie();
            insMovie.setName(result.getString("name"));
            insMovie.setId(result.getInt("movieid"));
            insMovie.setYear(result.getInt("year"));
            insMovie.setPrice(result.getDouble("price"));
            insMovie.setGenre(result.getString("genre"));
            insMovie.setPoster(result.getString("poster"));
            retArray.add(insMovie);
        }
        return retArray;
    }
    
    public ArrayList<Movie> searchGenre(String search) throws Exception {
       ArrayList<Movie> retArray = new ArrayList<>();
       Movie insMovie;
       PreparedStatement genreCheck = con.prepareStatement("SELECT name, year, price, genre, poster from movies "
               + "WHERE genre like '%" + search + "%'");
        ResultSet result = genreCheck.executeQuery();
        while (result.next()) {
           insMovie = new Movie();
           insMovie.setName(result.getString("name"));
           insMovie.setYear(result.getInt("year"));
           insMovie.setPrice(result.getDouble("price"));
           insMovie.setGenre(result.getString("genre"));
           insMovie.setPoster(result.getString("poster"));
           retArray.add(insMovie);
       }
       return retArray;
    }
    
    private Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/javamovie";
            String username = "root";
            String password = "";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("connection success");
            return conn;
        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public void purchases(int customerID, int movieID) throws SQLException {
        try {
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

            PreparedStatement statement = con.prepareStatement("INSERT INTO transactions(customerid, movieid, transactiondate) VALUES"
                    + "('" + customerID + "', '" + movieID + "', '" + sqlDate + "')");

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Movie> topChart() throws SQLException {
        ArrayList<Movie> retArray = new ArrayList<>();

        try {
            Movie insMovie;
            PreparedStatement statement = con.prepareStatement("SELECT m.name, m.price, COUNT(*) AS num_movies from transactions t "
                    +" JOIN movies m ON m.movieid = t.movieid "+
                    " GROUP BY t.movieid ORDER BY num_movies DESC, m.name ASC");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                insMovie = new Movie();
                insMovie.setName(result.getString("name"));
                insMovie.setPrice(result.getInt("price"));
                retArray.add(insMovie);
            }
            return retArray;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return retArray;
    }
    
    public String hashPass(String initialPass) {
        char[] regPass = initialPass.toCharArray();
        char[] hashArray = new char[initialPass.length()]; 
        int i = 0;
        for (char c: regPass) {
            c *= 2;
            c -= 3;
            c -= initialPass.charAt(initialPass.length() - 1);
            c += initialPass.charAt(0);
            hashArray[i] = c;
            ++i;
        }
        String hash = String.valueOf(hashArray);
        return hash;
    }
    
    public Movie searchPoster(String search) throws Exception {
        Movie insMovie = null;
        PreparedStatement movieCheck = con.prepareStatement("SELECT movieid, name, year, price, genre, poster from movies "
                + "WHERE poster like '%" + search + "%'");
        ResultSet result = movieCheck.executeQuery();
        while (result.next()) {
            insMovie = new Movie();
            insMovie.setName(result.getString("name"));
            insMovie.setId(result.getInt("movieid"));
            insMovie.setYear(result.getInt("year"));
            insMovie.setPrice(result.getDouble("price"));
            insMovie.setGenre(result.getString("genre"));
            insMovie.setPoster(result.getString("poster"));
        }
        return insMovie;
    }
    
    public ArrayList<Movie> newReleases() throws Exception {
        ArrayList<Movie> retArray = new ArrayList<>();
        Movie insMovie;
        PreparedStatement movieCheck = con.prepareStatement("SELECT movieid, name, year, price, genre, poster from movies "
                + "WHERE year >= 2018");
        ResultSet result = movieCheck.executeQuery();
        while (result.next()) {
            insMovie = new Movie();
            insMovie.setName(result.getString("name"));
            insMovie.setId(result.getInt("movieid"));
            insMovie.setYear(result.getInt("year"));
            insMovie.setPrice(result.getDouble("price"));
            insMovie.setGenre(result.getString("genre"));
            insMovie.setPoster(result.getString("poster"));
            retArray.add(insMovie);
        }
        return retArray;
    }
    
    public void addMember(int customerID) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO memberships(customerid) VALUES"
                    + "('" + customerID + "')");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean isMember(int customerID) {
        try {
            int custID;
            PreparedStatement logCheck = con.prepareStatement("SELECT CustomerID from memberships "
                + "WHERE CustomerID = '" + customerID + "'");
            ResultSet result = logCheck.executeQuery();
            if (result.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
