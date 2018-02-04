package flashflood.bondhu.shona.floodalert.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import flashflood.bondhu.shona.floodalert.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText email = (EditText) findViewById(R.id.emailEt);
        final EditText passcode = (EditText) findViewById(R.id.passEt);



        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*
               if( email.getText().toString().equalsIgnoreCase("admin") & passcode.getText().toString().equals("admin") ){
                   startActivity(new Intent(MainActivity.this,HomeActivity.class));

               }
               else {
                   Toast.makeText(MainActivity.this, "Please enter correct Information..", Toast.LENGTH_SHORT).show();
               }*/

                startActivity(new Intent(MainActivity.this,HomeActivity.class));

            }
        });
    }

}
