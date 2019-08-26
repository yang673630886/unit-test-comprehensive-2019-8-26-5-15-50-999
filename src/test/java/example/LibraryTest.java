package example;/*
				* This Java source file was generated by the Gradle 'init' task.
				*/

import org.junit.jupiter.api.*;

import tw.commands.CalculationNumber;

import java.util.LinkedList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("A special tests collection for junit and mockito")
class LibraryTest {

	@BeforeAll
	static void initTestEnv() {
	}

	@BeforeEach
	void initEveryMethod() {
	}

	@Test
	@DisplayName("someLibraryMethod should return 'true'")
	void testSomeLibraryMethod() {
		Library classUnderTest = new Library();
		Assertions.assertTrue(classUnderTest.someLibraryMethod());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testMockClass() throws Exception {
		// you can mock concrete classes, not only interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing appears before the actual execution
		String value = "first";
		when(mockedList.get(0)).thenReturn(value);

		Assertions.assertEquals(value, mockedList.get(0));
	}

	@Test
	@SuppressWarnings("unchecked")
	void test_mock_verify() {
		// mock creation
		List<String> mockedList = mock(List.class);
		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();
		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	@Test
	void groupedAssertions() {
		// In a grouped assertion all assertions are executed, and any
		// failures will be reported together.
		String firstName = "John";
		String lastName = "Doe";

		assertAll("person", () -> assertEquals("John", firstName), () -> assertEquals("Doe", lastName));
	}

	@Test
	void exceptionTesting() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		Assertions.assertEquals("a message", exception.getMessage());
	}

	@Test
	@Disabled
	void timeoutExceeded() {
		// The following assertion fails with an error message similar to:
		// execution exceeded timeout of 10 ms by 91 ms
		assertTimeout(ofMillis(10), () -> {
			// Simulate task that takes more than 10 ms.
			Thread.sleep(100);
		});
	}

	@Test
	void should_4A4B_when_Main_Given_right_answer() {
		CalculationNumber calculationNumber = new CalculationNumber();
		int[] answerNumber = calculationNumber.setAnswerNumber();
		String prompt = calculationNumber.getResult(answerNumber);
		assertEquals("你的结果是：4A4B", prompt);
	}

	@Test
	void should_return_errorMessage_when_input_check_given_wrong_input() {
		CalculationNumber calculationNumber = new CalculationNumber();
		String actual = calculationNumber.checkInput("1111");
		assertEquals("您输入的数字或格式有误", actual);
	}

}
