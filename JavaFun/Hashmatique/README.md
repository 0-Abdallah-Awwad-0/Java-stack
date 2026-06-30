# Hashmatique

## Assignment

This assignment practices using a `HashMap` in Java.

The program stores song titles as keys and sample lyrics as values. It allows us to retrieve lyrics by song title and also print all tracks with their lyrics.

## Concepts Practiced

* `HashMap`
* `put()`
* `get()`
* `keySet()`
* `for-each` loop
* Key-value pairs
* Printing output with `System.out.println()`

## Main Idea

A `HashMap` stores data using key-value pairs.

For this assignment:

Song title = key
Lyrics = value

Example:

Morning Light → The sun is rising over the city.

## Program Features

The program does the following:

1. Creates a `HashMap` called `trackList`.
2. Adds at least 4 songs.
3. Retrieves one song by its title.
4. Prints all tracks and lyrics in this format:

Track: Lyrics

## Example Output

Lyrics for Blue Horizon:
We run toward the open sky.

----- All Tracks -----
Morning Light: The sun is rising over the city.
Lost Signal: I keep calling but the line is gone.
Blue Horizon: We run toward the open sky.
Silent Roads: The night is quiet but my mind is loud.

## File Structure

Hashmatique
└── src
└── Hashmatique.java

## How to Run

Open the project in IntelliJ IDEA.

Run the `Hashmatique.java` file.

The output will appear in the console.

## Notes

The order of the tracks may appear different each time because `HashMap` does not guarantee order.
