package mainactivity.germanquintero.com.punto3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.text.TextUtils;
import android.widget.Toast;

import java.text.DecimalFormat;


public class Punto3 extends ActionBarActivity {


    private EditText e_Quices, e_Exposiciones, e_Laboratoio, e_Profinal;
    private TextView t_nota, t_estado, t_mensaje;
    private Button b_calcular;

    String notaquices, notaexp, notalab, profinal;
    float n_quiz = 0, n_exp = 0, n_lab = 0, n_profi = 0, definitiva = 0;
    String def;
    DecimalFormat df = new DecimalFormat("#.#");


    public Punto3() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"On Create", Toast.LENGTH_LONG).show();

        setContentView(R.layout.main_activity_notas);


             e_Quices = (EditText) findViewById(R.id.eQuiz);
             e_Exposiciones = (EditText) findViewById(R.id.eExp);
             e_Laboratoio = (EditText) findViewById(R.id.eLaboratorio);
             e_Profinal = (EditText) findViewById(R.id.eProfinal);
             t_nota = (TextView) findViewById(R.id.tDef);
             t_estado = (TextView) findViewById(R.id.tEstado);
             t_mensaje = (TextView) findViewById(R.id.tMensaje);

             b_calcular = (Button) findViewById(R.id.bNota);
             b_calcular.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     calcular();
                 }
             });



    }


    public void calcular() {

        notaquices = e_Quices.getText().toString();
        notaexp = e_Exposiciones.getText().toString();
        notalab = e_Laboratoio.getText().toString();
        profinal = e_Profinal.getText().toString();

        if (TextUtils.isEmpty(notaquices) || TextUtils.isEmpty(notaexp) || TextUtils.isEmpty(notalab) || TextUtils.isEmpty(profinal)) {
            mensaje1();

        } else {
            n_quiz = Float.parseFloat(notaquices);
            n_exp = Float.parseFloat(notaexp);
            n_lab = Float.parseFloat(notalab);
            n_profi = Float.parseFloat(profinal);

                        if (n_quiz > 5 || n_exp > 5 || n_lab > 5 || n_profi > 5) {
                            mensaje2();
                        } else {
                            definitiva = (float) (n_quiz * 0.15 + n_exp * 0.1 + n_lab * 0.4 + n_profi * 0.35);
                            t_mensaje.setText(getResources().getString(R.string.defi));
                            t_nota.setText(df.format(definitiva));
                            estado();
                        }

        }

    }

    private void estado() {

        if (definitiva >= 3)
            t_estado.setText(getResources().getString(R.string.gano));
        else {
            t_estado.setText(getResources().getString(R.string.perdio));
        }

    }

    public void mensaje1(){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getResources().getString(R.string.faltan));
        alertDialog.setMessage(getResources().getString(R.string.input));
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions
            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();

    }


    public void mensaje2(){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getResources().getString(R.string.erroneas));
        alertDialog.setMessage(getResources().getString(R.string.cerocinco));
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions
            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();

    }


    public void resetear( View view){


        e_Quices.setText("");
        e_Exposiciones.setText("");
        e_Laboratoio.setText("");
        e_Profinal.setText("");
        t_nota.setText("");
        t_estado.setText("");
        t_mensaje.setText("");


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto3, menu);
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



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("YourTextViewTextIdentifier", t_nota.getText().toString());
        outState.putString("estado", t_estado.getText().toString());
        outState.putString("mensaje", t_mensaje.getText().toString());


        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        t_nota.setText(savedInstanceState.getString("YourTextViewTextIdentifier"));
        t_estado.setText(savedInstanceState.getString("estado"));
        t_mensaje.setText(savedInstanceState.getString("mensaje"));


    }

    @Override
    protected void onStart() {
        Toast.makeText(this,"On Start", Toast.LENGTH_LONG).show();
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        Toast.makeText(this,"On Resume", Toast.LENGTH_LONG).show();
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"On Destroy", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this,"On Pause", Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"On Stop", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this,"On Restart", Toast.LENGTH_LONG).show();
        super.onRestart();
    }
}
