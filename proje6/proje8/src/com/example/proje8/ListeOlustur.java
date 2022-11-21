package com.example.proje8;

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
  
	 	private final Activity context;  	//mainactivty
	    private final String[] dövizcinsi;    //takým adlarý için
	  
	    public ListeOlustur(Activity context, String[] dövizcinsi) {  
	        super(context, R.layout.sablon, dövizcinsi);  //þablon seçimi
	        // TODO Auto-generated constructor stub  
	  
	        //nesne eþleþtirme
	        this.context=context;  
	        this.dövizcinsi=dövizcinsi;   
	     
	  
    }  
  
    //sablon giydirme iþlemi
    public View getView(int position,View view,ViewGroup parent) {  
        LayoutInflater inflater=context.getLayoutInflater();  
        View rowView=inflater.inflate(R.layout.sablon, null,true);  //satýr oluþturma
  
        //þablon listview item eþleþtirme
        TextView dövizadý = (TextView) rowView.findViewById(R.id.tv);    //þablondaki dovizcinsi
        
        //dövizcinsi yerleþtirme iþlemi
        dövizadý.setText(dövizcinsi[position]);  
        
        return rowView;  //oluþan satýr
  
    };  
}  