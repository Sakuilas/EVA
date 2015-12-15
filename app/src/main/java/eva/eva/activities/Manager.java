package eva.eva.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import eva.eva.R;

/**
 * Created by Luke on 15.12.2015.
 */
public class Manager extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("gruppe");
        tabSpec.setContent(R.id.tabGruppe);
        tabSpec.setIndicator("Gruppe");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("bewertung");
        tabSpec.setContent(R.id.tabBewertung);
        tabSpec.setIndicator("bewertung");
        tabHost.addTab(tabSpec);

    }
}
