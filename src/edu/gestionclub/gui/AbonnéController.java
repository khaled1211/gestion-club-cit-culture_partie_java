/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionclub.gui;

import edu.gestion_club.entities.Club;
import edu.gestion_club.entities.User;
import edu.gestion_club.entities.UserServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AbonnéController implements Initializable {

    @FXML
    private TableView<User> table2;
    @FXML
    private TableColumn<Club, Integer> id;
    @FXML
    private TableColumn<Club, String> nom;
    @FXML
    private TableColumn<Club, String> prenom;
    @FXML
    private TableColumn<Club, String> adress;
    @FXML
    private Button bannir;
    @FXML
    private Button close;
    @FXML
    private TableColumn<Club, String> telephone;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserServices us = new UserServices();
        ArrayList<User> pers = (ArrayList<User>) us.displayUser(ClubController.idclubisc);
        ObservableList<User> obs = FXCollections.observableArrayList(pers);
        table2.setItems(obs);
                 id.setCellValueFactory(new PropertyValueFactory<>("idUser"));

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
         telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
       
      
        
               
        // TODO
    }    

    @FXML
    private void bannir(ActionEvent event) {
        
        
    }

    @FXML
    private void close(ActionEvent event) {
         Stage stage = (Stage) close.getScene().getWindow();
         stage.close();
    }

    @FXML
    private void retour(ActionEvent event) {
         try {
            Parent root;
            root=FXMLLoader.load(getClass().getResource("club.fxml"));
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
