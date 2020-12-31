package com.company;

import java.net.URL;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = getIsrFromURL("https://google.com");
        writeToFile(isr, "result.html");
    }

    private static InputStreamReader getIsrFromURL(String url) throws IOException{
        return new InputStreamReader(new URL(url).openStream(), StandardCharsets.UTF_8);
    }

    private static void writeToFile(InputStreamReader isr, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(new File(fileName)); Scanner scanner = new Scanner(new BufferedReader(isr))) {
            while (scanner.hasNextLine())
                writer.write(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
