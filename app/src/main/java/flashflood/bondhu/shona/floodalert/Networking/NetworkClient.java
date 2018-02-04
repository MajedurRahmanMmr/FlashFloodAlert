package flashflood.bondhu.shona.floodalert.Networking;

import flashflood.bondhu.shona.floodalert.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Majedur Rahman on 2/1/2018.
 */

public class NetworkClient {


    public static Retrofit retrofit = null;

    public static Retrofit getApicLient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(Constant.OSNotification_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }

}
