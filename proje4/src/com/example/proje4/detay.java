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
	
	//1-nesne tan�mlama
	ImageView imageView1;
	TextView textView2,textView4,textView6,textView8,textView10,textView12,textView14;
	
	//1-dizi tan�mlama
	String [] tak�mad�;
	String [] logo;
	String [] �ehir;
	String [] stad;
	String [] kapasite;
	String [] ba�kan;
	String [] teknikdirekt�r;
	String [] kaptan;
	
	
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detay);
		
		//2-nesne widget e�le�tirme
		imageView1=(ImageView)findViewById(R.id.imageView1);
		textView2=(TextView)findViewById(R.id.textView2);
		textView4=(TextView)findViewById(R.id.textView4);
		textView6=(TextView)findViewById(R.id.textView6);
		textView8=(TextView)findViewById(R.id.textView8);
		textView10=(TextView)findViewById(R.id.textView10);
		textView12=(TextView)findViewById(R.id.textView12);
		textView14=(TextView)findViewById(R.id.textView14);
		
		//2-bilgi.xml i�erisindeki dizilerden de�er �ekilerek diziler olu�turuluyor
		tak�mad�=getResources().getStringArray(R.array.ad);
		logo=getResources().getStringArray(R.array.logo);
		�ehir=getResources().getStringArray(R.array.sehir);
		stad=getResources().getStringArray(R.array.stad);
		kapasite=getResources().getStringArray(R.array.kapasite);
		ba�kan=getResources().getStringArray(R.array.baskan);
		teknikdirekt�r=getResources().getStringArray(R.array.teknikdirektor);
		kaptan=getResources().getStringArray(R.array.kaptan);
		
		
		//3-MainActivity den gelen index bulunuyor
		Intent sayfa=getIntent();//MainActivity den gelen Intent bilgisi
		int index=Integer.parseInt(sayfa.getStringExtra("index"));//se�ilen elaman�n indeksi
		
		//4-tak�m bilgisi g�sterme i�lemi
		imageView1.setImageResource(this.getResources().getIdentifier(logo[index] , "drawable" , this.getPackageName()));
		textView2.setText(tak�mad�[index]);
		textView4.setText(�ehir[index]);
		textView6.setText(stad[index]);
		textView8.setText(ba�kan[index]);
		textView10.setText(teknikdirekt�r[index]);
		textView12.setText(kaptan[index]);
		textView14.setText(kapasite[index]);
		
		
		
	}
}
