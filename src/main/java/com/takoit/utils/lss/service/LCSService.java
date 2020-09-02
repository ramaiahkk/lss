package com.takoit.utils.lss.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LCSService {
    public String getSmallString(List<String> setStrings){
        if(setStrings==null||setStrings.size()==0){
            return null;
        }
        //filter null is not required as we throw error message in the event of blank or null. but to ensure quality adding filter null
        return setStrings.stream().filter(x -> x!=null).min(Comparator.comparingInt(String::length)).get();
    }
    public List<String> getLongestSubstrings(List<String> setStrings){
        String small = getSmallString(setStrings);
        List<String> result=null;
        for (int i = small.length(); i >= 1 && (result==null || result.size() ==0); i--) {
            Set<String> subStringSet = getSubstringsWithLength(small, i);
            result = subStringSet.stream().filter(x -> setStrings.stream().filter(source -> source.contains(x)).count() == setStrings.size()).collect(Collectors.toList());
        }
        return result;
    }
    public Set<String> getSubstringsWithLength(String small, int subLength) {
        Set<String> s = new HashSet<>();
        if(small==null||subLength>small.length()){
            return s;
        }
        for (int j = 0; subLength + j <= small.length(); j++) {
            s.add(small.substring(j, subLength + j));
        }
        return s;
    }
}
