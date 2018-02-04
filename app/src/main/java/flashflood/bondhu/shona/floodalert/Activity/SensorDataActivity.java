package flashflood.bondhu.shona.floodalert.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import flashflood.bondhu.shona.floodalert.Adapter.DataFragmentRecyclerAdapter;
import flashflood.bondhu.shona.floodalert.Adapter.SensorDataAdapter;
import flashflood.bondhu.shona.floodalert.Constant;
import flashflood.bondhu.shona.floodalert.Model.DataItem;
import flashflood.bondhu.shona.floodalert.Model.SensorData;
import flashflood.bondhu.shona.floodalert.R;

public class SensorDataActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference deviceRef = database.getReference(Constant.FlashFloodRoot).child(Constant.DATA);

    ArrayList<DataItem> sensorDataList = new ArrayList<>();
    private SensorDataAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_data);
        initRecyclerView();
        String deviceId = getIntent().getStringExtra(Constant.Device);
        getRecentSensorData(deviceId);



    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.dataRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SensorDataAdapter(SensorDataActivity.this,sensorDataList);
        recyclerView.setAdapter(adapter);
    }

    private void getRecentSensorData(String deviceId) {
        if (deviceId != "") {
            deviceRef.child(deviceId + "").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                   SensorData sensorData =dataSnapshot.getValue(SensorData.class);
                   sensorDataList.add(new DataItem("Water Level : "+ sensorData.getWaterLevel() ,"",sensorData.getDateTime().toString()));
                   adapter.notifyDataSetChanged();
                   Log.e("Data " , sensorData.toString());

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        } else {

            Toast.makeText(this, " Device Id not Found !! ", Toast.LENGTH_SHORT).show();
        }
    }
}
