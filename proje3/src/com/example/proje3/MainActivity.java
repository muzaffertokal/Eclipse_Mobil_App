package com.example.proje3;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	//1-Nesne Tan�mlama
	
	LinearLayout arkaplan;
	Button sm,rd;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//2-Nesne-Widget E�le�tirme
		arkaplan=(LinearLayout)findViewById(R.id.arkaplan);
		sm=(Button)findViewById(R.id.sm);
		rd=(Button)findViewById(R.id.rd);
		
		//3-Nesne-Widget �le ContextMenu Ba�lama 
		registerForContextMenu(sm);
		registerForContextMenu(rd);
		registerForContextMenu(arkaplan);
		
		
		
		
		
	}
	
	//A-ContextMen� Olu�turma Kodlar�
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
		
		if(v.getId()==R.id.sm)//e�er sosyal medya butonuna bas�ld� ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.sosyal_medya, menu); //sosyal medya men�s� y�kleme i�lemi
		}
		else if(v.getId()==R.id.rd)//e�er sosyal medya butonuna bas�ld� ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.renk_degistir, menu); //renk de�i�tir men�s� y�kleme i�lemi
		}
		else
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.renk_degistir, menu); //renk de�i�tir men�s� y�kleme i�lemi
		}
	}
	
	// B-Context Men� Eleman Se�me Fonksiyon
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		Intent sayfa; //bir activity �al��t�rmak i�in kullan�l�r
		switch (item.getItemId()) {
		case R.id.kirmizi:
			arkaplan.setBackgroundColor(Color.RED); //Arkaplan rengi k�rm�z�
			break;
			
		case R.id.yesil:
			arkaplan.setBackgroundColor(Color.GREEN); //Arkaplan rengi ye�il
			break;
			
		case R.id.mavi:
			arkaplan.setBackgroundColor(Color.BLUE);  //Arkaplan rengi mavi
			
			break;
			
		case R.id.facebook:
			sayfa = new Intent(this, facebook.class);//�ntent tan�mlama
			startActivity(sayfa); //Activity �al��t�rma
			break;
			
		case R.id.instagram:
			sayfa = new Intent(this, instagram.class);//�ntent tan�mlama
			startActivity(sayfa); //Activity �al��t�rma
			break;
			
		case R.id.whatsapp:
			sayfa = new Intent(this, whatsapp.class);//�ntent tan�mlama
			startActivity(sayfa); //Activity �al��t�rma
			break;
			
		case R.id.twitter:
			sayfa = new Intent(this, twitter.class);//�ntent tan�mlama
			startActivity(sayfa); //Activity �al��t�rma
			break;
		


		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
		//C-OPT�ON MEN� OLU�TURMA FONKS�YONU
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			getMenuInflater().inflate(R.menu.sosyal_medya, menu); //sosyal menu giydirme
			return super.onCreateOptionsMenu(menu);
		}
			
		//D-OPT�ON MEN� ELEMAN SE�ME FONKS�YONU
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			
			Intent sayfa; //bir activity �al��t�rmak i�in kullan�l�r
			switch (item.getItemId()) {
			
				
			case R.id.facebook:
				sayfa = new Intent(this, facebook.class);//�ntent tan�mlama
				startActivity(sayfa); //Activity �al��t�rma
				break;
				
			case R.id.instagram:
				sayfa = new Intent(this, instagram.class);//�ntent tan�mlama
				startActivity(sayfa); //Activity �al��t�rma
				break;
				
			case R.id.whatsapp:
				sayfa = new Intent(this, whatsapp.class);//�ntent tan�mlama
				startActivity(sayfa); //Activity �al��t�rma
				break;
				
			case R.id.twitter:
				sayfa = new Intent(this, twitter.class);//�ntent tan�mlama
				startActivity(sayfa); //Activity �al��t�rma
				break;
			


			default:
				break;
			}

			
			
			return super.onOptionsItemSelected(item);
		}
		
	}

