package flashflood.bondhu.shona.floodalert.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import flashflood.bondhu.shona.floodalert.Adapter.HomeRecyclerAdapter;
import flashflood.bondhu.shona.floodalert.Model.HomeItem;
import flashflood.bondhu.shona.floodalert.R;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_home, container, false);


        initRecyclerView(parentView);

        return parentView ;
    }

    private void initRecyclerView(View view) {


        ArrayList<HomeItem> homeItemArrayList = new ArrayList<>();


        /***
         * Add Menu here
         */
        homeItemArrayList.add(new HomeItem("Monthly Bar Chart",R.drawable.graph));
        homeItemArrayList.add(new HomeItem("Monthly Line Chart",R.drawable.linechart));
        homeItemArrayList.add(new HomeItem("Pie Chart",R.drawable.piechart));
        homeItemArrayList.add(new HomeItem("Monthly Overview",R.drawable.giphy));
        homeItemArrayList.add(new HomeItem("Monthly Bobble Chart" ,R.drawable.bubble));
        homeItemArrayList.add(new HomeItem("Current Weather",R.drawable.weather));

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycalerView);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
    //    LinearLayoutManager layout = new LinearLayoutManager(getActivity());

        HomeRecyclerAdapter adapter = new HomeRecyclerAdapter(getActivity(),homeItemArrayList );
        rv.setAdapter(adapter);
        rv.setLayoutManager(gridLayoutManager);

    }


}
