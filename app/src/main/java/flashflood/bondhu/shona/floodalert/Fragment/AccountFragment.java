package flashflood.bondhu.shona.floodalert.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import flashflood.bondhu.shona.floodalert.Activity.NotificationActivity;
import flashflood.bondhu.shona.floodalert.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {




    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        initActions(view);
        return view;
    }

    void initActions(View view){

        view.findViewById(R.id.sendNotificationToAllButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NotificationActivity.class));
            }
        });
    }

}
