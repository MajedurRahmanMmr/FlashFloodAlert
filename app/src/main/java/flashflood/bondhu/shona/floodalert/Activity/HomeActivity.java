package flashflood.bondhu.shona.floodalert.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import flashflood.bondhu.shona.floodalert.Adapter.NavigationViewAdapter;
import flashflood.bondhu.shona.floodalert.Constant;
import flashflood.bondhu.shona.floodalert.Fragment.AccountFragment;
import flashflood.bondhu.shona.floodalert.Fragment.DataFragment;
import flashflood.bondhu.shona.floodalert.Fragment.HomeFragment;
import flashflood.bondhu.shona.floodalert.R;


public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private MenuItem menuItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        oneSignalInit();

        initComponent();

    }

    private void oneSignalInit() {

        OneSignal.sendTag(Constant.ALL_TAG,Constant.ALL);
        OneSignal.sendTag(Constant.ADMIN_TAG,Constant.ADMIN);
    }


    private void initActionListener() {

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home_menu:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.raw_menu:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.accountInfo_menu:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setUpPager(viewPager);
    }

    private void setUpPager(ViewPager viewPager) {

        NavigationViewAdapter adapter = new NavigationViewAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new DataFragment());

        adapter.addFragment(new AccountFragment());


        viewPager.setAdapter(adapter);
    }

    public void initComponent() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        initActionListener();

    }
}
