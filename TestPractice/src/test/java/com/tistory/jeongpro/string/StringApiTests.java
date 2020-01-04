package com.tistory.jeongpro.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
		assertFalse(firstName.equals(lastName));
	}
	@Test
	public void equalsIgnoreCase_UppercaseString_returnTrue() {
		assertTrue(firstName.equalsIgnoreCase(firstName_upper));
	}
	@Test
	public void equalsIgnoreCase_differenceConstructorString_returnTrue() {
		assertTrue(firstName.equalsIgnoreCase((firstName_differenceConstructor)));
	}
	@Test
	public void equalsIgnoreCase_differenceString_returnFalse() {
		assertFalse(firstName.equalsIgnoreCase(lastName));
	}
	@Test
	public void charAt_normal() {
		assertEquals('p', firstName.charAt(0));
	}
	@Test
	public void charAt_negativeParameter_returnIndexOutOfBoundException() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			firstName.charAt(-1);
		});
	}
	@Test
	public void charAt_greaterThenLength_returnIndexOutOfBoundException() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			firstName.charAt(firstName.length() + 1);
		});
	}
	//chars() 생략, 각 문자를 int값으로 치환한 값을 intStream으로 리턴해줌.
	@Test
	public void compareTo_lessThenTarget_returnPositive() {
		assertTrue(firstName.compareTo(lastName) > 0);
	}
	@Test
	public void compareTo_greaterThenTarget_returnNegative() {
		assertTrue(lastName.compareTo(firstName) < 0);		
	}
	@Test
	public void compareTo_sameValue_returnZero() {
		assertEquals(0, firstName.compareTo(firstName));
	}
	@Test
	public void compareTo_upperCaseTarget_returnNegative() {
		assertTrue(firstName.compareTo(firstName_upper) > 0);
	}
	@Test
	public void compareTo_upperCaseTarget_returnZero() {
		assertEquals(0, firstName.compareToIgnoreCase(firstName_upper));
	}
	@Test
	public void concat_normalCase_returnTrue() {
		assertEquals("projeong", firstName.concat(lastName));
	}
	@Test
	public void concat_eachEmptyString_returnEmptyString() {
		assertEquals("", "".concat(""));
	}
	@Test
	public void concat_emptyStringTarget_returnOriginString() {
		assertEquals(firstName, firstName.concat(""));
	}
	@Test
	public void contains_isExistSameSomething_returnTrue() {
		assertTrue(firstName.contains("p"));
	}
	@Test
	public void contains_isNotExistString_returnFalse() {
		assertFalse(firstName.contains("helloworld"));
	}
	@Test
	public void contains_isExistSameString_returnTrue() {
		assertTrue(firstName.contains(firstName));
	}
	@Test
	public void contains_differenceConstructorString_returnTrue() {
		assertTrue(firstName.contains(firstName_differenceConstructor));
	}
	@Test
	public void contains_upperCaseTarget_returnFalse() {
		assertFalse(firstName.contains(firstName_upper));
	}
}
