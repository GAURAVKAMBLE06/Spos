package com.spos.weatherims;

import java.time.LocalDateTime;

public class Observation {
    private final String stationId;
    private final LocalDateTime observedAt;
    private final double temperatureC;
    private final double humidityPercent;
    private final double rainfallMm;
    private final double windSpeedKph;

    public Observation(
            String stationId,
            LocalDateTime observedAt,
            double temperatureC,
            double humidityPercent,
            double rainfallMm,
            double windSpeedKph) {
        this.stationId = stationId;
        this.observedAt = observedAt;
        this.temperatureC = temperatureC;
        this.humidityPercent = humidityPercent;
        this.rainfallMm = rainfallMm;
        this.windSpeedKph = windSpeedKph;
    }

    public String getStationId() {
        return stationId;
    }

    public LocalDateTime getObservedAt() {
        return observedAt;
    }

    public double getTemperatureC() {
        return temperatureC;
    }

    public double getHumidityPercent() {
        return humidityPercent;
    }

    public double getRainfallMm() {
        return rainfallMm;
    }

    public double getWindSpeedKph() {
        return windSpeedKph;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "stationId='" + stationId + '\'' +
                ", observedAt=" + observedAt +
                ", temperatureC=" + temperatureC +
                ", humidityPercent=" + humidityPercent +
                ", rainfallMm=" + rainfallMm +
                ", windSpeedKph=" + windSpeedKph +
                '}';
    }
}
