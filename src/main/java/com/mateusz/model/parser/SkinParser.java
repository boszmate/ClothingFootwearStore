package com.mateusz.model.parser;

import com.mateusz.enums.SkinType;

public class SkinParser {
    public static SkinType parserStringToSkin(String skinName) {
        String skin = skinName.toUpperCase();

        switch (skin) {
            case "NATURAL":
                return SkinType.NATURAL;
            case "ARTIFICIAL":
                return SkinType.ARTIFICIAL;
        }

        return SkinType.ARTIFICIAL;
    }
}
