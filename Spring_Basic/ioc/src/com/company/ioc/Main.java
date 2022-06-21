package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url = "www.daelim.ac.kr/dept/computerinfo?detail=software";

        // Encoder encoder = new Encoder(new BaseEncoder());
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);

        System.out.println(result);
    }
}
