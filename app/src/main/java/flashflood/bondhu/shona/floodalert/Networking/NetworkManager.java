package flashflood.bondhu.shona.floodalert.Networking;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import flashflood.bondhu.shona.floodalert.Constant;

/**
 * Created by Majedur Rahman on 2/4/2018.
 */

public class NetworkManager {

    // Write a message to the database
    public  FirebaseDatabase database;
    public  DatabaseReference sensorDataReferance;

    List<String> DeviceList;

    public NetworkManager(Context context) {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            sensorDataReferance = database.getReference(Constant.FlashFloodRoot)
                    .child(Constant.DATA);
            DeviceList = new ArrayList<>();
        }
    }

    public List<String> getDevice(){

        if (sensorDataReferance!=null) {
            sensorDataReferance.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.e("Devicc ID", dataSnapshot.getKey());
                    DeviceList.add(dataSnapshot.getKey());

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
        }

        return DeviceList;
    }


}
