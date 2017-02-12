package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.help.MyAdapter;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/10.
 * 作用：
 */
public class Homepage extends Fragment{
    private String[] title={"推荐","热点","阳光","体育","北京","社会","娱乐","财经"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=View.inflate(getActivity(), R.layout.homepage,null);

        tabLayout = (TabLayout) view1.findViewById(R.id.tablayout_title);
        viewPager = (ViewPager) view1.findViewById(R.id.viewpager);
        initData();

        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager(),getActivity(),title);
        myAdapter.setList(list);
        viewPager.setAdapter(myAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        return view1;
    }

    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            list.add(new TitleFragment());
        }
    }


}
