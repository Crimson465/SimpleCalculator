/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController3 implements Initializable {

    @FXML
    Button enter;
    
    @FXML
    TextArea area;
    
    @FXML
    TextField fielda;
    
    @FXML
    TextField fieldb;
    
    @FXML
    TextField fieldc;
    
    @FXML
    private void handleButtonActionEnter(ActionEvent event) {
        
        if((isNumber(fielda.getText()) && isNumber(fieldb.getText())) || (isNumber(fielda.getText()) && isNumber(fieldc.getText())) || (isNumber(fieldb.getText()) && isNumber(fieldc.getText()))){
            
            area.appendText("a: " + fielda.getText() + " b: " + fieldb.getText() + " c: " + fieldc.getText() + "\n");
            
            pythagorean(fielda.getText(), fieldb.getText(), fieldc.getText());
        }else{
            area.appendText("Not all values are set. Try again\n");
        }
    }
    
    @FXML
    private void handleButtonActionClear(ActionEvent event) {
        
        fielda.setText("");
        fieldb.setText("");
        fieldc.setText("");
        
        area.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public static boolean isNumber(String s) {
        
        if((!s.matches("-?(0|[1-9]\\d*)") && !s.matches("^([+-]?\\d*\\.?\\d*)$"))){
            return false;
        }
        
        return true;
    }
    
    public static int isEmpty(String s) {
        
        if(s.equals("")){
            return 1;
        }
        
        return 0;
    }
    
    public void pythagorean(String a, String b, String c){
        int empty = 0;
        double aNum;
        double bNum;
        double cNum;
        double theta;
        double phi;
        
        empty += isEmpty(a);
        empty += isEmpty(b);
        empty += isEmpty(c);
        System.out.println("Done with empty");
        
        if(empty != 1){
            area.appendText("empty: " + empty + "\n");
            area.appendText("Values have been input incorrectly. Please Try again\n\n");
            return;
        }
        
        if(a.equals("") && isNumber(b) && isNumber(c) && (Double.parseDouble(c) > Double.parseDouble(b))){
            System.out.println("StartA");
            a = "" + Math.pow(Math.pow(Double.parseDouble(c), 2) - Math.pow(Double.parseDouble(b), 2), 0.5);
            fielda.setText(a);
            System.out.println("FinishA");
        }else if(b.equals("") && isNumber(a) && isNumber(c) && (Double.parseDouble(c) > Double.parseDouble(a))){
            System.out.println("StartB");
            b = "" + Math.pow(Math.pow(Double.parseDouble(c), 2) - Math.pow(Double.parseDouble(a), 2), 0.5);
            fieldb.setText(b);
            System.out.println("FinishB");
        }else if(c.equals("") && isNumber(a) && isNumber(b)){
            System.out.println("StartC");
            c = "" + Math.pow(Math.pow(Double.parseDouble(a), 2) + Math.pow(Double.parseDouble(b), 2), 0.5);
            fieldc.setText(c);
            System.out.println("FinishC");
        }else{
            area.appendText("Values have been input incorrectly. Please Try again\n\n");
            return;
        }
        
        aNum = Double.parseDouble(a);
        bNum = Double.parseDouble(b);
        cNum = Double.parseDouble(c);
        theta = Math.asin(aNum/cNum)*(180/Math.PI);
        phi = Math.asin(bNum/cNum)*(180/Math.PI);
        
        area.appendText(String.format("\na: %.2f\nb: %.2f\nc: %.2f\nθ: %.2f°\nΦ: %.2f°\n", aNum, bNum, cNum, theta, phi));
    }
    
}
