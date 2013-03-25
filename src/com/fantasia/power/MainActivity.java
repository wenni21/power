package com.fantasia.power;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends FragmentActivity {
	private TabHost mTabHost;
	private TabManager mTabManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
        
        mTabHost.setCurrentTab(0);//設定一開始就跳到第一個分頁
        mTabManager.addTab(
                mTabHost.newTabSpec("Fragment1").setIndicator("省电",
                this.getResources().getDrawable(
                    android.R.drawable.ic_dialog_alert)),Fragment1.class, null);
            mTabManager.addTab(
                mTabHost.newTabSpec("Fragment2").setIndicator("充电",
                this.getResources().getDrawable(
                    android.R.drawable.ic_lock_lock)),Fragment2.class, null);
            mTabManager.addTab(
                mTabHost.newTabSpec("Fragment3").setIndicator("排行",
                this.getResources().getDrawable(
                    android.R.drawable.ic_input_add)),Fragment3.class, null);
            mTabManager.addTab(
                mTabHost.newTabSpec("Fragment4").setIndicator("更多",
                this.getResources().getDrawable(
                    android.R.drawable.ic_delete)),Fragment4.class, null);
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //先取得螢幕解析度  
        int screenWidth = dm.widthPixels;   //取得螢幕的寬
        Log.v("test", String.valueOf(screenWidth));
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //取得tab的物件
        int count = tabWidget.getChildCount();   //取得tab的分頁有幾個
        int width=Math.round((screenWidth)/count)+10;
        Log.v("test", String.valueOf(width));
        for (int i = 0; i < count; i++) {   
            tabWidget.getChildTabViewAt(i).setMinimumWidth(width);//設定每一個分頁最小的寬度   
        }
	}
}
