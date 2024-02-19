package com.dta.demo13;

import android.util.Log;

public class TestThread extends Thread{
    private final String TAG = "DTA===>";
    @Override
    public void run() {
        super.run();

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int result = add(1, 2);
            String resultStr = add("1","2");
            //Log.i(TAG,"The Result is ==> " + result);
        }
    }

    private int add(int a, int b){

        //Log.i(TAG,"The first param is ==-> " + a);
        //Log.i(TAG,"The second param is ==-> " + b);
        return a+b;
    }

   private String add(String a, String b){

        return a+b;
    }

    public static String static_add(String a,String b){
        return a+b;
    }
}
