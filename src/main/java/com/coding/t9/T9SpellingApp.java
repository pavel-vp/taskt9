package com.coding.t9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Application class for console input/output. Calls T9Spelling.spell method for encode T9 data.
 * The first line of input gives the number of cases, N. N test cases follow. Each case is a line of text formatted as
 *
 * desired_message
 * Each message will consist of only lowercase characters a-z and space characters ' '. Pressing zero emits a space
 *
 * @author Pavel Pinegin
 */
public class T9SpellingApp {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out, true));

        int numCases = Integer.parseInt(scanner.nextLine());
        String[] inputs = new String[numCases];

        for (int cs = 1; cs<=numCases; cs++) {
            inputs[cs-1] = scanner.nextLine();
        }

        for (int cs = 1; cs<=numCases; cs++) {
            String output = T9Spelling.spell(inputs[cs-1]);
            bufferedWriter.write("Case #" + cs + ": " + output);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
