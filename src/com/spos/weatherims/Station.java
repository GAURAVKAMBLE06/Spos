package com.spos.weatherims;

public class Station {
    private final String stationId;
    private String stationName;
    private String district;

    public Station(String stationId, String stationName, String district) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.district = district;
    }

    public String getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return stationId + " - " + stationName + " (" + district + ")";
    }
}
