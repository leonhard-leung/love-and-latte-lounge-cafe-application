package com.leonhard_leung.view;

import com.leonhard_leung.utility.UIUtility;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class LandingPageView {
    @FXML
    private Pane menuPane;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button signInBT;
    @FXML
    private Button signUpBT;
    @FXML
    private Button homeBT;
    @FXML
    private Button aboutBT;
    @FXML
    private Button productBT;
    @FXML
    private Button contactBT;
    @FXML
    private ImageView sideImage;
    @FXML
    private ImageView instagramLogo;
    @FXML
    private ImageView xLogo;
    @FXML
    private ImageView facebookLogo;
    @FXML
    private ImageView tiktokLogo;
    @FXML
    private Circle circle1;
    @FXML
    private Circle circle2;
    @FXML
    private Parent aboutContent;
    @FXML
    private Parent productContent;
    @FXML
    private Parent contactContent;

    @FXML
    public void initialize() {
        setCircleVisibility(false);
        initializeContentPanes();
        setComponentAnimations();
        setMenuClickBehavior();
        setSocialMediaImageBehavior();
        setMenuSwitch();
        //setCircleTransition();
    } // end of initialize

    private void initializeContentPanes() {
        Platform.runLater(() -> {
            try {
                aboutContent = new FXMLLoader(getClass().getResource("/fxml/about_page.fxml")).load();
                aboutContent.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/about_page.css")).toExternalForm());

                contactContent = new FXMLLoader(getClass().getResource("/fxml/contact_page.fxml")).load();
                contactContent.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/contact_page.css")).toExternalForm());

                productContent = new FXMLLoader(getClass().getResource("/fxml/product_page.fxml")).load();
                productContent.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/product_page.css")).toExternalForm());
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        });
    } // end of initializeContentPanes

    private void setMenuSwitch() {
        homeBT.setOnAction(event -> {
            menuPane.setStyle("-fx-background-color: linear-gradient(to right, #dfafb4 58%, #f2d3cc 38%); -fx-background-radius: 20 20 0 0;");
            stackPane.getChildren().setAll(anchorPane);
        });

        aboutBT.setOnAction(event -> {
            menuPane.setStyle("-fx-background-color: #dfafb4; -fx-background-radius: 20 20 0 0; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.5, 0, 0);");
            stackPane.getChildren().setAll(aboutContent);
        });

        productBT.setOnAction(event -> {
            menuPane.setStyle("-fx-background-color: #dfafb4; -fx-background-radius: 20 20 0 0; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.5, 0, 0);");
            stackPane.getChildren().setAll(productContent);
        });

        contactBT.setOnAction(event -> {
            menuPane.setStyle("-fx-background-color: #dfafb4; -fx-background-radius: 20 20 0 0; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.5, 0, 0);");
            stackPane.getChildren().setAll(contactContent);
        });
    } // end of setMenuSwitch

    private void setComponentAnimations() {
        UIUtility.applyPrimaryButtonEffectsWithTranslation(signInBT);
        UIUtility.applySecondaryButtonEffects(signUpBT);
        UIUtility.applyImageScreenShake(sideImage);
    } // end of setComponentAnimations

    private void setMenuClickBehavior() {
        homeBT.setOnMouseClicked(event -> removeMenuButtonHighlight(homeBT));
        aboutBT.setOnMouseClicked(event -> removeMenuButtonHighlight(aboutBT));
        productBT.setOnMouseClicked(event -> removeMenuButtonHighlight(productBT));
        contactBT.setOnMouseClicked(event -> removeMenuButtonHighlight(contactBT));
    } // end of setMenuClickBehavior

    private void removeMenuButtonHighlight(Button button) {
        String originalStyle = "-fx-border-color: transparent; -fx-border-width: 0 0 0 0;";

        button.setStyle("-fx-border-color: #631f3a; -fx-border-width: 0 0 2 0;");
        if (!button.equals(homeBT)) {
            homeBT.setStyle(originalStyle);
        }
        if (!button.equals(aboutBT)) {
            aboutBT.setStyle(originalStyle);
        }
        if (!button.equals(productBT)) {
            productBT.setStyle(originalStyle);
        }
        if (!button.equals(contactBT)) {
            contactBT.setStyle(originalStyle);
        }
    } // end of removeMenuButtonHighlight

    public void setCircleVisibility(boolean value) {
        circle1.setVisible(value);
        circle2.setVisible(value);
    } // end of setCircleVisibility

    private void setSocialMediaImageBehavior() {
        setImageEnteredAndExited(instagramLogo, "/images/landing_page/home/instagram_hovered.png", "/images/landing_page/home/instagram.png");
        setImageEnteredAndExited(xLogo, "/images/landing_page/home/x_hovered.png", "/images/landing_page/home/x.png");
        setImageEnteredAndExited(facebookLogo, "/images/landing_page/home/facebook_hovered.png", "/images/landing_page/home/facebook.png");
        setImageEnteredAndExited(tiktokLogo, "/images/landing_page/home/tik_tok_hovered.png", "/images/landing_page/home/tik_tok.png");

        setImageURI(instagramLogo, "https://www.instagram.com/lleon.here/");
        setImageURI(xLogo, "https://twitter.com/lleon_here");
        setImageURI(facebookLogo, "https://www.facebook.com/leonhard.leung/");
        setImageURI(tiktokLogo, "https://www.tiktok.com/@lleon.here");
    } // end of setSocialMediaImageBehavior

    private void setImageEnteredAndExited(ImageView imageView, String imagePathEntered, String imagePathExited) {
        imageView.setOnMouseEntered(event -> {
            imageView.setCursor(Cursor.HAND);
            imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePathEntered))));
        });

        imageView.setOnMouseExited(event -> imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePathExited)))));
    } // end of setImageEnteredAndExited

    private void setImageURI(ImageView imageView, String link) {
        imageView.setOnMouseClicked(event -> {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException | URISyntaxException exception) {
                throw new RuntimeException(exception);
            }
        });
    } // end of setURI

    public ScaleTransition setCircleScaleTransition(Duration duration, Circle node, double initialXYValue, double xYValue) {
        ScaleTransition transition = new ScaleTransition(duration, node);

        transition.setFromX(initialXYValue);
        transition.setFromY(initialXYValue);
        transition.setToX(xYValue);
        transition.setToY(xYValue);

        return transition;
    } // end of setCircleScaleTransition

    public Button getSignInBT() {
        return signInBT;
    }

    public Button getSignUpBT() {
        return signUpBT;
    }

    public Circle getCircle1() {
        return circle1;
    }

    public Circle getCircle2() {
        return circle2;
    }
} // end of LandingPageView class
