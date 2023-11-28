package MemoryGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random;
import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        
        String[] wordDict = new String[50];

        try {
            BufferedReader file = new BufferedReader(new FileReader("./MemoryGame/words.txt"));
            for (int i = 0; i < 50; i++) wordDict[i] = file.readLine();
            file.close();
        }
        catch (IOException error) { System.out.println(error); }

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int size = 0;

        System.out.print("Enter the number of words: ");
        size = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        String[] wordSeq = new String[size];

        // Generate random words
        int randomWordMaxLength = 13;
        for (int i = 0 ; i < size; i++) {
            String randomWord = wordDict[rand.nextInt(wordDict.length)];
            System.out.printf("Word %d: %s\n", (i + 1), randomWord);
            wordSeq[i] = randomWord;
            randomWordMaxLength = Math.max(randomWordMaxLength, randomWord.length());
        }

        // // Delay
        // new CountdownTimer(5).start();
        
        // Test memory
        int userRecallMaxLength = 11;
        System.out.println("Enter the words in sequence now:");
        String[] userRecall = new String[size];
        for (int i = 0; i < size; i++) {
            userRecall[i] = sc.nextLine();
            userRecallMaxLength = Math.max(userRecallMaxLength, userRecall[i].length());
        }

        // Display result
        int score = 0;
        System.out.println("\nResult:");
        System.out.printf("%-" + randomWordMaxLength + "s | ", "Original Word");
        System.out.printf("%-" + userRecallMaxLength + "s | ", "Your Recall");
        System.out.printf("%-10s\n", "Validation");
        System.out.println("-".repeat(randomWordMaxLength + userRecallMaxLength + 16));
        for (int i = 0; i < size; i++) {
            String validation = "Not Match";
            System.out.printf("%-" + randomWordMaxLength + "s | ", wordSeq[i]);
            System.out.printf("%-" + userRecallMaxLength + "s | ", userRecall[i]);
            if (wordSeq[i].equalsIgnoreCase(userRecall[i])) {
                score++;
                validation = "Match";
            }
            System.out.printf("%-10s\n", validation);
        }
        System.out.printf("Your Final Score is: %d/%d\n", score, size);
        sc.close();
    }
}