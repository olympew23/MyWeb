package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jerieshasmith on 2/16/17.
 */
public class Forum {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Post> posts = new ArrayList<>();

        // read all the posts into our data structure
        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();

            String[] columns = line.split("\\|");

            Post post = new Post(Integer.valueOf(columns[0]), columns[1], columns[2]);

            posts.add(post);

        }

        Scanner consoleScanner = new Scanner(System.in);


        int replyID = -1;
        while (true) {

            int id = 0;

            for (Post post : posts) {
                if (post.replyId == replyID) {
                    System.out.printf("(%d) %S by %s\n", id, post.text, post.author);
                }
                id++;


            }


            System.out.println("Type the id you want to see replies to ");

             replyID = Integer.valueOf(consoleScanner.nextLine());
        }

    }
}