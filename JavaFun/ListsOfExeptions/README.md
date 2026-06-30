# Lists of Exceptions

## Assignment

This assignment practices Java generics and exception handling.

The program creates an `ArrayList<Object>` that contains both strings and numbers. Then it loops through the list and tries to cast each item into an `Integer`.

Some values cannot be cast to `Integer`, so the program uses a `try/catch` block to handle the error without stopping the program.

## Concepts Practiced

* `ArrayList`
* Generics
* `Object` type
* Type casting
* `try` / `catch`
* `ClassCastException`
* Looping through an ArrayList
* Printing error information

## Program Features

The program does the following:

1. Creates an `ArrayList<Object>`.
2. Adds mixed values to the list.
3. Loops through the list.
4. Tries to cast each value to an `Integer`.
5. Catches `ClassCastException` errors.
6. Prints the error message.
7. Prints the index where the error happened.
8. Prints the value that caused the error.
9. Continues running after the error.

## Example List

```java
ArrayList<Object> myList = new ArrayList<Object>();

myList.add("13");
myList.add("hello world");
myList.add(48);
myList.add("Goodbye World");
```

## Example Output

```text
Error: java.lang.ClassCastException
Index where error happened: 0
Value that caused the error: 13

Error: java.lang.ClassCastException
Index where error happened: 1
Value that caused the error: hello world

Casted value: 48

Error: java.lang.ClassCastException
Index where error happened: 3
Value that caused the error: Goodbye World
```

## File Structure

```text
ListOfExceptions
└── src
    └── ListOfExceptions.java
```

## How to Run

Open the project in IntelliJ IDEA.

Run the `ListOfExceptions.java` file.

The output will appear in the console.

## Notes

The program should not crash when a value cannot be cast to an `Integer`.

Instead, the `catch` block handles the exception and allows the loop to continue.
