package javamovie;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * 
 */
class JavaMovie {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        boolean done = false;
        Connection dbConnect;
        dbConnect = getConnection();
        if (dbConnect != null) {
            createTables(dbConnect);
            while (done == false) {
                System.out.println("Would you like to insert data into the database? (y/n)");
                choice = sc.next();
                if ("y".equals(choice) || "yes".equals(choice)) {
                    insertData(dbConnect);
                    done = true;
                }
                else if ("n".equals(choice) || "no".equals(choice) ) {
                    done = true;
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
        }
        
    }
    public static void insertData(Connection con) throws Exception {
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
    public static void createTables(Connection con) throws Exception {
        try {
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS movies("
                    + "MovieID int Auto_Increment not null, name varchar(255) not null, year int not null, price double not null, "
                    + "genre varchar(255) not null, poster varchar(50) not null,"
                    + " PRIMARY KEY(MovieID))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS customers("
                    + "CustomerID int Auto_Increment not null, firstName varchar(50) not null, "
                    + "lastName varchar(255) not null, dob date not null, phoneNum varchar(20),"
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
        }   
        catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    public static Connection getConnection() throws Exception {
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
}
