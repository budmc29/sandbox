package budmc29.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

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

        List<String> brandList = expert.getBrands( beerType );

        StringBuilder brandsFormatted = new StringBuilder();

        for ( String brand : brandList ) {
            brandsFormatted.append(brand).append('\n');
        }

        brands.setText( brandsFormatted );
    }
}
