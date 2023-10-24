package com.example.mokpo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DirectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.direct);

        // 스위치를 ID로 찾습니다
        Switch directSwitch = findViewById(R.id.directswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup directRadioGroup = findViewById(R.id.directrg);
        final TextView directIntroTextView = findViewById(R.id.direct_2);
        final ImageView directImageView = findViewById(R.id.directimg);
        final Button directLinkButton = findViewById(R.id.directlink);
        final TextView direct_num = findViewById(R.id.direct_num);

        // TextView를 ID로 찾습니다
        final TextView directDesc = findViewById(R.id.direct_desc);
        final TextView direct_phone = findViewById(R.id.direct_phone);


        // btn_back 버튼을 ID로 찾습니다
        Button btn_directback = findViewById(R.id.directback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_directback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DirectActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });

        // 스위치의 상태를 감지하는 리스너를 설정합니다
        directSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    directRadioGroup.setVisibility(View.VISIBLE);
                    directIntroTextView.setVisibility(View.VISIBLE);
                    directImageView.setVisibility(View.VISIBLE);
                    directLinkButton.setVisibility(View.VISIBLE);
                    directLinkButton.setVisibility(View.VISIBLE);
                    direct_num.setVisibility(View.VISIBLE);

                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    directRadioGroup.setVisibility(View.INVISIBLE);
                    directIntroTextView.setVisibility(View.INVISIBLE);
                    directImageView.setVisibility(View.INVISIBLE);
                    directLinkButton.setVisibility(View.INVISIBLE);
                    directDesc.setVisibility(View.INVISIBLE);
                    direct_num.setVisibility(View.INVISIBLE);


                    // TextView를 숨깁니다
                    directDesc.setVisibility(View.INVISIBLE);
                    direct_phone.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        directRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.direct1) {
                    directDesc.setText("해외유학을 목표로 삼고 있는 학생들을 위한 학부");
                    direct_num.setText("061-450-7380");
                    directImageView.setImageResource(R.drawable.direct1);
                    directLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/960/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.direct2) {
                    directDesc.setText("따로 정해진 전공․학과 없이 목포대의 모든 전공․학과(보건, 사범 계열 등 일부 학과 제외)를 자유롭게 선택할 수 있는 학부");
                    direct_num.setText("061-450-7380");
                    directImageView.setImageResource(R.drawable.direct2);
                    directLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/961/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                directDesc.setVisibility(View.VISIBLE);
                directImageView.setVisibility(View.VISIBLE);
                direct_phone.setVisibility(View.VISIBLE);
                direct_num.setVisibility(View.VISIBLE);

            }
        });
        direct_num.setOnClickListener(new View.OnClickListener() {
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
