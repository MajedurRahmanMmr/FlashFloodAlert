package flashflood.bondhu.shona.floodalert.Networking;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Majedur Rahman on 2/1/2018.
 */

public interface NetworkInterface {


    @POST("notifications")
    @Headers( {"Content-Type: application/json","Authorization: Basic YzNkOWJlMDAtNGExYi00MDUyLWJmNjMtYjA1YWZhMGIyNDYx"})
    Call<String> postNotification(@Body JSONObject jsonObject);
}
