package cho.mobile.weather.retrofit;

import cho.mobile.weather.MainModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("forecast?latitude=-7.98&longitude=112.63&daily=weathercode&current_weather=true&timezone=auto")
    Call<MainModel> getData();
}
