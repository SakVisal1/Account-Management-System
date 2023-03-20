package account;

import account.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Account> arr = new ArrayList<>();

        int option;

        do {
            System.out.println("1: Add account:");
            System.out.println("2: Remove account.Account: ");
            System.out.println("3. Edit account.Account ");
            System.out.println("4. Show account infor");
            System.out.println("5. Exit ");
            System.out.println("Choose option ( 1 - 5 ) : ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add account.Account");
                    System.out.print("Enter id : ");
                    int id = input.nextInt();
                    System.out.print("Enter name : ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.print("Enter Balance : ");
                    double b = input.nextDouble();
                    arr.add(new Account(id, name, b));
                    break;
                case 2:
                    boolean isFound = false;
                    System.out.print("Enter ID : ");
                    int index = input.nextInt();

                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).id == index) {
                            isFound = true;
                            arr.remove(i);
                        }
                    }
                    if (!isFound) {
                        System.out.println("Not Found ..!!!!!!");
                    } else {
                        System.out.println("Successfully Delete !!! ");
                    }
                    break;
                case 3:
                    System.out.print("Enter id to edit : ");
                    int indexEdit = input.nextInt();

                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).id == indexEdit) {
                            input.nextLine();
                            System.out.print("Enter New name : ");
                            String nameN = input.nextLine();
                            System.out.print("Enter New Balance : ");
                            double balanceN = input.nextDouble();
                            arr.set(i, new Account(arr.get(i).id, nameN, balanceN));
                        }

                    }

                    break;
                case 4:

                    int showOption;
                    System.out.println("Show account Information");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descending order by balance ");

                    System.out.println("Choose show option : ");
                    showOption = input.nextInt();
                    switch (showOption) {
                        case 1:
                            List<Account> acc = arr.stream().sorted(Comparator.comparingLong(value -> value.id)).collect(Collectors.toList());
                            acc.stream().forEach(System.out::println);
                            break;
                        case 2:
                            List<Account> acc2 = arr.stream().sorted((o1, o2) -> (o2.id - o1.id)).collect(Collectors.toList());
                            acc2.stream().forEach(System.out::println);
                            break;


                        case 3:
                            List<Account> arr3 = arr.stream().sorted(Comparator.comparingDouble(Account::getBalance).reversed()).collect(Collectors.toList());
                            arr3.stream().forEach(System.out::println);
                            break;
                    }

                    break;
                case 5:
                    System.out.println("Exit the program....!!!!!");
                    break;

            }
        } while (option != 5);
    }
}