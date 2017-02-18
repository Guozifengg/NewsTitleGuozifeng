package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.activity.AddTitleActivity;
import guozifeng.bwie.com.newstitleguozifeng.activity.SearchActivity;
import guozifeng.bwie.com.newstitleguozifeng.adapter.TitleAdapter;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/10.
 * 作用：
 */
public class Homepage extends Fragment{
    private String[] title={"头条","足球","娱乐","体育","财经","科技","电影","汽车","电影","汽车",
            "笑话","游戏","时尚","情感"};
    private String[] titleId={"T1348647909107","T1399700447917","T1348648517839","T1348649079062","T1348648756099",
            "T1348649580692","T1348648650048","T1348654060988", "T1350383429665","T1348654151579",
            "T1348650593803","T1348650839000"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;
    private LinearLayout searchll;
    private TextView addTitle;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=View.inflate(getActivity(), R.layout.homepage,null);

        searchll = (LinearLayout) view1.findViewById(R.id.searchll);
        editText = (EditText) view1.findViewById(R.id.editText);
        tabLayout = (TabLayout) view1.findViewById(R.id.tablayout_title);
        viewPager = (ViewPager) view1.findViewById(R.id.viewpager);
        addTitle = (TextView) view1.findViewById(R.id.addTitle);
        initData();
        //适配器
        TitleAdapter myAdapter = new TitleAdapter(getChildFragmentManager(),getActivity(),title);
        myAdapter.setList(list);
        //预加载
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(myAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        //搜索跳转
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //添加标题
        addTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AddTitleActivity.class);
                startActivity(intent);
            }
        });
        return view1;
    }

    //循环获取Fragment
    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            TitleFragment fragment=new TitleFragment();
            Bundle args = new Bundle();
            args.putString("type", titleId[i]);
            fragment.setArguments(args);
            list.add(fragment);
        }
    }


}
