package net.rdyonline.catclowder.networking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class UrlFactoryTest {

    @Test
    public void xmlShouldThrowIllegalArgException() {
        try {
            UrlFactory.get(CatApiPath.xmlList);
            fail("Exception should have been thrown");
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage()).contains("XML");
        }
    }

    @Test
    public void srcPngShouldHaveFullUrl() {
        String url = UrlFactory.get(CatApiPath.srcPng);
        assertThat(url).isEqualTo("http://thecatapi.com/api/images/get?format=src&type=png");
    }

}