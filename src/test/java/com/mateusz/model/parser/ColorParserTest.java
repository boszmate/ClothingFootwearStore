package com.mateusz.model.parser;

import com.mateusz.enums.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {
    @Test
    public void testParseColorBlack() {
        String stringColor = "blaCK";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.BLACK, color);
    }

    @Test
    public void testParseColorWhite() {
        String stringColor = "White";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.WHITE, color);
    }

    @Test
    public void testParseColorRed() {
        String stringColor = "red";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.RED, color);
    }

    @Test
    public void testParseColorGreen() {
        String stringColor = "gREen";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.GREEN, color);
    }

    @Test
    public void testParseColorBlue() {
        String stringColor = "BLUe";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.BLUE, color);
    }

    @Test
    public void testParseColorYellow() {
        String stringColor = "yelloW";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.YELLOW, color);
    }

    @Test
    public void testParseWrongColor() {
        String stringColor = "qwerty";

        Color color = ColorParser.parserStringToColor(stringColor);

        Assert.assertEquals(Color.WHITE, color);
    }
}
