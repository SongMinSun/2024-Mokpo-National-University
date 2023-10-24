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

public class EducationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education);

        // 스위치를 ID로 찾습니다
        Switch educationSwitch = findViewById(R.id.educationswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup educationRadioGroup = findViewById(R.id.educationrg);
        final TextView educationIntroTextView = findViewById(R.id.education_2);
        final ImageView educationImageView = findViewById(R.id.educationimg);
        final Button educationLinkButton = findViewById(R.id.educationlink);
        final TextView education_num = findViewById(R.id.education_num);

        // TextView를 ID로 찾습니다
        final TextView educationDesc = findViewById(R.id.education_desc);
        final TextView education_phone = findViewById(R.id.education_phone);

        // btn_back 버튼을 ID로 찾습니다
        Button btn_educationback = findViewById(R.id.educationback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_educationback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EducationActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        educationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    educationRadioGroup.setVisibility(View.VISIBLE);
                    educationIntroTextView.setVisibility(View.VISIBLE);
                    educationImageView.setVisibility(View.VISIBLE);
                    educationLinkButton.setVisibility(View.VISIBLE);
                    education_num.setVisibility(View.VISIBLE);

                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    educationRadioGroup.setVisibility(View.INVISIBLE);
                    educationIntroTextView.setVisibility(View.INVISIBLE);
                    educationImageView.setVisibility(View.INVISIBLE);
                    educationLinkButton.setVisibility(View.INVISIBLE);
                    education_num.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    educationDesc.setVisibility(View.INVISIBLE);
                    education_phone.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        educationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.education1) {
                    educationDesc.setText("학습지도 능력을 갖춘 바람직한 교육실천가 양성");
                    education_num.setText("061-450-2170");
                    educationImageView.setImageResource(R.drawable.education1);
                    educationLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://educa.mokpo.ac.kr/educa/index.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.education2) {
                    educationDesc.setText("진리와 정의를 탐구하는 윤리교육과");
                    education_num.setText("061-450-2180");
                    educationImageView.setImageResource(R.drawable.education2);
                    educationLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ethics.mokpo.ac.kr/ethics/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.education3) {
                    educationDesc.setText("영어교육발전에 공헌하며 영어학습 지도 능력을 갖춘 바람직한 교육 실천가를 양성하는 국립목포대학교 영어교육과");
                    education_num.setText("061-450-2540");
                    educationImageView.setImageResource(R.drawable.education3);
                    educationLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://englishedu.mokpo.ac.kr/englishedu/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.education4) {
                    educationDesc.setText("중등학교의 우수한 수학 교사 양성하는데 목표를 둠");
                    education_num.setText("061-450-2310");
                    educationImageView.setImageResource(R.drawable.education4);
                    educationLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mmed.mokpo.ac.kr/mmed/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                else if (checkedId == R.id.education5) {
                    educationDesc.setText("미래의 환경을 생각하는 국립목포대학교 환경교육과");
                    education_num.setText("061-450-2780");
                    educationImageView.setImageResource(R.drawable.education5);
                    educationLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://eedu.mokpo.ac.kr/eedu/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                educationDesc.setVisibility(View.VISIBLE);
                educationImageView.setVisibility(View.VISIBLE);
                education_phone.setVisibility(View.VISIBLE);
                education_num.setVisibility(View.VISIBLE);

            }
        });
        education_num.setOnClickListener(new View.OnClickListener() {
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
