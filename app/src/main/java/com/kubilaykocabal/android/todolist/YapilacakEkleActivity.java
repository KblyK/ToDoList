package com.kubilaykocabal.android.todolist;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class YapilacakEkleActivity extends AppCompatActivity {
    Database db ;

    EditText mBaslik;
    EditText mİcerik;
    Button mTarih,mKaydet,mListele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yapilacak_ekle);
        db=new Database(this);


        mBaslik =(EditText)findViewById(R.id.Baslik);
        mİcerik=(EditText)findViewById(R.id.İcerik);
        mKaydet=(Button)findViewById(R.id.Kaydet);
        mListele=(Button)findViewById(R.id.Listele);

        mKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.todoEkle(mBaslik.getText().toString(),mİcerik.getText().toString());
                Intent intent = new Intent(YapilacakEkleActivity.this,YapilacaklariGoster.class);
                startActivity(intent);
            }
        });

        mListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YapilacakEkleActivity.this,YapilacaklariGoster.class);
                startActivity(intent);
            }
        });


        mTarih=(Button)findViewById(R.id.Tarih);
        mTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    Calendar mcurrentTime=Calendar.getInstance();
                    int year = mcurrentTime.get(Calendar.YEAR);//Güncel Yılı alıyoruz
                    int month = mcurrentTime.get(Calendar.MONTH);//Güncel Ayı alıyoruz
                    int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);//Güncel Günü alıyoruz

                    DatePickerDialog datePicker;//Datepicker objemiz
                    datePicker = new DatePickerDialog(YapilacakEkleActivity.this, new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear,
                                              int dayOfMonth) {
                            // TODO Auto-generated method stub
                            mTarih.setText( dayOfMonth + "/" + monthOfYear + "/" + year);//Ayarla butonu tıklandığında textview'a yazdırıyoruz

                        }
                    },year,month,day);//başlarken set edilcek değerlerimizi atıyoruz
                    datePicker.setTitle("Tarih Seçiniz");
                    datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                    datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", datePicker);

                    datePicker.show();
                }
            }
        });

    }
}
