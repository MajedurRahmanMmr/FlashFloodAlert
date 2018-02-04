package flashflood.bondhu.shona.floodalert.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import flashflood.bondhu.shona.floodalert.Adapter.DataFragmentRecyclerAdapter;
import flashflood.bondhu.shona.floodalert.Constant;
import flashflood.bondhu.shona.floodalert.Model.DataItem;
import flashflood.bondhu.shona.floodalert.Networking.NetworkManager;
import flashflood.bondhu.shona.floodalert.R;


public class DataFragment extends Fragment {
    NetworkManager networkManager;
    public  List<String> DeviceList = new ArrayList<>();
    ArrayList<DataItem> dataList = new ArrayList<>();
    public static FirebaseDatabase database = null;
    public static DatabaseReference sensorDataReferance = null;
    private DataFragmentRecyclerAdapter adapter;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_data, container, false);


        initRecyclerView(parentView);
        return parentView;
    }


    private void initRecyclerView(View view) {




        /***
         * Add Menu here
         */

        networkManager = new NetworkManager(getActivity());
        DeviceList = networkManager.getDevice();

    /*    dataList.add(new DataItem("Water Level - 7 ", "1:30 AM", "14/11/2017"));
        dataList.add(new DataItem("Water Level - 5 ", "9:00 PM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 6 ", "11:30 AM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 8 ", "5:00 AM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 7 ", "9:30 AM", "13/11/2017"));
        dataList.add(new DataItem("Water Level - 6 ", "1:00 PM", "12/11/2017"));
        dataList.add(new DataItem("Water Level - 5 ", "6:30 AM", "12/11/2017"));
        dataList.add(new DataItem("Water Level - 6 ", "10:50 PM", "11/11/2017"));
        if (DeviceList != null) {
            for (String str : DeviceList)
                dataList.add(new DataItem("Device " + str + " Water Level - 5 ", "12:05 AM", "11/11/2017"));
        }*/
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.dataRecycler);


        //   GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());

        adapter = new DataFragmentRecyclerAdapter(getActivity(), dataList);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);

        initDeviceList();
    }


    void initDeviceList(){
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            sensorDataReferance = database.getReference(Constant.FlashFloodRoot)
                    .child(Constant.DATA);
        }


        sensorDataReferance.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dataList.add(new DataItem("Device id :" + dataSnapshot.getKey() + "", "", ""));
                adapter.notifyDataSetChanged();
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

    @Override
    public void onStart() {
        super.onStart();
        networkManager.getDevice();

    }

    @Override
    public void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

    }
}
