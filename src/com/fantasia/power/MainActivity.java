package com.fantasia.power;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
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
        
        mTabHost.setCurrentTab(0);//�O��һ�_ʼ��������һ�����
        mTabManager.addTab(
                mTabHost.newTabSpec("Fragment1").setIndicator("ʡ��",
                this.getResources().getDrawable(
                    android.R.drawable.ic_dialog_alert)),Fragment1.class, null);
            mTabManager.addTab(
                mTabHost.newTabSpec("Fragment2").setIndicator("Fragment2",
                this.getResources().getDrawable(
                    android.R.drawable.ic_lock_lock)),Fragment2.class, null);
            mTabManager.addTab(
                mTabHost.newTabSpec("Fragment3").setIndicator("Fragment3",
                this.getResources().getDrawable(
                    android.R.drawable.ic_input_add)),Fragment3.class, null);
            mTabManager.addTab(
                mTabHost.newTabSpec("Fragment4").setIndicator("Fragment4",
                this.getResources().getDrawable(
                    android.R.drawable.ic_delete)),Fragment4.class, null);
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //��ȡ��ΞĻ������  
        int screenWidth = dm.widthPixels;   //ȡ��ΞĻ�Č�
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //ȡ��tab�����
        int count = tabWidget.getChildCount();   //ȡ��tab�ķ���Ўׂ�
        if (count > 3) {   
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i)
                      .setMinimumWidth((screenWidth)/3);//�O��ÿһ�������С�Č���   
            }   
        }
	}
}
