import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DiceResults {
    public static void main(String[] args) throws IOException {
        Dice.createFile("AllDiceThrows.txt");
        String[] numbersArray= Dice.createArray("AllDiceThrows.txt");
        int[] occurencesArray = Dice.analyseArray(numbersArray);
        PrintWriter outstream = new PrintWriter(new BufferedWriter(new FileWriter("DiceResults.txt")));
        String results = "Antal 1:or = "+occurencesArray[0]+"\nAntal 2:or = "+occurencesArray[1]
        +"\nAntal 3:or = "+occurencesArray[2]+"\nAntal 4:or = "+occurencesArray[3]+
                "\nAntal 5:or = "+occurencesArray[4]+"\nAntal 6:or = "+occurencesArray[5];
        System.out.println(results);
        outstream.print(results);
        outstream.close();
    }//main
}//class
