package com.example.junittest;

public class StaticUtils {

    public static final String name = "StaticUtils";;
    public static String getClassName() {
        return "StaticUtils";
    }

    public static void setName(String name) {
        name = name;
    }
    public static String setParam(String name) {
        name = name;
        return name;
    }
}
