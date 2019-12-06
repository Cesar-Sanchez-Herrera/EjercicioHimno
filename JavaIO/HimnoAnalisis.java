package JavaIO;
import java.io.File;
import java.io.IOException;
public interface HimnoAnalisis {
	
	public Integer countCharacter(File file)throws IOException;
	public Integer countWords(File file)throws IOException;
	public Integer countLines(File file)throws IOException;
	public Integer countParagraph(File file)throws IOException;
	public Integer countWordMexican(File file)throws IOException;
}
