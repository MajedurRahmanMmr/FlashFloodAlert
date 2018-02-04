package flashflood.bondhu.shona.floodalert.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import flashflood.bondhu.shona.floodalert.R;


public class AppHome extends AppCompatActivity {

    private int activitynuber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent FlagActivity = getIntent();

        activitynuber = FlagActivity.getIntExtra("activity", -1);


    }

    public void onClick(View view) {

        if (activitynuber != -1) {

        }


    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
