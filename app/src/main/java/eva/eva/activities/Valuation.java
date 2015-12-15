package eva.eva.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import eva.eva.R;

public class Valuation extends AppCompatActivity {

    private static Button button_bestätigen;
    private static RatingBar rating_motivation;
    private static RatingBar rating_teamfähigkeit;
    private static RatingBar rating_knowhow;
    private static RatingBar rating_kommunikation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valuation);
        listenerForRatingBars();
        onButtonClickListener();
    }

    public void listenerForRatingBars() {
        rating_motivation = (RatingBar) findViewById(R.id.rating_motivation);
        rating_teamfähigkeit = (RatingBar) findViewById(R.id.rating_teamfaehigkeit);
        rating_knowhow = (RatingBar) findViewById(R.id.rating_knowhow);
        rating_kommunikation = (RatingBar) findViewById(R.id.rating_kommunikation);

        rating_motivation.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    }
                }
        );
    }

    public void onButtonClickListener() {
        rating_motivation = (RatingBar) findViewById(R.id.rating_motivation);
        rating_teamfähigkeit = (RatingBar) findViewById(R.id.rating_teamfaehigkeit);
        button_bestätigen = (Button) findViewById(R.id.button);

        button_bestätigen.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Valuation.this,
                                String.valueOf(rating_motivation.getRating()
                                + rating_teamfähigkeit.getRating()
                                + rating_knowhow.getRating()
                                + rating_kommunikation.getRating()),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
