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
	
	//1-Nesne Tanýmlama
	
	LinearLayout arkaplan;
	Button sm,rd;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//2-Nesne-Widget Eþleþtirme
		arkaplan=(LinearLayout)findViewById(R.id.arkaplan);
		sm=(Button)findViewById(R.id.sm);
		rd=(Button)findViewById(R.id.rd);
		
		//3-Nesne-Widget Ýle ContextMenu Baðlama 
		registerForContextMenu(sm);
		registerForContextMenu(rd);
		registerForContextMenu(arkaplan);
		
		
		
		
		
	}
	
	//A-ContextMenü Oluþturma Kodlarý
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
		
		if(v.getId()==R.id.sm)//eðer sosyal medya butonuna basýldý ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.sosyal_medya, menu); //sosyal medya menüsü yükleme iþlemi
		}
		else if(v.getId()==R.id.rd)//eðer sosyal medya butonuna basýldý ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.renk_degistir, menu); //renk deðiþtir menüsü yükleme iþlemi
		}
		else
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.renk_degistir, menu); //renk deðiþtir menüsü yükleme iþlemi
		}
	}
	
	// B-Context Menü Eleman Seçme Fonksiyon
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		Intent sayfa; //bir activity çalýþtýrmak için kullanýlýr
		switch (item.getItemId()) {
		case R.id.kirmizi:
			arkaplan.setBackgroundColor(Color.RED); //Arkaplan rengi kýrmýzý
			break;
			
		case R.id.yesil:
			arkaplan.setBackgroundColor(Color.GREEN); //Arkaplan rengi yeþil
			break;
			
		case R.id.mavi:
			arkaplan.setBackgroundColor(Color.BLUE);  //Arkaplan rengi mavi
			
			break;
			
		case R.id.facebook:
			sayfa = new Intent(this, facebook.class);//Ýntent tanýmlama
			startActivity(sayfa); //Activity çalýþtýrma
			break;
			
		case R.id.instagram:
			sayfa = new Intent(this, instagram.class);//Ýntent tanýmlama
			startActivity(sayfa); //Activity çalýþtýrma
			break;
			
		case R.id.whatsapp:
			sayfa = new Intent(this, whatsapp.class);//Ýntent tanýmlama
			startActivity(sayfa); //Activity çalýþtýrma
			break;
			
		case R.id.twitter:
			sayfa = new Intent(this, twitter.class);//Ýntent tanýmlama
			startActivity(sayfa); //Activity çalýþtýrma
			break;
		


		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
		//C-OPTÝON MENÜ OLUÞTURMA FONKSÝYONU
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			getMenuInflater().inflate(R.menu.sosyal_medya, menu); //sosyal menu giydirme
			return super.onCreateOptionsMenu(menu);
		}
			
		//D-OPTÝON MENÜ ELEMAN SEÇME FONKSÝYONU
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			
			Intent sayfa; //bir activity çalýþtýrmak için kullanýlýr
			switch (item.getItemId()) {
			
				
			case R.id.facebook:
				sayfa = new Intent(this, facebook.class);//Ýntent tanýmlama
				startActivity(sayfa); //Activity çalýþtýrma
				break;
				
			case R.id.instagram:
				sayfa = new Intent(this, instagram.class);//Ýntent tanýmlama
				startActivity(sayfa); //Activity çalýþtýrma
				break;
				
			case R.id.whatsapp:
				sayfa = new Intent(this, whatsapp.class);//Ýntent tanýmlama
				startActivity(sayfa); //Activity çalýþtýrma
				break;
				
			case R.id.twitter:
				sayfa = new Intent(this, twitter.class);//Ýntent tanýmlama
				startActivity(sayfa); //Activity çalýþtýrma
				break;
			


			default:
				break;
			}

			
			
			return super.onOptionsItemSelected(item);
		}
		
	}

