import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MethodTest {

    private final InputStream originalSystemIn = System.in;
    private final Method testMethod = new Method();

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testValidateValid() {       //Valid testcase

        String testSentence = "Hello, this is one valid test!";
        testMethod.validate(testSentence);

        assertTrue(testMethod.invalidReason.isEmpty());
    }

    @Test
    public void testValidateCapitalAtStartInvalid() {       //Invalid testcase (no capital at the start)

        String testSentence = "this doesn't have a capital at the start.";
        testMethod.validate(testSentence);

        assertEquals("This sentence does not start with a capital letter", testMethod.invalidReason.get(0));
    }

    @Test
    public void testValidateEvenQuotationsInvalid() {       //Invalid testcase (odd number of quotation marks)

        String testSentence = "This doesn't have \"an equal number of quotations.";
        testMethod.validate(testSentence);

        assertEquals("This sentence does not have an even number of quotation marks", testMethod.invalidReason.get(0));
    }

    @Test
    public void testValidateEndsWithPunctuationInvalid() {       //Invalid testcase (no "!", "?", or "." at the end of the sentence)

        String testSentence = "This doesn't end with !, ?, or. so is invalid";
        testMethod.validate(testSentence);

        assertEquals("This sentence does not end with \".\", \"?\", or \"!\"", testMethod.invalidReason.get(0));
    }

    @Test
    public void testValidateContainsPeriodInvalid() {       //Invalid testcase (contains period that isn't at the end)

        String testSentence = "This has a misplaced. period.";
        testMethod.validate(testSentence);

        assertEquals("This sentence has a period character within it other than the last character", testMethod.invalidReason.get(0));
    }

    @Test
    public void testValidateContainsNumInvalid() {       //Invalid testcase (contains a number under 13 that isn't spelt out)

        String testSentence = "This has 13 not spelt out.";
        testMethod.validate(testSentence);

        assertEquals("This sentence contains a number below 13 that isn't spelt out", testMethod.invalidReason.get(0));
    }

    @Test
    public void testValidateInvalid() {       //Invalid testcase (all rules broken)

        String testSentence = "nothing. is c0rrect \"here";
        testMethod.validate(testSentence);

        assertEquals(5, testMethod.invalidReason.size());       //5 messaged should be within invalidReason Arraylist
    }
}
