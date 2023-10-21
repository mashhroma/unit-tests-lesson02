package seminars.fourth.webService;

public class HttpClient {

    private String url;

    HttpClient(String url){
        url = this.url;
    }

    public String get(String url){
        return "this page " + url;
    }
}
