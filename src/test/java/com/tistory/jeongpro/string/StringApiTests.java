package com.tistory.jeongpro.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

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
	@Test
	public void toLowerCase_onlyEnglish_returnLowerCase(){
		assertEquals("hello", "HELLO".toLowerCase());
	}
	@Test
	public void toLowerCase_withKoreanAndNumber_returnOnlyEnglishLowercase(){
		assertEquals("hello123월드world", "HELLO123월드WORLD".toLowerCase());
	}
	@Test
	public void trim_existPrefixBlank_returnRemovedPrefixBlank(){
		assertEquals("helloworld", "       helloworld".trim());
	}
	@Test
	public void trim_existU205FEmptyString_returnCantTrim(){
		String str = "hello\u205F";
		assertEquals(str, str.trim());
	}
	@Test
	public void trim_existBlankBetweenWordAndWord_returnExistBlank(){
		assertEquals("h e l l o", "h e l l o".trim());
	}
	@Test
	public void trim_existOnlyBlank_returnBlank(){
		assertEquals("", "         ".trim());
	}
	@Test
	public void subString_startIndex_returnRemainStringIndexToEnd(){
		assertEquals("loworld", "helloworld".substring(3));
	}
	@Test
	public void subString_NegativeIndex_returnThrow(){
		assertThrows(IndexOutOfBoundsException.class, ()->"helloworld".substring(-1));
	}
	@Test
	public void subString_OverflowIndex_returnThrow(){
		assertThrows(IndexOutOfBoundsException.class, ()->"helloworld".substring(1000));
	}
	@Test
	public void subString_StartIndexWithEndIndex_returnMiddleString(){
		assertEquals("java", "hellojavaworld".substring(5,9));
	}
	@Test
	public void split_NoneMatchPattern_returnOriginString(){
		String[] stringArray = firstName.split("hello");
		assertEquals(1, stringArray.length);
		assertEquals(firstName, stringArray[0]);
	}
	@Test
	public void split_specifyChar_returnStringArray(){
		String[] stringArray = "pro,jeong,hello".split(",");
		assertEquals(3, stringArray.length);
		assertEquals(firstName, stringArray[0]);
	}
	@Test
	public void split_regex_returnStringArray(){
		String[] stringArray = "a-ab-bc-bd-abc-aa-bbc".split("a+");
		assertEquals(5, stringArray.length);
	}
	@Test
	public void split_regexOnlyDot_returnLengthZeroArray(){
		String[] stringArray = "i wanna make a money".split(".");
		assertEquals(0, stringArray.length);
	}
	@Test
	public void split_limit3_returnLengthThreeStringArray(){
		String[] stringArray = "http://192.168.0.111:19000/posts.world.hello.aa".split("\\.",3);
		for(int i=0;i<stringArray.length;i++){
			System.out.println(stringArray[i]);
		}
		assertEquals(3, stringArray.length);
	}
	@Test
	public void matches_existChar_returnTrue(){
		assertTrue(firstName.matches("p.*"));
	}
	@Test
	public void matches_notExistChar_returnFalse(){
		assertFalse(firstName.matches("hello"));
	}
	@Test
	public void matches_existRegexIpPattern_returnTrue(){
		assertTrue("http://192.168.0.111:8080".matches("(?:https?)://(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]):(6553[0-5]|655[0-2][0-9]|65[0-4][0-9][0-9]|6[0-4][0-9][0-9][0-9]|\\d{2,4}|[1-9]).*"));
	}
	@Test
	public void strip_existU205F_returnTrimString(){
		String stringWithWhiteSpace = "hello\u205F";
		System.out.println(stringWithWhiteSpace + "world");
		assertEquals("hello", stringWithWhiteSpace.strip());
	}
}
