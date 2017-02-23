package guozifeng.bwie.com.newstitleguozifeng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.bean.VideoBean;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/23.
 * 作用：
 */
public class VideoAdapter extends BaseAdapter {
    private Context context;
    private List<VideoBean> list=new ArrayList<VideoBean>();

    public VideoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public VideoBean getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        if(view==null){
            viewHolder = new ViewHolder();
            view=View.inflate(context, R.layout.video_lv,null);
            viewHolder.topname = (TextView) view.findViewById(R.id.topname);
            viewHolder.videoJc = (JCVideoPlayer) view.findViewById(R.id.videoJc);

            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }

        viewHolder.topname.setText(list.get(i).getTopicName());
        viewHolder.videoJc.setUp(list.get(i).getMp4_url(),list.get(i).getTitle());
        viewHolder.videoJc.ivThumb.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(list.get(i).getCover(),viewHolder.videoJc.ivThumb);
        return view;
    }

    public void setData(List<VideoBean> data, Boolean flag) {
        if(data!=null)
        {
            if(flag)
            {
                list.clear();
            }
            list.addAll(data);
        }
    }
    static class ViewHolder{

        public TextView topname;
        public JCVideoPlayer videoJc;
    }
}
