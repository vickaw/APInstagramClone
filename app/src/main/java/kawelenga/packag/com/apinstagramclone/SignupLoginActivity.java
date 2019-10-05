package kawelenga.packag.com.apinstagramclone;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignupLoginActivity extends AppCompatActivity {

    private Button loginButton, signupButton ;
    private EditText edtSUusername, edtSUpwd,edtLusername,edtLpwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_login_activity);

        edtLpwd= findViewById(R.id.edtLUPassword);
        edtLusername=findViewById(R.id.edtLUUsername);
        edtSUpwd=findViewById(R.id.edtSUPassword);
        edtSUpwd=findViewById(R.id.edtSUPassword);

        loginButton=findViewById(R.id.btnLoginUser);
        signupButton=findViewById(R.id.btnSignUp);

       /* ParseUser appUser = new ParseUser();
        appUser.setUsername("Victor");
        appUser.setPassword("123Vic");
        */
        //FancyToast.makeText(SignupLoginActivity.this,"User signed up successfully!",FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseUser.logInInBackground(edtLusername.getText().toString(), edtLpwd.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user!=null && e==null){

                            FancyToast.makeText(SignupLoginActivity.this,"Success!",FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                        }else {

                            FancyToast.makeText(SignupLoginActivity.this,e.getMessage(),FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });


            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              /*  ParseUser appUser = new ParseUser();
                appUser.setUsername(edtSUusername.getText().toString());
                appUser.setPassword(edtSUpwd.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(SignupLoginActivity.this,"User signed up successfully!",
                                    FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        }else {

                            FancyToast.makeText(SignupLoginActivity.this,e.getMessage(),
                                    FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }
                    }
                });*/

            }
        });
    }
}
