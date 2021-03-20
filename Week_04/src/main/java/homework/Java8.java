package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> list2 = list.stream().filter(item -> Integer.parseInt(item) > 0).collect(Collectors.toList());
        System.out.println(list2);

    }
}
