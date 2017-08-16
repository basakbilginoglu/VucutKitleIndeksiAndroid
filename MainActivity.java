package vucutkitleindeksi.com.tr.vucutkutleindeksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Intent i;

    EditText kilo, boy;

    Button hesaplaButton;

    float kilonuz;
    float boyunuz;
    float k;
    float kalori;
    float x;
    float  idealKilo;
    RadioButton radioButtonErkek;
    RadioButton radioButtonKadin;
    ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ekran üzerinde bulunan nesnelerin fontlarıyla birlikte yazdım.Yazı Fontu
//        Typeface font = Typeface.createFromAsset(getAssets(), "font/Felipa-Regular.otf");
        hesaplaButton = (Button) findViewById(R.id.hesaplaButton);

        // hesaplaButton.setTypeface(font);

        kilo = (EditText) findViewById(R.id.kiloEditText);
        //  kilo.setTypeface(font);
        boy = (EditText) findViewById(R.id.boyEditText);
        //boy.setTypeface(font);

        radioButtonErkek = (RadioButton) findViewById(R.id.erkekRadioButton);
        // rb_bay.setTypeface(font);
        radioButtonKadin = (RadioButton) findViewById(R.id.kadinRadioButton);
        // rb_bayan.setTypeface(font);
        final TextView kiloTextView = (TextView) findViewById(R.id.kilonuzTextView);
        final TextView kaloriTextView = (TextView) findViewById(R.id.kaloriTextView);
        final TextView idealKiloTextView = (TextView) findViewById(R.id.idealKiloTextView);
        final TextView endeksTextView = (TextView) findViewById(R.id.endeksEditText);

        hesaplaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //edittext boş mu dolu mu  olduğunu kontrol ettirmek için yazdım.

                if ((boy.getText().toString().trim().equals("")) || (kilo.getText().toString().trim().equals("")))

                {
                    Toast.makeText(getApplicationContext(), "Lütfen bütün değerleri doldurunuz!", Toast.LENGTH_LONG).show();
                } else {






                        //vücut kitle endeksinin formülü
                        kilonuz = (float) Double.parseDouble((kilo.getText().toString()));
                        boyunuz = (float) Double.parseDouble((boy.getText().toString()));

                        k = kilonuz / (boyunuz * boyunuz);
                        endeksTextView.setText("VKE: " + (int) Math.ceil(k));

                        if (k <= 18) {

                            kiloTextView.setText("Kilo Durumunuz:"+" "+"Zayıf");
                        } else if (18 < k && k <= 25) {

                            kiloTextView.setText("Kilo Durumunuz:"+" "+"Kilonuz Normal");
                        } else if (25 < k && k <= 30) {

                            kiloTextView.setText("Kilo Durumunuz:"+" "+"Fazla Kilolu");
                        } else if (30 < k && k <= 35) {

                            kiloTextView.setText("Kilo Durumunuz:"+" "+"1.Derecede Obez");
                        } else if (35 < k && k <= 40) {

                            kiloTextView.setText("Kilo Durumunuz:"+" "+"2. Derecede Obez");
                        } else {
                            kiloTextView.setText("Kilo Durumunuz:"+" "+"3. Derecede Obez");

                        }
                        //kişinin günlük alması gereken kalori miktarını verir.
                        kalori = kilonuz * 2 * 10;
                        kaloriTextView.setText("Günlük Almanız Gereken Kalori Miktarı: " + (int) Math.ceil(kalori));

                        //cinsiyete göre ideal kilo formülü
                        if (radioButtonErkek.isChecked()) {
                            x = boyunuz * 100;
                            idealKilo= x - 100 - ((x - 150) / 4);
                            idealKiloTextView.setText("İdeal Kilonuz:" + (int) Math.ceil(idealKilo));

                        } else if (radioButtonKadin.isChecked()) {
                            x = boyunuz * 100;
                            idealKilo = x - 100 - ((x - 150) / 2);
                            idealKiloTextView.setText("İdeal Kilonuz:" + (int) Math.ceil(idealKilo));
                        }
                }

                kilo.setText("");
                boy.setText("");
                radioButtonErkek.setChecked(false);
                radioButtonKadin.setChecked(false);
            }

        });



        //yenile butonu
        imgBtn = (ImageButton) findViewById(R.id.imageButton);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kilo.setText("");
                boy.setText("");
                idealKiloTextView.setText("");
                endeksTextView.setText("");
                kaloriTextView.setText("");
                kiloTextView.setText("");
                radioButtonKadin.setChecked(false);
                radioButtonErkek.setChecked(false);
            }

        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);

        return  true;
    }
}