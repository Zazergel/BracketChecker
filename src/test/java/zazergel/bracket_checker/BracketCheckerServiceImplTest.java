package zazergel.bracket_checker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zazergel.bracket_checker.service.BracketCheckerServiceImpl;

class BracketCheckerServiceImplTest {
    BracketCheckerServiceImpl bracketCheckerServiceImpl = new BracketCheckerServiceImpl();


    @Test
    void testShouldBeTrue() {
        boolean result = bracketCheckerServiceImpl.isValidBracketPlacement("text with (correct) brackets.");
        boolean result2 = bracketCheckerServiceImpl.isValidBracketPlacement("text with ( correct) brackets.");
        boolean result3 = bracketCheckerServiceImpl.isValidBracketPlacement("text with (correct ) brackets.");
        boolean result4 = bracketCheckerServiceImpl.isValidBracketPlacement("(text with (correct) brackets.)");
        boolean result5 = bracketCheckerServiceImpl.isValidBracketPlacement("text (with (correct)) brackets.");
        Assertions.assertTrue(result);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
        Assertions.assertTrue(result4);
        Assertions.assertTrue(result5);
    }

    @Test
    void testShouldBeFalse() {
        boolean result = bracketCheckerServiceImpl.isValidBracketPlacement("text with incorrect) brackets.");
        boolean result2 = bracketCheckerServiceImpl.isValidBracketPlacement("text with (incorrect brackets.");
        boolean result3 = bracketCheckerServiceImpl.isValidBracketPlacement(") text with (incorrect) brackets.");
        boolean result4 = bracketCheckerServiceImpl.isValidBracketPlacement("text with incorrect () brackets.");
        boolean result5 = bracketCheckerServiceImpl.isValidBracketPlacement("text with incorrect (  ) brackets.");
        boolean result6 = bracketCheckerServiceImpl.isValidBracketPlacement("text with incorrect brackets.)");
        Assertions.assertFalse(result);
        Assertions.assertFalse(result2);
        Assertions.assertFalse(result3);
        Assertions.assertFalse(result4);
        Assertions.assertFalse(result5);
        Assertions.assertFalse(result6);
    }

}
