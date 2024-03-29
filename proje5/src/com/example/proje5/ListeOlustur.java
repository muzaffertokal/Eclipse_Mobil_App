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
  
	//DE���T�R�LECEK DE���KENLER
	 	private final Activity context;  	//mainactivty
	    private final String[] ad;    //tak�m adlar� i�in
	    private final String[] ulkebayraklari;  	//logolar i�in
	   
	    
	    
	  
	    //KULLANILACAK D�Z�LER
	    public ListeOlustur(Activity context, String[] logolistesi,String[] isimlistesi) {  
	        super(context, R.layout.sablon, isimlistesi);  //�ablon se�imi
	        // TODO Auto-generated constructor stub  
	  
	        //gelen diziler bu dosyadaki dizilere y�kleniyor
	        this.context=context;  
	        this.ulkebayraklari=logolistesi;  
	        this.ad=isimlistesi;   
	  
	  
    }  
  
    //sablon giydirme i�lemi
    public View getView(int position,View view,ViewGroup parent) {  
        LayoutInflater inflater=context.getLayoutInflater();  
        View rowView=inflater.inflate(R.layout.sablon, null,true);  //�ablon y�kleme i�lemi,sat�r olu�turma
  
        //�ablondaki widgetlar ile bu dosyadaki nesneleri e�le�tirme
        TextView takimadi = (TextView) rowView.findViewById(R.id.tv);    //�ablondaki tv
        ImageView takimlogo = (ImageView) rowView.findViewById(R.id.iv); //�ablondaki iv 
        
        //logo tak�mad� �ehir yerle�tirme i�lemi
        //diziden de�erler �ekilerek widget alr �zerinde g�steriliyor
        takimlogo.setImageResource(context.getResources().getIdentifier(ulkebayraklari[position] , "drawable" , context.getPackageName()));
        takimadi.setText(ad[position]); //tak�mad� 
        return rowView;  //olu�an sat�r
        
        
        
  
    };  
}  