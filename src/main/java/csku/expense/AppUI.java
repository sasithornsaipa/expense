package csku.expense;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AppUI {
    Scanner in = new Scanner(System.in);
    public void start(){
        System.out.println("Hello!");
        System.out.println("Enter your name: ");
        String name = in.nextLine();
        User user = new User(name);

        while (true){
            System.out.println("Type I(add income), EX(add expense), L(show all), ED(edit), X(exit): ");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("I")){
                System.out.println("-------------------------------");
                addTransaction(user, "i");
                System.out.println("-------------------------------");
            }else if (input.equalsIgnoreCase("EX")){
                System.out.println("-------------------------------");
                addTransaction(user, "e");
                System.out.println("-------------------------------");
            }else if (input.equalsIgnoreCase("L")){
                System.out.println("-------------------------------");
                showList(user);
                System.out.println("-------------------------------");
            }else if (input.equalsIgnoreCase("ED")){
                System.out.println("-------------------------------");
                edit(user);
                System.out.println("-------------------------------");
            }else if (input.equalsIgnoreCase("x")){
                break;
            }
        }
        writeFile(user, user.getAccount().getTransaction());
        readFile(user);
    }

    public void addTransaction(User user, String t){
        if (t.equalsIgnoreCase("i")){
            System.out.println("Enter your Income Detail: ");
            String detail = in.nextLine();
            System.out.println("Enter your Income: ");
            String income = in.nextLine();

            user.getAccount().addTransaction(t,detail,income);
        }else {
            System.out.println("Enter your Expense Detail: ");
            String detail = in.nextLine();
            System.out.println("Enter your Expense: ");
            String ex = in.nextLine();

            user.getAccount().addTransaction(t,detail,ex);
        }
    }
    
    public void showList(User user){
        System.out.println("All of Your Income and Expense");
        for (ArrayList<String> i:user.getAccount().getTransaction()) {
            if (i.get(0) == "i"){
                System.out.println(i.get(1));
                System.out.println("                   +" + i.get(2));

            }else {
                System.out.println(i.get(1));
                System.out.println("                   -" + i.get(2));
            }
        }
        System.out.println("Balance:            " + user.getAccount().getBalance());
    }

    public void edit(User user){
        showList(user);
        System.out.println("-------------------------------");
        System.out.println("Which index do you want to edit?");
        String index = in.nextLine();
        System.out.println("New Value: ");
        String nv = in.nextLine();
        user.getAccount().editTransaction(Integer.parseInt(index)-1,nv);
    }

    public void readFile(User user){
        try {
            Path file = Paths.get("./src/main/text-file/" + user.getName() + ".txt");
            BufferedReader reader = Files.newBufferedReader(file ,
                    StandardCharsets.UTF_8);
            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line.split(" ")[0]+" "+line.split(" ")[1]+" "+line.split(" ")[2]);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public void writeFile(User user, ArrayList<ArrayList<String>> content){
        try {
            Path file = Paths.get("./src/main/text-file/" + user.getName() + ".txt");
            BufferedWriter writer = Files.newBufferedWriter(file,
                    StandardCharsets.UTF_8);

            for (int i = 0; i < content.size(); i++) {
                writer.write(content.get(i).get(0)+" "+content.get(i).get(1)+" "+content.get(i).get(2));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

}
