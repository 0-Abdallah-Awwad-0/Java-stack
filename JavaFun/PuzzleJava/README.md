# Puzzle Java

## Assignment

This assignment practices Java problem solving using the `Random` class.

The project generates random numbers, random letters, random passwords, and a set of random passwords.

## Concepts Practiced

* Java methods
* Returning values from methods
* Arrays
* `ArrayList`
* `Random`
* Loops
* String concatenation
* Creating objects from another class
* Testing code using a separate test file

## Files

PuzzleJava
└── src
├── PuzzleJava.java
└── TestPuzzleJava.java

## PuzzleJava.java

This file contains the main logic for the assignment.

It includes the following methods:

### getTenRolls()

Generates 10 random numbers from 1 to 20 and returns them inside an `ArrayList<Integer>`.

Example output:

[4, 18, 2, 20, 7, 11, 3, 15, 6, 9]

---

### getRandomLetter()

Creates an array containing all 26 letters of the alphabet.

Then it chooses one random letter and returns it.

Example output:

m

---

### generatePassword()

Generates a random password with 8 letters.

It uses the `getRandomLetter()` method 8 times.

Example output:

xqazplmn

---

### getNewPasswordSet(int length)

Generates an array of random passwords.

The number of passwords depends on the `length` parameter.

Example:

If we call:

getNewPasswordSet(5)

The method returns 5 random passwords.

Example output:

[abcdefgz, qwertyui, mnoplkjh, zxcvbnma, poiuytre]

## TestPuzzleJava.java

This file contains the `main` method.

It creates an object from the `PuzzleJava` class and tests all the methods.

Example:

PuzzleJava generator = new PuzzleJava();

ArrayList<Integer> randomRolls = generator.getTenRolls();

System.out.println(randomRolls);

## How to Run

Open the project in IntelliJ IDEA.

Run the `TestPuzzleJava.java` file.

The output will appear in the console.

## Notes

The output changes every time because the program uses random values.

`PuzzleJava.java` contains the methods and logic.

`TestPuzzleJava.java` is used to run and test the code.
