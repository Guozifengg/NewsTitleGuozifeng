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
import guozifeng.bwie.com.newstitleguozifeng.adapter.TitleAdapter;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/10.
 * 作用：
 */
public class Find extends Fragment{

    private View view1;
    private TabLayout tabLayoutFind;
    private ViewPager vpFind;
    private String[] titleVideo={"热点","娱乐","搞笑","精品","科技","电影","汽车",
            "笑话","游戏","时尚","情感"};
    private String[] videoId={"V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB","V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB","V9LG4B3A0","V9LG4CHOR","V9LG4E6VR"};
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view1 = View.inflate(getActivity(), R.layout.find,null);

        initView();

        return view1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFragment();
        TitleAdapter myAdapter = new TitleAdapter(getChildFragmentManager(),getActivity(),titleVideo);
        myAdapter.setList(list);
        //预加载
        vpFind.setOffscreenPageLimit(3);
        vpFind.setAdapter(myAdapter);
        tabLayoutFind.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayoutFind.setupWithViewPager(vpFind);
    }

    private void initFragment() {
        list = new ArrayList<>();
        for(int i=0;i<titleVideo.length;i++){
            VideoFragment fragment = new VideoFragment();
            Bundle args = new Bundle();
            args.putString("typeVideo", videoId[i]);
            fragment.setArguments(args);
            list.add(fragment);
        }
    }

    private void initView() {
        tabLayoutFind = (TabLayout) view1.findViewById(R.id.tabLayoutFind);
        vpFind = (ViewPager) view1.findViewById(R.id.vpFind);
    }


}
