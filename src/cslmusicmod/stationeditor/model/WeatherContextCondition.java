package cslmusicmod.stationeditor.model;

public class WeatherContextCondition extends ContextCondition {

    public static IntRange TEMPERATURE_RANGE_BORDERS = new IntRange(-100, 100);
    public static IntRange DEFAULT_TEMPERATURE_RANGE = TEMPERATURE_RANGE_BORDERS;
    public static IntRange WEATHER_RANGE_BORDERS = new IntRange(0, 10);
    public static IntRange DEFAULT_WEATHER_RANGE = WEATHER_RANGE_BORDERS;

    private String type = "weather";
    private IntRange temperature;
    private IntRange rain;
    private IntRange cloudy;
    private IntRange foggy;
    private IntRange rainbow;
    private IntRange northernlights;
    private boolean not;

    public WeatherContextCondition() {
        temperature = new IntRange(-100, 100);
        rain = new IntRange(0, 10);
        cloudy = new IntRange(0, 10);
        foggy = new IntRange(0, 10);
        rainbow = new IntRange(0, 10);
        northernlights = new IntRange(0, 10);
        not = false;
    }

    public WeatherContextCondition(Station station) {
        this();
        setStation(station);
    }

    public WeatherContextCondition(WeatherContextCondition original, Station parent) {
        this.setStation(parent);
        this.temperature = new IntRange(original.temperature);
        this.rain = new IntRange(original.rain);
        this.cloudy = new IntRange(original.cloudy);
        this.foggy = new IntRange(original.foggy);
        this.rainbow = new IntRange(original.rainbow);
        this.northernlights = new IntRange(original.northernlights);
        this.not = original.not;
    }

    @Override
    public String getType() {
        return "weather";
    }

    @Override
    public String getSummary() {

        String sum = (not ? "Not " : "");
        int count = 0;

        if(!temperature.equals(DEFAULT_TEMPERATURE_RANGE)) {
            sum += (count++ > 0 ? " & " : "") + temperature.toString("°C");
        }
        if(!rain.equals(DEFAULT_WEATHER_RANGE)) {
            sum += (count++ > 0 ? " & " : "") + rain.scale(10).toString("%") + " rainy";
        }
        if(!cloudy.equals(DEFAULT_WEATHER_RANGE)) {
            sum += (count++ > 0 ? " & " : "") + cloudy.scale(10).toString("%") + " cloudy";
        }
        if(!foggy.equals(DEFAULT_WEATHER_RANGE)) {
            sum += (count++ > 0 ? " & " : "") + foggy.scale(10).toString("%") + " foggy";
        }
        if(!rainbow.equals(DEFAULT_WEATHER_RANGE)) {
            sum += (count++ > 0 ? " & " : "") + rainbow.scale(10).toString("%") + " rainbow";
        }
        if(!northernlights.equals(DEFAULT_WEATHER_RANGE)) {
            sum += (count++ > 0 ? " & " : "") + northernlights.scale(10).toString("%") + " northern lights";
        }

        return sum;
    }

    public IntRange getTemperature() {
        return temperature;
    }

    public void setTemperature(IntRange temperature) {
        this.temperature = temperature;
    }

    public IntRange getRain() {
        return rain;
    }

    public void setRain(IntRange rain) {
        this.rain = rain;
    }

    public IntRange getCloudy() {
        return cloudy;
    }

    public void setCloudy(IntRange cloudy) {
        this.cloudy = cloudy;
    }

    public IntRange getFoggy() {
        return foggy;
    }

    public void setFoggy(IntRange foggy) {
        this.foggy = foggy;
    }

    public IntRange getRainbow() {
        return rainbow;
    }

    public void setRainbow(IntRange rainbow) {
        this.rainbow = rainbow;
    }

    public IntRange getNorthernlights() {
        return northernlights;
    }

    public void setNorthernlights(IntRange northernlights) {
        this.northernlights = northernlights;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    @Override
    public ValidationResult isValid() {
        return new ValidationResult(this)
                .and(temperature)
                .and(rain)
                .and(cloudy)
                .and(foggy)
                .and(rainbow)
                .and(northernlights);
    }
}
