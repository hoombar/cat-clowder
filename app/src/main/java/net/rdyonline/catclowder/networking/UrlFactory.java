package net.rdyonline.catclowder.networking;

public class UrlFactory {

    static final String BASE_URL = "http://thecatapi.com";

    private UrlFactory() {}

    public static String get(CatApiPath url) {
        switch(url) {
            case xmlList:
                throw new IllegalArgumentException("XML is not yet implemented");

            case srcPng:
            default:
                return BASE_URL + url.getPath();
        }
    }

}
