package guozifeng.bwie.com.newstitleguozifeng.requestData;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import guozifeng.bwie.com.newstitleguozifeng.bean.Tid;
import guozifeng.bwie.com.newstitleguozifeng.help.StreamUtils;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/18.
 * 作用：
 */
public class HttpClient {

    private static String result;

    public static String requestData(String tid){
        String path="http://c.m.163.com/nc/article/headline/"+tid+"/0-20.html";
        try {
            URL url=new URL(path);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            int code=connection.getResponseCode();
            if(code==200){
                InputStream inputStream=connection.getInputStream();
                result = StreamUtils.parser(inputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
