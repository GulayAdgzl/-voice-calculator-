package com.example.hesapmakinesi2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnActionDivide,btnDecimal,btnActionMultiply,btnActionSubstract,btnActionAdd,btnActionEnter,btnClear;
    TextView txtDisplayText;
    Button btnbasla;
    Context context=this;
    static  int REQUEST_CODE=100;
    Dialog eslesenText;
    ListView textListes;
   ArrayList<String> eslesenTextListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        btn1 = findViewById (R.id.btn_1);
        btn2 = findViewById (R.id.btn_2);
        btn3 = findViewById (R.id.btn_3);
        btn4 = findViewById (R.id.btn_4);
        btn5 = findViewById (R.id.btn_5);
        btn6 = findViewById (R.id.btn_6);
        btn7 = findViewById (R.id.btn_7);
        btn8 = findViewById (R.id.btn_8);
        btn9 = findViewById (R.id.btn_9);
        btn0 = findViewById (R.id.btn_0);
        btnDecimal = findViewById (R.id.btn_dot);
        btnActionDivide = findViewById (R.id.btn_divide);
        btnActionMultiply = findViewById (R.id.btn_Multiply);
        btnActionSubstract = findViewById (R.id.btn_substract);
        btnActionAdd = findViewById (R.id.btn_addition);
        btnActionEnter = findViewById (R.id.btn_enter);
        txtDisplayText = findViewById (R.id.txt_out);
        btnClear = findViewById (R.id.btn_cut);
        btnbasla=findViewById (R.id.btn_basla);




        btn1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "1");

            }
        });
        btn2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "2");

            }
        });

        btn3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "3");


            }
        });

        btn4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
               txtDisplayText.setText (txtDisplayText.getText ().toString () + "4");


            }
        });

        btn5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "5");


            }
        });

        btn6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "6");


            }
        });

        btn7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "7");


            }
        });

        btn8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "8");

            }
        });

        btn9.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "9");

            }
        });

        btn0.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "0");

            }
        });
        btnActionDivide.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "/");


            }
        });

        btnActionAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "+");

            }
        });

        btnActionSubstract.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "-");


            }
        });

        btnActionMultiply.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + "*");

            }
        });

        btnActionEnter.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String number=txtDisplayText.getText ().toString () ;
                if(number.contains ("/")){
                    String[] splitNumber=number.split ("/");


                    double firstNumber=Double.valueOf (splitNumber[0]);
                    double secondNumber=Double.valueOf (splitNumber[1]);

                    txtDisplayText.setText (String.valueOf (divide (firstNumber,secondNumber)));
                }
                //çarpım

                else if(number.contains ("X")){
                    String[] splitNumber=number.split ("x");
                    double firstNumber=Double.valueOf (splitNumber[0]);
                    double seconderNumber=Double.valueOf (splitNumber[1]);
                    txtDisplayText.setText (String.valueOf (multiply (firstNumber,seconderNumber)));
                }
                else  if(number.contains ("-")){
                    String[] splitNumber=number.split ("-");

                    double firstNumber=Double.valueOf (splitNumber[0]);
                    double secondNumber=Double.valueOf (splitNumber[1]);

                    txtDisplayText.setText (String.valueOf (substract (firstNumber,secondNumber)));
                }
                //toplama
                else  if(number.contains ("+")){
                    String[] splitNumber=number.split ("//+");

                    double firstNumber=Double.valueOf (splitNumber[0]);
                    double secondNumber=Double.valueOf (splitNumber[1]);

                    txtDisplayText.setText (String.valueOf (add (firstNumber,secondNumber)));
                }



            }
        });

        btnDecimal.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                txtDisplayText.setText (txtDisplayText.getText ().toString () + ".");

            }
        });
        btnClear.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                txtDisplayText.setText ("");
            }
        });



        //Ses Kaydetme Kısmı


        btnbasla.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                if(baglıMı()){
                    Intent intent=new Intent (RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra (RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent
                    .LANGUAGE_MODEL_FREE_FORM);
                    startActivityForResult (intent,REQUEST_CODE);

                }
                else{
                    Toast.makeText (context,"Please make your Internet Connection",Toast.LENGTH_SHORT).show ();

                }


            }
        });


    }
    //Ses Kaydetme


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            eslesenText=new Dialog (context);
            eslesenText.setContentView (R.layout.eslesen_sesler_listesi);
            eslesenText.setTitle ("Eşleşen metni seç");
            textListes=eslesenText.findViewById (R.id.liste);
            eslesenTextListesi=data.getStringArrayListExtra (RecognizerIntent.EXTRA_RESULTS);
            ArrayAdapter<String> adapter=new ArrayAdapter<String> (context, android.R.layout
                    .simple_list_item_1,eslesenTextListesi);
            textListes.setAdapter (adapter);
            textListes.setOnItemClickListener (new AdapterView.OnItemClickListener () {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    txtDisplayText.setText ("Söylediğiniz"+eslesenTextListesi.get (position));
                }
            });
            eslesenText.show ();

        }
        super.onActivityResult (requestCode, resultCode, data);
    }



    public boolean baglıMı(){
        ConnectivityManager con=(ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        NetworkInfo net=con.getActiveNetworkInfo ();
        if (net!=null && net.isAvailable () && net.isConnected ()){
            return  true;
        }
        else
            return false;
    }


















    double add(double a,double b){

        return  a+b;
    }
    double substract(double a,double b){

        return  a-b;
    }
    double divide(double a,double b){

        return a/b;
    }
    double multiply(double a,double b){

        return a*b;
    }


























}