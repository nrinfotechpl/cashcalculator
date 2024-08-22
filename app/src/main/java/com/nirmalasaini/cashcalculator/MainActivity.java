package com.nirmalasaini.cashcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText et500,et200,et100,et50,et20,et10;
    TextView txt500,txt200,txt100,txt50,txt20,txt10;

    TextView txtFinalCash,txtFinalCashInWords;
    ImageButton btReset, btShare;

    ArrayList<Integer> fluctuateCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();

        fluctuateCash = new ArrayList<>();


        et500.addTextChangedListener(new CashTextWatcher());
        et200.addTextChangedListener(new CashTextWatcher());
        et100.addTextChangedListener(new CashTextWatcher());
        et50.addTextChangedListener(new CashTextWatcher());
        et20.addTextChangedListener(new CashTextWatcher());
        et10.addTextChangedListener(new CashTextWatcher());




        txt500.addTextChangedListener(new FinalCashTextWatcher());
        txt200.addTextChangedListener(new FinalCashTextWatcher());
        txt100.addTextChangedListener(new FinalCashTextWatcher());
        txt50.addTextChangedListener(new FinalCashTextWatcher());
        txt20.addTextChangedListener(new FinalCashTextWatcher());
        txt10.addTextChangedListener(new FinalCashTextWatcher());


        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
            }
        });
/// share button start
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");

                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://wa.me/917568822022" );
                startActivity(Intent.createChooser(sendIntent,"Choose One"));

            }
        });


     //share button end
    }

    private void clearData() {

        txtFinalCashInWords.setText("0");
        txtFinalCash.setText("Zero");


        txt500.setText("0");
        txt200.setText("0");
        txt100.setText("0");
        txt50.setText("0");
        txt20.setText("0");
        txt10.setText("0");




        et500.setText("");
        et200.setText("");
        et100.setText("");
        et50.setText("");
        et20.setText("");
        et10.setText("");


    }

    private void setUpUI() {
        btShare = findViewById(R.id.BtnShare);
        btReset = findViewById(R.id.btnReset);
        txtFinalCash = findViewById(R.id.txtFinalCash);
        txtFinalCashInWords = findViewById(R.id.txtFinalCashInWords);


        et500 = findViewById(R.id.et500);
        et200 = findViewById(R.id.et200);
        et100 = findViewById(R.id.et100);
        et50= findViewById(R.id.et50);
        et20= findViewById(R.id.et20);
        et10= findViewById(R.id.et10);





        txt500 = findViewById(R.id.txt500);
        txt200 = findViewById(R.id.txt200);
        txt100 = findViewById(R.id.txt100);
        txt50 = findViewById(R.id.txt50);
        txt20 = findViewById(R.id.txt20);
        txt10 = findViewById(R.id.txt10);


    }


    private class CashTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                cashCalculate();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    private void cashCalculate() {

      int row_value = 0;

        DecimalFormat df = new DecimalFormat("0");


        int num2 = 0;
        if (!et500.getText().toString().equals("")){

            num2 = Integer.parseInt(et500.getText().toString());
            row_value = num2 * 500;
            txt500.setText(df.format(row_value));
            fluctuateCash.add(row_value);

        }

        int num3 = 0;
        if (!et200.getText().toString().equals("")){

            num3 = Integer.parseInt(et200.getText().toString());
            row_value = num3 * 200;
            txt200.setText(df.format(row_value));
            fluctuateCash.add(row_value);

        }

        int num4 = 0;
        if (!et100.getText().toString().equals("")){

            num4 = Integer.parseInt(et100.getText().toString());
            row_value = num4 * 100;
            txt100.setText(df.format(row_value));
            fluctuateCash.add(row_value);

        }

        int num5 = 0;
        if (!et50.getText().toString().equals("")){

            num5 = Integer.parseInt(et50.getText().toString());
            row_value = num5 * 50;
            txt50.setText(df.format(row_value));
            fluctuateCash.add(row_value);

        }

        int num6 = 0;
        if (!et20.getText().toString().equals("")){

            num6 = Integer.parseInt(et20.getText().toString());
            row_value = num6 * 20;
            txt20.setText(df.format(row_value));
            fluctuateCash.add(row_value);

        }

        int num7 = 0;
        if (!et10.getText().toString().equals("")){

            num7 = Integer.parseInt(et10.getText().toString());
            row_value = num7 * 10;
            txt10.setText(df.format(row_value));
            fluctuateCash.add(row_value);

        }





        if (et500.getText().toString().equals("")){
            txt500.setText(df.format(0));
        }

        if (et200.getText().toString().equals("")){
            txt200.setText(df.format(0));
        }

        if (et100.getText().toString().equals("")){
            txt100.setText(df.format(0));
        }

        if (et50.getText().toString().equals("")){
            txt50.setText(df.format(0));
        }

        if (et20.getText().toString().equals("")){
            txt20.setText(df.format(0));
        }

        if (et10.getText().toString().equals("")){
            txt10.setText(df.format(0));
        }




    }

    private class FinalCashTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            totalCash();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    private void totalCash() {

            int totalCash = 0;

            DecimalFormat df = new DecimalFormat("0");


            Main ob = new Main();

            if (!txt500.getText().toString().equals("") && !txt200.getText().toString().equals("")){
                if (!txt100.getText().toString().equals("") && !txt50.getText().toString().equals("")){
                    if (!txt20.getText().toString().equals("") && !txt10.getText().toString().equals("")){


                                int num1 = 0,num2 =0,num3 =0,num4 = 0, num5 = 0, num6  = 0,num7 =0,num8 = 0,num9 = 0,num10 =0;


                                num2 = Integer.parseInt(txt500.getText().toString());
                                num3 = Integer.parseInt(txt200.getText().toString());
                                num4 = Integer.parseInt(txt100.getText().toString());
                                num5 = Integer.parseInt(txt50.getText().toString());
                                num6 = Integer.parseInt(txt20.getText().toString());
                                num7 = Integer.parseInt(txt10.getText().toString());


                                totalCash = num2+num3+num4+num5+num6+num7;
                                txtFinalCash.setText("Total Cash : ₹ " + df.format(totalCash));
                                txtFinalCashInWords.setText(String.valueOf(ob.convertNumberToWords(totalCash)));

                                if (txtFinalCashInWords.getText().toString().equals("")){
                                    txtFinalCashInWords.setText(R.string.zero);
                                }

                            }
                        }
                    }
                }
            }



