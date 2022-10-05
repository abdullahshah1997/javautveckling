import java.util.Random;

public class DiceModou {
    public int[] diceArray;
    public static void createFile(){
        Random varde = new Random();
        int[] numList = new int[1000] ;
        for( int i = 0; i<1000;i++) {
            numList[i] = varde.nextInt(6)+1;
            System.out.println(numList[i]); }
// här skapar jag en ny lista som har 6 platser.
    }

    public static int[] analyseArray(int[] currentList) {
        int[] analysedArray = new int[6];
        for (int i=0; i <currentList.length; i++) {

            switch(currentList[i]) {
                case 1:
                    analysedArray[0]++;
                    break;
                case 2:
                    analysedArray[1]++;

                    break;
                case 3:
                    analysedArray[2]++;
                    break;
                case 4:
                    analysedArray[3]++;

                    break;

                case 5:
                    analysedArray[4]++;
                    break;
                case 6:
                    analysedArray[5]++;

                    break;

                default:

            }



        }


        return analysedArray;
    }
}