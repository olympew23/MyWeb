package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jerieshasmith on 2/15/17.
 */
public class ReadWriteJson {

    public static void main(String[] args) throws IOException {

        Person p = new Person();

        p.name = "Alice Smith";
        p.age= 30;


        File f = new File("person.json");

        JsonSerializer serializer = new JsonSerializer();

        String jsonformattedPerson = serializer.serialize(p);

        FileWriter fw = new FileWriter(f);

        fw.write(jsonformattedPerson);
        fw.close();



        //read json
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
//
        JsonParser parser = new JsonParser();
        Person p2 = parser.parse(contents,Person.class);

        System.out.println(p2);
        System.out.println("p2 Name: " + p2.name);
        System.out.println("p2 age: " + p2.getAge());


    }








}
