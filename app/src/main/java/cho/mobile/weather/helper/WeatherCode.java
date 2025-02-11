package cho.mobile.weather.helper;

import cho.mobile.weather.R;

public class WeatherCode {
    static int[] sunny = {0, 1};
    static int[] cloudy = {3};
    static int[] partiallyCloudy = {2};
    static int[] fog = {45, 48};
    static int[] drizzle = {51, 53, 55};
    static int[] rain = {61, 63, 80, 81};
    static int[] heavyRain = {65, 82};
    static int[] snowy = {56, 57, 66, 67, 71, 73, 77, 85};
    static int[] heavySnow = {75, 86};
    static int[] thunderstorm = {95, 96, 99};
    static int[][] arrKondisi = {sunny, cloudy, partiallyCloudy, fog, drizzle, rain, heavyRain, snowy, heavySnow, thunderstorm};
    static String[] stringKondisi = {"Sunny", "Cloudy", "Partially Cloudy", "Fog", "Drizzle", "Rain", "Heavy Rain", "Snowy", "Heavy Snow", "Thunderstorm"};
    static int[] kodeIcon = {R.drawable.sun, R.drawable.clouds, R.drawable.partially_cloudy, R.drawable.mist, R.drawable.rain,
            R.drawable.rain, R.drawable.rain, R.drawable.snow, R.drawable.snow, R.drawable.storm};

    public static String getKondisi(int weatherCode) {
        for (int i = 0; i < arrKondisi.length; i++) {
            for (int j = 0; j < arrKondisi[i].length; j++) {
                if (weatherCode == arrKondisi[i][j]){
                    return stringKondisi[i];
                }
            }
        }
        return "Cuaca Tidak Terdeteksi";
    }

    public static int getCodeIcon(int weatherCode) {
        for (int i = 0; i < arrKondisi.length; i++) {
            for (int j = 0; j < arrKondisi[i].length; j++) {
                if (weatherCode == arrKondisi[i][j]){
                    return kodeIcon[i];
                }
            }
        }
        return R.drawable.sun;
    }
}
