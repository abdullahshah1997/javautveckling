import java.io.*;
import java.util.Random;

public class DiceV0 {
    //Skapar en metod createFile som skapar en textfil och lägger in 1000 slumpmässiga siffror från 1 till 6 i den.
    public static void createFile(String fileName) throws IOException {
        Random dice = new Random();
        PrintWriter outstream = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        String diceThrows = "";
        for(int i = 1;i<=1000;i++) {
            diceThrows += (dice.nextInt(6)+1)+" ";
        }//for
        diceThrows = diceThrows.trim();
        outstream.print(diceThrows);
        outstream.close();
    }//createFile

    public static String[] createArray(String fileName) throws IOException {
        BufferedReader instream = new BufferedReader((new FileReader(fileName)));
        String fullFile = instream.readLine();
        fullFile = fullFile.replace(" ","");
        String[] numbersArray = new String[1000];
        for(int i =0;i<1000;i++) {
            numbersArray[i] = Character.toString(fullFile.charAt(i));

        }//for-loop

        return numbersArray;

    }//createArray

    public static int [] analyseArray(String[] numbersArray){
        int [] occurencesArray = new int[6];
        for(int i = 0;i<1000;i++) {
            if (numbersArray[i].equals("1")) {
                occurencesArray[0]++;
            }//if
            else if(numbersArray[i].equals("2")){

                    occurencesArray[1]++;

            }//else if

            else if(numbersArray[i].equals("3")){

                    occurencesArray[2]++;

            }//else if

            else if(numbersArray[i].equals("4")){

                    occurencesArray[3]++;

            }//else if

            else if(numbersArray[i].equals("5")){

                    occurencesArray[4]++;

            }//else if

            else {

                    occurencesArray[5]++;

            }//else

        }//for-loop

        return occurencesArray;

    }//analyseArray
}//Dice
