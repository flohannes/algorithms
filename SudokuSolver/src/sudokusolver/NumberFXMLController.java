/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokusolver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author UKM
 */
public class NumberFXMLController implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private GridPane bigGrid;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked meYou!");
    }
    
    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        System.out.println("You clicked meYou!");
        
    }
    
    @FXML
    private void handleLabel1Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
//        label1.setFont(new Font(14));
        label1.setUnderline(true);
    }
    @FXML
    private void handleLabel2Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel3Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel4Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel5Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel6Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel7Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel8Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    @FXML
    private void handleLabel9Action(MouseEvent event) {
        System.out.println("You clicked meYou!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
