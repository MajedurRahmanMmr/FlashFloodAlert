package flashflood.bondhu.shona.floodalert;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.onesignal.OneSignal;

import flashflood.bondhu.shona.floodalert.Notification.MyNotificationOpenedHandler;
import flashflood.bondhu.shona.floodalert.Notification.MyNotificationReceivedHandler;

public class MyApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }
    public RequestQueue requestQueue;
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;

        context = getApplicationContext();
        //MyNotificationOpenedHandler : This will be called when a notification is tapped on.
        //MyNotificationReceivedHandler : This will be called when a notification is received while your app is running.
        OneSignal.startInit(this)
                .setNotificationReceivedHandler(new MyNotificationReceivedHandler())
                .setNotificationOpenedHandler(new MyNotificationOpenedHandler())
                .autoPromptLocation(true)
                .disableGmsMissingPrompt(true).filterOtherGCMReceivers(true)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
    public static synchronized MyApplication getInstance()
    {
        return mInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue==null)
            requestQueue= Volley.newRequestQueue(getApplicationContext());

        return requestQueue;
    }
    public void addToRequestQueue(Request request, String tag)
    {
        request.setTag(tag);
        getRequestQueue().add(request);

    }

    /**
     Cancel all the requests matching with the given tag
     **/

    public void cancelAllRequests(String tag)
    {
        getRequestQueue().cancelAll(tag);
    }
}
