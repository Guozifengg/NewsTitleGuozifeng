package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.help.StreamUtils;
import xlistview.baiw.com.xlistview.XListView;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/12.
 * 作用：
 */
public class TitleFragment extends Fragment{

    private XListView xlv;
    private String result;
    private String titleType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=View.inflate(getActivity(), R.layout.fragment_title,null);
        xlv = (XListView) view1.findViewById(R.id.xlv);

        //接收值
        titleType = getArguments().getString("type");
        return view1;
    }

    //视图加载完成
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //子线程
        new Thread(){
            @Override
            public void run() {
                super.run();
                getData();

            }
        }.start();
    }

    public void getData(){

    }
}
