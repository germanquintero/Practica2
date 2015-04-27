package mainactivity.germanquintero.com.punto5_full;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;



public class Punto5_full extends ActionBarActivity {

    int flag_mas=0, flag_fem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_punto5
        );



        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        final TextView tSexo = (TextView) findViewById(R.id.tSexo);
        final TextView tPai = (TextView) findViewById(R.id.tPais);

        final TextView tH1 = (TextView) findViewById(R.id.tHobbie1);
        final TextView tH2 = (TextView) findViewById(R.id.tHobbie2);
        final TextView tH3 = (TextView) findViewById(R.id.tHobbie3);
        final TextView tH4 = (TextView) findViewById(R.id.tHobbie4);

        final TextView tfecha = (TextView) findViewById(R.id.tNaci);
        final DatePicker dpnaci= (DatePicker)findViewById(R.id.dpFechanaci);

        final RadioButton rmas=(RadioButton)findViewById(R.id.rMasculino);
        final RadioButton rfem=(RadioButton)findViewById(R.id.rFemenino);
        final Spinner SCountry=(Spinner)findViewById(R.id.SPais);

        final CheckBox CHoby1=(CheckBox)findViewById(R.id.CMusica);
        final CheckBox CHoby2=(CheckBox)findViewById(R.id.CCine);
        final CheckBox CHoby3=(CheckBox)findViewById(R.id.CJugar);
        final CheckBox CHoby4=(CheckBox)findViewById(R.id.CNadar);

        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());

                 if (rmas.isChecked()){
                     tSexo.setText(getResources().getString(R.string.mascu));
                 }

                if (rfem.isChecked()){
                    tSexo.setText(getResources().getString(R.string.feme));
                }

                tPai.setText(SCountry.getSelectedItem().toString());

                if(CHoby1.isChecked()){
                    tH1.setText(getResources().getString(R.string.musica));

                } else if (!CHoby1.isChecked()){
                    tH1.setText("");

                }

                if(CHoby2.isChecked()){
                    tH2.setText(getResources().getString(R.string.cine));

                } else if (!CHoby2.isChecked()){
                    tH2.setText("");

                }

                if(CHoby3.isChecked()){
                    tH3.setText(getResources().getString(R.string.jugar));

                } else if (!CHoby3.isChecked()){
                    tH3.setText("");

                }

                if(CHoby4.isChecked()){
                    tH4.setText(getResources().getString(R.string.nadar));

                }else if (!CHoby4.isChecked()){
                    tH4.setText("");

                }


                tfecha.setText(dpnaci.getDayOfMonth()+"-"+(dpnaci.getMonth()+1)+"-"+dpnaci.getYear());


            }
        });


        //TextView

    }


    public void sexo(View view) {
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rMasculino:
                if (checked ){
                    flag_mas=1;
              }
                break;
            case R.id.rFemenino:
                if (checked){
                    flag_fem=1;
                   }
                break;
            default:

                break;


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto5_full, menu);
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
