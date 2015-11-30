package com.company.samsalvail.drinkingbuddy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class PickCategoryActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    ViewPager viewPager;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_category);
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.company.samsalvail.drinkingbuddy",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }
        initViewPager();
        initTabHost();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        fragmentList.add(new SelectCoffeeActivityFragment());
        fragmentList.add(new SelectTeaActivityFragment());
        fragmentList.add(new SelectSodaActivityFragment());
        fragmentList.add(new SelectSportsActivityFragment());
        fragmentList.add(new SelectEnergyActivityFragment());
        fragmentList.add(new SelectBeerActivityFragment());

        MyPagerAdapter myFragmentsPagerAdapter = new MyPagerAdapter(getSupportFragmentManager()
                , fragmentList);
        viewPager.setAdapter(myFragmentsPagerAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void initTabHost() {

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        String[] tabNames = {"Coffee", "Tea", "Soda", "Sports","Energy", "Beer"};

        for(int i = 0; i < tabNames.length; i++) {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new PageContent(getApplicationContext()));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    // viewPager listener
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // tabHost listener
    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);

        HorizontalScrollView horizontalScrollView = (HorizontalScrollView)
                findViewById(R.id.h_scroll_view);

        View tabView = tabHost.getCurrentTabView();

        int scrollPos = tabView.getLeft() -
                (horizontalScrollView.getWidth() - tabView.getWidth()) / 2;

        horizontalScrollView.smoothScrollTo(scrollPos, 0);
    }

    public class PageContent implements TabHost.TabContentFactory {
        Context context;

        public PageContent(Context mcontext) {
            context = mcontext;
        }

        @Override
        public View createTabContent(String tag) {

            View myView = new View(context);
            myView.setMinimumHeight(0);
            myView.setMinimumHeight(0);

            return myView;
        }
    }
}
