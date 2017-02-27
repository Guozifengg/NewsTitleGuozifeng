package guozifeng.bwie.com.newstitleguozifeng.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.night.ThemeManager;
import guozifeng.bwie.com.newstitleguozifeng.requestData.Message;

public class AddTitleActivity extends AppCompatActivity{

    private ActionBar supportActionBar;
    private RelativeLayout rlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_title);

    }


}
