package com.gl.llive.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gl.llive.R;
import com.gl.llive.fragment.HomeFragment;
import com.gl.llive.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.main_fl)
    ViewPager mainFL;
    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.live)
    ImageView live;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    private HomeFragment homeFragment;
    private MineFragment mineFragment;

    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        //定义底部标签图片大小
//        setImgSize(home, R.mipmap.tab_live_p, 10, 10, 50, 50);
//        setImgSize(mine, R.mipmap.tab_me_p, 10, 10, 50, 50);

        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(mineFragment);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        mainFL.setAdapter(fragmentPagerAdapter);
    }

    private void setImgSize(RadioButton view, int drawableId, int lr, int tb, int h, int w) {
        Drawable drawableHome = getResources().getDrawable(drawableId);
        drawableHome.setBounds(lr, tb, h, w);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        view.setCompoundDrawables(null, drawableHome, null, null);//只放上面
    }

    @OnClick({R.id.home, R.id.live, R.id.mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                mainFL.setCurrentItem(0);
                break;
            case R.id.live :
                Toast.makeText(this, "live", Toast.LENGTH_LONG).show();
                break;
            case R.id.mine:
                mainFL.setCurrentItem(1);
                break;
        }
    }

}
