package mainactivity.germanquintero.com.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class ConfigurarNotas extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_notas);

        final EditText  e_Quices = (EditText) findViewById(R.id.eeQuiz);
        final EditText e_Exposiciones = (EditText) findViewById(R.id.eeExp);
        final EditText e_Laboratoio = (EditText) findViewById(R.id.eeLaboratorio);
        final EditText e_Profinal = (EditText) findViewById(R.id.eeProfinal);
        final Button b_Aceptar = (Button) findViewById(R.id.bbaceptar);

        Bundle extras=getIntent().getExtras();
        e_Quices.setText(String.valueOf(extras.getInt("pQuiz")));
        e_Exposiciones.setText(String.valueOf(extras.getInt("pExp")));
        e_Laboratoio.setText(String.valueOf(extras.getInt("pPra")));
        e_Profinal.setText(String.valueOf(extras.getInt("pPro")));





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configurar_notas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
