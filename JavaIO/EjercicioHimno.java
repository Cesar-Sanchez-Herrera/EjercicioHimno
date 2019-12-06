package JavaIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioHimno implements HimnoAnalisis{
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\curso\\Documents\\JavaIO\\himno.txt");
		EjercicioHimno cj = new EjercicioHimno();
		
		
		Integer numberCh = cj.countCharacter(file);
		System.out.println("1.- Número de caracteres: " + numberCh);
		
		Integer numberW = cj.countWords(file);
		System.out.println("2.- Número de palabras: " + numberW);
		
		Integer numberL = cj.countLines(file);
		System.out.println("3.- Número de lineas: " + numberL);
		
		Integer numberP = cj.countParagraph(file);
		System.out.println("4.- Número de parrafos: " + numberP);
		
		Integer numberWM = cj.countParagraph(file);
		System.out.println("5.- Número de palabras que dicen mexicanos: " + numberWM);
	}

	@Override
	public Integer countCharacter(File file) throws IOException{
		int charactercount = 0;
		file.getName();
		System.out.println(file.getName());
		
		try {
			FileInputStream filestream = new FileInputStream(file);
			InputStreamReader inputstreamreader = new InputStreamReader(filestream);
			BufferedReader reader = new BufferedReader(inputstreamreader);
			
			String line = null;
			
			
			while((line = reader.readLine()) != null) {
				charactercount += line.length();
			}
			
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		
		return charactercount;
	}

	@Override
	public Integer countWords(File file) throws IOException {
		int wordcount = 0;
		
		try {
			FileInputStream filestream = new FileInputStream(file);
			InputStreamReader inputstreamreader = new InputStreamReader(filestream);
			BufferedReader reader = new BufferedReader(inputstreamreader);
			
			String line = null;
			int i;  
			
			while((line = reader.readLine()) != null) {
			
                for(i=0; i < line.length(); i++)
                {
                    if(i==0)
                    {
                        if(line.charAt(i)!=' ')
                        	wordcount++;
                    }
                    else
                    {
                        if(line.charAt(i-1)==' ')
                            if(line.charAt(i)!=' ')
                            	wordcount++;
                    }
                }
			}
			
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		
		return wordcount;
	}

	@Override
	public Integer countLines(File file) throws IOException {
		int linecount = 0;
		
		try {
			FileInputStream filestream = new FileInputStream(file);
			InputStreamReader inputstreamreader = new InputStreamReader(filestream);
			BufferedReader reader = new BufferedReader(inputstreamreader);
			
			String line = null;
			
			while ((line = reader.readLine())!=null) {
				linecount++;
				}       
			
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		
		return linecount;
	}

	@Override
	public Integer countParagraph(File file)throws IOException {
		int paracount = 0;
		
		try {
			FileInputStream filestream = new FileInputStream(file);
			InputStreamReader inputstreamreader = new InputStreamReader(filestream);
			BufferedReader reader = new BufferedReader(inputstreamreader);
			
			String line = null;
			
			while ((line= reader.readLine())!=null) {

                if(line.equalsIgnoreCase("I") || line.equalsIgnoreCase("II") || line.equalsIgnoreCase("III") || line.equalsIgnoreCase("IV")){
                    paracount++;
                }
			}
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		
		return paracount+1;
	}

	@Override
	public Integer countWordMexican(File file)throws IOException {
		int mexicanoscount = 0;
		
		try {
			FileInputStream filestream = new FileInputStream(file);
			InputStreamReader inputstreamreader = new InputStreamReader(filestream);
			BufferedReader reader = new BufferedReader(inputstreamreader);
			
			String line = null;
			
			while ((line= reader.readLine())!=null) {

                if(line.equalsIgnoreCase("mexicanos") || line.equalsIgnoreCase("Mexicanos")){
                	mexicanoscount++;
                }
			}
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}
		
		return mexicanoscount;
	}

}
