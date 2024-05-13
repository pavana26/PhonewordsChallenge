#Question
Today, Phonewords (https://en.wikipedia.org/wiki/Phoneword) are being used by 
many companies as their phone numbers.
Write a program to display possible matches for a list of provided phone numbers.
The program should be a command line application which accepts input in one of the 
following ways:
1. A file specified in a command-line argument. Each line of these files will 
contain a single phone number. 
2. STDIN 
For each number read, the program should output all possible word replacements 
from a dictionary. The program should try to replace every digit of the provided 
phone number with a letter from a dictionary word.
However, if no complete match can be made a single digit can be left as is. 
No two consecutive digits can remain unchanged.
If a match cannot be made, the program should produce no output for that number.
To allow the user to set a dictionary, implement a -dictionary command-line option. 
The dictionary should consist of one word per line.
The program should be case insensitive.
Punctuation and whitespaces should be ignored in both the dictionary file and the 
phone numbers.
Output should be in capital letters and digits separated with a single dash (-).
The output should also display one possible word replacement per line.

# Why I choose this challenge :

This challenge  provides an opportunity to demonstrate proficiency in programming fundamentals, problem-solving skills, and the ability to design and implement a command-line application that interacts with files and STDIN.
It challenges to generate possible word replacements for phone numbers while adhering to specific constraints, such as not allowing consecutive unchanged digits.I recently learnt alot about Trie datastructure and wanted to use it here.
I believe it offers a valuable opportunity to showcase relevant skills and experience.

# Design 
I have used Trie data structure to solve this.
Based on whether "numberfile" parameter is passed or not, executor decides to go with command line input or file input.
Either with default dictionary file or "dictionary" set as part of paramater dictionary is traversed.
Factory design pattern is used here.Recursion is used to decide the word.

# Dependencies
- Java OpenJDK 17
- Gradle 8.4
- JUnit 5

# Setup

No need to install gradle.
COpy the repo and build using following command.

$ git clone https://github.com/pavana26/PhonewordsChallenge.git
$ cd PhonewordsChallenge
$ ./gradlew build

# Running
This is a command line application.
First build the jar

$ ./gradlew build
This will create PhonewordsChallenge.jar file in build/libs folder.


1 )To input numbers from STDIN

a) With default dictionary file
$ java -jar build/libs/PhonewordsChallenge.jar

b)By setting custom dictionary file
$ java -jar  -Ddictionary="PATH TO CUSTOM DICTIONARY FILE" build/libs/PhonewordsChallenge.jar 

2 )To input numbers from files

a) With default dictionary file
$ java -jar -Dnumberfile="PATH TO THE FILE WHICH CONTAINS NUMBERS" build/libs/PhonewordsChallenge.jar

b)By setting custom dictionary file
$ java -jar  -Ddictionary="PATH TO CUSTOM DICTIONARY FILE" -Dnumberfile="PATH TO THE FILE WHICH CONTAINS NUMBERS" build/libs/PhonewordsChallenge.jar 


dictionary - parameter sets the path of dictionary file
numberfile - paramter sets input file which contain numbers.

Sample Input and output:

1)  Input - 54,889
	Expected output: KITTY
	
2)  Input - 78 27927 71
	Expected output: STAR-WARS-1




