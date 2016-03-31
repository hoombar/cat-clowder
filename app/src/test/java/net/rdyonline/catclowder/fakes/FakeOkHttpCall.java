package net.rdyonline.catclowder.fakes;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public class FakeOkHttpCall implements Call {

    private static final String FAKE_URL = "http://address.fake.url";
    private long mContentLength = 0;
    private BufferedSource mResponseBody;
    private Request mOriginalRequest;

    public FakeOkHttpCall() {
        this(new Request.Builder().url(FAKE_URL).build());
    }

    private FakeOkHttpCall(Request originalRequest) {
        mOriginalRequest = originalRequest;
    }

    public void setResponseBody(BufferedSource responseBody, long contentLength) {
        mResponseBody = responseBody;
        mContentLength = contentLength;
    }

    @Override
    public Request request() {
        return null;
    }

    @Override
    public Response execute() throws IOException {
        ResponseBody body = ResponseBody.create(null, mContentLength, mResponseBody);
        return new Response.Builder()
                .body(body)
                .request(mOriginalRequest)
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .build();
    }

    @Override
    public void enqueue(Callback responseCallback) {}

    @Override
    public void cancel() {}

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public boolean isCanceled() {
        return false;
    }
}