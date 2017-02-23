package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.adapter.VideoAdapter;
import guozifeng.bwie.com.newstitleguozifeng.bean.VideoBean;
import guozifeng.bwie.com.newstitleguozifeng.interfaces.DataInterface;
import guozifeng.bwie.com.newstitleguozifeng.requestData.HttpXutils;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/23.
 * 作用：
 */
public class VideoFragment extends Fragment implements DataInterface<VideoBean>,PullToRefreshListView.OnRefreshListener2{

    private PullToRefreshListView pulltoVideo;
    private String typeVideo;
    private int num=1;
    private int number=10;
    private Boolean flag=false;
    private String path;
    private VideoAdapter videoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=View.inflate(getActivity(), R.layout.video_fragment,null);

        typeVideo = getArguments().getString("typeVideo");
        initView(view1);
        return view1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        path = "http://c.3g.163.com/nc/video/list/"+typeVideo+"/n/"+num+"-"+number+".html";
        HttpXutils.utils(path,VideoBean.class,this);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    public void initView(View view){
        pulltoVideo = (PullToRefreshListView) view.findViewById(R.id.pulltoVideo);
        videoAdapter = new VideoAdapter(getActivity());
        pulltoVideo.setAdapter(videoAdapter);
        pulltoVideo.setMode(PullToRefreshBase.Mode.BOTH);
        pulltoVideo.setOnRefreshListener(this);
    }
    @Override
    public void setdata(List<VideoBean> t) {
        videoAdapter.setData(t,flag);
        videoAdapter.notifyDataSetChanged();
        pulltoVideo.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        num=1;
        number=10;
        flag=true;
        HttpXutils.utils(path,VideoBean.class,this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        num+=10;
        number+=10;
        flag=false;
        HttpXutils.utils(path, VideoBean.class,this);
    }
}
