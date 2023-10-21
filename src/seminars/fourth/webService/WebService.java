package seminars.fourth.webService;

public class WebService {
    private HttpClient httpClient;

    WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
        public String getPage(String page){
            return httpClient.get(page);
        }
}
