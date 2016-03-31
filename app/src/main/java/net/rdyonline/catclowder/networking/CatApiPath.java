package net.rdyonline.catclowder.networking;

public enum CatApiPath {

    xmlList("/api/images/get?format=xml&type=png"),
    srcPng("/api/images/get?format=src&type=png");

    private final String mPath;

    CatApiPath(String path) {
        mPath = path;
    }

    public String getPath() {
        return mPath;
    }
}
