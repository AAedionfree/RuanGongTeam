package com.example.shebeimanage2.activity;

import java.util.ArrayList;
import java.util.List;

public class parseJsonArray {
    public parseJsonArray(){}
    public static List<String> split(String str){
        ArrayList<String> ans = new ArrayList<>();
        String first = str.substring(1,str.length()-1);
        if(first.contains("},")){
            String[] splits = first.split("},");
            for(String s:splits) ans.add(s + "}");
        }else{
            ans.add(first);
        }
        return ans;
    }
}
