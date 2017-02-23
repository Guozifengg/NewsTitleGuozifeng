package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.activity.WebViewActivity;
import guozifeng.bwie.com.newstitleguozifeng.adapter.NewsAdapter;
import guozifeng.bwie.com.newstitleguozifeng.bean.JsonBean;
import guozifeng.bwie.com.newstitleguozifeng.interfaces.DataInterface;
import guozifeng.bwie.com.newstitleguozifeng.requestData.HttpXutils;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/12.
 * 作用：
 */
public class TitleFragment extends Fragment implements DataInterface<JsonBean>,PullToRefreshListView.OnRefreshListener2{

    private int homePage=0;
    private int endPage=20;
    private String titleType;
    private PullToRefreshListView pullto;
    private boolean flag=false;
    private String path;
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = View.inflate(getActivity(), R.layout.fragment_title, null);

        //接收值
        titleType = getArguments().getString("type");
        initView(view1);
        return view1;
    }

    //视图加载完成
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        path = "http://c.m.163.com/nc/article/headline/"+titleType+"/"+homePage+"-"+endPage+".html";
        HttpXutils.utils(path,JsonBean.class,this);
        }

    public void initView(View view){
        pullto = (PullToRefreshListView) view.findViewById(R.id.pullto);
        newsAdapter = new NewsAdapter(getActivity());
        pullto.setAdapter(newsAdapter);
        pullto.setMode(PullToRefreshBase.Mode.BOTH);
        pullto.setOnRefreshListener(this);

    }


    @Override
    public void setdata(final List<JsonBean> t) {

        newsAdapter.addData(t,flag);
        newsAdapter.notifyDataSetChanged();

        pullto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url",t.get(i).getUrl_3w());
                startActivity(intent);
            }
        });
        pullto.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

        homePage=0;
        endPage=20;
        flag=true;
        HttpXutils.utils(path,JsonBean.class,this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        homePage+=20;
        endPage+=20;
        flag=false;
        HttpXutils.utils(path,JsonBean.class,this);
    }
}
