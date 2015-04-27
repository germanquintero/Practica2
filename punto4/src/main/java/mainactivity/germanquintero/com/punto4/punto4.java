package mainactivity.germanquintero.com.punto4;

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



public class punto4 extends ActionBarActivity {

    private EditText e_Base, e_Altura, e_Radio, e_Lado;
    private TextView t_area,t_Mensaje, t_Cm2;
    private Button b_Area, b_Nuevo;
    private RadioButton r_Cuadrado, r_Rectangulo, r_Triangulo, r_Circulo;
    int flag_cuadrado=0, flag_tria=0, flag_rect=0, flag_cir=0;

    String input_base, input_altura, input_radio, input_lado;
    float area_cuarado=0, area_rectangulo=00, area_trianglo=0, area_circulo=0;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_punto4);
        e_Base=(EditText)findViewById(R.id.eBase);
        e_Altura=(EditText)findViewById(R.id.eAltura);
        e_Radio=(EditText)findViewById(R.id.eRadio);
        e_Lado=(EditText)findViewById(R.id.eLado);
        t_area=(TextView)findViewById(R.id.tArea);

        r_Circulo=(RadioButton)findViewById(R.id.rCirculo);
        r_Cuadrado=(RadioButton)findViewById(R.id.rCuadrado);
        r_Triangulo=(RadioButton)findViewById(R.id.rTriangulo);
        r_Rectangulo=(RadioButton)findViewById(R.id.rRectangulo);

        t_Mensaje=(TextView)findViewById(R.id.tMensaje);
        t_Cm2=(TextView)findViewById(R.id.tAcm2);

        t_Mensaje.setVisibility(View.GONE);
        t_Cm2.setVisibility(View.GONE);
        t_area.setVisibility(View.GONE);

        t_Mensaje.setVisibility(View.INVISIBLE);
        t_Cm2.setVisibility(View.INVISIBLE);
        t_area.setVisibility(View.INVISIBLE);


        b_Area=(Button)findViewById(R.id.bArea);

        b_Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcular();
            }
        });

    }

    public void operar(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rCuadrado:
                if (checked ){
                    a_cuadrado();}
                break;
            case R.id.rTriangulo:
                if (checked){
                    a_triangulo();}
                break;
            case R.id.rRectangulo:
                if (checked){
                   a_rectangulo();}
                break;
            case R.id.rCirculo:
                if (checked){
                   a_circulo();}
                break;
            default:

                break;


        }
    }


    public void a_cuadrado(){
        flag_cuadrado=1;
        flag_tria=0;
        flag_rect=0;
        flag_cir=0;

    }

    public void a_triangulo(){
        flag_cuadrado=0;
        flag_tria=1;
        flag_rect=0;
        flag_cir=0;

    }

    public void a_rectangulo(){
        flag_cuadrado=0;
        flag_tria=0;
        flag_rect=1;
        flag_cir=0;

    }

    public void a_circulo(){
        flag_cuadrado=0;
        flag_tria=0;
        flag_rect=0;
        flag_cir=1;

    }

    public void calcular(){


        if (flag_cuadrado==1)
        {
            flag_cuadrado=0;
            Toast.makeText(this, getResources().getString(R.string.cuadrado), Toast.LENGTH_LONG).show();
            String lado= e_Lado.getText().toString();

            if (TextUtils.isEmpty(lado)){
                mensaje1();
            }

            else {


                float lado1 = Float.parseFloat(lado);
                float area = (float) (lado1 * lado1);
                String cuadrado = String.valueOf(area);
                t_area.setText(cuadrado);
                t_Mensaje.setVisibility(View.VISIBLE);
                t_Cm2.setVisibility(View.VISIBLE);
                t_area.setVisibility(View.VISIBLE);

            }

        }
        else if  (flag_rect==1){
            Toast.makeText(this, getResources().getString(R.string.rectangulo), Toast.LENGTH_LONG).show();
            flag_rect=0;

            String altura= e_Altura.getText().toString();
            String base= e_Base.getText().toString();


            if (TextUtils.isEmpty(altura) || TextUtils.isEmpty(base) ) {
                mensaje2();
            }
             else {

                float altura1 = Float.parseFloat(altura);
                float base1 = Float.parseFloat(base);

                float area = (float) (altura1 * base1);
                String rect1 = String.valueOf(area);
                t_area.setText(rect1);
                t_Mensaje.setVisibility(View.VISIBLE);
                t_Cm2.setVisibility(View.VISIBLE);
                t_area.setVisibility(View.VISIBLE);


            }

        }
        else if (flag_tria==1){
            Toast.makeText(this,getResources().getString(R.string.triangulo), Toast.LENGTH_LONG).show();
            flag_tria=0;

            String altura= e_Altura.getText().toString();
            String base= e_Base.getText().toString();
            if (TextUtils.isEmpty(altura) || TextUtils.isEmpty(base) ) {
                mensaje2();
            }

            else {
                float altura1 = Float.parseFloat(altura);
                float base1 = Float.parseFloat(base);

                float area = (float) (altura1 * base1 * 0.5);
                String tria1 = String.valueOf(area);
                t_area.setText(tria1);
                t_Mensaje.setVisibility(View.VISIBLE);
                t_Cm2.setVisibility(View.VISIBLE);
                t_area.setVisibility(View.VISIBLE);

            }

        }

        else if (flag_cir==1){
            Toast.makeText(this, getResources().getString(R.string.circulo), Toast.LENGTH_LONG).show();
            flag_cir=0;

            String radio= e_Radio.getText().toString();

            if (TextUtils.isEmpty(radio)) {
                mensaje3();
            }

            else {
                float radio1 = Float.parseFloat(radio);

                float area = (float) (radio1 * radio1 * Math.PI);
                String cir1 = String.valueOf(area);
                t_area.setText(cir1);
                t_Mensaje.setVisibility(View.VISIBLE);
                t_Cm2.setVisibility(View.VISIBLE);
                t_area.setVisibility(View.VISIBLE);

            }

        }

    }
    public void mensaje1(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getResources().getString(R.string.fatan));
        alertDialog.setMessage(getResources().getString(R.string.basaltura));
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions

                t_Mensaje.setVisibility(View.INVISIBLE);
                t_Cm2.setVisibility(View.INVISIBLE);
                t_area.setVisibility(View.INVISIBLE);

            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();

    }


    public void mensaje2(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getResources().getString(R.string.fatan));
        alertDialog.setMessage(getResources().getString(R.string.basaltura));
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions

                t_Mensaje.setVisibility(View.INVISIBLE);
                t_Cm2.setVisibility(View.INVISIBLE);
                t_area.setVisibility(View.INVISIBLE);

            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();

    }


    public void mensaje3(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getResources().getString(R.string.fatan));
        alertDialog.setMessage(getResources().getString(R.string.faltaradio));
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions

                t_Mensaje.setVisibility(View.INVISIBLE);
                t_Cm2.setVisibility(View.INVISIBLE);
                t_area.setVisibility(View.INVISIBLE);

            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();

    }

    public void resetear( View view){

        r_Cuadrado.setChecked(false);
        r_Triangulo.setChecked(false);
        r_Rectangulo.setChecked(false);

        r_Circulo.setChecked(false);

        e_Radio.setText("");
        e_Altura.setText("");
        e_Base.setText("");
        e_Lado.setText("");

        t_Mensaje.setVisibility(View.INVISIBLE);
        t_Cm2.setVisibility(View.INVISIBLE);
        t_area.setVisibility(View.INVISIBLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto4, menu);
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
