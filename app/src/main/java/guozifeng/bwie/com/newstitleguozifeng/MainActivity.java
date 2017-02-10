package guozifeng.bwie.com.newstitleguozifeng;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import guozifeng.bwie.com.newstitleguozifeng.fragment.Find;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Focus;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Homepage;
import guozifeng.bwie.com.newstitleguozifeng.fragment.Me;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private TextView[] textArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView homepage = (TextView) findViewById(R.id.homepage);
        homepage.setOnClickListener(this);
        TextView find = (TextView) findViewById(R.id.find);
        find.setOnClickListener(this);
        TextView focus = (TextView) findViewById(R.id.focus);
        focus.setOnClickListener(this);
        TextView me = (TextView) findViewById(R.id.me);
        me.setOnClickListener(this);

        textArray = new TextView[]{homepage,find,focus,me};

        addFragment(new Homepage());
        setColor(0);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.homepage:
                addFragment(new Homepage());
                setColor(0);
                break;
            case R.id.find:
                addFragment(new Find());
                setColor(1);
                break;
            case R.id.focus:
                addFragment(new Focus());
                setColor(2);
                break;
            case R.id.me:
                addFragment(new Me());
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
}
