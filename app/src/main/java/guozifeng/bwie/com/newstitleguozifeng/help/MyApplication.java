package guozifeng.bwie.com.newstitleguozifeng.help;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/18.
 * 作用：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Xutils
        x.Ext.init(this);
        //初始化ImageLoader
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
    }
}
