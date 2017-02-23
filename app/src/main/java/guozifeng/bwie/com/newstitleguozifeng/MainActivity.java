package guozifeng.bwie.com.newstitleguozifeng;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import guozifeng.bwie.com.newstitleguozifeng.fragment.Find;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Focus;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Homepage;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Mine;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView[] textArray;
    private ImageView[] imgArray;
    private int[] img;
    private int[] img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        addFragment(new Homepage());
        setBackground(0);
        setColor(0);

        //夜间模式
//        uiMode();
    }

    /*private void uiMode() {
        LinearLayout yejian = (LinearLayout) getSupportFragmentManager().findFragmentById(R.id.mineLayout).getView().findViewById(R.id.yejianmoshi);
        yejian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO
                        ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                // 同样需要调用recreate方法使之生效
                recreate();
            }
        });
    }*/

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.homell:
                addFragment(new Homepage());
                setBackground(0);
                setColor(0);
                break;
            case R.id.findll:
                addFragment(new Find());
                setBackground(1);
                setColor(1);
                break;
            case R.id.focusll:
                addFragment(new Focus());
                setBackground(2);
                setColor(2);
                break;
            case R.id.mell:
                addFragment(new Mine());
                setBackground(3);
                setColor(3);
                break;
        }
    }

    public void addFragment(Fragment fragment){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
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
}
