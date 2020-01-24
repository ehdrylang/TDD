package com.tistory.jeongpro.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void add_givenBigIndex_returnIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () ->arrayList.add(Integer.MAX_VALUE ,"a"));
    }
    @Test
    public void add_givenIndex_returnIndexValue(){
        arrayList.add(3,"6");
        assertEquals("6", arrayList.get(3));
    }
    @Test
    public void clear_asList_throwsUnSupportedOperationException(){
        assertThrows(UnsupportedOperationException.class, ()->asList.clear());
    }
    @Test
    public void clear_arrayList_returnSizeZero(){
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }
    @Test
    public void clear_linkedList_returnSizeZero(){
        linkedList.clear();
        assertEquals(0, linkedList.size());
    }
    @Test
    public void addAll_asListGivenLinkedList_returnUnsupportedOperationException(){
        assertThrows(UnsupportedOperationException.class, ()->asList.addAll(linkedList));
    }
    @Test
    public void addAll_arrayListGivenLinkedList_returnSumSize(){
        int sum = arrayList.size() + linkedList.size();
        arrayList.addAll(linkedList);
        assertEquals(sum, arrayList.size());
    }
    @Test
    public void addAll_linkedListGivenArrayList_returnSumSize(){
        int sum = arrayList.size() + linkedList.size();
        linkedList.addAll(arrayList);
        assertEquals(sum, linkedList.size());
    }
    @Test
    public void size_addNull_returnPlusOne(){
        int size = arrayList.size();
        arrayList.add(null);
        assertEquals(size + 1, arrayList.size());
    }
    @Test
    @Disabled
    public void size_addElementGreaterThanIntegerMax_returnIntegerMaxSize(){
        for(int i=0;i<Integer.MAX_VALUE;i++){
            arrayList.add(""+i);
        }
        assertEquals(Integer.MAX_VALUE, arrayList.size());
    }
    @Test
    public void isEmpty_ExistElement_returnfalse(){
        assertFalse(asList.isEmpty());
    }
    @Test
    public void isEmpty_DontExistElement_returnTrue(){
        linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
    }
}
