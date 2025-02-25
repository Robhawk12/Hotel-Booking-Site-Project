package edu.wgu.d387_sample_code.rest;


import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WelcomeMessageController implements Runnable {



    Properties propertiesFr = new Properties();
    Properties propertiesEn = new Properties();
    static ExecutorService messageEx = newFixedThreadPool(2);

    @RequestMapping(path = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> displayWelcome(){
            messageEx.execute(() -> {
                        try {
                            InputStream stream = new ClassPathResource("welcomeBundle_fr_CA.properties").getInputStream();

                            propertiesFr.load(stream);
  
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            messageEx.execute(() -> {
                        try {
                            InputStream stream = new ClassPathResource("welcomeBundle_en_US.properties").getInputStream();
                            propertiesEn.load(stream);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        String welcomeFr = propertiesFr.getProperty("welcome");
        String welcomeEn = propertiesEn.getProperty("welcome");
        /*if(welcomeEn == null || welcomeFr == null){
             welcomeFr = propertiesFr.getProperty("welcome");
             welcomeEn = propertiesEn.getProperty("welcome");
        }*/
        String welcome = welcomeFr +" "+welcomeEn;
        return new  ResponseEntity<> ( welcome, HttpStatus.OK);  }




    @Override
    public void run() {

    }
}
