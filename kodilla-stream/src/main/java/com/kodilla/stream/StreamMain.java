package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("text", (textToDecorate) -> "ABC"+textToDecorate+"ABC");
        poemBeautifier.beautify("text", (textToDecorate) -> textToDecorate.toUpperCase());
        poemBeautifier.beautify("text", (textToDecorate) -> textToDecorate.replace('x','s'));
        poemBeautifier.beautify(" text ", (textToDecorate) -> textToDecorate.trim());

    }
}