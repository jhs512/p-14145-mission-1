package org.example;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        QuoteList quoteList = new QuoteList(sc);
        quoteList.printWelcomeMessage();

        while (quoteList.isRunning()) {
            quoteList.printCommandPrompt();

            String cmd = sc.nextLine().trim();

            if (quoteList.isAvailableCommand(cmd)) {
                quoteList.execute(cmd);
            } else {
                quoteList.printInvalidInputMessage();
            }
        }
    }
}
