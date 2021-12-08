package com.example.proje5;

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
	String [] ad;
	String [] logo;
	String [] parabirimi;
	String [] baskent;
	String [] bolge;
	String [] baskan;
	String [] nufus;
	String [] dil;
	
	
	
		
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
		ad=getResources().getStringArray(R.array.ad);
		logo=getResources().getStringArray(R.array.logo);
		parabirimi=getResources().getStringArray(R.array.parabirimi);
		baskent=getResources().getStringArray(R.array.baskent);
		bolge=getResources().getStringArray(R.array.bolge);
		baskan=getResources().getStringArray(R.array.baskan);
		nufus=getResources().getStringArray(R.array.nufus);
		dil=getResources().getStringArray(R.array.dil);
		
		
		//3-MainActivity den gelen index bulunuyor
		Intent sayfa=getIntent();//MainActivity den gelen Intent bilgisi
		int index=Integer.parseInt(sayfa.getStringExtra("index"));//seçilen elamanýn indeksi
		
		//4-takým bilgisi gösterme iþlemi
		imageView1.setImageResource(this.getResources().getIdentifier(logo[index] , "drawable" , this.getPackageName()));
		textView2.setText(ad[index]);
		textView4.setText(parabirimi[index]);
		textView6.setText(baskent[index]);
		textView8.setText(bolge[index]);
		textView10.setText(baskan[index]);
		textView12.setText(nufus[index]);
		textView14.setText(dil[index]);
		
		
		
	}
}
