package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocument2Controller implements Initializable {
    
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
    
    double a;
    double b;
    double c;
    
    @FXML
    private void handleButtonActionEnter(ActionEvent event) {
        
        if(isNumber(fielda.getText()) && isNumber(fieldb.getText()) && isNumber(fieldc.getText())){
            System.out.println("Value a: " + fielda.getText() + "Value b: " + fieldb.getText() + "Value c: " + fieldc.getText());
            area.appendText("Value a: " + fielda.getText() + " Value b: " + fieldb.getText() + " Value c: " + fieldc.getText() + "\n");
            a = Double.parseDouble(fielda.getText());
            b = Double.parseDouble(fieldb.getText());
            c = Double.parseDouble(fieldc.getText());
            
            quadratic(a, b, c);
        }else{
            System.out.println("Not all values set. Please Try again");
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
        
    }
    
    public static boolean isNumber(String s) {
        
        if((!s.matches("-?(0|[1-9]\\d*)") && !s.matches("^([+-]?\\d*\\.?\\d*)$")) || s.equals("")){
            return false;
        }
        
        return true;
    }
    
    public void quadratic(double a, double b, double c){
        double valuePlus;
        double valueMinus;
        double disc = Math.pow(Math.pow(b, 2) - (4*a*c), 0.5);
        String sign1 = "";
        String sign2 = "";
        
        valuePlus = ((0-b)+disc)/(2*a);
        valueMinus = ((0-b)-disc)/(2*a);
        
        if(b >= 0) sign1 = "+";
        if(c >= 0) sign2 = "+";
        
        area.appendText("The zeros of " + a + "x^2" + sign1 + b + "x" + sign2 + c + " is: \n");
        area.appendText("x = " + valuePlus + " x = " + valueMinus + "\n");
    }
    
}
