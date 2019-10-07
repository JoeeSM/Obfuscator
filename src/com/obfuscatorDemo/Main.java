package com.obfuscatorDemo;

import com.sun.jdi.Value;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        String inputFilepath = "input.txt";
        String mapFilepath = "hashMap.txt";
        String outputFilepath = "obfuscatedFile.txt";
        obfuscator(inputFilepath, mapFilepath, outputFilepath);
    }


    private static void obfuscator(String inputFilepath, String mapFilepath, String outputFilepath) throws IOException{
            HashMap<Integer, String> wordMap = new HashMap<Integer, String>();

            BufferedReader inputBR = new BufferedReader(new FileReader(inputFilepath));
            FileWriter fw = new FileWriter(outputFilepath);
            FileWriter fw2 = new FileWriter(mapFilepath);
            String input;
            while((input = inputBR.readLine()) != null){
                int id = 0;
                String[] words = input.split("[,.\\s]+");
                for (String word : words) {
                    if (!wordMap.containsValue(word)){
                        id++;
                        wordMap.put(id, word);
                    }
                    for (Map.Entry<Integer, String> map :  wordMap.entrySet()) {
                        if (map.getValue().equals(word)){
                            id = map.getKey();
                            fw.write(id + " ");
                        }
                    }
                }
            }

            System.out.println(wordMap);
            fw2.write(wordMap.toString());
            fw.close();
            fw2.close();
    }

    private static void deobfuscator(String filepath){

    }
}
