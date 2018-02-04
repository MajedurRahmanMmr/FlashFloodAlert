package flashflood.bondhu.shona.floodalert;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Majedur Rahman on 2/1/2018.
 */

public class Constant {
    /**
     * User Constant Area
     **/
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    public static final String EMPLOYEE = "EMPLOYEE";
    public static final String ALL = "ALL";
    public static final String USER_TAG = "_user";
    public static final String ADMIN_TAG = "_admin";
    public static final String EMPLOYEE_TAG = "_employee";
    public static final String ALL_TAG = "_all";


    /**
     * API Constant Area
     **/

    public static final String OSNotification_URL = "https://onesignal.com/api/v1/";

    /**
     *
     * Firebase Constant
     */

    private static final String TAG = "Message recieved";
    public static FirebaseDatabase database;
    public static DatabaseReference myRef;
    public static final String WaterLevel = "WaterLevel:";
    public static final String DeviceId = "DeviceId:";
    public static final String AreaId = "AreaId:";
    public static final String TOKEN = "Token:HwoEweVdFGks==";
    public static final String Time = "Time:";
    public static final String FlashFloodRoot = "FlashFloodRoot";
    public static final String DATA = "sensorData";
    public static final String Device = "DeviceId";
    /**
     *
     * Water Level Constant
     */

    public static int HIGH = 30;
    public static int Low = 20;
    public static int MID = 10;
}
