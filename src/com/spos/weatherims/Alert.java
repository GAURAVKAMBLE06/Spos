package com.spos.weatherims;

import java.time.LocalDateTime;

public class Alert {
    private final int alertId;
    private final String region;
    private final String severity;
    private final String message;
    private final LocalDateTime issuedAt;

    public Alert(int alertId, String region, String severity, String message, LocalDateTime issuedAt) {
        this.alertId = alertId;
        this.region = region;
        this.severity = severity;
        this.message = message;
        this.issuedAt = issuedAt;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", region='" + region + '\'' +
                ", severity='" + severity + '\'' +
                ", message='" + message + '\'' +
                ", issuedAt=" + issuedAt +
                '}';
    }
}
