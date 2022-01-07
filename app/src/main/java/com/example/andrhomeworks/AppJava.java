package com.example.andrhomeworks;

import java.util.Scanner;

public class AppJava {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter a sentence");
        String w = in.nextLine();
        String z = "", v = "aieAie", ww = "";
        int cc = 0, cl = 0;

        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != 32)
                z += c;
            else {
                for (int j = 0; j < w.length(); j++) {
                    char d = z.charAt(j);
                    if (v.indexOf(d) != -1)
                        cc++;
                }
                if (cc > cl){
                    ww = z;
                    cl = cc;
                }
                z = ""; cc = 0;
            }
        }
        System.out.println("res is :" +ww);
        System.out.println("it has" +cc+"no is vowels");
    }
}
