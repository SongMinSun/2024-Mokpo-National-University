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

public class FutureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.future);

        // 스위치를 ID로 찾습니다
        Switch futureSwitch = findViewById(R.id.futureswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup futureRadioGroup = findViewById(R.id.futurerg);
        final TextView futureIntroTextView = findViewById(R.id.future_2);
        final ImageView futureImageView = findViewById(R.id.futureimg);
        final Button futureLinkButton = findViewById(R.id.futurelink);
        final TextView future_num = findViewById(R.id.future_num);


        // TextView를 ID로 찾습니다
        final TextView futureDesc = findViewById(R.id.future_desc);
        final TextView future_phone = findViewById(R.id.future_phone);

        // btn_back 버튼을 ID로 찾습니다
        Button btn_futureback = findViewById(R.id.futureback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_futureback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FutureActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        futureSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    futureRadioGroup.setVisibility(View.VISIBLE);
                    futureIntroTextView.setVisibility(View.VISIBLE);
                    futureImageView.setVisibility(View.VISIBLE);
                    futureLinkButton.setVisibility(View.VISIBLE);
                    future_num.setVisibility(View.VISIBLE);
                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    futureRadioGroup.setVisibility(View.INVISIBLE);
                    futureIntroTextView.setVisibility(View.INVISIBLE);
                    futureImageView.setVisibility(View.INVISIBLE);
                    futureLinkButton.setVisibility(View.INVISIBLE);
                    future_num.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    futureDesc.setVisibility(View.INVISIBLE);
                    future_phone.setVisibility(View.INVISIBLE);


                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        futureRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.future1) {
                    futureDesc.setText("총체적 자질을 갖춘 실무 중심 리더 양성, 창의․융합적 사고를 통한 현장 경험 전문 함양, 맞춤형 생애 설계를 위한 전문 역량 함양으로 설정하고 이론 및 실기, 현장 실무 역량 심화");
                    future_num.setText("061-450-7380");
                    futureImageView.setImageResource(R.drawable.future1);
                    futureLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mnuk2.mokpo.ac.kr/sites/F1/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.future2) {
                    futureDesc.setText("인간의 정서, 심리, 행동에 대한 이해를 바탕으로 전문지식을 갖춘 상담심리치료 전문가 양성");
                    future_num.setText("-");
                    futureImageView.setImageResource(R.drawable.future2);
                    futureLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://counseling.mokpo.ac.kr/sites/F2/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.future3) {
                    futureDesc.setText("21세기 한국 차(茶)문화의 세계화를 선도하는 학사학위 전문가 과정 인재 양성");
                    future_num.setText("061-450-2140");
                    futureImageView.setImageResource(R.drawable.future3);
                    futureLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tea.mokpo.ac.kr/F3/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.future4) {
                    futureDesc.setText("전문역량을 갖춘 융합형 회계전문가 양성");
                    future_num.setText("061-450-2610");
                    futureImageView.setImageResource(R.drawable.future4);
                    futureLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mnuk2.mokpo.ac.kr/sites/F4/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.future5) {
                    futureDesc.setText("에너지 관련 기업 및 기관의 소속 직원, 만학도의 재교육 및 직무능력 향상을 위해 스마트에너지관련 산업에 필요한 설계, 개발, 운용 및 품질관리 등 전문기술 인력양성");
                    future_num.setText("061-338-3969");
                    futureImageView.setImageResource(R.drawable.future5);
                    futureLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://se.mokpo.ac.kr/F5/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.future6) {
                    futureDesc.setText("공정혁신을 위한 융합적 사고를 갖춘 친환경 선박생산 전문인력을 양성");
                    future_num.setText("061-460-7450");
                    futureImageView.setImageResource(R.drawable.future6);
                    futureLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mnuk2.mokpo.ac.kr/sites/F6/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                futureDesc.setVisibility(View.VISIBLE);
                futureImageView.setVisibility(View.VISIBLE);
                future_phone.setVisibility(View.VISIBLE);
                future_num.setVisibility(View.VISIBLE);


            }
        });
        future_num.setOnClickListener(new View.OnClickListener() {
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
