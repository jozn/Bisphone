package cz.msebera.android.httpclient;

public class ProtocolException extends HttpException {
    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Throwable th) {
        super(str, th);
    }
}
