package kawelenga.packag.com.apinstagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username, punchSpeed, kickSpeed;
    private Button newBoxer, transitionActivity;
    private TextView getData;
    private String outputKickBoxer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username= findViewById(R.id.edtText);
        punchSpeed= findViewById(R.id.edtPunchSpeed);
        kickSpeed= findViewById(R.id.edtKickSpeed);
        newBoxer = findViewById(R.id.btnKickBoxer);
        getData = findViewById(R.id.txtGetData);
        transitionActivity = findViewById(R.id.btnTransition);

        outputKickBoxer= "";

        newBoxer.setOnClickListener(MainActivity.this);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* ParseQuery<ParseObject> parseQuery= ParseQuery.getQuery("KickBoxer");
                parseQuery.getInBackground("zAxq29tAu1", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (object!=null && e== null) {
                            getData.setText(object.get("kick_boxer")+"");
                        } else {
                            getData.setText(e.getMessage().toString());
                        }
                    }
                });*/

               ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("KickBoxer");
               queryAll.whereGreaterThan("kick_speed",1000);
               queryAll.findInBackground(new FindCallback<ParseObject>() {
                   @Override
                   public void done(List<ParseObject> objects, ParseException e) {

                       if (objects.size() >0  && e==null){

                           for (ParseObject kb: objects) {
                            outputKickBoxer=outputKickBoxer + kb.get("kick_boxer");
                           }

                           FancyToast.makeText(MainActivity.this, outputKickBoxer,
                                   FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                       }

                   }
               });
            }
        });


        transitionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,SignupLoginActivity.class);
                startActivity(intent);

            }
        });
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
