package com.example.proje2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	//Nesne Tanýtma
	
	EditText sayi1,sayi2,sonuc;
	Button topla,cikar,bol,carp;
	LinearLayout arkaplan;
	
	SeekBar s1,s2,s3;
	TextView r,g,b;
	
	int k=0,y=0,m=0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Nesne ile Widget Eþleþtirme
		
		sayi1=(EditText)findViewById(R.id.sayi1);
		sayi2=(EditText)findViewById(R.id.sayi2);
		sonuc=(EditText)findViewById(R.id.sonuc);
		
		topla=(Button)findViewById(R.id.topla);
		carp=(Button)findViewById(R.id.carp);
		bol=(Button)findViewById(R.id.bol);
		cikar=(Button)findViewById(R.id.cikar);
		
		s1=(SeekBar)findViewById(R.id.s1);
		s2=(SeekBar)findViewById(R.id.s2);
		s3=(SeekBar)findViewById(R.id.s3);
		
		r=(TextView)findViewById(R.id.r);
		g=(TextView)findViewById(R.id.g);
		b=(TextView)findViewById(R.id.b);
		
		
	
		
		
		arkaplan=(LinearLayout)findViewById(R.id.arkaplan);
		
		s1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			//deðer deðiþim olayý
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				k=progress;
				arkaplan.setBackgroundColor(Color.rgb(k, y, m));
				r.setText(k+"");
				
			}
		});
		
		s2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				y=progress;
				arkaplan.setBackgroundColor(Color.rgb(k, y, m));
				g.setText(y+"");
				
			}
		});
		
		s3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				m=progress;
				arkaplan.setBackgroundColor(Color.rgb(k, y, m));
				b.setText(m+"");
				
			}
		});
		
				
				
		
		
		
	}
	// olay alt fonksiyon tanýtma
	
	
	public void topla(View  v)
	{
	double sayý1= Double.parseDouble(sayi1.getText().toString()); //
	double sayý2= Double.parseDouble(sayi2.getText().toString()); //
	double sonuç=sayý1+sayý2;
	sonuc.setText(sonuç+""); // deðer yazdýrma fonksiyonu
	
	
	
	
	}
	public void carp(View  v)
	{
	double sayý1= Double.parseDouble(sayi1.getText().toString()); //
	double sayý2= Double.parseDouble(sayi2.getText().toString()); //
	double sonuç=sayý1*sayý2;
	sonuc.setText(sonuç+""); // deðer yazdýrma fonksiyonu
	
	
	
	
	}
	public void bol(View  v)
	{
	double sayý1= Double.parseDouble(sayi1.getText().toString()); //
	double sayý2= Double.parseDouble(sayi2.getText().toString()); //
	double sonuç=sayý1/sayý2;
	sonuc.setText(sonuç+""); // deðer yazdýrma fonksiyonu
	
	
	
	
	}
	public void cikar(View  v)
	{
	double sayý1= Double.parseDouble(sayi1.getText().toString()); //
	double sayý2= Double.parseDouble(sayi2.getText().toString()); //
	double sonuç=sayý1-sayý2;
	sonuc.setText(sonuç+""); // deðer yazdýrma fonksiyonu
	
	
	
	
	}
}
