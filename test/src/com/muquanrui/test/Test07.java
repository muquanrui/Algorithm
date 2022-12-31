package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/16 19:39
 */

public class Test07 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String xml = br.readLine();
            System.out.println(parseXml(xml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String parseXml(String xml) {
        Deque<String> stack = new LinkedList<>();
        int i = 0;
        while (i < xml.length()) {

        }
        return null;
    }
    class XmlNode {
        String s;
        String[] children;
    }
}
