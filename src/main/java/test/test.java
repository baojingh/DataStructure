package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: hebj
 * @Date: 2020/2/29 22:12
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        HashMap<String, Set<String>> hashMap = new HashMap<>();
        Set<String> set = hashMap.get("a");
        if (set == null) {
            set = new HashSet<String>();
        }
        set.add("1");
        set.add("2");
        hashMap.put("a", set);

        System.out.println(hashMap.get("a"));
    }
}
