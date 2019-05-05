package javamovie;

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
import javafx.event.EventType;
import javafx.scene.Node;

public class Main extends Application {

    private DBOperation database = null;
    private Customer logIn = null;
    @Override
    public void start(Stage primaryStage) throws Exception {



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
        ArrayList<Movie> cart = new ArrayList<>();
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

            Stage popUpWindow=new Stage();

            popUpWindow.initModality(Modality.APPLICATION_MODAL);
            popUpWindow.setTitle("Find criteria");

            //GridPane gridPane = new GridPane();
            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(0, 30, 30, 30));
            Label addMovies = new Label("Add Movie:");
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
                    if(logIn == null){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Not logged In");
                        alert.setHeaderText(null);
                        alert.setContentText("You must login before you can use the system.");
                        alert.showAndWait();
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
        });

                //Search Button
        Button searchButton = new Button();
        searchButton.setPrefHeight(30);
        searchButton.setPrefWidth(50);
        searchButton.setGraphic(searchImage);
        searchButton.setOnMouseClicked(e -> { //////

            Stage popUpWindow=new Stage();

            popUpWindow.initModality(Modality.APPLICATION_MODAL);
            popUpWindow.setTitle("Find criteria");

            //GridPane gridPane = new GridPane();
            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(0, 30, 30, 30));
            Label addMovies = new Label("Add Movie:");
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
                    if(logIn == null){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Not logged In");
                        alert.setHeaderText(null);
                        alert.setContentText("You must login before you can use the system.");
                        alert.showAndWait();
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
        }); ////////
        
        //Register
        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: gray");
        registerButton.setPrefWidth(70);
        registerButton.setPrefHeight(30);
        registerWindow(registerButton, "Register");
        //Sign in Button
        Button signInButton = new Button("Sign in");
        signInButton.setStyle("-fx-background-color: dodgerblue");
        signInButton.setPrefWidth(70);
        signInButton.setPrefHeight(30);
        logInWindow(signInButton, "Sign in");
        
        //ShopCart button
        Button shopCar = new Button();
        ImageView cartImage = new ImageView("cart.png");
        cartImage.setFitHeight(25);
        cartImage.setFitWidth(30);
        shopCar.setGraphic(cartImage);
        shopCar.setPrefWidth(40);
        shopCar.setPrefHeight(25);


        shopCar.setOnAction(e -> {
            Button checkOut = new Button("Checkout");
            Stage nw=new Stage();
            double total = 0;

            BorderPane borderPane = new BorderPane();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle("Shopping cart");
            ListView<String> listView = new ListView<>();
            for(Movie movie: cart) {
                listView.getItems().add(movie.toString());
                total += movie.getPrice();
            }
            Label labelTotal = new Label(" $" + String.format("%.2f", total));
            borderPane.setTop(listView);
            borderPane.setCenter(labelTotal);
            borderPane.setBottom(checkOut);

            Scene scene1= new Scene(borderPane, 500, 500);

            nw.setScene(scene1);

            nw.showAndWait();
        });

        //--------------Add all the controls to the hBox
        hBox.getChildren().addAll(imageLogo, labelLogo, searchTextField, searchButton, registerButton, signInButton, shopCar);
        hBox.setMargin(searchButton, new Insets(7, 0, 0, 0));
        hBox.setMargin(searchTextField, new Insets(7, 0, 0, 40));
        hBox.setMargin(imageLogo, new Insets(-5, 3, 0, 0));
        hBox.setMargin(signInButton, new Insets(7, 10, 0, 150));
        hBox.setMargin(registerButton, new Insets(6, 9, 0, 70));
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

        //Genres button
        MenuItem action = new MenuItem("Action");
        MenuItem adventure = new MenuItem("Adventure");
        MenuItem sciFi = new MenuItem("Sci-Fi");
        MenuItem fantasy = new MenuItem("Fantasy");
        MenuItem drama = new MenuItem("Drama");
        MenuItem family = new MenuItem("Family");
        MenuItem musical = new MenuItem("Musical");
        MenuItem romance = new MenuItem("Romance");
        MenuItem mystery = new MenuItem("Mystery");
        MenuItem thriller = new MenuItem("Thriller");
        MenuItem crime = new MenuItem("Crime");
        MenuItem animation = new MenuItem("Animation");
        MenuItem comedy = new MenuItem("Comedy");

        MenuButton menuButton = new MenuButton("Genres", null, action, adventure, sciFi, fantasy, drama, family, musical, romance, mystery,
                                               thriller, crime, animation, comedy);
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
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle("New Releases");

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(0, 30, 30, 30));
            ListView listView = new ListView();
            Label addMovie = new Label("Add movie: ");
            addMovie.setPadding(new Insets(10));
            Button doneButton = new Button("Done");

            ArrayList<Movie> movieSearch;
            try {
                movieSearch = database.searchMovie("Toy Story 4");
                movieSearch.forEach(m -> {
                    String movie = m.getName() + ".  " + "Year: " + m.getYear() + " $" + m.getPrice();
                    listView.getItems().add(movie);
                });
            } catch (Exception ex) {
                System.out.println("error 1");
                throw new RuntimeException(ex);
            }

            borderPane.setCenter(listView);
            borderPane.setTop(addMovie);
            borderPane.setBottom(doneButton);
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
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle("Top Chart");

            BorderPane borderPane = new BorderPane();

            Scene scene1= new Scene(borderPane, 300, 250);

            nw.setScene(scene1);

            nw.showAndWait();
        });



        //Button 5 Account
        Button button5 = new Button("Account");
        button5.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: grey; -fx-font-size: 2em");
        vBox.setMargin(button5, new Insets(5, 0, 0, 15));
        button5.setFont(new Font("Courier", 14));
        logInWindow(button5, "Account");

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

    //This method creates a login window, parameters are the button being pressed and the name of the new window
    public void registerWindow(Button button, String name) {
        button.setOnAction(e -> {
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle(name);

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(30));
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
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
            Button okButton = new Button("OK");
            Button cancelButton = new Button("Cancel");

            cancelButton.setOnAction(ex -> {
                nw.close();
            });
            okButton.setOnAction(ok ->{
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
            
            gridPane.add(okButton, 0, 7);
            gridPane.add(cancelButton, 1, 7);

            borderPane.setCenter(gridPane);

            Scene scene1= new Scene(borderPane, 350, 200);

            nw.setScene(scene1);

            nw.showAndWait();
        });
    }
    
    public void logInWindow(Button button, String name) {
        button.setOnAction(e -> {
            Stage nw=new Stage();

            nw.initModality(Modality.APPLICATION_MODAL);
            nw.setTitle(name);

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(30));
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            Label userNameLabel = new Label("User Name: ");
            Label passwordLabel = new Label("Password: ");
            TextField userNameField = new TextField();
            PasswordField passwordField = new PasswordField();
            Button okButton = new Button("OK");
            Button cancelButton = new Button("Cancel");

            cancelButton.setOnAction(ex -> {
                nw.close();
            });

            okButton.setOnAction(ok ->{
                try {
                    logIn = database.logIn(userNameField.getText(), passwordField.getText());
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

            });

            gridPane.add(userNameLabel, 0, 0);
            gridPane.add(userNameField, 1, 0);
            gridPane.add(passwordLabel, 0, 1);
            gridPane.add(passwordField, 1, 1);
            gridPane.add(okButton, 0, 2);
            gridPane.add(cancelButton, 1, 2);

            borderPane.setCenter(gridPane);

            Scene scene1= new Scene(borderPane, 350, 200);

            nw.setScene(scene1);

            nw.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

