package guozifeng.bwie.com.newstitleguozifeng;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import guozifeng.bwie.com.newstitleguozifeng.fragment.Find;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Focus;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Homepage;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Mine;
import guozifeng.bwie.com.newstitleguozifeng.night.ThemeManager;
import guozifeng.bwie.com.newstitleguozifeng.requestData.Message;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ThemeManager.OnThemeChangeListener {

    private TextView[] textArray;
    private ImageView[] imgArray;
    private int[] img;
    private int[] img1;
    private LinearLayout nightLyaout;
    private ActionBar supportActionBar;
    private RelativeLayout rlt;

    private TextView xxtz;
    private Fragment fragment;
    private Homepage homepagef;
    private Find findf;
    private Focus focusf;
    private Mine minef;

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
    private LinearLayout linear;
    private TextView dhx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册eventBus
        ThemeManager.registerThemeChangeListener(this);
        supportActionBar = getSupportActionBar();
        EventBus.getDefault().register(this);

        LinearLayout homell = (LinearLayout) findViewById(R.id.homell);
        homell.setOnClickListener(this);
        LinearLayout findll = (LinearLayout) findViewById(R.id.findll);
        findll.setOnClickListener(this);
        LinearLayout focusll = (LinearLayout) findViewById(R.id.focusll);
        focusll.setOnClickListener(this);
        LinearLayout mell = (LinearLayout) findViewById(R.id.mell);
        mell.setOnClickListener(this);

        TextView homepage = (TextView) findViewById(R.id.homepage);
        TextView find = (TextView) findViewById(R.id.find);
        TextView focus = (TextView) findViewById(R.id.focus);
        TextView me = (TextView) findViewById(R.id.me);

        ImageView homeimg = (ImageView) findViewById(R.id.homeimg);
        ImageView findimg = (ImageView) findViewById(R.id.findimg);
        ImageView focusimg = (ImageView) findViewById(R.id.focusimg);
        ImageView meimg = (ImageView) findViewById(R.id.meimg);

        textArray = new TextView[]{homepage,find,focus,me};

        imgArray = new ImageView[] {homeimg,findimg,focusimg,meimg};
        img = new int[]{R.mipmap.shou1,R.mipmap.vip1,R.mipmap.guanzhu1,R.mipmap.wode1};
        img1 = new int[]{R.mipmap.shou,R.mipmap.vip,R.mipmap.guanzhu,R.mipmap.wode};
//        addFragment(new Homepage());
        if(homepagef==null){
            homepagef = new Homepage();
        }
            addFragment(homepagef);

        setBackground(0);
        setColor(0);

        /*FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();
        tran.add(R.id.frame,new Homepage()).show(new Homepage())
                .add(R.id.frame,new Find()).hide(new Find())
                .add(R.id.frame,new Focus()).hide(new Focus())
                .add(R.id.frame,new Mine()).hide(new Mine());
        tran.commit();*/
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.homell:
                if(homepagef==null){
                    homepagef = new Homepage();
                }
                    addFragment(homepagef);

                setBackground(0);
                setColor(0);
                break;
            case R.id.findll:
                if(findf==null){
                    findf = new Find();
                }
                addFragment(findf);
                setBackground(1);
                setColor(1);
                break;
            case R.id.focusll:
                if(focusf==null){
                    focusf = new Focus();
                }
                addFragment(focusf);
                setBackground(2);
                setColor(2);
                break;
            case R.id.mell:
                if(minef==null){
                    minef = new Mine();
                }
                addFragment(minef);
                setBackground(3);
                setColor(3);
                break;
        }
    }

    public void addFragment(Fragment f){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragment!=null){
            transaction.hide(fragment);
        }if(!f.isAdded()){
            transaction.add(R.id.frame,f);
        }

        transaction.show(f);
        transaction.commit();
        fragment=f;
    }

    public void setColor(int index){
        for(int i=0;i<textArray.length;i++){
            if(i==index){
                textArray[i].setTextColor(Color.RED);
            }else{
                textArray[i].setTextColor(Color.BLACK);
            }
        }
    }

    public void setBackground(int index){
            for(int i=0;i<imgArray.length;i++){
                if(i==index){
                    imgArray[i].setImageResource(img[i]);
                }else{
                    imgArray[i].setImageResource(img1[i]);
                }
            }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvents(Message ev) {
        rlt = (RelativeLayout) findViewById(R.id.main_layout);
        linear = (LinearLayout) findViewById(R.id.ll);
        dhx = (TextView) findViewById(R.id.dhx);
        LinearLayout nightBack = ev.getYejian();
        xxtz = ev.getXxtz();
        ttsc=ev.getTtsc();
        jdtg=ev.getJdtg();
        wybl=ev.getWybl();
        yhfk=ev.getYhfk();
        xtsz=ev.getXtsz();
        shouji=ev.getShouji();
        qq=ev.getQq();
        weibo=ev.getWeibo();
        nightButton=ev.getNightButton();
        bjTextArray = ev.getBjTextArray();
        //设置监听
        nightBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);

            }
        });
    }

    //关于夜间模式
    public void initTheme() {
        xxtz.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        ttsc.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        jdtg.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        wybl.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        yhfk.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        xtsz.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        rlt.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
        // 设置标题栏颜色
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.colorPrimary))));
        }
        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.colorPrimary)));
        }

        Resources resources = getBaseContext().getResources();
        if(xxtz.getCurrentTextColor()==Color.BLACK){
            shouji.setImageResource(R.mipmap.shoujidenglu1);
            qq.setImageResource(R.mipmap.qqdenglu1);
            weibo.setImageResource(R.mipmap.weibodenglu1);
            nightButton.setImageResource(R.mipmap.yejian);
            for(int i=0;i<bjTextArray.length;i++){
                Drawable HippoDrawable = resources.getDrawable(R.drawable.bai);
                bjTextArray[i].setBackgroundDrawable(HippoDrawable);
            }
            Drawable HippoDrawable1 = resources.getDrawable(R.drawable.dh);
            Drawable HippoDrawable2 = resources.getDrawable(R.drawable.dhx);
            linear.setBackgroundDrawable(HippoDrawable1);
            dhx.setBackgroundDrawable(HippoDrawable2);
        }else{
            shouji.setImageResource(R.mipmap.shoujidenglu2);
            qq.setImageResource(R.mipmap.qqdenglu2);
            weibo.setImageResource(R.mipmap.weibodenglu2);
            nightButton.setImageResource(R.mipmap.rijian);
            for(int i=0;i<bjTextArray.length;i++){
//                Resources resources = getBaseContext().getResources();
                Drawable HippoDrawable = resources.getDrawable(R.drawable.yejian);
                bjTextArray[i].setBackgroundDrawable(HippoDrawable);
            }

            Drawable HippoDrawable1 = resources.getDrawable(R.drawable.dh1);
            Drawable HippoDrawable2 = resources.getDrawable(R.drawable.dhx1);
            linear.setBackgroundDrawable(HippoDrawable1);
            dhx.setBackgroundDrawable(HippoDrawable2);
        }
    }

    @Override
    public void onThemeChanged() {
        initTheme();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeManager.unregisterThemeChangeListener(this);
    }
}
