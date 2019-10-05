package kawelenga.packag.com.apinstagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username, punchSpeed, kickSpeed;
    private Button newBoxer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username= findViewById(R.id.edtText);
        punchSpeed= findViewById(R.id.edtPunchSpeed);
        kickSpeed= findViewById(R.id.edtKickSpeed);
        newBoxer = findViewById(R.id.btnKickBoxer);

        newBoxer.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v){
            try {
                final ParseObject kickboxer = new ParseObject("KickBoxer");
                kickboxer.put("punch_speed", Integer.parseInt(punchSpeed.getText().toString()));
                kickboxer.put("kick_speed", Integer.parseInt(kickSpeed.getText().toString()));
                kickboxer.put("kick_boxer", username.getText().toString());
                kickboxer.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(MainActivity.this, "Boxer Saved", FancyToast.LENGTH_LONG,
                                    FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(MainActivity.this, e.getMessage(),
                                    FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }

                    }
                });
            } catch (Exception e) {

                FancyToast.makeText(MainActivity.this, e.getMessage(),
                        FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
            }
    }


}
