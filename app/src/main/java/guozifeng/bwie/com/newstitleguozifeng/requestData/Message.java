package guozifeng.bwie.com.newstitleguozifeng.requestData;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/23.
 * 作用：
 */
public class Message {
    private LinearLayout yejian;
    private TextView xxtz;
    private TextView ttsc;
    private TextView jdtg;
    private TextView wybl;
    private TextView yhfk;
    private TextView xtsz;
    private ImageView shouji;
    private ImageView qq;
    private ImageView weibo;
    private ImageView nightButton;
    private TextView[] bjTextArray;

    public Message(LinearLayout yejian, TextView xxtz, TextView ttsc, TextView jdtg, TextView wybl, TextView yhfk, TextView xtsz, ImageView shouji, ImageView qq, ImageView weibo, ImageView nightButton, TextView[] bjTextArray) {
        this.yejian = yejian;
        this.xxtz = xxtz;
        this.ttsc = ttsc;
        this.jdtg = jdtg;
        this.wybl = wybl;
        this.yhfk = yhfk;
        this.xtsz = xtsz;
        this.shouji = shouji;
        this.qq = qq;
        this.weibo = weibo;
        this.nightButton = nightButton;
        this.bjTextArray = bjTextArray;
    }

    public LinearLayout getYejian() {
        return yejian;
    }

    public TextView getXxtz() {
        return xxtz;
    }

    public TextView getTtsc() {
        return ttsc;
    }

    public TextView getJdtg() {
        return jdtg;
    }

    public TextView getWybl() {
        return wybl;
    }

    public TextView getYhfk() {
        return yhfk;
    }

    public TextView getXtsz() {
        return xtsz;
    }

    public ImageView getShouji() {
        return shouji;
    }

    public ImageView getQq() {
        return qq;
    }

    public ImageView getWeibo() {
        return weibo;
    }

    public ImageView getNightButton() {
        return nightButton;
    }

    public TextView[] getBjTextArray() {
        return bjTextArray;
    }
}
