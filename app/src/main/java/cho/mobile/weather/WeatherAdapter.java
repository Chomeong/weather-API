package cho.mobile.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cho.mobile.weather.helper.WeatherCode;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.VHWeather> {
    private List<String> dates;
    private List<Integer> weatherCodes;
    private int size;
    Context context;
    public WeatherAdapter(List<String> dates, List<Integer> weatherCodes, int size, Context context) {
        this.dates = dates;
        this.weatherCodes = weatherCodes;
        this.context = context;
        this.size = size;
    }

    @NonNull
    @Override
    public VHWeather onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item, parent, false);

        return new VHWeather(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHWeather holder, int position) {
        holder.tvDailyWeather.setText(WeatherCode.getKondisi(weatherCodes.get(position)));
        holder.tvDailyDate.setText(dates.get(position));
        holder.ivDailyWeather.setImageResource(WeatherCode.getCodeIcon(weatherCodes.get(position)));
    }

    @Override
    public int getItemCount() {
        return size;
    }

    class VHWeather extends RecyclerView.ViewHolder{
        private TextView tvDailyWeather, tvDailyDate;
        private ImageView ivDailyWeather;

        public VHWeather(@NonNull View itemView) {
            super(itemView);

            tvDailyWeather = (TextView) itemView.findViewById(R.id.tvKondisi);
            tvDailyDate = (TextView) itemView.findViewById(R.id.tvTanggal);
            ivDailyWeather = (ImageView) itemView.findViewById(R.id.ivDailyWeather);
        }


    }

}
