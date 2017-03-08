package com.gl.llive.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gl.llive.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

//    private LayoutInflater mInflater;
//    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
//    private View view1, view2;//页卡视图
//    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    private List<Fragment> fragmentList = new ArrayList<>();
    SelectFragment selectFragment;
    HotFragment hotFragment;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        selectFragment = new SelectFragment();
        hotFragment = new HotFragment();
        fragmentList.add(selectFragment);
        fragmentList.add(hotFragment);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewpager.setAdapter(fragmentPagerAdapter);

        initTab();


//        mInflater = LayoutInflater.from(getContext());
//        view1 = mInflater.inflate(R.layout.fragment_select, null);
//        view2 = mInflater.inflate(R.layout.fragment_hot, null);
//
//        //添加页卡视图
//        mViewList.add(view1);
//        mViewList.add(view2);
//
//        //添加页卡标题
//        mTitleList.add("精选");
//        mTitleList.add("热门");

//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
//        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
//        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(1)));
//
//        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
//        viewpager.setAdapter(mAdapter);//给ViewPager设置适配器
//        tabLayout.setupWithViewPager(viewpager);//将TabLayout和ViewPager关联起来。
//        tabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    private void initTab() {
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setTag("精选");
        tabLayout.getTabAt(0).setTag("热门");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //ViewPager适配器
    /*class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }*/
}
