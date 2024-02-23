package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            InetAddress[] address = InetAddress.getAllByName("www.oriely.com");
            for (InetAddress inetAddress : address) {
                System.out.println(inetAddress);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
