package net.rdyonline.catclowder.networking;

public enum CatApiPath {

    xmlList("/api/images/get?format=xml&type=png&api_key=Nzc2MDQ"),
    srcPng("/api/images/get?format=src&type=png&api_key=Nzc2MDQ");

    private final String mPath;

    CatApiPath(String path) {
        mPath = path;
    }

    public String getPath() {
        return mPath;
    }
}
