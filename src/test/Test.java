package test;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        System.out.println(map.get("hello"));
    }
}
