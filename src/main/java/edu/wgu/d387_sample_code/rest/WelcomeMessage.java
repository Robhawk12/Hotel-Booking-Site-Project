package edu.wgu.d387_sample_code.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class WelcomeMessage {
   /* Properties properties = new Properties();
    static ExecutorService messageEx = newFixedThreadPool(5);



    public ResponseEntity<String> displayWelcome(){
        messageEx.execute(()->{
                    try{
                        InputStream stream = new ClassPathResource("welcomeBundle_fr_CA.properties").getInputStream();
                        properties.load(stream);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        messageEx.execute(()->{
                    try{
                        InputStream stream = new ClassPathResource("welcomeBundle_en_US.properties").getInputStream();
                        properties.load(stream);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        String welcome = (properties.getProperty("welcome"));
        return new  ResponseEntity<> (welcome, HttpStatus.OK);  }*/





}
