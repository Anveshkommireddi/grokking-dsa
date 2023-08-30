package com.learn.java.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyValueExchange {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyValueExchange.class);

    public static void main(String[] args) {

        Map<String, String> kvMap = new HashMap<>();
        kvMap.put("naga", "charan");
        kvMap.put("ram", "anvesh");
        LOGGER.info("Key Value Map is :: {}", kvMap);

        // key - val and val - key
        Map<String, String> vkMap = kvMap.entrySet()
				 .parallelStream()
				 .collect(Collectors.toMap(Entry::getValue, Entry::getKey, (oldKey, newKey) -> oldKey, HashMap<String, String>::new));
        LOGGER.info("Value Key Map is :: {}", vkMap);

        // sort map based on the values
        Map<String, String> valsSortMap = kvMap.entrySet().parallelStream()
				.sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.collect(Collectors.toMap(Entry::getValue, Entry::getKey, (oldVal, newVal) -> newVal, LinkedHashMap<String, String>::new));
        LOGGER.info("valsSortMap Map is :: {}", valsSortMap);

        // Testing for key val params
        Map<String, Integer> nameCountMap = new HashMap<>();
        nameCountMap.put("naga", 4);
        nameCountMap.put("ram", 3);
        LOGGER.info("nameCountMap is :: {}", nameCountMap);

        Map<String, Integer> nameCountSortMap = nameCountMap.entrySet().parallelStream()
				.sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldval, newVal) -> newVal, LinkedHashMap<String, Integer>::new));
        LOGGER.info("nameCountSortMap is :: {}", nameCountSortMap);

    }
}
