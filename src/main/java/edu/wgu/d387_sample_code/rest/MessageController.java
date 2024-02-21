package edu.wgu.d387_sample_code.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageController {

    @GetMapping(value = "/presentation")
    public ResponseEntity<String> displayPresentation(){
        String presentation = "You are invited to an online presentation starting at: " + getTime();
     return new ResponseEntity<String>(presentation, HttpStatus.OK);
    }

    public static String getTime() {
        ZonedDateTime time = ZonedDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime eastern = time.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime mountain = time.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime universal = time.withZoneSameInstant(ZoneId.of("UTC"));
        String allTimeZones = eastern.format(timeFormat) + "EST, " + mountain.format(timeFormat) + "MST, " + universal.format(timeFormat) + "UTC";

        return allTimeZones;
    }




}
