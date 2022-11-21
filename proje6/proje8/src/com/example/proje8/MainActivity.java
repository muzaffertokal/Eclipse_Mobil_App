package com.example.proje8;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.net.URL;

//html parse etmek için kullanýlýr
//html sayfasýndan veri çekmek için kullanýlýr
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends Activity {
	
	//1-nesne tanýmlama
	ListView listView1;
	TextView cins,alisfiyati,satisfiyati,efektifalis,efektifsatis;
	String [] dövizcinsi;
	String [] alýþfiyatý;
	String [] satýþfiyatý;
	String [] efektifalýþ;
	String [] efektifsatýþ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//2-nesne-widget eþleþtirme
		 
		listView1=(ListView)findViewById(R.id.listView1);  
		cins=(TextView)findViewById(R.id.cins);
		alisfiyati=(TextView)findViewById(R.id.alisfiyati);
		satisfiyati=(TextView)findViewById(R.id.satisfiyati);
		efektifalis=(TextView)findViewById(R.id.efektifalis);
		efektifsatis=(TextView)findViewById(R.id.efektifsatis);
		 
		new DövizGetir().execute();
		
		//listView elaman seçme olayý
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				 
				/*Intent verigönderici=new Intent(getApplicationContext(),detay.class); //çalýþtýlacak sýnýf/activty
				verigönderici.putExtra("index", position+"");//deðiþken tanýmlama
				startActivity(verigönderici); //activty çalýþtýrma
			*/
				cins.setText(bilgi.dövizcinsi[position]);
				alisfiyati.setText(bilgi.alýþfiyatý[position]);
				satisfiyati.setText(bilgi.satýþfiyatý[position]);
				efektifalis.setText(bilgi.efektifalýþ[position]);
				efektifsatis.setText(bilgi.efektifsatýþ[position]);
				
			}
		});
		
	}
	
	public class DövizGetir extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog dialog;
		Element tablo;
		Elements baþlýk,döviz;
		URL url;
		//ÖN ÝÞLEM AÞAMASI-HAZIRLIK AÞAMASI
		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			dialog=new ProgressDialog(MainActivity.this);
			dialog.setTitle("TCMB KUR BÝLGÝLERÝ");
			dialog.setMessage("Kur Bilgileri Yükleniyor..."); //dialog kutusu bilgileri
			dialog.setIndeterminate(false);
			dialog.show();//dialog kutusunu göster
		}
	
		//ARKAPLANDA EÞ ZAMANLI ÇALIÞAN  FONKSÝYON
		//VERÝ ÇEKME-ÝÞLEME YAPAN  FONKSÝYON
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				
				url=new URL("https://www.turkiye.gov.tr/doviz-kurlari");
				Document doc = Jsoup.parse(url, 3000);//web sayafasýnda veri(html kodlarý) çekiliyor
				tablo = doc.select("thead").get(0); //baþlýk olan tabloyu seç
				baþlýk = tablo.select("tr>th");//tr içindeki th larý seç//baþlýklar
				tablo = doc.select("tbody").get(0); //döviz/kur bilgilerinin olduðu tabloyu seç
				döviz   = tablo.select("tr");//döviz/kur bilgilerini al
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		//SON ÝÞLEM AÞAMASI-HAZIRLIK AÞAMASI
		//VERÝ-SONUÇ GÖSTERME YAPAN FONKSÝYON
		@Override
		protected void onPostExecute(Void result) 
		{
			super.onPostExecute(result);
			Elements dovizbilgisi;
			bilgi.dövizcinsi=new String[döviz.size()];
			bilgi.alýþfiyatý=new String[döviz.size()];
			bilgi.satýþfiyatý=new String[döviz.size()];
			bilgi.efektifalýþ=new String[döviz.size()];
			bilgi.efektifsatýþ=new String[döviz.size()];

			for(int i=0;i<döviz.size();i++)
			{
			dovizbilgisi=döviz.get(i).select("td");
			bilgi.dövizcinsi[i]=dovizbilgisi.get(0).text();//döviz baþlýðý
			bilgi.alýþfiyatý[i]=dovizbilgisi.get(1).text();//döviz baþlýðý
			bilgi.satýþfiyatý[i]=dovizbilgisi.get(2).text();//döviz baþlýðý
			bilgi.efektifalýþ[i]=dovizbilgisi.get(3).text();//döviz baþlýðý
			bilgi.efektifsatýþ[i]=dovizbilgisi.get(4).text();//döviz baþlýðý
			}
			
			ListeOlustur adapter=new ListeOlustur(MainActivity.this, bilgi.dövizcinsi); 
			listView1.setAdapter(adapter);
			
			dialog.dismiss();//dialog kutusunu kapat
		}
		
	}
	
	
}
