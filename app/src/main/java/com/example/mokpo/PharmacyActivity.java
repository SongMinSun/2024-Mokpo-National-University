package com.example.mokpo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PharmacyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharmacy);

        // 스위치를 ID로 찾습니다
        Switch pharmacySwitch = findViewById(R.id.pharmacyswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup pharmacyRadioGroup = findViewById(R.id.pharmacyrg);
        final TextView pharmacyIntroTextView = findViewById(R.id.pharmacy_2);
        final ImageView pharmacyImageView = findViewById(R.id.pharmacyimg);
        final Button pharmacyLinkButton = findViewById(R.id.pharmacylink);
        final TextView pharmacy_num = findViewById(R.id.pharmacy_num);

        // TextView를 ID로 찾습니다
        final TextView pharmacyDesc = findViewById(R.id.pharmacy_desc);
        final TextView pharmacy_phone = findViewById(R.id.pharmacy_phone);


        // btn_back 버튼을 ID로 찾습니다
        Button btn_pharmacyback = findViewById(R.id.pharmacyback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_pharmacyback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PharmacyActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        pharmacySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    pharmacyRadioGroup.setVisibility(View.VISIBLE);
                    pharmacyIntroTextView.setVisibility(View.VISIBLE);
                    pharmacyImageView.setVisibility(View.VISIBLE);
                    pharmacyLinkButton.setVisibility(View.VISIBLE);
                    pharmacy_num.setVisibility(View.VISIBLE);

                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    pharmacyRadioGroup.setVisibility(View.INVISIBLE);
                    pharmacyIntroTextView.setVisibility(View.INVISIBLE);
                    pharmacyImageView.setVisibility(View.INVISIBLE);
                    pharmacyLinkButton.setVisibility(View.INVISIBLE);
                    pharmacy_num.setVisibility(View.INVISIBLE);


                    // TextView를 숨깁니다
                    pharmacyDesc.setVisibility(View.INVISIBLE);
                    pharmacy_phone.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        pharmacyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.pharmacy1) {
                    pharmacyDesc.setText("인간의 질병 예방, 진단, 치료, 건강유지 및 증진을 통해 수명 연장 및 삶의 질 개선을 목적으로 하는 학문 공부");
                    pharmacy_num.setText("061-450-2680");
                    pharmacyImageView.setImageResource(R.drawable.pharmacy);
                    pharmacyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pharmacy.mokpo.ac.kr/pharmacy/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                pharmacyDesc.setVisibility(View.VISIBLE);
                pharmacyImageView.setVisibility(View.VISIBLE);
                pharmacy_phone.setVisibility(View.VISIBLE);
                pharmacy_num.setVisibility(View.VISIBLE);

            }
        });
        pharmacy_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 전화번호를 가져와 전화 다이얼 띄우기
                String phoneNumber = ((TextView) v).getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(dialIntent);
            }
        });
    }
}
