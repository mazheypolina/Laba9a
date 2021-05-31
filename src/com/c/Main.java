package com.c;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("data/input.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data/out.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String line =  bufferedReader.readLine();
            line = line.replace(".", "");
            line = line.replace(",", "");
            bufferedWriter.write(line);
            String regex = "(\\s+)";
            String[] line1 = line.split(regex);
            int count = 0;
            for(int i=0; i < line1.length; i++) {
                line1[i] = line1[i].intern();
            }
            for(int i = 0; i < line1.length; i++) {
                for(int j = 0; j < line1.length; j++){
                    if(line1[i].equals(line1[j])){
                        count++;
                    }
                }
                bufferedWriter.write("Слово " + "'" + line1[i] + "'" + " встречается " + count + " раз!");
                bufferedWriter.newLine();
                count = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Всё подсчитано и выведено!");
    }
}
