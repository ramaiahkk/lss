package com.takoit.utils.lss.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class LCSServiceTest {

    @Autowired
    private LCSService lcsService;

    private List<String> getTestData() {
        List<String> list = new ArrayList<>();
        list.add("Comcast");
        list.add("broadcast");
        list.add("cast");
        return list;
    }

    @Test
    public void testGetSmallStringSuccess() {
        Assertions.assertTrue(lcsService.getSmallString(getTestData()).equals("cast"));
    }

    @Test
    public void testGetSmallStringSuccessSingleCharAndNull() {
        List<String> list = getTestData();
        list.add("a");
        list.add(null);
        Assertions.assertTrue(lcsService.getSmallString(list).equals("a"));
    }

    @Test
    public void testGetSmallStringSuccessEmpty() {
        List<String> list = getTestData();
        list.add("a");
        list.add("");
        Assertions.assertTrue(lcsService.getSmallString(list).equals(""));
    }

    @Test
    public void testGetSubstringwithLength() {
        Set<String> stringSet = lcsService.getSubstringsWithLength("broadcast", 4);
        Assertions.assertTrue(stringSet.size() == 6);
        Assertions.assertTrue(stringSet.contains("cast")&&stringSet.contains("oadc"));
        Assertions.assertTrue(stringSet.contains("road")&&stringSet.contains("broa"));
        Assertions.assertTrue(stringSet.contains("adca")&&stringSet.contains("dcas"));
    }
    @Test
    public void testGetSubstringwithLengthMore() {
        Set<String> stringSet = lcsService.getSubstringsWithLength("broadcast", 11);
        Assertions.assertTrue(stringSet.size() == 0);
    }
    @Test
    public void testGetSubstringwithLengthNull() {
        Set<String> stringSet = lcsService.getSubstringsWithLength(null, 11);
        Assertions.assertTrue(stringSet.size() == 0);
    }

    @Test
    public void testgetLongestSubstrings() {
        List<String> lcsting= lcsService.getLongestSubstrings(getTestData());
        Assertions.assertTrue(lcsting.size()==1 && lcsting.get(0).equalsIgnoreCase("cast"));
    }

    @Test
    public void testgetLongestSubstringswithSingleChar() {
        List<String> list = getTestData();
        list.add("a");
        List<String> lcsting= lcsService.getLongestSubstrings(list);
        Assertions.assertTrue(lcsting.size()==1 && lcsting.get(0).equalsIgnoreCase("a"));
    }
    @Test
    public void testgetLongestSubstringswithnoMatch() {
        List<String> list = getTestData();
        list.add("z");
        List<String> lcsting= lcsService.getLongestSubstrings(list);
        Assertions.assertTrue(lcsting.size()==0 );
    }
}
