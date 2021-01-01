package sample;

import javafx.scene.input.KeyCode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Keyboard {

    Robot robot = new Robot();

    public Keyboard() throws AWTException {

    }

    public void pressCharacter(char key) {
        List<Integer> keysToPress = new ArrayList<>();
        if (Character.isAlphabetic(key) || Character.isDigit(key)) {
            if (Character.isUpperCase(key)) {
                keysToPress.add(KeyCode.SHIFT.getCode());
            }
            String strVersion = String.valueOf(key).toUpperCase();
            if (Character.isDigit(key)) {
                strVersion = "DIGIT" + strVersion;
            }
            keysToPress.add(KeyCode.valueOf(strVersion).getCode());
        }
        else {
            switch (key) {
                case '\'':
                    keysToPress.add(KeyCode.QUOTE.getCode());
                    break;
                case '¬':
                    keysToPress.add(KeyCode.ENTER.getCode());
                    break;
                case ' ':
                    keysToPress.add(KeyCode.SPACE.getCode());
                    break;
                case ',':
                    keysToPress.add(KeyCode.COMMA.getCode());
                    break;
                case '.':
                    keysToPress.add(KeyCode.PERIOD.getCode());
                    break;
                case '!':
                    keysToPress.add(KeyCode.EXCLAMATION_MARK.getCode());
                    break;
                case '?':
                    keysToPress.add(KeyCode.SHIFT.getCode());
                    keysToPress.add(KeyCode.SLASH.getCode());
                    break;
                case '-':
                    keysToPress.add(KeyCode.MINUS.getCode());
                    break;
                case ';':
                    keysToPress.add(KeyCode.SEMICOLON.getCode()); break;
                case ':':
                    keysToPress.add(KeyCode.COLON.getCode()); break;
                default:
                    keysToPress.add(KeyCode.valueOf(String.valueOf(key).toUpperCase()).getCode());
            }
        }
        pressKeys(keysToPress);
    }

    private void pressKeys(List<Integer> keys) {
        try {
            for (Integer key : keys) {
                robot.keyPress(key);
            }
            for (Integer key : keys) {
                robot.keyRelease(key);
            }
        }catch(IllegalArgumentException e) {


        }

    }

}



