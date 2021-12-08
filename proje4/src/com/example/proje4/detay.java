package com.example.proje4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class detay extends Activity {
	
	//1-nesne tanýmlama
	ImageView imageView1;
	TextView textView2,textView4,textView6,textView8,textView10,textView12,textView14;
	
	//1-dizi tanýmlama
	String [] takýmadý;
	String [] logo;
	String [] þehir;
	String [] stad;
	String [] kapasite;
	String [] baþkan;
	String [] teknikdirektör;
	String [] kaptan;
	
	
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detay);
		
		//2-nesne widget eþleþtirme
		imageView1=(ImageView)findViewById(R.id.imageView1);
		textView2=(TextView)findViewById(R.id.textView2);
		textView4=(TextView)findViewById(R.id.textView4);
		textView6=(TextView)findViewById(R.id.textView6);
		textView8=(TextView)findViewById(R.id.textView8);
		textView10=(TextView)findViewById(R.id.textView10);
		textView12=(TextView)findViewById(R.id.textView12);
		textView14=(TextView)findViewById(R.id.textView14);
		
		//2-bilgi.xml içerisindeki dizilerden deðer çekilerek diziler oluþturuluyor
		takýmadý=getResources().getStringArray(R.array.ad);
		logo=getResources().getStringArray(R.array.logo);
		þehir=getResources().getStringArray(R.array.sehir);
		stad=getResources().getStringArray(R.array.stad);
		kapasite=getResources().getStringArray(R.array.kapasite);
		baþkan=getResources().getStringArray(R.array.baskan);
		teknikdirektör=getResources().getStringArray(R.array.teknikdirektor);
		kaptan=getResources().getStringArray(R.array.kaptan);
		
		
		//3-MainActivity den gelen index bulunuyor
		Intent sayfa=getIntent();//MainActivity den gelen Intent bilgisi
		int index=Integer.parseInt(sayfa.getStringExtra("index"));//seçilen elamanýn indeksi
		
		//4-takým bilgisi gösterme iþlemi
		imageView1.setImageResource(this.getResources().getIdentifier(logo[index] , "drawable" , this.getPackageName()));
		textView2.setText(takýmadý[index]);
		textView4.setText(þehir[index]);
		textView6.setText(stad[index]);
		textView8.setText(baþkan[index]);
		textView10.setText(teknikdirektör[index]);
		textView12.setText(kaptan[index]);
		textView14.setText(kapasite[index]);
		
		
		
	}
}
