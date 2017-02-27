package guozifeng.bwie.com.newstitleguozifeng.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import guozifeng.bwie.com.newstitleguozifeng.R;
import guozifeng.bwie.com.newstitleguozifeng.requestData.Message;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/10.
 * 作用：
 */
public class Mine extends Fragment{

    private LinearLayout yejian;
    private View view1;
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

    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105927999";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    private RelativeLayout enterSuccess;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            enterSuccess.setVisibility(View.VISIBLE);
            handler.sendEmptyMessageDelayed(0,3000);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view1 = View.inflate(getActivity(), R.layout.me,null);

        yejian = (LinearLayout) view1.findViewById(R.id.yejianmoshi);
        initView();
        return view1;
    }

    private void initView() {
        enterSuccess = (RelativeLayout) view1.findViewById(R.id.enterSuccess);
        xxtz = (TextView) view1.findViewById(R.id.xxtz);
        ttsc = (TextView) view1.findViewById(R.id.ttsc);
        jdtg = (TextView) view1.findViewById(R.id.jdtg);
        wybl = (TextView) view1.findViewById(R.id.wybl);
        yhfk = (TextView) view1.findViewById(R.id.yhfk);
        xtsz = (TextView) view1.findViewById(R.id.xtsz);

        shouji = (ImageView) view1.findViewById(R.id.shouji);
        qq = (ImageView) view1.findViewById(R.id.qq);
        weibo = (ImageView) view1.findViewById(R.id.weibo);
        nightButton = (ImageView) view1.findViewById(R.id.yejian);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //传入参数APPID和全局Context上下文
        mTencent = Tencent.createInstance(APP_ID,getActivity());

        yejian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new Message(yejian,xxtz,ttsc,jdtg,wybl,yhfk,xtsz,shouji,qq,weibo,nightButton));

            }
        });

        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(getActivity(),"all", mIUiListener);

                handler.sendEmptyMessageDelayed(0,3000);
            }
        });
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener{

        @Override
        public void onComplete(Object response) {
            Toast.makeText(getActivity(), "授权成功", Toast.LENGTH_SHORT).show();

            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getActivity(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(getActivity(), "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(getActivity(), "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
