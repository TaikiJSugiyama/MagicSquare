/*
 * https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn07.pdf
 */
package magicsquare;
import java.io.*;
/**
 *
 * @author tue97382
 */
public class MagicSquare {
    int countL;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MagicSquare().goLuna();
        new MagicSquare().goMercury();
    }
    
    public void goLuna() {
        int[][] nums = TxtHandler.numArray("Luna.txt");
        int numsCount = TxtHandler.count("Luna.txt");
        System.out.println("Luna's case");
        TxtHandler.doCalc(nums, numsCount);
        System.out.println("");
    }
    
    
    public void goMercury(){
        int[][] nums = TxtHandler.numArray("Mercury.txt");
        int numsCount = TxtHandler.count("Mercury.txt");
        System.out.println("Mercury's case");
        TxtHandler.doCalc(nums, numsCount);
        
    }
}
