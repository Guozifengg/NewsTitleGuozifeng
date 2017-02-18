package guozifeng.bwie.com.newstitleguozifeng.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/12.
 * 作用：
 */
public class TitleAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    private Context context;
    private String[] title;
    public TitleAdapter(FragmentManager fm, Context context, String[] title) {
        super(fm);
        this.context=context;
        this.title=title;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
