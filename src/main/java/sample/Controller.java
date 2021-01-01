package sample;

import javafx.scene.input.KeyCode;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {


    public void startTyping() {
        new Thread(() -> {
            Keyboard keyboard = null;
            try {
                keyboard = new Keyboard();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            List<Character> keysToType = null;
            try {
                keysToType = loadBeeMovieScript();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Character character : keysToType) {
                keyboard.pressCharacter(character);
                try {
                    Thread.sleep(90);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private List<Character> loadBeeMovieScript() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("../beemoviescript.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        List<Character> keysToType = new ArrayList<>();
        for (String string : lines) {
            for (char character : string.toCharArray()) {
                keysToType.add(character);
            }
            keysToType.add('¬');
        }
        return keysToType;
    }

}
