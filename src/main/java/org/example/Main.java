package org.example;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the I/O Assignment!");
        // Initialize array to store integers
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        /*
        Read integers from two text files called "input1.txt"
        and "input2.txt". Each integer is on a new line in
        the respective files.
         */
        // Buffered reading of characters from a file, throws exception if error
        try(FileReader fr = new FileReader("src/input1.txt"); FileReader fr2 = new FileReader("src/input2.txt")){
            try (BufferedReader br = new BufferedReader(fr); BufferedReader br2 = new BufferedReader(fr2)) {
                String line1;
                String line2;
                while ((line1 = br.readLine()) != null) {
                    // Try to add number to array otherwise throw error
                    try{numbers1.add(Integer.parseInt(line1));}
                    catch(NumberFormatException e){
                        System.out.println("NumberFormatException: " + e);
                    }
                }
                while ((line2 = br2.readLine()) != null) {
                    try{numbers2.add(Integer.parseInt(line2));}
                    catch(NumberFormatException e){
                        System.out.println("NumberFormatException: " + e);
                    }
                }
            /*
            Merge the contents of the two input files,
            maintaining the original order of the integers,
            and write the result to a new text file called "merged.txt".
             */
                // Write contents of both arrays to new file
                try (FileWriter fw = new FileWriter("src/merged.txt")) {
                    for (Integer s : numbers1) {
                        fw.write(s + "\n");
                    }
                    for (Integer s : numbers2) {
                        fw.write(s + "\n");
                    }
                }
                // Check if there are any duplicate numbers
                FileWriter fw2 = new FileWriter("src/common.txt");
                for (Integer num : numbers1) {
                    if(numbers2.contains(num)) {
                        fw2.write(num + "\n");
                    }
                }
                fw2.close();

            } catch (IOException e) {
                System.out.println("IOException: "+ e);
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException: "+ e);
        }





    }
}