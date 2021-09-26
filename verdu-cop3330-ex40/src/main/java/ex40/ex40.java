package ex40;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ex40 {

    public static void main(String[] Args){

        Map<String, String> name_records = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);

        name_records.put("John","Johnson");
        name_records.put("Tou","Xiong");
        name_records.put("Michaela","Michaelson");
        name_records.put("Jake","Jacobson");
        name_records.put("Jacquelyn","Jackson");
        name_records.put("Sally","Webber");

        Map<String, String> position_records = new HashMap<String, String>();

        position_records.put("Johnson","Manager");
        position_records.put("Xiong","Software Engineer");
        position_records.put("Michaelson","District Manager");
        position_records.put("Jacobson","Programmer");
        position_records.put("Jackson","DBA");
        position_records.put("Webber","Web Developer");

        Map<String, String> date_records = new HashMap<String, String>();

        date_records.put("Manager","2016-12-31");
        date_records.put("Software Engineer","2016-10-05");
        date_records.put("District Manager","2015-12-19");
        date_records.put("Programmer"," ");
        date_records.put("DBA"," ");
        date_records.put("Web Developer","2015-12-18");

        Map<String, String> ordered_records = namesort(name_records);

        System.out.println("Enter a search string: ");
        String search = scanner.next();

        System.out.println("Results: \n");

        System.out.print("Name                | Position          | Separation date\n");
        System.out.print("--------------------|-------------------|----------------\n");

        printrecords(ordered_records, position_records, date_records, search);


    }


    public static <K, V extends Comparable<? super V>> Map<K, V> namesort(Map<K, V> records) {

        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(records.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> ordered_results = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            ordered_results.put(entry.getKey(), entry.getValue());
        }

        return ordered_results;
    }


    public static <K, V> void printrecords(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, String search) {

        for (Map.Entry<K, V> temp : map.entrySet()) {

            String key = temp.getKey().toString();
            String value = temp.getValue().toString();

            if(value.startsWith(search) || key.startsWith(search)){
                String output1 = (temp.getKey() + " " + temp.getValue());
                System.out.print(String.format("%-19s", output1) + " | ");

                for (Map.Entry<K, V> temp2 : map2.entrySet()){
                    if (temp.getValue() == temp2.getKey()) {
                        System.out.print(String.format("%-18s", temp2.getValue()) + "| ");

                        for (Map.Entry<K, V> temp3 : map3.entrySet()) {
                            if (temp2.getValue() == temp3.getKey()) {
                                System.out.println(String.format("%-15s", temp3.getValue()));
                            }
                        }
                    }
                }
            }


        }
        return;
    }







}
