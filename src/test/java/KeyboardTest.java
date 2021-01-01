import org.junit.BeforeClass;
import org.junit.Test;
import sample.Keyboard;

import java.awt.*;

public class KeyboardTest {

    @Test
    public void testDigitChecker() {
        assert Character.isDigit('1') == true;
    }

    @Test
    public void testDigit() {
        Keyboard keyboard = null;
        try {
            keyboard = new Keyboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        keyboard.pressCharacter('1');
    }

    @Test
    public void testCharacter() {
        Keyboard keyboard = null;
        try {
            keyboard = new Keyboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        keyboard.pressCharacter('A');
    }

    @Test
    public void testApostrophe() {
        Keyboard keyboard = null;
        try {
            keyboard = new Keyboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        keyboard.pressCharacter('\'');
    }

}
