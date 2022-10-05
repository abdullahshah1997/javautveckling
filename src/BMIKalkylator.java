import javax.swing.JOptionPane;
public class BMIKalkylator {
    public static void main(String[] args)
    {
        //Frågar användaren om vikt.
        String weightString = JOptionPane.showInputDialog(null,"Ange din vikt (kg)","BMI-" +
                "kalkylator",JOptionPane.QUESTION_MESSAGE);

        //Gör om vikten till en double.
        double weight = Double.parseDouble(weightString);

        //Frågar användaren om längd.
        String heightString = JOptionPane.showInputDialog(null,"Ange din längd (cm)","BMI-" +
                "kalkylator",JOptionPane.QUESTION_MESSAGE);

        //Gör om längden till en double och omvandlar till meter.
        double height = Double.parseDouble(heightString)/100;

        //Skapar ett "villkorsträd" som placerar användarens BMI i rätt viktklass.
        Double BMI = weight/Math.pow(height,2);
        String weightclass;
        if(BMI<18.5)
            weightclass = "Undervikt";
        else if (BMI>=18.5&&BMI<=25.0)
            weightclass = "Normalvikt";
        else if (BMI>25.0&&BMI<=30.0)
            weightclass = "Övervikt";
        else if (BMI>30.0&&BMI<=35.0)
            weightclass = "Fetma klass 1";
        else if (BMI>35.0&&BMI<=40.0)
            weightclass = "Fetma klass 2";
        else
            weightclass = "Fetma klass 3";

        //Avrundar BMI-värdet med två värdessiffror med ett trick och placerar det i en ny variabel.
        double BMIDecimal = Math.round(BMI*100.0)/100.0;

        //Visar användaren dennes värden samt viktklass.
        JOptionPane.showMessageDialog(null,"Vikt: "+weightString+"\nLängd: "+heightString+
                "\nBMI: "+BMIDecimal+"\nViktklass: "+weightclass,"BMI-kalkylator",JOptionPane.INFORMATION_MESSAGE);

    }//main
}//class
