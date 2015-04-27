package mainactivity.germanquintero.com.punto3;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class Punto3 extends ActionBarActivity {


    private EditText e_Quices, e_Exposiciones, e_Laboratoio, e_Profinal;
    private TextView t_nota, t_estado, t_mensaje;
    private Button b_calcular;

    String notaquices, notaexp, notalab, profinal;
    float n_quiz = 0, n_exp = 0, n_lab = 0, n_profi = 0, definitiva = 0;


    public Punto3() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity_notas);


             e_Quices = (EditText) findViewById(R.id.eQuiz);
             e_Exposiciones = (EditText) findViewById(R.id.eExp);
             e_Laboratoio = (EditText) findViewById(R.id.eLaboratorio);
             e_Profinal = (EditText) findViewById(R.id.eProfinal);
             t_nota = (TextView) findViewById(R.id.tDef);
             t_estado = (TextView) findViewById(R.id.tEstado);
             t_mensaje = (TextView) findViewById(R.id.tMensaje);
             t_mensaje.setVisibility(View.GONE);
             t_mensaje.setVisibility(View.INVISIBLE);

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
                            String def =String.valueOf(definitiva);
                            t_mensaje.setVisibility(View.VISIBLE);
                            t_nota.setText(def);
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
        t_mensaje.setVisibility(View.INVISIBLE);


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
}
