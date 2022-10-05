import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAnalyzer {
    public static int characterCounter(String fileName) throws IOException {
        BufferedReader instream = new BufferedReader(new FileReader(fileName));
        String fullFile = "";
        while(true){
            String currentLine = instream.readLine();
            if(currentLine!=null) {
                fullFile += currentLine;
            }//if
            else {
                break;
            }//else
        }//while

        return fullFile.length();

    }//characterCounter
}//class
