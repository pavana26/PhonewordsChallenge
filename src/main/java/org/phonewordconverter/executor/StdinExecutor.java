package org.phonewordconverter.executor;

import java.util.Scanner;

import static java.util.Collections.singletonList;

public class StdinExecutor extends BaseExecutor {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter a phone number(if you want to exit press q) : ");
            String number = scanner.nextLine();

            if ("q".equals(number)) {
                break;
            }
            displayValues(traversal.getValues(singletonList(number)));
        }
        scanner.close();
    }
}
