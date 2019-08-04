package com.healthq.core.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.annotation.Nullable;

public class Utils {
    public static Timestamp toTimestamp(@Nullable final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null : Timestamp.valueOf(zonedDateTime.toLocalDateTime());
    }
    
    public static ZonedDateTime toZoneDateTime(Timestamp timestamp) {
        return timestamp != null ? ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(timestamp.getTime()), ZoneOffset.UTC) : null;
      }
}
