import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "source.txt";

        // This will reference one line at a time
        String line = null;
        
        Scanner scan = new Scanner(System.in);

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            } 
            
            String s1 = scan.nextLine();
            
            //Write to an output text file
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter("output.bin"));
            
            //System.out.println("\nEnter Input: " + s1 + "\n");
            do
            {
                System.out.println("\nEnter Input: " + s1 + "\n");
                
                Scanner input = new Scanner(s1);
                int word = 0;
                while (input.hasNext())
                {
                    input.next();
                    word++;
                    bufferedWriter.write("Line #"+ word +": " + s1);
                    //input.next();
                    bufferedWriter.newLine();
                    
                    System.out.print("\nEnter 'q' to quit, enter string to continue:  \t");
                    s1 = scan.nextLine();
                }
                
                //System.out.print("\nEnter 'q' to quit, enter string to continue:  \t");
                //s1 = scan.nextLine();
                
            } while(!s1.equals("q"));
            
            // Close Writer
                scan.close();
            
            // Close Writer
                bufferedWriter.close();
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}
