package com.spos.weatherims;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WeatherDepartmentIMS {
    private final Map<String, Station> stations = new HashMap<>();
    private final List<Observation> observations = new ArrayList<>();
    private final List<Alert> alerts = new ArrayList<>();
    private int nextAlertId = 1;

    public boolean addStation(String stationId, String stationName, String district) {
        if (stations.containsKey(stationId)) {
            return false;
        }
        stations.put(stationId, new Station(stationId, stationName, district));
        return true;
    }

    public List<Station> listStations() {
        return new ArrayList<>(stations.values());
    }

    public Optional<Station> findStation(String stationId) {
        return Optional.ofNullable(stations.get(stationId));
    }

    public boolean addObservation(
            String stationId,
            LocalDateTime observedAt,
            double temperatureC,
            double humidityPercent,
            double rainfallMm,
            double windSpeedKph) {
        if (!stations.containsKey(stationId)) {
            return false;
        }
        if (humidityPercent < 0 || humidityPercent > 100) {
            return false;
        }
        observations.add(new Observation(
                stationId,
                observedAt,
                temperatureC,
                humidityPercent,
                rainfallMm,
                windSpeedKph));
        return true;
    }

    public List<Observation> getObservationsByStation(String stationId) {
        List<Observation> stationObservations = new ArrayList<>();
        for (Observation observation : observations) {
            if (observation.getStationId().equals(stationId)) {
                stationObservations.add(observation);
            }
        }
        return stationObservations;
    }

    public Optional<Observation> getLatestObservation(String stationId) {
        Observation latest = null;
        for (Observation observation : observations) {
            if (!observation.getStationId().equals(stationId)) {
                continue;
            }
            if (latest == null || observation.getObservedAt().isAfter(latest.getObservedAt())) {
                latest = observation;
            }
        }
        return Optional.ofNullable(latest);
    }

    public Alert issueAlert(String region, String severity, String message) {
        Alert alert = new Alert(nextAlertId++, region, severity, message, LocalDateTime.now());
        alerts.add(alert);
        return alert;
    }

    public List<Alert> listAlerts() {
        return new ArrayList<>(alerts);
    }
}
