package guozifeng.bwie.com.newstitleguozifeng.requestData;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import guozifeng.bwie.com.newstitleguozifeng.interfaces.DataInterface;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/18.
 * 作用：
 */
public class HttpXutils {

    public static <T>void utils(String url,final Class<T> clazz,final DataInterface dataInterface) {

        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                List<T> beanList = new ArrayList<T>();
                try {
                    JSONObject resultObject = new JSONObject(result);
                    Iterator<String> keys = resultObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray nextArray = resultObject.optJSONArray(next);
                        for (int i = 0; i < nextArray.length(); i++) {
                            JSONObject object = nextArray.optJSONObject(i);
                            T tBean = gson.fromJson(object.toString(), clazz);
                            beanList.add(tBean);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                dataInterface.setdata(beanList);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("zzz", "onError " + ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("zzz", "onCancelled");
            }

            @Override
            public void onFinished() {
                Log.d("zzz", "onFinished");
            }
        });
    }
}
