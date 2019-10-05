package kawelenga.packag.com.apinstagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("mLC6iu8nIW6cY7Maq5stEXBGze4tT7ngAGvEVA13")
                // if defined
                .clientKey("ewfVEkcbea0Eg9HZtOa46MT7dVuSOaPcHmz2aBJm")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
