package com.antoiovi.unicig.project.commons;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;

import javax.swing.InputVerifier;
import javax.swing.JComponent;

public class VerifierDouble extends InputVerifier {
Double min=null;
Double max=null;
	
public VerifierDouble() {
	super();
}

public VerifierDouble(Double min, Double max) {
	super();
	Double tmp,tmp2;
	tmp=min;
	tmp2=max;
	max=min>max?min:max;
	min=tmp<tmp2?tmp:tmp2;
	this.min = min;
	this.max = max;
}

public boolean shouldYieldFocus(JComponent input) {
		boolean inputOK = verify(input);
		// makeItPretty(input);
		if (inputOK) {
			input.setBackground(Color.white);
			//CreaTubo();
			return false;
		} else {
			input.setBackground(Color.red);
			Toolkit.getDefaultToolkit().beep();
			return true;
		}
	}
	
	@Override
	public boolean verify(JComponent input) {
		 Double value;

		 
			try {
				if(input.getClass().getName().equals("javax.swing.JTextField")){
					System.out.println(input.getClass().getName());
				value= Double.parseDouble(((JTextField)input).getText());
				if(min!=null){
					if (value<min){
						return false;
					}
				}
				if(max!=null){
					if(value>max){
						return false;
					}
				}
				
				return true;
				}else{
					
					return false;
				}
			} catch (Exception e) {
				
				return false;
			}

	}			
	
	 

}
