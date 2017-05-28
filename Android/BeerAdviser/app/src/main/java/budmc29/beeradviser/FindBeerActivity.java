package budmc29.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class FindBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById( R.id.brands );

        Spinner colour = (Spinner) findViewById( R.id.colour );

        String beerType = String.valueOf( colour.getSelectedItem() );

        brands.setText( beerType );
    }
}
