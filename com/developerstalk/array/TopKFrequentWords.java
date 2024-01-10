package com.developerstalk.array;

import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word,map.get(word) + 1);
            }
            else{
              map.put(word,1);
            }
            
        }
        
        Map<String,Integer> sortedMap = map.entrySet()
				.stream()
				.sorted(Comparator
		                .<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue, Comparator.reverseOrder())
		                .thenComparing(Map.Entry::getKey))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));
        
        List<String> extractedValues = sortedMap.entrySet().stream()
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());  

        return extractedValues;              
    }
}