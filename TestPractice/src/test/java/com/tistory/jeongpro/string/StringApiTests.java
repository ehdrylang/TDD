package com.tistory.jeongpro.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringApiTests {
	private String firstName;
	private String firstName_upper;
	private String firstName_differenceConstructor;
	private String lastName;
	@BeforeEach
	private void init() {
		firstName = "pro";
		firstName_upper = firstName.toUpperCase();
		firstName_differenceConstructor = new String("pro");
		lastName = "jeong";
	}
	@Test
	public void equals_differenceConstructorString_returnTrue() {
		assertTrue(firstName.equals(firstName_differenceConstructor));
	}
	@Test
	public void equals_sensitiveCase_returnFalse() {
		assertFalse(firstName.equals(firstName_upper));
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
	@Test
	public void equalsIgnoreCase_differenceConstructorString_returnTrue() {
		final String name = "jeong";
		final String name2 = new String("jeong");
		assertTrue(name.equalsIgnoreCase(name2));
	}
}
