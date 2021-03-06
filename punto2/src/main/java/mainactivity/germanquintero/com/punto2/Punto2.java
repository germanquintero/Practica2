package mainactivity.germanquintero.com.punto2;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.Activity;
import android.widget.Toast;
import android.app.AlertDialog;


public class Punto2 extends ActionBarActivity {


    private EditText eOpe11;
    private EditText eOpe22;
    private EditText eRes;
    private TextView tTipo;
    //private Button bReset=(Button)findViewById(R.id.bReset);
    private RadioButton rSumar;
    private RadioButton rRestar;
    private RadioButton rMulti;
    private RadioButton rDiv;



    private float ope1=0, ope2=0, res=0;
    String operando1, operando2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);

        eOpe11=(EditText)findViewById(R.id.eOpe1);
        eOpe22=(EditText)findViewById(R.id.eOpe2);
        eRes=(EditText)findViewById(R.id.eRes);
        tTipo=(TextView)findViewById(R.id.tTipo);
        //private Button bReset=(Button)findViewById(R.id.bReset);
        rSumar=(RadioButton)findViewById(R.id.rsumar);
        rRestar=(RadioButton)findViewById(R.id.rrestar);
        rMulti=(RadioButton)findViewById(R.id.rmulti);
        rDiv=(RadioButton)findViewById(R.id.rdivi);



       /* <!--  Cuadndo se presiona un boton se bace esto
        bSumar=(Button)findViewById(R.id.bSumar);
        bSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();
            }
        });*/



    }

    public void operar(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rsumar:
                if (checked ){
                    sumar();}
                break;
            case R.id.rrestar:
                if (checked){
                    restar();}
                break;
            case R.id.rmulti:
                if (checked){
                    multiplicar();}
                break;
            case R.id.rdivi:
                if (checked){
                    dividir();}
                break;
            default:

                break;


        }
    }


    public void mensaje(){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Faltan Datos");
        alertDialog.setMessage("Es necesario Llenar los Campos");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                rSumar.setChecked(false);
                rRestar.setChecked(false);
                rMulti.setChecked(false);
                rDiv.setChecked(false);
            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();

    }


    public void resetear( View view){

        rSumar.setChecked(false);
        rRestar.setChecked(false);
        rMulti.setChecked(false);
        rDiv.setChecked(false);
        eOpe11.setText("");
        eOpe22.setText("");
        eRes.setText("");


    }
    public void sumar(){

        operando1=eOpe11.getText().toString();
        operando2=eOpe22.getText().toString();

        if (TextUtils.isEmpty(operando1) || TextUtils.isEmpty(operando2)) {
            mensaje();

        }
        else {
            ope1 = Float.parseFloat(operando1);
            ope2 = Float.parseFloat(operando2);
            res = ope1 + ope2;
            String suma = String.valueOf(res);
            eRes.setText(suma);
            tipo();
        }

    }

    public void restar(){
        operando1=eOpe11.getText().toString();
        operando2=eOpe22.getText().toString();

        if (TextUtils.isEmpty(operando1) || TextUtils.isEmpty(operando2)) {
            mensaje();

        }
        else {
            ope1 = Float.parseFloat(operando1);
            ope2 = Float.parseFloat(operando2);
            res = ope1 - ope2;
            String resta = String.valueOf(res);
            eRes.setText(resta);
            tipo();
        }
    }

    public void multiplicar(){

        operando1=eOpe11.getText().toString();
        operando2=eOpe22.getText().toString();

        if (TextUtils.isEmpty(operando1) || TextUtils.isEmpty(operando2)) {
            mensaje();

        }
        else {
            ope1 = Float.parseFloat(operando1);
            ope2 = Float.parseFloat(operando2);
            res = ope1 * ope2;
            String multi = String.valueOf(res);
            eRes.setText(multi);
            tipo();
        }

    }

    public void dividir(){

        operando1=eOpe11.getText().toString();
        operando2=eOpe22.getText().toString();

        if (TextUtils.isEmpty(operando1) || TextUtils.isEmpty(operando2)) {
            mensaje();

        }
        else {
            ope1 = Float.parseFloat(operando1);
            ope2 = Float.parseFloat(operando2);
            res = ope1 / ope2;
            String divi = String.valueOf(res);
            eRes.setText(divi);
            tipo();
        }

    }



    public void tipo(){
        if (res>0) {
            tTipo.setText("Es Positivo");
        }else if (res<0)
        {
            tTipo.setText("Es negativo");
        }
        else if (res==0){
            tTipo.setText("Es Cero");
        }
        else {
            tTipo.setText("Indeterminado o No Existe");
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto2, menu);
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