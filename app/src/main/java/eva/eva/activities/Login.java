package eva.eva.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eva.eva.R;
import eva.eva.dao.DatabaseHelper;

public class Login extends ActionBarActivity implements  View.OnClickListener {

    DatabaseHelper mydb;
    Button bLogin;
    EditText etUsername, etPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb = new DatabaseHelper(this);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin =(Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
          case R.id.bLogin:



                break;
      }
    }
}
