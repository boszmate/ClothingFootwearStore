package com.mateusz.model.parser;

import com.mateusz.enums.Color;

public class ColorParser {
    public static Color parserStringToColor(String colorName) {
        String color = colorName.toUpperCase();

        switch (color) {
            case "BLACK":
                return Color.BLACK;
            case "BLUE":
                return Color.BLUE;
            case "RED":
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            case "YELLOW":
                return Color.YELLOW;
            case "WHITE":
                return Color.WHITE;
        }

        return Color.WHITE;
    }
}
