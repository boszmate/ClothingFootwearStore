package com.mateusz.model.parser;

import com.mateusz.enums.Material;

public class MaterialParser {
    public static Material parserStringToMaterial(String materialName) {
        String material = materialName.toUpperCase();

        switch (material) {
            case "COTTON":
                return Material.COTTON;
            case "FUR":
                return Material.FUR;
            case "LEATHER":
                return Material.LEATHER;
            case "POLYESTERS":
                return Material.POLYESTERS;
            case "WOOL":
                return Material.WOOL;
        }

        return Material.POLYESTERS;
    }
}
