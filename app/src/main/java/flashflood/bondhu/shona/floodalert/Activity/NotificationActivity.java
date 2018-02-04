package flashflood.bondhu.shona.floodalert.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import flashflood.bondhu.shona.floodalert.Constant;
import flashflood.bondhu.shona.floodalert.MyApplication;
import flashflood.bondhu.shona.floodalert.Networking.NetworkClient;
import flashflood.bondhu.shona.floodalert.Networking.NetworkInterface;
import flashflood.bondhu.shona.floodalert.R;
import retrofit2.Callback;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.NotificationCArd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    SendRequest();


            }
        });
    }

    void SendRequest(){

        //OneSignal.postNotification();
    }
}
