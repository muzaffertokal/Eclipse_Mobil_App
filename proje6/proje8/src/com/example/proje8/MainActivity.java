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

//html parse etmek i�in kullan�l�r
//html sayfas�ndan veri �ekmek i�in kullan�l�r
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends Activity {
	
	//1-nesne tan�mlama
	ListView listView1;
	TextView cins,alisfiyati,satisfiyati,efektifalis,efektifsatis;
	String [] d�vizcinsi;
	String [] al��fiyat�;
	String [] sat��fiyat�;
	String [] efektifal��;
	String [] efektifsat��;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//2-nesne-widget e�le�tirme
		 
		listView1=(ListView)findViewById(R.id.listView1);  
		cins=(TextView)findViewById(R.id.cins);
		alisfiyati=(TextView)findViewById(R.id.alisfiyati);
		satisfiyati=(TextView)findViewById(R.id.satisfiyati);
		efektifalis=(TextView)findViewById(R.id.efektifalis);
		efektifsatis=(TextView)findViewById(R.id.efektifsatis);
		 
		new D�vizGetir().execute();
		
		//listView elaman se�me olay�
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				 
				/*Intent verig�nderici=new Intent(getApplicationContext(),detay.class); //�al��t�lacak s�n�f/activty
				verig�nderici.putExtra("index", position+"");//de�i�ken tan�mlama
				startActivity(verig�nderici); //activty �al��t�rma
			*/
				cins.setText(bilgi.d�vizcinsi[position]);
				alisfiyati.setText(bilgi.al��fiyat�[position]);
				satisfiyati.setText(bilgi.sat��fiyat�[position]);
				efektifalis.setText(bilgi.efektifal��[position]);
				efektifsatis.setText(bilgi.efektifsat��[position]);
				
			}
		});
		
	}
	
	public class D�vizGetir extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog dialog;
		Element tablo;
		Elements ba�l�k,d�viz;
		URL url;
		//�N ��LEM A�AMASI-HAZIRLIK A�AMASI
		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			dialog=new ProgressDialog(MainActivity.this);
			dialog.setTitle("TCMB KUR B�LG�LER�");
			dialog.setMessage("Kur Bilgileri Y�kleniyor..."); //dialog kutusu bilgileri
			dialog.setIndeterminate(false);
			dialog.show();//dialog kutusunu g�ster
		}
	
		//ARKAPLANDA E� ZAMANLI �ALI�AN  FONKS�YON
		//VER� �EKME-��LEME YAPAN  FONKS�YON
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				
				url=new URL("https://www.turkiye.gov.tr/doviz-kurlari");
				Document doc = Jsoup.parse(url, 3000);//web sayafas�nda veri(html kodlar�) �ekiliyor
				tablo = doc.select("thead").get(0); //ba�l�k olan tabloyu se�
				ba�l�k = tablo.select("tr>th");//tr i�indeki th lar� se�//ba�l�klar
				tablo = doc.select("tbody").get(0); //d�viz/kur bilgilerinin oldu�u tabloyu se�
				d�viz   = tablo.select("tr");//d�viz/kur bilgilerini al
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		//SON ��LEM A�AMASI-HAZIRLIK A�AMASI
		//VER�-SONU� G�STERME YAPAN FONKS�YON
		@Override
		protected void onPostExecute(Void result) 
		{
			super.onPostExecute(result);
			Elements dovizbilgisi;
			bilgi.d�vizcinsi=new String[d�viz.size()];
			bilgi.al��fiyat�=new String[d�viz.size()];
			bilgi.sat��fiyat�=new String[d�viz.size()];
			bilgi.efektifal��=new String[d�viz.size()];
			bilgi.efektifsat��=new String[d�viz.size()];

			for(int i=0;i<d�viz.size();i++)
			{
			dovizbilgisi=d�viz.get(i).select("td");
			bilgi.d�vizcinsi[i]=dovizbilgisi.get(0).text();//d�viz ba�l���
			bilgi.al��fiyat�[i]=dovizbilgisi.get(1).text();//d�viz ba�l���
			bilgi.sat��fiyat�[i]=dovizbilgisi.get(2).text();//d�viz ba�l���
			bilgi.efektifal��[i]=dovizbilgisi.get(3).text();//d�viz ba�l���
			bilgi.efektifsat��[i]=dovizbilgisi.get(4).text();//d�viz ba�l���
			}
			
			ListeOlustur adapter=new ListeOlustur(MainActivity.this, bilgi.d�vizcinsi); 
			listView1.setAdapter(adapter);
			
			dialog.dismiss();//dialog kutusunu kapat
		}
		
	}
	
	
}
