package cho.mobile.weather.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String BASE_URL = "https://api.open-meteo.com/v1/";
    private static Retrofit retrofit;
    public static ApiEndPoint endpoint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiEndPoint.class);
    }
}
