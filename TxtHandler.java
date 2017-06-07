/*
 * https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn07.pdf
 */
package magicsquare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tue97382
 */
public class TxtHandler {
    
    
    public static int count(String name){
        int count = 0;

        try{
            int i = 0;
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null){
                String[] myLine = line.split("\t");
                count = myLine.length;
            }
            
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return count;
    }
    
    public static int[][] numArray(String name){
        int[][] nums = new int[TxtHandler.count(name)][TxtHandler.count(name)];
        
        try{
            int i = 0;
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            
            while((line = br.readLine()) != null){
                String[] myLine = line.split("\t");
                
                for (int j = 0; j < myLine.length; j++){
                    int num = Integer.valueOf(myLine[j]);
                    nums[i][j] = num;
                }
                i++;
            }
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        
        return nums;
    }
    
    public static void doCalc(int[][] nums, int count){
        //for row cum
        for(int row = 0; row < count; row++){
            int rowNo = row + 1;
            System.out.println("For the " + rowNo + " row, the sum is");
            
            int rowSum = 0;
            for(int clm = 0; clm < count; clm++){
                rowSum = nums[row][clm] + rowSum;
            }
            
            System.out.println(rowSum);
            System.out.println("");
        }
        
        //for column sum
        for(int clm = 0; clm < count; clm++){
            int clmNo = clm + 1;
            System.out.println("For the " + clmNo + " column, the sum is");
            
            int clmSum = 0;
            for(int row = 0; row < count; row++){
                clmSum = nums[row][clm] + clmSum;
            }
            
            System.out.println(clmSum);
            System.out.println("");
        }
        
        //for diagonal sum
        int dgnlSum = 0;
        for (int dgnl = 0; dgnl < count; dgnl++){
            dgnlSum = nums[dgnl][dgnl] + dgnlSum;
        }
        System.out.println("For the diagonal from left top to right bottom, the sum is ");
        System.out.println(dgnlSum);
        System.out.println("");
        
        //reverse diagonal sum
        int rvsDgnlSum = 0;
        int iter = 0;
        for (int dgnl = count - 1; dgnl >= 0; dgnl--){
            rvsDgnlSum = nums[iter][dgnl] + rvsDgnlSum;
            iter++;
        }
        System.out.println("For the diagonal from right top to left bottom, the sum is ");
        System.out.println(rvsDgnlSum);
        System.out.println("");
    }
}
