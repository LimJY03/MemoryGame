# Mad Libs

This lab hands-on manual guides you to build a simple Mad Libs game using basic Java programming only.

> **Mad Libs** is a phrasal template word game created by Leonard Stern and Roger Price. It consists of one player prompting others for a list of words to substitute for blanks in a story before reading aloud
>
> *Source: [Wikipedia](https://en.wikipedia.org/wiki/Mad_Libs)*

This guide will not cover the basics of Java programming like what Java is, the IDEs to use and the general syntax. It will just show the steps to build the game in Java.

If you are ready with your IDE, you may start from Step 01.

## Step 01: Compiler Testing

Create a Java project and create a `Main.java` file. Then, test if the Java compiler is running properly by printing out a "Hello World" in the console using the following code:

```java
class Main {

    public static void main(String[] args) {

        // Test Print
        System.out.println("Hello World");
    }
}
```

When the "Hello World" is printed out in the console successfully, we can remove both testing lines and start building our game in the next step.

## Step 02: Building The Game Backbone

The Mad Libs example we are going to use is from [this link](https://kids.nationalgeographic.com/games/funny-fill-in/article/funny-fill-in-spaced-out). We will first create a variable `story` to store the story text.

```java
final String story = "Welcome to the year 30**%s**. It was my first day as Intergalactic Space Sheriff, so I decided to patrol planet **%s**. I jumped into my space **%s**, turned on the antigravity **%s**, and traveled at **%s** speed toward the planet. When I stepped onto the **%s** surface, I came face-to-face with an alien. He was the size of a(n) **%s** and looked like a giant lump of **%s**. “**%s**,” I said to him, the galactic word for “hello.” But the alien didn’t respond. Instead he pulled out his laser **%s**, **%s** my vehicle, then tried to **%s** me. Quickly I activated my defense **%s**. The laser beam **%s** off it and hit the alien on the **%s**. “**%s**!” yelled the alien as he turned into a big puddle of **%s**. Exhausted, I teleported back to the space station near **%s**. This job is going to be tougher than I thought.";
```

I used the `final` keyword (indicating `story` is a constant) here since the story will not be modified. It is not mandatory to set every immutable variable to be a `final` variable but it is a good practice to avoid unnecessary and accidental changes to the constants.

Then, we can start to declare a bunch of variables related to the questions as shown in the [example link above](https://kids.nationalgeographic.com/games/funny-fill-in/article/funny-fill-in-spaced-out), and initialize them with a sample value. An example of the code is shown as below:

```java
String numberBetween10and99 = "12";
String noun1 = "ByteBuddies";
String transportation = "bicycle";
String noun2 = "helmet";
String adjective1 = "extremely slow";
String adjective2 = "small";
String noun3 = "stadium";
String typeOfFoodPlural = "apples";
String sillyWord = "Brouhaha";
String noun4 = "eraser";
String pastTenseVerb1 = "ate";
String verb = "congratulate";
String noun5 = "pizza";
String pastTenseVerb2 = "fried";
String bodyPart = "face";
String exclamation = "cool";
String somethingIcky = "dirty";
String planet = "Saturn";
```

Now that we have the values that we need, we can insert them into our story and look at the final story in the next step.

## Step 03: Inserting Variable Values into String

The `story` variable contains the `%s` format specifier which we can replace it with the variables that we have created in the previous step using the `printf()` method.

```java
System.out.prinf(story, numberBetween10and99, noun1, transportation, noun2, adjective1, adjective2, noun3, typeOfFoodPlural, sillyWord, noun4, pastTenseVerb1, verb, noun5, pastTenseVerb2, bodyPart, exclamation, somethingIcky, planet);
```

> **NOTE**
> <br>If your variable names are not exactly the same as in this guide, please modify the code above to suit your variable names.

You now can display your story in the console.

*Add-On: You can also change the values of the variables, then look at how your story looks like!*

## Step 04: Getting User Input

To get user input in Java, we will need to import the `Scanner` library from `java.util`. We can just add in the code below before the class declaration.

```java
import java.util.Scanner;
```

**[DO NOT COPY]** Your code should look like this now:

```java
package MadLibs;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        ...
```

Then, we will need to create a Scanner object `sc` with the argument `System.in`. Add the following code to the first line of the `main()` method.

```java
Scanner sc = new Scanner(System.in);
```

Now, we can prompt user input for each variable by modifying the code in Step 02. Starting from the first variable `numberBetween10and99`, we can prompt the user input with the code below:

```java
System.out.print("Enter a number between 10 and 99: ");
String numberBetween10and99 = sc.nextLine();
```

What we have done is we added in `System.out.print()` statement to prompt the user what to input, then we modify the initialized value of the variable `numberBetween10and99` by letting it get the user input using `sc.nextLine()`. Next, you will need to do the same thing for every other variables. The final code should look similar to below:

```java
System.out.print("Enter a number between 10 and 99: ");
String numberBetween10and99 = sc.nextLine();

System.out.print("Enter a noun: ");
String noun1 = sc.nextLine();

System.out.print("Enter a type of transportation: ");
String transportation = sc.nextLine();

System.out.print("Enter a noun: ");
String noun2 = sc.nextLine();

System.out.print("Enter an adjective: ");
String adjective1 = sc.nextLine();

System.out.print("Enter an adjective: ");
String adjective2 = sc.nextLine();

System.out.print("Enter a noun: ");
String noun3 = sc.nextLine();

System.out.print("Enter a type of food (plural): ");
String typeOfFoodPlural = sc.nextLine();

System.out.print("Enter a silly word: ");
String sillyWord = sc.nextLine();

System.out.print("Enter a noun: ");
String noun4 = sc.nextLine();

System.out.print("Enter a past tense verb: ");
String pastTenseVerb1 = sc.nextLine();

System.out.print("Enter a verb: ");
String verb = sc.nextLine();

System.out.print("Enter a noun: ");
String noun5 = sc.nextLine();

System.out.print("Enter a past tense verb: ");
String pastTenseVerb2 = sc.nextLine();

System.out.print("Enter a body part: ");
String bodyPart = sc.nextLine();

System.out.print("Enter an exclamation: ");
String exclamation = sc.nextLine();

System.out.print("Enter something icky: ");
String somethingIcky = sc.nextLine();

System.out.print("Enter a planet: ");
String planet = sc.nextLine();
```

After getting all inputs, we will need to close our `sc` object by adding the line after the final user input line (`String planet = sc.nextLine();`).

```java
sc.close();
```

Now if we execute the code again, we should be able to get the user input and display it in the final story.

## Step 05: Using Arrays

Since our code above is so long and repetitive, we can simplify it using an array. 

By investigating the code, we realized that the code in Step 04 varies by the following 2 points:

* Prompt in `System.out.print();`
* Variable name for user input

Hence, we can create 2 arrays to simplify the code:

* 1 for the prompt
* 1 to store user input

Removing the prompt-and-input code segment in Step 04, we can now do the following which works similar to the removed code:

```java
// Array for prompt
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

// Array for user input
String[] userInput = new String[questions.length];
```

To get user input iteratively, we can use a `for` loop.

```java
for (int i = 0; i < questions.length; i++) {
    System.out.print(questions[i]);
    userInput[i] = sc.nextLine();
}
```

From this code, we can see that we effectively generalized the prompt in `System.out.print()` method with `questions[i]` (which is each question in the `questions` array) and the variable with `userInput[i]` which stores all user inputs in the `userInput` array.

Then, we can also remove all variables after the `story` variable in the `System.out.printf()` statement that displays the final story and insert the `userInput` array instead. The final statement should look similar to teh code below:

```java
System.out.printf(story, (Object[]) userInput);
```

We used the `(Object[])` type casting to convert the elements in the `userInput` array into objects to fit the data type.

We should be able to still see the final result like that in Step 04, but our code is much shorter now.

## Step 06: Writing Into File

Instead of just displaying the output in the terminal, we can also write it into a file. We can do that by importing the necessary libraries first.

```java
import java.io.*;
```

Then, we can write into a [markdown file](https://www.markdownguide.org/) for better viewing by using the code below:

```java
// Output to markdown file
try {
    PrintWriter file = new PrintWriter(new FileWriter("output.md"));
    file.printf(story, (Object[]) userInput);
    file.close();
}
catch (IOException e) { 
    System.out.println(e); 
}
```

That's it, we have successfully written the output into the markdown file.

---

## Copyright

This guide is created and owned by [**LimJY03**](https://github.com/LimJY03) licensed under the [Apache License 2.0](https://github.com/LimJY03/SimpleGamesJava/blob/main/LICENSE).
