import winter.hell.http.HttpRequest;
import winter.hell.http.HttpResponseEntity;

/**
 * Created by ZGY on 16/2/19.
 */
public class Test {

    static HttpRequest httpRequest = new HttpRequest();
    static String url = "http://www.daxiushow.com/viewmore.html?tag=all";
    public static void main(String[] args) {
        for(int i = 0;i<250;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                try {
                                    long time1 = System.currentTimeMillis();
                                    HttpResponseEntity response = httpRequest.doRequest(url, null, null, "utf-8");
                                    System.out.println(System.currentTimeMillis()-time1);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            ).start();
        }
    }
}
