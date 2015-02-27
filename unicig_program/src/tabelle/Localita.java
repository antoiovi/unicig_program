package tabelle;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class Localita {
List<Citta> citta;
String localita[];
private static Localita instance=null;
	private Localita(){
		try{
			citta=new ArrayList<Citta>();
			String filename="TemperatureEsterneMinime.csv";
		    // Apre il file "nomefile" presente nel package
	        InputStream is=getClass().getResourceAsStream(filename);// per legger i dati
	        InputStream is2=getClass().getResourceAsStream(filename);// per contare le righe
	       // Crea un buffered reader per il file, in modo da leggere linee di testo una 
	        // alla volta
	  BufferedReader br = new BufferedReader(new InputStreamReader(is));
	  BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
	  // r=numero di righe
	  // conto le righe
	  int r=0; 
	      while((br2.readLine())!= null){
		    	r++;
	  }
	  //localita= new double[r][8];
	  String strLine;
	  int x=0; 
	    while((strLine = br.readLine())!= null)
	        {
	          // Creo uno scanner per scannerizzare la stringa
	            Scanner scanner = new Scanner(strLine);
	            //without this line the program wouldn't work on machines with different locales
	            scanner.useLocale(Locale.US); 
	            scanner.useDelimiter(";\\s*");
	            int y=0;
	            Citta c=new Citta();
	            c.nome=scanner.next();
	            c.temp=scanner.nextDouble();
	            citta.add(c);
	            /*while (scanner.hasNextDouble()) {
	                localita[x][y]=scanner.nextDouble();
	                y++;
	            }*/
	            x++;
	        } 
	    } catch (IOException ex) {
	        Logger.getLogger(Localita.class.getName()).log(Level.SEVERE, null, ex);
	    }catch(java.lang.NullPointerException e){
	        Logger.getLogger(Localita.class.getName()).log(Level.SEVERE, null, e);
	    }
	}
	
	public static Localita getInstance(){
		if(instance==null)
			instance=new Localita();
		return instance;
	}
	
public String[] getlocalita(){
	localita=new String[citta.size()];
	int x=0;
	for(Citta temp: citta){
		localita[x]=temp.nome;
		x++;
	}
	return localita;
}
public double getTemperatura(String citta_){
	double t=0;
	for(Citta temp: citta){
		if(temp.nome.equals(citta_))
			t=temp.temp;
	}
	return t;
}

private class Citta{
String nome;
double temp;
}

}
