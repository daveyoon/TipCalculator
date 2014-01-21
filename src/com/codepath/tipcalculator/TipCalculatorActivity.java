package com.codepath.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends Activity {
	double tipPercent = 0.0; 
	double totalAmount;

	EditText etTotalAmount;
	TextView tvTipTotal;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);								
		setContentView(R.layout.activity_tip_calculator);
		setupListViewListener(); 		
	}

	protected void setupListViewListener() {
		Button btn10 = (Button) findViewById(R.id.btn_10);
		btn10.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	tipPercent = 0.1; 
		    			    	
		    	calculateTipTotal();		    	
		    }
		});
		Button btn15 = (Button) findViewById(R.id.btn_15);
		btn15.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        tipPercent = 0.15;		        		        
		        calculateTipTotal();		        
		    }
		});
		Button btn20 = (Button) findViewById(R.id.btn_20);
		btn20.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	tipPercent = 0.20; 		    			    	
		    	calculateTipTotal();		    	
		    }
		});		
	}
	
	protected void calculateTipTotal() {
		etTotalAmount = (EditText) findViewById(R.id.etAmountTotal);
		tvTipTotal = (TextView) findViewById(R.id.tvTipTotal);
		try {
			totalAmount = Double.valueOf(etTotalAmount.getText().toString());
		} catch (NumberFormatException e){
			totalAmount = 0.0; // if the user hasn't entered a value in yet, assume that the total is 0 
		}
		
		Double tipTotal = Math.round( 100.00 * tipPercent * totalAmount) / 100.00 ;	
		String text = "Tip is: $" + String.format("%.2f", tipTotal);
		tvTipTotal.setText(text);				
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
}
