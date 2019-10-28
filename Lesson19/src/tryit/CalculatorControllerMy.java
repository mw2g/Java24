package tryit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorControllerMy {
	
	@FXML                 // inject the value from GUI
	private TextField displayField;  
	  
	private String previousValue="";
//	private String currentValue="";
	private String previousButton="";
	private double result;
	private String lastOperation;
		
	public void buttonClickHandler(ActionEvent evt){
		 
		Button clickedButton = (Button) evt.getTarget();
		String buttonLabel = clickedButton.getText();
		
		// Tell apart digits from operations
		switch(buttonLabel){
		  case "0": case "1": case "2": case "3": case "4": case "5":
		  case "6": case "7": case "8": case "9": case "10": case ".":		
		     processDigit(buttonLabel);
			 break;
		 default:
			 processOperation(buttonLabel);
		}
	}	
	  
	private void processDigit(String buttonLabel){ 
		if (previousButton == ""||previousButton == "digit") {
			displayField.setText(displayField.getText() + buttonLabel);
		}
		else {
			displayField.setText(buttonLabel);
		}
		previousButton = "digit";
	}
	  
	private void processOperation(String buttonLabel){
		switch(buttonLabel){
			case "C": 
				displayField.setText("");
				lastOperation = "";
				previousButton = "";
				previousValue = "";
			return;
		default:{  
			if (previousValue != "" && lastOperation != "") {
				calculate(lastOperation, previousValue, displayField.getText());
				
			}
			}
		}
		lastOperation = buttonLabel;
		previousButton = "operation";
		previousValue = displayField.getText();
	}
	  
	private void calculate(String operation, String prevVal, String curVal) {
		switch (operation) {
		    
			case "+":
				result = Double.parseDouble(prevVal) + Double.parseDouble(curVal);
			break;
			
			case "-":
				result = Double.parseDouble(prevVal) - Double.parseDouble(curVal);
		    break;
		    
			case "x":
				result = Double.parseDouble(prevVal) * Double.parseDouble(curVal);
			break;
			
			case "/":
				result = Double.parseDouble(prevVal) / Double.parseDouble(curVal);
			break;
		}
		displayField.setText("" + result);
	}
}
