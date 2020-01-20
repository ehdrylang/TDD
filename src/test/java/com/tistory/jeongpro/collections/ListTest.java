package com.tistory.jeongpro.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ListTest {
    private List<String> asList;
    private ArrayList<String> arrayList;
    private LinkedList<String> linkedList;

    @BeforeEach
    private void init(){
        asList = Arrays.asList("1","2","3","4","5");
        arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        linkedList = new LinkedList<>();
        linkedList.push("1");
        linkedList.push("2");
        linkedList.push("3");
        linkedList.push("4");
        linkedList.push("5");
    }

    @Test
    public void add_givenElementToAsList_throwUnSupportedOperationException(){
        assertThrows(UnsupportedOperationException.class, ()->asList.add("6"));
    }
    @Test
    public void add_givenCastedObject_throwClassCastException(){
        assertThrows(ClassCastException.class, () -> asList.add((String)new Object()));
    }
    @Test
    public void add_givenNull_throwUnSupportedOperationException(){
        assertThrows(UnsupportedOperationException.class, ()->asList.add(null));
    }
    @Test
    public void add_givenElementToArrayList_returnTrue(){
        assertTrue(arrayList.add("6"));
    }
    @Test
    public void add_givenNullToArrayList_returnTrue(){
        assertTrue(arrayList.add(null));
    }
    @Test
    public void add_givenElementToLinkedList_returnTrue(){
        assertTrue(linkedList.add("6"));
    }
    @Test
    public void add_givenNullToLinkedList_returnTrue(){
        assertTrue(linkedList.add(null));
    }
}
