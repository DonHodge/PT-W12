package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	static Stream <Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(-3, 5, 88, true),
				arguments(0, 7, 7, true),
				arguments(5, 5, 10, false),
				arguments(5, 0, 5, true)
				);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(3, 5)).isEqualTo(8);
	}

	@Test
	void assertThatReversedStringIsAPalindrome() {
		assertThat(testDemo.isPalindrome("racecar")).isEqualTo(true);
		assertThat(testDemo.isPalindrome("mOm")).isEqualTo(true);
		assertThat(testDemo.isPalindrome("DAd")).isEqualTo(true);
		assertThat(testDemo.isPalindrome("Deven")).isEqualTo(false);
		assertThat(testDemo.isPalindrome("what is this")).isEqualTo(false);
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(6).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(36);
	}

}