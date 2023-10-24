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

public class HumanEcologyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humanecology);

        // 스위치를 ID로 찾습니다
        Switch humanEcologySwitch = findViewById(R.id.humanecologyswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup humanEcologyRadioGroup = findViewById(R.id.humanecologyrg);
        final TextView humanEcologyIntroTextView = findViewById(R.id.humanecology_2);
        final ImageView humanEcologyImageView = findViewById(R.id.humanecologyimg);
        final Button humanEcologyLinkButton = findViewById(R.id.humanecologylink);
        final TextView humanecology_num = findViewById(R.id.humanecology_num);

        // TextView를 ID로 찾습니다
        final TextView humanecologyDesc = findViewById(R.id.humanecology_desc);
        final TextView humanecology_phone = findViewById(R.id.humanecology_phone);

        // btn_back 버튼을 ID로 찾습니다
        Button btn_humanecologyback = findViewById(R.id.humanecologyback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_humanecologyback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HumanEcologyActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        humanEcologySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    humanEcologyRadioGroup.setVisibility(View.VISIBLE);
                    humanEcologyIntroTextView.setVisibility(View.VISIBLE);
                    humanEcologyImageView.setVisibility(View.VISIBLE);
                    humanEcologyLinkButton.setVisibility(View.VISIBLE);
                    humanecology_num.setVisibility(View.VISIBLE);
                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    humanEcologyRadioGroup.setVisibility(View.INVISIBLE);
                    humanEcologyIntroTextView.setVisibility(View.INVISIBLE);
                    humanEcologyImageView.setVisibility(View.INVISIBLE);
                    humanEcologyLinkButton.setVisibility(View.INVISIBLE);
                    humanecology_num.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    humanecologyDesc.setVisibility(View.INVISIBLE);
                    humanecology_phone.setVisibility(View.INVISIBLE);


                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        humanEcologyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.humanecology1) {
                    humanecologyDesc.setText("아동의 전인적 발달에 기초한 전문적 지식과 아동을 사랑하는 인성을 기반으로 현장중심의 실무능력을 겸비한 아동전문 보육인 양성");
                    humanecology_num.setText("061-450-2510");
                    humanEcologyImageView.setImageResource(R.drawable.humanecology1);
                    humanEcologyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://child.mokpo.ac.kr/child/index.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.humanecology2) {
                    humanecologyDesc.setText("인체 건강에 영향을 미치는 식품 속 영양소 대사 및 상호작용을 이해하고, 식품의 위생과 안전성을 고려하여 개인이나 사회의 건강 증진을 위한 전문가를 양성하는 학문");
                    humanecology_num.setText("061-450-2520");
                    humanEcologyImageView.setImageResource(R.drawable.humanecology2);
                    humanEcologyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fashion.mokpo.ac.kr/fashion/index.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.humanecology3) {
                    humanecologyDesc.setText("창조적이고 진취적인 패션전문 인력을 양성 국립목포대학교 패션의류학과");
                    humanecology_num.setText("061-450-2530");
                    humanEcologyImageView.setImageResource(R.drawable.humanecology3);
                    humanEcologyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/945/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.humanecology4) {
                    humanecologyDesc.setText("국내 유일한 학과로 새로운 도약 음악공연기획과");
                    humanecology_num.setText("061-450-6050");
                    humanEcologyImageView.setImageResource(R.drawable.humanecology4);
                    humanEcologyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://music.mokpo.ac.kr/music/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.humanecology5) {
                    humanecologyDesc.setText("아트앤디자인학부에는 뉴아트영상애니메이션 전공, 시각디자인 전공이 있습니다.");
                    humanecology_num.setText("061-450-6070");
                    humanEcologyImageView.setImageResource(R.drawable.humanecology5);
                    humanEcologyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1368/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.humanecology6) {
                    humanecologyDesc.setText("학교, 생활, 전문 체육 현장에서 움직임, 운동, 스포츠를 과학적이고 체계적으로 탐구하고 현장 능력을 함양하고자 함");
                    humanecology_num.setText("061-450-2380");
                    humanEcologyImageView.setImageResource(R.drawable.humanecology6);
                    humanEcologyLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://physical.mokpo.ac.kr/physical/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                humanecologyDesc.setVisibility(View.VISIBLE);
                humanEcologyImageView.setVisibility(View.VISIBLE);
                humanecology_phone.setVisibility(View.VISIBLE);
                humanecology_num.setVisibility(View.VISIBLE);
            }
        });
        humanecology_num.setOnClickListener(new View.OnClickListener() {
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
