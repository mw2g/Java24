package tryit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
	
	@FXML                 // inject the value from GUI
	private TextField displayField;  
	  
	private String previousValue="";
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
			 lastOperation = buttonLabel;
			 previousButton = "operation";
		}
	}	
	  
	private void processDigit(String buttonLabel){
		
		if (previousButton != "operation") {
			if (displayField.getText().indexOf(".")!=-1 && ".".equals(buttonLabel)) return;
			displayField.setText(displayField.getText() + buttonLabel);
		}
		else {
			displayField.setText((buttonLabel==".")? "0." : buttonLabel);
		}
		
		if (".".equals(displayField.getText())) 
			displayField.setText("0.");
			
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
				calculate(buttonLabel, lastOperation, previousValue, displayField.getText());
				
			}
			}
		}
		previousValue = displayField.getText();
	}
	  
	private void calculate(String button, String operation, String prevVal, String curVal) {
		Double a = Double.parseDouble(prevVal);
		Double b = Double.parseDouble(curVal);
		
		switch (operation) {
			case "+":
				result = a + b;
			break;
			
			case "-":
				result = a - b;
		    break;
		    
			case "x":
				result = a * b;
			break;
			
			case "/":
				result = a / b;
			break;
		}
		if ("=".equals(button)) {
			lastOperation = "";
			previousButton = "";
			previousValue = "";
		}
		displayField.setText("" + result);
	}
}
