package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import guozifeng.bwie.com.newstitleguozifeng.R;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/12.
 * 作用：
 */
public class TitleFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=View.inflate(getActivity(), R.layout.fragment_title,null);
        return view1;
    }
}
