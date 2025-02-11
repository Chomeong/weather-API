package cho.mobile.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cho.mobile.weather.helper.WeatherCode;
import cho.mobile.weather.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private WeatherAdapter weatherAdapter;
    private TextView tvWeather, tvTemperature, tvWindSpeed, tvCondition, tvCoordinate;
    private ImageView ivWeather;
    private RecyclerView rvWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTemperature = findViewById(R.id.tvTemperature);
        tvWindSpeed = findViewById(R.id.tvWindSpeed);
        tvCondition = findViewById(R.id.tvCondition);
        tvCoordinate = findViewById(R.id.tvCoordinate);
        tvWeather = findViewById(R.id.tvWeather);
        ivWeather = findViewById(R.id.ivDailyWeather);
        rvWeather = findViewById(R.id.rvWeather);
        getDataFromRetrofit();
    }

    private void getDataFromRetrofit() {
        ApiService.endpoint().getData().enqueue(new Callback<MainModel>()  {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                if (response.isSuccessful()){
                    MainModel data = response.body();
                    ivWeather.setImageResource(WeatherCode.getCodeIcon(data.getCurrent_weather().getWeathercode()));
                    tvTemperature.setText(data.getCurrent_weather().getTemperature() + "°C");
                    tvCondition.setText(WeatherCode.getKondisi(data.getCurrent_weather().getWeathercode()));
                    tvWindSpeed.setText("Windspeed : " + data.getCurrent_weather().getWindspeed());
                    tvCoordinate.setText("Koordinat : " + data.getLatitude() + ", " + data.getLongitude());

                    weatherAdapter = new WeatherAdapter(data.getDaily().getTime(), data.getDaily().getWeathercode(), data.getDaily().getTime().size(), MainActivity.this);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    rvWeather.setLayoutManager(layoutManager);
                    rvWeather.setHasFixedSize(true);
                    rvWeather.setAdapter(weatherAdapter);

                    Log.d(TAG, data.toString());
                }
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}