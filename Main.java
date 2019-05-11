package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.Node;

public class Main extends Application {

    private DBOperation database = null;
    private Customer logIn = null;
    private ArrayList<Movie> cart = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        try {
            database = new DBOperation();
        } catch (Exception ex) {
            System.out.println("error 1");
            throw new RuntimeException(ex);
        }

        //----Everything will be added to a border pane
        BorderPane borderPane = new BorderPane();

        borderPane.setTop(getTopHBox());
        borderPane.setLeft(getVBox());
        borderPane.setCenter((getScrollPane()));
        borderPane.setBottom(getBottomBox());

        Scene scene = new Scene(borderPane, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Movie Play");
        primaryStage.show();
    }
    //----Border Pane Top
    private HBox getTopHBox() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));

        //Logo image
        ImageView imageLogo = new ImageView("movieplay.gif");
        imageLogo.setFitHeight(50);
        imageLogo.setFitWidth(55);

        //Search Image
        ImageView searchImage = new ImageView("Capture10.png");
        searchImage.setFitWidth(22);
        searchImage.setFitHeight(22);


        //Logo Label MOVIE PLAY
        Label labelLogo = new Label("Movie Play");
        labelLogo.setFont(new Font("Courier", 30));
        labelLogo.setTextFill(Color.GRAY);
        labelLogo.setStyle("-fx-font-weight: bold");

        //---------------Search TextField
        TextField searchTextField = new TextField("Search");
        searchTextField.setPrefWidth(400);
        searchTextField.setPrefHeight(30);


        //This action will pop up a window with the desire movies
        searchTextField.setOnAction(e -> {
            searchTextPopUp(searchTextField);
        });

                //Search Button
                Button searchButton = new Button();
        searchButton.setPrefHeight(30);
        searchButton.setPrefWidth(50);
        searchButton.setGraphic(searchImage);

        searchButton.setOnMouseClicked(e -> { //////
            searchTextPopUp(searchTextField);
        });


        //Sign in Button
        Button signInButton = new Button("Sign in");
        signInButton.setStyle("-fx-background-color: dodgerblue");
        signInButton.setPrefWidth(70);
        signInButton.setPrefHeight(30);

        signInButton.setOnAction(e -> {
            logInWindow("Sign in");
        });


        //logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: dodgerblue");
        logoutButton.setPrefWidth(70);
        logoutButton.setPrefHeight(30);
        logoutButton.setOnAction(e ->{
            if(logIn != null){
                logIn = null;
            }
        });

        //ShopCart button
        Button shopCar = new Button();
        ImageView cartImage = new ImageView("cart.png");
        cartImage.setFitHeight(25);
        cartImage.setFitWidth(30);
        shopCar.setGraphic(cartImage);
        shopCar.setPrefWidth(40);
        shopCar.setPrefHeight(25);


        shopCar.setOnAction(e -> {
            if(loginFirstPopUp()){
                return;
            }
            Button checkOut = new Button("Checkout");
            Button deleteButton = new Button("Delete Movie");
            Stage nw=new Stage();
            double total = 0;

            Button returnButton = new Button("Continue Shopping");
            returnButton.setOnAction(e3 ->{
                nw.close();
            });

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(10));
            Label yourShopCart = new Label("Confirm your listing");
            yourShopCart.setPadding(new Insets(10));

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle("Shopping cart");
            ListView<String> listView = new ListView<>();
            listView.setPadding(new Insets(20));
            for(Movie movie: cart) {
                listView.getItems().add(movie.toString());
                total += movie.getPrice();
            }
            Label labelTotal = new Label("Total: $" + String.format("%.2f", total));
            labelTotal.setPadding(new Insets(100,0,0,0));

            deleteButton.setOnAction(ex -> {
                cart.remove(listView.getSelectionModel().getSelectedIndex());
            });

            checkOut.setOnAction(ex -> {
                int CustomerID = logIn.getCustomerId();

                for(Movie movie : cart)
                    try {
                        database.purchases(CustomerID, movie.getId());
                    } catch (Exception ex1) {
                        System.out.println("error 1");
                        throw new RuntimeException(ex1);
                    }

                Stage nw2=new Stage();

                nw2.initModality(Modality.APPLICATION_MODAL);
                nw2.setTitle("Shopping Cart");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Purchase Successful");
                alert.setHeaderText(null);
                alert.setContentText("Thank You For Your Purchase!");
                alert.showAndWait();
                nw2.close();
                nw.close();
                listView.getItems().clear();
            });

            VBox vBox = new VBox();
            vBox.setPadding(new Insets(20));
            vBox.getChildren().addAll(returnButton, deleteButton, labelTotal, checkOut);
            vBox.setSpacing(10);
            borderPane.setTop(yourShopCart);
            borderPane.setCenter(listView);
            borderPane.setRight(vBox);

            Scene scene1= new Scene(borderPane, 500, 320);

            nw.setScene(scene1);

            nw.showAndWait();
        });

        //--------------Add all the controls to the hBox
        hBox.getChildren().addAll(imageLogo, labelLogo, searchTextField, searchButton, logoutButton, signInButton, shopCar);
        hBox.setMargin(searchButton, new Insets(7, 0, 0, 0));
        hBox.setMargin(searchTextField, new Insets(7, 0, 0, 40));
        hBox.setMargin(imageLogo, new Insets(-5, 3, 0, 0));
        hBox.setMargin(logoutButton, new Insets(7, 5, 0, 120));
        hBox.setMargin(signInButton, new Insets(6, 5, 0, 0));
        hBox.setMargin(shopCar, new Insets(6, -3, 0, 0));

        return hBox;
    }

    //----Border Pane Bottom
    private HBox getBottomBox() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(30, 30, 50, 280));

        Label label = new Label("©2019 Java Project Application | Location: United States Language: English");

        hBox.getChildren().add(label);

        return hBox;
    }

    //Left side of Border Pane
    private VBox getVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 20, 20, 0));

        //Button 1 MOVIES AND TV
        Button button1 = new Button("MOVIES AND TV");
        button1.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold");
        button1.setPrefHeight(30);
        button1.setPrefWidth(180);
        button1.setFont(new Font("Courier", 15));


        //-------------Genre Button
        ArrayList<String> genreList = new ArrayList<>();
        genreList.add("Action");
        genreList.add("Adventure");
        genreList.add("Sci-Fi");
        genreList.add("Fantasy");
        genreList.add("Drama");
        genreList.add("Family");
        genreList.add("Musical");
        genreList.add("Romance");
        genreList.add("Mystery");
        genreList.add("Thriller");
        genreList.add("Crime");
        genreList.add("Animation");
        genreList.add("Adventure");
        genreList.add("Comedy");

        MenuButton menuButton = new MenuButton("Genres");

        for(int i = 0; i < 14; i++) {
            MenuItem item = new MenuItem(genreList.get(i));
            item.setOnAction(a->{
                if(loginFirstPopUp()){
                    return;
                }
                ListView listVi = new ListView();

                ArrayList<Movie> movieSearch;
                try {
                    movieSearch = database.searchGenre(item.getText());
                    movieSearch.forEach(m -> {
                        String movie = m.getName() + ".  " + "Year: " + m.getYear() + " $" + m.getPrice();
                        listVi.getItems().add(movie);
                    });
                } catch (Exception ex) {
                    System.out.println("error 1");
                    throw new RuntimeException(ex);
                }

                selectionDisplay(listVi,  movieSearch, "Genre");
            });
            menuButton.getItems().add(item);
        }


        menuButton.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: lightgrey; -fx-font-size: 2em");
        vBox.setMargin(menuButton, new Insets(10, 0, 0, 15));
        menuButton.setFont(new Font("Courier", 14));

        //--------------Button 3 New Releases
        Button button3 = new Button("New Releases");
        button3.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: grey; -fx-font-size: 2em");
        button3.setPrefWidth(190);
        vBox.setMargin(button3, new Insets(5, 0, 0, 0));
        button3.setFont(new Font("Courier", 14));
        button3.setOnAction(e -> {
            if(loginFirstPopUp()){
                return;
            }
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle("New Releases");

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(0, 30, 30, 30));
            ListView listView = new ListView();
            Label addMovie = new Label("Add movie: ");
            addMovie.setPadding(new Insets(10));
            Button doneButton = new Button("Go Back");
            Button checkOutButton = new Button("Add To Cart");

            ArrayList<Movie> movieSearch;
            try {
                if(loginFirstPopUp()){
                    return;
                }
                movieSearch = database.searchMovie("Toy Story 4");
                movieSearch.forEach(m -> {
                    String movie = m.getName() + ".  " + "Year: " + m.getYear() + " $" + m.getPrice();
                    listView.getItems().add(movie);
                });
            } catch (Exception ex) {
                System.out.println("error 1");
                throw new RuntimeException(ex);
            }

            checkOutButton.setOnAction(e2 -> {
                cart.add(movieSearch.get(listView.getSelectionModel().getSelectedIndex()));
            });

            doneButton.setOnAction(e3 -> {
                nw.close();
            });

            HBox hBox = new HBox();
            hBox.setSpacing(100);
            hBox.getChildren().addAll(doneButton, checkOutButton);
            borderPane.setCenter(listView);
            borderPane.setTop(addMovie);
            borderPane.setBottom(hBox);
            Scene scene1= new Scene(borderPane, 300, 250);

            nw.setScene(scene1);

            nw.showAndWait();
        });

        //Button 4 Top Chart
        Button button4 = new Button("Top Chart");
        button4.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: grey; -fx-font-size: 2em");
        button4.setPrefWidth(150);
        vBox.setMargin(button4, new Insets(10, 0, 0, 0));
        button4.setFont(new Font("Courier", 14));

        button4.setOnAction(e -> {
            if(loginFirstPopUp()){
                return;
            }

            ListView listView = new ListView();

            ArrayList<Movie> movieSearch;
            try {
                movieSearch = database.topChart();
                movieSearch.forEach(m -> {
                    listView.getItems().add(m.getName() + " " + m.getPrice());
                });
            } catch (Exception ex) {
                System.out.println("error 1");
                throw new RuntimeException(ex);
            }

            selectionDisplay(listView,  movieSearch, "Top Chart");

        });

        //Button 5 Account
        Button button5 = new Button("Account");
        button5.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: grey; -fx-font-size: 2em");
        vBox.setMargin(button5, new Insets(5, 0, 0, 15));
        button5.setFont(new Font("Courier", 14));
        button5.setOnAction( e -> {
            logInWindow("Account");
        });


        //Separate last two button with a line
        Line line = new Line();
        line.setStroke(Color.LIGHTGRAY);
        line.setStartX(10);
        line.setStartY(300);
        line.setEndX(200);
        line.setEndY(300);

        vBox.getChildren().addAll(button1, menuButton, button3, button4, line, button5);

        return vBox;
    }


    //----Center of Border Pane
    private ScrollPane getScrollPane() {
        //--------Scroll panes
        ScrollPane root = new ScrollPane();
        root.setStyle("-fx-background-color:transparent;");
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        ScrollPane horizontalSp1 = new ScrollPane();
        horizontalSp1.setStyle("-fx-background-color:transparent;");
        horizontalSp1.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        horizontalSp1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        horizontalSp1.setHmax(300);


        //---------GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 50, 50, 25));
        //-----Add gridPane to Principal ScrollPane
        root.setContent(gridPane);

        //------Text Labels
        Label label1 = new Label("All Movies");
        label1.setStyle("-fx-text-fill: darkslategrey; -fx-font-size: 3em");
        label1.setFont(new Font("Courier", 14));

        //----------Buttons for movies
        File imageDir = new File("images");
        File[] imageFiles = imageDir.listFiles();
//        System.out.println("Image File: " + imageFiles.length);

        HBox imageHBox = new HBox();
        imageHBox.setMaxWidth(100);
        horizontalSp1.setContent(imageHBox);


        //Movie images
        TilePane pane = new TilePane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPrefColumns(5);
        pane.setMaxWidth(Region.USE_PREF_SIZE);
        ObservableList<Node> list = pane.getChildren();

            try{
            for(File imageFile : imageFiles) {
                String posterName = imageFile.getName().replace(".jpg", "");

                ImageView image = new ImageView(imageFile.toURI().toURL().toString());
                image.setFitHeight(200);
                image.setFitWidth(150);
                list.add(image);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        //-------Add labels and the two scroll panes to the gridpane
        gridPane.add(label1, 0, 0);
        gridPane.add(pane, 0, 1);

        return root;
    }

    //-------Functions

    //This method creates a login window, parameters are the button being pressed and the name of the new window
    public void logInWindow(String name) {
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle(name);

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(30,0,30,30));
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            //Register
            Button registerButton = new Button("Register");
            registerButton.setStyle("-fx-background-color: gray");
            registerButton.setPrefWidth(70);
            registerButton.setPrefHeight(30);
            registerWindow(registerButton, "Register");

            Label firstNameLabel = new Label("User Name: ");
            Label passwordLabel = new Label("Password: ");
            TextField firstNameField = new TextField();
            PasswordField passwordField = new PasswordField();
            Button loginButton = new Button("Login");
            Button cancelButton = new Button("Cancel");
            Label notAccountLabel = new Label("Don't have an account? ");
            HBox hBox = new HBox();
            hBox.setSpacing(30);
            hBox.getChildren().addAll(notAccountLabel, registerButton);

            cancelButton.setOnAction(ex -> {
                nw.close();
            });

            loginButton.setOnAction(ok ->{
                loginEntered(firstNameField, passwordField, nw);
            });

            passwordField.setOnAction(enter -> {
                loginEntered(firstNameField, passwordField, nw);
            });

            gridPane.add(firstNameLabel, 0, 0);
            gridPane.add(firstNameField, 1, 0);
            gridPane.add(passwordLabel, 0, 1);
            gridPane.add(passwordField, 1, 1);
            gridPane.add(loginButton, 0, 2);
            gridPane.add(cancelButton, 1, 2);


            borderPane.setCenter(gridPane);
            borderPane.setBottom(hBox);

            Scene scene1= new Scene(borderPane, 320, 250);

            nw.setScene(scene1);

            nw.showAndWait();
    }

    //This function is used to accept entering to your account
    public void loginEntered(TextField firstNameField, PasswordField passwordField, Stage nw){
        try {
            logIn = database.logIn(firstNameField.getText(), passwordField.getText());
            if(logIn == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Log In Failed");
                alert.setHeaderText(null);
                alert.setContentText("You must login before you can use the system.");
                alert.showAndWait();
            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Log In Was Successful");
                alert.setHeaderText(null);
                alert.setContentText("You may now use the system.");
                alert.showAndWait();
                nw.close();
            }
        } catch (Exception ex) {
            System.out.println("error 1");
            throw new RuntimeException(ex);
        }
    }

    //This method creates a login window, parameters are the button being pressed and the name of the new window
    public void registerWindow(Button button, String name) {
        button.setOnAction(e -> {
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle(name);

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(31,0,30,30));
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(11));
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            Label firstNameLabel = new Label("First Name: ");
            Label lastNameLabel = new Label("Last Name: ");
            Label dateOfBirthLabel = new Label("Date of Birth: ");
            Label emailLabel = new Label("Email: ");
            Label userNameLabel = new Label("User Name: ");
            Label passwordLabel = new Label("Password: ");
            TextField firstNameField = new TextField();
            TextField lastNameField = new TextField();
            TextField dateOfBirthField = new TextField();
            TextField emailField = new TextField();
            TextField userNameField = new TextField();
            PasswordField passwordField = new PasswordField();
            Button submitButton = new Button("Submit");
            Button cancelButton = new Button("Cancel");

            cancelButton.setOnAction(ex -> {
                nw.close();
            });
            submitButton.setOnAction(ok ->{
                try {
                    Customer cust = new Customer(-1, firstNameField.getText(), lastNameField.getText(),
                            dateOfBirthField.getText(), emailField.getText());
                    boolean loggedIn = database.createAccount(cust, userNameField.getText(), passwordField.getText());
                    if(loggedIn == false){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Register Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid registry information");
                        alert.showAndWait();
                    } else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Registration was successful");
                        alert.setHeaderText(null);
                        alert.setContentText("You may now log in with your account information.");
                        alert.showAndWait();
                        nw.close();
                    }
                } catch (Exception ex) {
                    System.out.println("error 1");
                    throw new RuntimeException(ex);
                }

            });
            gridPane.add(firstNameLabel, 0, 0);
            gridPane.add(firstNameField, 1, 0);
            gridPane.add(lastNameLabel, 0, 1);
            gridPane.add(lastNameField, 1, 1);
            gridPane.add(dateOfBirthLabel, 0, 2);
            gridPane.add(dateOfBirthField, 1, 2);
            gridPane.add(emailLabel, 0, 3);
            gridPane.add(emailField, 1, 3);
            gridPane.add(userNameLabel, 0, 4);
            gridPane.add(userNameField, 1, 4);
            gridPane.add(passwordLabel, 0, 5);
            gridPane.add(passwordField, 1, 5);

            gridPane.add(submitButton, 0, 7);
            gridPane.add(cancelButton, 1, 7);

            borderPane.setCenter(gridPane);

            Scene scene1= new Scene(borderPane, 330, 300);

            nw.setScene(scene1);

            nw.showAndWait();
        });
    }

    public boolean loginFirstPopUp(){
        boolean result = false;
        if(logIn == null){
            result = true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not logged In");
            alert.setHeaderText(null);
            alert.setContentText("You must login before you can use the system.");
            alert.showAndWait();
        }
        return result;
    }

    public void selectionDisplay(ListView listView,  ArrayList<Movie> movieSearch, String nameOfWindow){
        Stage popUpWin=new Stage();
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(0, 31, 30, 30));
        borderPane.setCenter(listView);

        Label addMovies = new Label("Select Movie:");
        addMovies.setPadding(new Insets(10));
        listView.setMinWidth(300);
        Button doneButton = new Button("Return");
        Button addButton = new Button("Add to Cart ");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(211);
        hBox1.getChildren().addAll(doneButton, addButton);

        doneButton.setOnAction(donebutton -> {
            popUpWin.close();
        });

        addButton.setOnAction(actionEvent -> {
            cart.add(movieSearch.get(listView.getSelectionModel().getSelectedIndex()));
        });

        borderPane.setCenter(listView);
        borderPane.setTop(addMovies);
        borderPane.setBottom(hBox1);

        popUpWin.initModality(Modality.APPLICATION_MODAL);
        popUpWin.setTitle(nameOfWindow);

        Scene scene1= new Scene(borderPane, 480, 350);

        popUpWin.setScene(scene1);

        popUpWin.showAndWait();
    }

    public void searchTextPopUp(TextField searchTextField){

            Stage popUpWindow=new Stage();

            popUpWindow.initModality(Modality.APPLICATION_MODAL);
            popUpWindow.setTitle("Find criteria");

            //GridPane gridPane = new GridPane();
            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(0, 30, 30, 30));
            Label addMovies = new Label("Select Movie:");
            addMovies.setPadding(new Insets(10));
            ListView<String> listView = new ListView();
            listView.setMinWidth(300);
            Button doneButton = new Button("Done");
            Button addButton = new Button("Add to Cart");
            HBox hBox1 = new HBox();
            hBox1.setSpacing(210);
            hBox1.getChildren().addAll(doneButton, addButton);

            doneButton.setOnAction(donebutton -> {
                popUpWindow.close();
            });

            String userInput = searchTextField.getText();

            ArrayList<Movie> movieSearch;
            try {
                if(loginFirstPopUp()){
                    return;
                }
                movieSearch = database.searchMovie(userInput);
                movieSearch.forEach(m -> {
                    listView.getItems().add(m.toString());
                });
            } catch (Exception ex) {
                System.out.println("error 1");
                throw new RuntimeException(ex);
            }

            addButton.setOnAction(actionEvent -> {
                cart.add(movieSearch.get(listView.getSelectionModel().getSelectedIndex()));
            });

            borderPane.setCenter(listView);
            borderPane.setTop(addMovies);
            borderPane.setBottom(hBox1);

            Scene scene1= new Scene(borderPane, 400, 400);

            popUpWindow.setScene(scene1);

            popUpWindow.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

