package com.leetcode.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamsTest
 */
public class StreamsTest {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 3, 2, 1};

        Arrays.stream(arr).forEach(System.out::print);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);

        Map<Integer, Integer> map = Arrays.stream(arr).boxed().collect(Collectors.toMap(i -> i, i -> i));
        System.out.println(map);

        // Reverse order map by Key
        Map<Integer, Integer> sortedMap = Arrays.stream(arr)
                                                    .boxed()
                                                    .sorted((o1,o2)-> o2.compareTo(o1))
                                                    .collect(Collectors.toMap(i -> i, i -> i, (o1, o2) -> o2, LinkedHashMap::new));
        System.out.println(sortedMap);

        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(1, 5);
        testMap.put(2, 4);
        testMap.put(6, 3);
        testMap.put(3, 3);
        testMap.put(4, 3);
        testMap.put(50, 3);
        testMap.put(5, 1);

        // Sort by Key if value is same, else sort by value
        Map<Integer, Integer> sortMapByValues = testMap.entrySet()
                                                    .stream()
                                                    .sorted((e1, e2) -> e1.getValue() == e2.getValue()? Integer.compare(e1.getKey(), e2.getKey()): Integer.compare(e1.getValue(), e2.getValue()))
                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(sortMapByValues);

        int[] intArr = sortMapByValues
                        .entrySet()
                        .stream()
                        .mapToInt(e -> e.getKey())
                        .toArray();
        System.out.println(Arrays.toString(intArr));
    }
}