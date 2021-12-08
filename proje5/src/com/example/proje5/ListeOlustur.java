package com.example.proje5;

import android.app.Activity;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;  
/**
 * @author user
 *
 */
public class ListeOlustur extends  ArrayAdapter<String> {  
  
	//DEÐÝÞTÝRÝLECEK DEÐÝÞKENLER
	 	private final Activity context;  	//mainactivty
	    private final String[] ad;    //takým adlarý için
	    private final String[] ulkebayraklari;  	//logolar için
	   
	    
	    
	  
	    //KULLANILACAK DÝZÝLER
	    public ListeOlustur(Activity context, String[] logolistesi,String[] isimlistesi) {  
	        super(context, R.layout.sablon, isimlistesi);  //þablon seçimi
	        // TODO Auto-generated constructor stub  
	  
	        //gelen diziler bu dosyadaki dizilere yükleniyor
	        this.context=context;  
	        this.ulkebayraklari=logolistesi;  
	        this.ad=isimlistesi;   
	  
	  
    }  
  
    //sablon giydirme iþlemi
    public View getView(int position,View view,ViewGroup parent) {  
        LayoutInflater inflater=context.getLayoutInflater();  
        View rowView=inflater.inflate(R.layout.sablon, null,true);  //þablon yükleme iþlemi,satýr oluþturma
  
        //þablondaki widgetlar ile bu dosyadaki nesneleri eþleþtirme
        TextView takimadi = (TextView) rowView.findViewById(R.id.tv);    //þablondaki tv
        ImageView takimlogo = (ImageView) rowView.findViewById(R.id.iv); //þablondaki iv 
        
        //logo takýmadý þehir yerleþtirme iþlemi
        //diziden deðerler çekilerek widget alr üzerinde gösteriliyor
        takimlogo.setImageResource(context.getResources().getIdentifier(ulkebayraklari[position] , "drawable" , context.getPackageName()));
        takimadi.setText(ad[position]); //takýmadý 
        return rowView;  //oluþan satýr
        
        
        
  
    };  
}  