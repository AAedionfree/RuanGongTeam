package org.spring.springboot;

public class RegressionTest {
    private static String Regression = "";
    private static String nullString = "";
    private static String RegressionStr = "---RegressionTest---:";
    public static void RegressionTestBegin(){
        Regression = RegressionStr;
    }

    public static void RegressionTestEnd(){
        Regression = nullString;
    }

    public static void setTestInfo(String info){
        Regression = RegressionStr.substring(0,RegressionStr.length()-4) + info;
    }
    public static String Regression(){
        return Regression;
    }
}
