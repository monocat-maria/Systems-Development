package bmiapp;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class BmiApp {
    
    public static void main(String[] args) {
        Double weight;
        String name;
        Double height;
        Double imc;
        String message;
                
        JOptionPane.showMessageDialog(null, "Hello,\nLet's make the best diet for you.");
        
        name = JOptionPane.showInputDialog("Enter your name:");
        weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight in Kilograms(Kg):"));
        height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height in centimeters (cm):"));
        
        imc = weight / (height/100 * height/100);
        NumberFormat imcF = new DecimalFormat(".#");
        
        if(imc < 18.5){
            message = name + ", you are very skinny.\nYou need to gain some weight.\nIMC = " + imcF.format(imc);
        }else if(imc < 24.9){
            message = name + ", you are at your ideal weight.\nDon't need to lose weight.\nIMC = " + imcF.format(imc);
        }else if(imc < 29.9){
            message = name + ", you are overweight.\nYou need a diet to lose weight.\nIMC = " + imcF.format(imc);
        }else if(imc <30){
            message = name + ", you have obesity.\nYou need a diet, exercises and a life change.\nIMC = " + imcF.format(imc);
        }else{
            message = name + ", you have morbid obesity.\nYou need to see a doctor.\nIMC = " + imcF.format(imc);
        }
        
        JOptionPane.showMessageDialog(null,message);
    }
}
