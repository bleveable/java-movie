package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBOperation {
    private final Connection con;

    public DBOperation() throws Exception {
        con = getConnection();
    }


    public boolean createAccount(Customer cust, String login, String pass) throws Exception {
        String insertedPass = hashPass(pass);
        int custID;
        PreparedStatement logCheck = con.prepareStatement("SELECT UserID from logins "
                + "WHERE LoginName = '" + login + "'");
        ResultSet result = logCheck.executeQuery();
        if (result.next()) {
            return false;
        } else {
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
            customer.setMail(result.getString("email"));
            return customer;
        }
        return null;
    }

    public Customer logIn(String search) throws Exception {
        Customer customer = null;
        PreparedStatement customerCheck = con.prepareStatement("SELECT customerid, firstname, lastname, dob, email from customers "
                + "WHERE firstname = '" + search + "'");
        ResultSet result = customerCheck.executeQuery();
        if (result.next()) {
            customer = new Customer();
            customer.setCustomerId(result.getInt("customerId"));
            customer.setFirst(result.getString("firstname"));
            customer.setLast(result.getString("lastname"));
            customer.setMail(result.getString("email"));
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

    //private Connection mySqlConnection;
    private Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javamovie", "root", "password");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String hashPass(String initialPass) {
        char[] regPass = initialPass.toCharArray();
        char[] hashArray = new char[initialPass.length()];
        int i = 0;
        for (char c : regPass) {
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
}

