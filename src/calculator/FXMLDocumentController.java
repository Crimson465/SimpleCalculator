/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author Owner
 */
public class FXMLDocumentController implements Initializable {
    String value = "0";
    
    @FXML
    private Button num0;
    
    @FXML
    private Button num1;
    
    @FXML
    private Button num2;
    
    @FXML
    private Button num3;
    
    @FXML
    private Button num4;
    
    @FXML
    private Button num5;
    
    @FXML
    private Button num6;
    
    @FXML
    private Button num7;
    
    @FXML
    private Button num8;
    
    @FXML
    private Button num9;
    
    @FXML
    private Button clear;
    
    @FXML
    private TextField field;
    
    @FXML
    private TextArea area;
    
    @FXML
    private MenuItem quadratic;
    
    @FXML
    private BorderPane bPane;
    
    @FXML
    private void handleButtonActionNum0(ActionEvent event) {
        if(!field.getText().equals("")){
            field.appendText("0");
        }
    }
    
    @FXML
    private void handleButtonActionNum1(ActionEvent event) {
        
        field.appendText("1");
    }
    
    @FXML
    private void handleButtonActionNum2(ActionEvent event) {
        
        field.appendText("2");
    }
    
    @FXML
    private void handleButtonActionNum3(ActionEvent event) {
        
        field.appendText("3");
    }
    
    @FXML
    private void handleButtonActionNum4(ActionEvent event) {
        
        field.appendText("4");
    }
    
    @FXML
    private void handleButtonActionNum5(ActionEvent event) {
        
        field.appendText("5");
    }
    
    @FXML
    private void handleButtonActionNum6(ActionEvent event) {
        
        field.appendText("6");
    }
    
    @FXML
    private void handleButtonActionNum7(ActionEvent event) {
        
        field.appendText("7");
    }
    
    @FXML
    private void handleButtonActionNum8(ActionEvent event) {
        
        field.appendText("8");
    }
    
    @FXML
    private void handleButtonActionNum9(ActionEvent event) {
        
        field.appendText("9");
    }
    
    @FXML
    private void handleButtonActionClear(ActionEvent event) {
        value = "0";
        field.clear();
        area.clear();
    }
    
    @FXML
    private void handleButtonActionBackspace(ActionEvent event) {
        field.setText(field.getText().substring(0, field.getText().length() - 1));
    }
    
    @FXML
    private void handleButtonActionEquals(ActionEvent event) throws ScriptException {
        if(field.getText().equals("") || field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        
        if(field.getText().substring(field.getText().length() - 1).matches("^-?\\d+$")){
            value = "" + engine.eval(field.getText());
            area.appendText("\n" + field.getText() + " = " + engine.eval(field.getText()));
        }
        
        field.clear();
    }
    
    @FXML
    private void handleButtonActionAdd(ActionEvent event) {
        if(field.getText().equals("")){
            field.appendText(value + "+");
            return;
        }
        
        if(field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        field.appendText("+");
    }
    
    @FXML
    private void handleButtonActionSubtract(ActionEvent event) {
        
        if(field.getText().equals("")){
            field.appendText(value + "-");
            return;
        }
        
        if(field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        field.appendText("-");
    }
    
    @FXML
    private void handleButtonActionMultiply(ActionEvent event) {
        
        if(field.getText().equals("")){
            field.appendText(value + "*");
            return;
        }
        
        if(field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        field.appendText("*");
    }
    
    @FXML
    private void handleButtonActionDivide(ActionEvent event) {
        
        if(field.getText().equals("")){
            field.appendText(value + "/");
            return;
        }
        
        if(field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        field.appendText("/");
    }
    
    @FXML
    private void handleButtonActionModulus(ActionEvent event) {
        if(field.getText().equals("")){
            field.appendText(value + "%");
            return;
        }
        
        if(field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        field.appendText("%");
    }
    
    @FXML
    private void handleButtonActionNegative(ActionEvent event) {
        if(field.getText().equals("") || field.getText().contains("+") || field.getText().contains("-") || field.getText().contains("*") || field.getText().contains("/") || field.getText().contains("%")){
            return;
        }
        
        field.setText("-" + field.getText());
    }
    
    @FXML
    private void handleButtonActionDecimal(ActionEvent event) {
        if(field.getText().equals("") || field.getText().substring(field.getText().length() - 1).equals(".") || field.getText().substring(field.getText().length() - 1).equals("+") || field.getText().substring(field.getText().length() - 1).equals("-") || field.getText().substring(field.getText().length() - 1).equals("*") || field.getText().substring(field.getText().length() - 1).equals("/") || field.getText().substring(field.getText().length() - 1).equals("%")){
            return;
        }
        
        field.setText(field.getText() + ".");
    }
    
    /*@FXML
    private void handleButtonActionAction1(ActionEvent event) throws IOException {
        Process p = Runtime.getRuntime().exec("C:\\Users\\Owner\\Documents\\NetBeansProjects\\AMedia\\src\\amedia\\AMedia.java");
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void loadQuadratic(ActionEvent event) throws IOException{
        BorderPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
        
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setTitle("Quadratic Equation");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void loadPythagorean(ActionEvent event) throws IOException{
        BorderPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument3.fxml"));
        
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setTitle("Pythagorean Theorem");
        stage.setScene(scene);
        stage.show();
    }
}
