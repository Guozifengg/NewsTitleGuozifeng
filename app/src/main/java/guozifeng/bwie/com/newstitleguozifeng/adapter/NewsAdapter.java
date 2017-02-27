package guozifeng.bwie.com.newstitleguozifeng.adapter;

import android.app.job.JobInfo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.bean.JsonBean;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/17.
 * 作用：
 */
public class NewsAdapter extends BaseAdapter {

    private Context context;
    private List<JsonBean> list=new ArrayList<>();

    final int TYPE_ITEM1=0;
    final int TYPE_ITEM2=1;
    final int TYPE_ITEM3=2;
    private DisplayImageOptions options;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public JsonBean getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        int type=getItemViewType(i);
        if(view==null){
            viewHolder = new ViewHolder();
            switch (type){
                case TYPE_ITEM1:
                    view=View.inflate(context, R.layout.xlv_layout1,null);
                    viewHolder.title1 = (TextView) view.findViewById(R.id.title1);
                    viewHolder.title12 = (TextView) view.findViewById(R.id.title12);
                    viewHolder.img11 = (ImageView) view.findViewById(R.id.img11);
                    break;
                case TYPE_ITEM2:
                    view=View.inflate(context, R.layout.xlv_layout2,null);
                    viewHolder.title2 = (TextView) view.findViewById(R.id.title2);
                    viewHolder.img21 = (ImageView) view.findViewById(R.id.img21);
                    viewHolder.img22 = (ImageView) view.findViewById(R.id.img22);
                    viewHolder.img23 = (ImageView) view.findViewById(R.id.img23);
                    break;
                case TYPE_ITEM3:
                    view=View.inflate(context, R.layout.xlv_layout3,null);
                    viewHolder.title3 = (TextView) view.findViewById(R.id.title3);
                    viewHolder.img31 = (ImageView) view.findViewById(R.id.img31);
                    break;
            }
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }

        options = new DisplayImageOptions.Builder().build();
        switch (type){
            case TYPE_ITEM1:
                viewHolder.title1.setText(list.get(i).getTitle());
                viewHolder.title12.setText(list.get(i).getSource());
                ImageLoader.getInstance().displayImage(list.get(i).getImgsrc(),viewHolder.img11,options);
                break;
            case TYPE_ITEM2:
                viewHolder.title2.setText(list.get(i).getTitle());
                ImageLoader.getInstance().displayImage(list.get(i).getImgsrc(),viewHolder.img21,options);
                ImageLoader.getInstance().displayImage(list.get(i).getImgextra().get(0).getImgsrc(),viewHolder.img22,options);
                ImageLoader.getInstance().displayImage(list.get(i).getImgextra().get(1).getImgsrc(),viewHolder.img23,options);
                break;
            case TYPE_ITEM3:
                viewHolder.title3.setText(list.get(i).getTitle());
                ImageLoader.getInstance().displayImage(list.get(i).getImgsrc(),viewHolder.img31,options);
                break;
        }

        return view;
    }

    public void addData(List<JsonBean> jsonBean,boolean flag){
        if(jsonBean!=null){
            if(flag){
                list.clear();
            }
            list.addAll(jsonBean);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

        JsonBean item=getItem(position);
        if(item.getImgextra()!=null&&item.getImgextra().size()>0){
            return TYPE_ITEM2;
        }else if(position%2==0){
            return TYPE_ITEM1;
        }else{
            return TYPE_ITEM3;
        }
    }

    static class ViewHolder{

        public TextView title1;
        public ImageView img11;
        public TextView title2;
        public ImageView img21;
        public ImageView img22;
        public ImageView img23;
        public TextView title3;
        public ImageView img31;
        public TextView title12;
    }
}
