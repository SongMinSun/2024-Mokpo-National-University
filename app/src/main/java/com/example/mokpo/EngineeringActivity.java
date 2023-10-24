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

public class EngineeringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.engineering);

        // 스위치를 ID로 찾습니다
        Switch engineeringSwitch = findViewById(R.id.engineeringswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup engineeringRadioGroup = findViewById(R.id.engineeringrg);
        final TextView engineeringIntroTextView = findViewById(R.id.engineering_2);
        final ImageView engineeringImageView = findViewById(R.id.engineeringimg);
        final Button engineeringLinkButton = findViewById(R.id.engineeringlink);
        final TextView engineering_num = findViewById(R.id.engineering_num);

        // TextView를 ID로 찾습니다
        final TextView EngineeringDesc = findViewById(R.id.Engineering_desc);
        final TextView engineering_phone = findViewById(R.id.engineering_phone);

        // btn_back 버튼을 ID로 찾습니다
        Button btn_engineeringback = findViewById(R.id.engineeringback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_engineeringback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EngineeringActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        engineeringSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    engineeringRadioGroup.setVisibility(View.VISIBLE);
                    engineeringIntroTextView.setVisibility(View.VISIBLE);
                    engineeringImageView.setVisibility(View.VISIBLE);
                    engineeringLinkButton.setVisibility(View.VISIBLE);
                    engineering_num.setVisibility(View.VISIBLE);
                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    engineeringRadioGroup.setVisibility(View.INVISIBLE);
                    engineeringIntroTextView.setVisibility(View.INVISIBLE);
                    engineeringImageView.setVisibility(View.INVISIBLE);
                    engineeringLinkButton.setVisibility(View.INVISIBLE);
                    engineering_num.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    EngineeringDesc.setVisibility(View.INVISIBLE);
                    engineering_phone.setVisibility(View.INVISIBLE);

                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        engineeringRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.engineering1) {
                    EngineeringDesc.setText("전자분야, 자동차분야, 의료기기, 에너지 등 다양한 산업에서 요구되는 반도체를 위한 경험기반 실무교육");
                    engineering_num.setText("061-450-2430");
                    engineeringImageView.setImageResource(R.drawable.engineering1);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://semicon.mokpo.ac.kr/E1/index.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.engineering2) {
                    EngineeringDesc.setText("자동차, 선박, 해양 및 육상플랜트, 인공지능 로봇, 드론 등의 친환경 고부가가치 기술 연구");
                    engineering_num.setText("061-450-2410");
                    engineeringImageView.setImageResource(R.drawable.engineering2);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1362/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.engineering3) {
                    EngineeringDesc.setText("우리 주변의 여러 전기적/자기적 현상을 학문적으로 규명하고, 전기에너지의 발생, 수송, 이용과 관련된 기초 이론과 응용 기술을 연구하는 학문공부");
                    engineering_num.setText("061-450-2480");
                    engineeringImageView.setImageResource(R.drawable.engineering3);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elec-con.mokpo.ac.kr/elec-con/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.engineering4) {
                    EngineeringDesc.setText("인공지능을 기술적, 이론적으로 이해하고, 설계, 구현, 응용하는 학문공부");
                    engineering_num.setText("061-450-2740");
                    engineeringImageView.setImageResource(R.drawable.engineering4);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ai.mokpo.ac.kr/E4/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }else if (checkedId == R.id.engineering5) {
                    EngineeringDesc.setText("컴퓨터학부에는 컴퓨터공학 전공, 융합소프트웨어 전공, 정보보호 전공이 있습니다.");
                    engineering_num.setText("061-450-2440");
                    engineeringImageView.setImageResource(R.drawable.engineering5);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1363/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.engineering6) {
                    EngineeringDesc.setText("건축·토목·환경공학부에는 건축공학 전공, 토목공학 전공, 환경공학 전공이 있습니다.");
                    engineering_num.setText("061-450-2450");
                    engineeringImageView.setImageResource(R.drawable.engineering6);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1364/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.engineering7) {
                    EngineeringDesc.setText("도시계획및조경학부에는 조경학 전공, 도시계획및지역개발학 전공이 있습니다.");
                    engineering_num.setText("061-450-2360");
                    engineeringImageView.setImageResource(R.drawable.engineering7);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1365/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.engineering8) {
                    EngineeringDesc.setText("지역적 특성을 구현하고 지역사회 발전을 선도하는 건축가 양성");
                    engineering_num.setText("061-450-2720");
                    engineeringImageView.setImageResource(R.drawable.engineering8);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://doa.mokpo.ac.kr/doa/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }else if (checkedId == R.id.engineering9) {
                    EngineeringDesc.setText("탄소 중립 구현을 위한 차세대 신기술 산업을 담당할 인력양성을 목적으로 함");
                    engineering_num.setText("061-450-2330");
                    engineeringImageView.setImageResource(R.drawable.engineering9);
                    engineeringLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mnuk2.mokpo.ac.kr/sites/E9/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                EngineeringDesc.setVisibility(View.VISIBLE);
                engineeringImageView.setVisibility(View.VISIBLE);
                engineering_phone.setVisibility(View.VISIBLE);
                engineering_num.setVisibility(View.VISIBLE);

            }
        });
        engineering_num.setOnClickListener(new View.OnClickListener() {
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
