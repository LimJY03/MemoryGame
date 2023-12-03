package MadLibs;

import java.util.Scanner;
import java.io.*;

class Game {

    public static void main(String[] args) {
        
        final String story = "Welcome to the year 30**%s**. It was my first day as Intergalactic Space Sheriff, so I decided to patrol planet **%s**. I jumped into my space **%s**, turned on the antigravity **%s**, and traveled at **%s** speed toward the planet. When I stepped onto the **%s** surface, I came face-to-face with an alien. He was the size of a(n) **%s** and looked like a giant lump of **%s**. “**%s**,” I said to him, the galactic word for “hello.” But the alien didn’t respond. Instead he pulled out his laser **%s**, **%s** my vehicle, then tried to **%s** me. Quickly I activated my defense **%s**. The laser beam **%s** off it and hit the alien on the **%s**. “**%s**!” yelled the alien as he turned into a big puddle of **%s**. Exhausted, I teleported back to the space station near **%s**. This job is going to be tougher than I thought.";
        
        String[] questions = {
            "number between 10 and 99",
            "noun",
            "type of transportation",
            "noun",
            "adjective",
            "adjective",
            "noun",
            "type of food, plural",
            "silly word",
            "noun",
            "past-tense verb",
            "verb",
            "noun",
            "past-tense verb",
            "body part",
            "exclamation",
            "something icky",
            "name of a planet in our solar system"
        };
        
        String[] userInput = new String[questions.length];
        
        // Get user input
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < questions.length; i++) {
            System.out.print("Enter a(n) " + questions[i] + ": ");
            userInput[i] = sc.nextLine();
        }

        // Output to markdown file
        try {
            PrintWriter file = new PrintWriter(new FileWriter("./MadLibs/output.md"));
            file.printf(story, (Object[]) userInput);
            file.close();
        }
        catch (IOException e) { System.out.println(e); }

        sc.close();
    }
}
