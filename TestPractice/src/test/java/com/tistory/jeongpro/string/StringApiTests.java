package com.tistory.jeongpro.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringApiTests {
	@Test
	public void equals_differenceConstructorString_returnTrue() {
		final String name = "jeong";
		final String name2 = new String("jeong");
		assertTrue(name.equals(name2));
	}
	@Test
	public void equals_sensitiveCase_returnFalse() {
		final String name = "Jeong";
		final String name2 = "jeong";
		assertFalse(name.equals(name2));
	}
	@Test
	public void equals_differenceString_returnFalse() {
		final String name = "jeong";
		final String name2 = "pro";
		assertFalse(name.equals(name2));
	}
	@Test
	public void equalsIgnoreCase_UppercaseString_returnTrue() {
		final String name = "jeong";
		final String name2 = name.toUpperCase();
		assertTrue(name.equalsIgnoreCase(name2));
	}
}
