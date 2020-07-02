package com.mateusz.model.parser;

import com.mateusz.enums.Material;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {
    @Test
    public void testParseMaterialLeather() {
        String stringMaterial = "Leather";

        Material material = MaterialParser.parserStringToMaterial(stringMaterial);

        Assert.assertEquals(Material.LEATHER, material);
    }

    @Test
    public void testParseMaterialFur() {
        String stringMaterial = "fUR";

        Material material = MaterialParser.parserStringToMaterial(stringMaterial);

        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void testParseMaterialCotton() {
        String stringMaterial = "cotton";

        Material material = MaterialParser.parserStringToMaterial(stringMaterial);

        Assert.assertEquals(Material.COTTON, material);
    }

    @Test
    public void testParseMaterialWool() {
        String stringMaterial = "WOOL";

        Material material = MaterialParser.parserStringToMaterial(stringMaterial);

        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void testParseMaterialPolyesters() {
        String stringMaterial = "polYESTers";

        Material material = MaterialParser.parserStringToMaterial(stringMaterial);

        Assert.assertEquals(Material.POLYESTERS, material);
    }

    @Test
    public void testParseWrongMaterial() {
        String stringMaterial = "ytwQw";

        Material material = MaterialParser.parserStringToMaterial(stringMaterial);

        Assert.assertEquals(Material.POLYESTERS, material);
    }
}
