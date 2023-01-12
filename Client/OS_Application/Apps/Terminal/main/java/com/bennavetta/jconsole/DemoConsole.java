/**
 * Copyright (C) 2022 By Super coder <pbyt998@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://github.com/phungbatam/TVN_OS
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bennavetta.jconsole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class DemoConsole {

    private static final String CONSOLE_NAME = "Console Demo";     

    private static final String ICON_IMAGE_FILE = "SomeImage.png"; 

    private static final Color BACKGROUND_COLOR = Color.BLACK;  
    private static final Color FOREGROUND_COLOR = Color.GREEN; 

    private static final Map<String, InputProcessor> commandMap = new HashMap<String, InputProcessor>(10);
    public static void main(String[] args) {

        InputProcessor clearScreen = new InputProcessor() {
            public void process(String[] args, Console console) {
                console.cls();
            }
        };

        InputProcessor terminateProgram = new InputProcessor() {
            public void process(String[] args, Console console) {
                System.exit(0);
            }
        };

        InputProcessor echo = new InputProcessor() {
            public void process(String[] args, Console console) {
                console.write(args[1]); // only echos the first word...
            }
        };

        InputProcessor IDontUnderstand = new InputProcessor() {
            public void process(String[] args, Console console) {
                console.write("Sorry, I don't understand that command \n");
            }
        };

        commandMap.put("cls", clearScreen);  

        commandMap.put("close", terminateProgram);
        commandMap.put("exit", terminateProgram);    

        commandMap.put("echo", echo);                

        commandMap.put("help", IDontUnderstand);

        JFrame frame = new JFrame(CONSOLE_NAME);
        try {
            frame.setIconImage(ImageIO.read(new File(ICON_IMAGE_FILE)));
        } catch (IOException e) {
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(677, 343);                    // Official Windows Command Prompt size, looks beautiful and can be resized

        //Init console
        Console console = new Console(Color.BLACK, Color.GREEN,
                new Font(Font.MONOSPACED, Font.BOLD, 14), "$ ");
        console.setPreferredSize(new Dimension(677, 343)); // Same as above

        console.setCompletionSource(new DefaultCompletionSource("help", "echo", "cls", "close", "exit")); // String commands go here as well.

        console.setProcessor(new InputProcessor() {
            private int requests = 0;

            public void process(String[] args, Console console) {
                //1. Print for debugging:
                System.out.println("Got Req. " + ++requests + ": '" + args[0] + "'");

                System.out.println("asked: " + Arrays.toString(args));
                //4. Process list of arguments
                if (args.length > 0 && commandMap.containsKey(args[0].toLowerCase())) {
                    commandMap.get(args[0].toLowerCase()).process(args, console);
                } else {
                    commandMap.get("help").process(args, console);
                }
            }
        });
        frame.add(console);
        frame.addComponentListener(console);
        frame.pack();
        console.setScreenHeight((int) frame.getContentPane().getSize().getHeight());
        frame.setVisible(true);
    }

    public static String removeQuotes(String arg) { //Param: a quote.
        return arg.substring(1, arg.length() - 1);
    }

}
