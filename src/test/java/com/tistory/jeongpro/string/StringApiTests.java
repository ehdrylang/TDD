package com.tistory.jeongpro.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

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
	//contentEquals 생략 -> 문자열이 100%동일해야 true 이외 false
	@Test
	public void endWith_existSuffix_returnTrue(){
		assertTrue(firstName.endsWith("ro"));
	}
	@Test
	public void endWith_notExistSuffix_returnFalse(){
		assertFalse(firstName.endsWith(lastName));
	}
	@Test
	public void endWith_upperCaseSuffix_returnFalse(){
		assertFalse(firstName.endsWith(firstName_upper));
	}
	@Test
	public void endWith_containsSuffix_returnFalse(){
		assertFalse(firstName.endsWith("pr"));
	}
	@Test
	public void isBlank_normal_returnFalse(){
		assertFalse(firstName.isBlank());
	}
	@Test
	public void isBlank_normalContainsBlank_returnFalse(){
		assertFalse((firstName + " ").isBlank());
	}
	@Test
	public void isBlank_ThreeBlankString_returnTrue(){
		assertTrue("   ".isBlank());
	}
	@Test
	public void isBlank_blank_returnTrue(){
		assertTrue("".isBlank());
	}
	@Test
	public void isEmpty_normal_returnFalse(){
		assertFalse(firstName.isEmpty());
	}
	@Test
	public void isEmpty_ThreeBlank_returnFalse(){
		assertFalse("   ".isEmpty());
	}
	@Test
	public void isEmpty_emptyString_returnTrue(){
		assertTrue("".isEmpty());
	}
	@Test
	public void replace_firstChar_returnUpdatedString(){
		assertEquals("aro",firstName.replace("p","a"));
	}
	@Test
	public void replace_isNotExist_returnOrigin(){
		assertEquals(firstName, firstName.replace("g","hello"));
	}
	@Test
	public void replace_existDoubleString_return(){
		assertEquals("hello world hello", "hi world hi".replace("hi","hello"));
	}
	@Test
	public void startsWith_existPrefix_returnTrue(){
		assertTrue(firstName.startsWith("pr"));
	}
	@Test
	public void startsWith_notExistPrefix_returnFalse(){
		assertFalse(firstName.startsWith(lastName));
	}
	@Test
	public void startsWith_upperCasePrefix_returnFalse(){
		assertFalse(firstName.startsWith(firstName_upper));
	}
	@Test
	public void startsWith_containsPrefix_returnFalse(){
		assertFalse(firstName.startsWith("ro"));
	}
	@Test
	public void indexOf_inputValueIsString_returnFirstIndex(){
		assertEquals(0, firstName.indexOf("pr"));
	}
	@Test
	public void indexOf_inputValueIsExistChar_returnNormalIndex(){
		assertEquals(0, firstName.indexOf('p'));
	}
	@Test
	public void indexOf_inputValueIsExistAndRepeatTwice_returnFirstSameIndex(){
		assertEquals(0, "propropro".indexOf("pr"));
	}
	@Test
	public void indexOf_inputValueIsExistAndFindAfterSomeIndex_returnNormalIndex(){
		assertEquals(3, "propropro".indexOf("pr",1));
	}
	@Test
	public void lastIndexOf_inputValueIsString_returnLastIndex(){
		assertEquals(1, firstName.lastIndexOf("ro"));
	}
	@Test
	public void lastIndexOf_inputValueIsExistChar_returnNormalIndex(){
		assertEquals(2, firstName.lastIndexOf('o'));
	}
	@Test
	public void indexOf_inputValueIsExistAndRepeatTwice_returnLastSameIndex(){
		assertEquals(6, "propropro".lastIndexOf("pr"));
	}
	@Test
	public void lastIndexOf_inputValueIsExistAndFindAfterSomeIndex_returnNormalIndex(){
		assertEquals(3, "propropro".lastIndexOf("pr",5));
	}
	@Test
	public void toUpperCase_onlyEnglish_returnUppercase(){
		assertEquals(firstName_upper, firstName.toUpperCase());
	}
	@Test
	public void toUpperCase_withKorenAndNumber_returnOnlyEnglishUppercase(){
		assertEquals("HELLO1월드WORLD","hello1월드world".toUpperCase());
	}
}
