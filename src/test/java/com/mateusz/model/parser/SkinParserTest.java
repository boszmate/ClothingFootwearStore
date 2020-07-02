package com.mateusz.model.parser;

import com.mateusz.enums.SkinType;
import org.junit.Assert;
import org.junit.Test;

public class SkinParserTest {
    @Test
    public void testParseNatural() {
        String stringSkinType = "NatuRAl";

        SkinType skinType = SkinParser.parserStringToSkin(stringSkinType);

        Assert.assertEquals(SkinType.NATURAL, skinType);
    }

    @Test
    public void testParseArtificial() {
        String stringSkinType = "artificial";

        SkinType skinType = SkinParser.parserStringToSkin(stringSkinType);

        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }

    @Test
    public void testParseWrongType() {
        String stringSkinType = "iltjs";

        SkinType skinType = SkinParser.parserStringToSkin(stringSkinType);

        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }
}
