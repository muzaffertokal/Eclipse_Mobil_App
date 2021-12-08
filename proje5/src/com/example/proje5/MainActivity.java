package com.example.proje5;

import com.example.proje5.ListeOlustur;
import com.example.proje5.R;
import com.example.proje5.detay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	//1-nesne tanýmlama
			ListView listView1;
			
			//2-dizi tanýmlama	
			String[]logolistesi,isimlistesi;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		//3-bilgi.xml içerisindeki dizilerden deðer çekilerek dizi olusturuluyor
		logolistesi=getResources().getStringArray(R.array.logo);
		isimlistesi=getResources().getStringArray(R.array.ad);
	
		
		
		//4-listview1 doldurma iþlemi
		ListeOlustur adapter=new ListeOlustur(this, logolistesi, isimlistesi );
		listView1=(ListView)findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
		
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				
				//Intent actvityler arasý  veri aktarmak için kullanýlýr
				
				Intent sayfa=new Intent(getApplicationContext(),detay.class);//bu activityden detay activity sine geçiþ yapýlacak
				sayfa.putExtra("index", position+"");
				startActivity(sayfa);
			    
				
				
				
			}
		});
	}
}
