import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Scanner;

public class ReadAndEditFile {

      public static void main(String[] args) throws IOException {

            // scanner for reading input from keyboard

            Scanner scanner = new Scanner(System.in);

            // buffered reader to read from a file char by char

            BufferedReader fileReader = null;

            // looping as long as fileReader is null

            while (fileReader == null) {

                  // promptng and reading file name

                  System.out.println("What is the name of your file?");

                  String name = scanner.nextLine();

                  // trying to open the specified file

                  try {

                        fileReader = new BufferedReader(new FileReader(new File(name)));

                        // if file opened correctly, no exceptions will occur and loop

                        // will be terminated

                  } catch (FileNotFoundException e) {

                        // some exception occurred, displaying file not found error

                        System.out.println("File Not Found " + name);

                        // setting fileReader to null so that the loop will run again

                        fileReader = null;

                  }

            }

            int c;

            char ch;

            String contents = ""; // to store formatted contents of file

            boolean beginSentence = true; // denoting start of a sentence

            char prevChar = ' '; // to store previous character

            // looping until end of file, reading a character as int

            while ((c = fileReader.read()) != -1) {

                  // casting int to char

                  ch = (char) c;

                  // checking if beginSentence is true and ch is a letter

                  if (beginSentence && Character.isLetter(ch)) {

                        // converting ch to upper case and appending to contents

                        ch = Character.toUpperCase(ch);

                        contents += ch;

                        // setting beginSentence to false

                        beginSentence = false;

                  }

                  // checking if ch is a space or tab

                  else if (ch == ' ' || ch == '\t') {

                        // if previous character is a not space and not a tab,appending

                        // a single white space

                        if (prevChar != ' ' && prevChar != '\t') {

                              contents += ' ';

                        }

                  }

                  // if ch is a period, appending to contents and setting

                  // beginSentence to true

                  else if (ch == '.') {

                        contents += ch;

                        beginSentence = true;

                  }

                  // all other characters, simply appending to contents

                  else {

                        contents += ch;

                  }

                  // storing ch in prevChar before going to the next loop

                  prevChar = ch;

            }

            // closing file

            fileReader.close();


            PrintWriter writer = new PrintWriter(new File("HomeworkOutput6-2.txt"));

            // writing contents, closing and saving file

            writer.print(contents);

            writer.close();

            // alerting the user that operation is completed successfully


      }

}