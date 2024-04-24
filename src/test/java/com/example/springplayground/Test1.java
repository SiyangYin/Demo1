package com.example.springplayground;

import com.example.springplayground.demo.demo15;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class Test1 {

    @Mock
    demo15.Animal animal;

    @Mock
    @InjectMocks
    demo15.Dog dog;

    @Mock
    demo15.Bird bird;

    @Test
    public void test1() {
        Mockito.when(dog.bark()).thenReturn("wang wang");
        assert dog.bark().equals("wang wang");
    }
}
