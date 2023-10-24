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

public class SocialScienceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socialscience);

        // 스위치를 ID로 찾습니다
        Switch socialSwitch = findViewById(R.id.socialswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup socialRadioGroup = findViewById(R.id.socialrg);
        final TextView socialIntroTextView = findViewById(R.id.social_2);
        final ImageView socialImageView = findViewById(R.id.socialimg);
        final Button socialLinkButton = findViewById(R.id.sociallink);
        final TextView social_num = findViewById(R.id.social_num);

        // TextView를 ID로 찾습니다
        final TextView SocialscienceDesc = findViewById(R.id.Socialscience_desc);
        final TextView social_phone = findViewById(R.id.social_phone);

        // btn_back 버튼을 ID로 찾습니다
        Button btn_Socialscienceback = findViewById(R.id.socialback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_Socialscienceback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SocialScienceActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        socialSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    socialRadioGroup.setVisibility(View.VISIBLE);
                    socialIntroTextView.setVisibility(View.VISIBLE);
                    socialImageView.setVisibility(View.VISIBLE);
                    socialLinkButton.setVisibility(View.VISIBLE);
                    social_num.setVisibility(View.VISIBLE);
                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    socialRadioGroup.setVisibility(View.INVISIBLE);
                    socialIntroTextView.setVisibility(View.INVISIBLE);
                    socialImageView.setVisibility(View.INVISIBLE);
                    socialLinkButton.setVisibility(View.INVISIBLE);
                    social_num.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    SocialscienceDesc.setVisibility(View.INVISIBLE);
                    social_phone.setVisibility(View.INVISIBLE);

                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        socialRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.social1) {
                    SocialscienceDesc.setText("법·경찰학부에는 법학 전공, 경찰안전법 전공이 있습니다.");
                    social_num.setText("061-450-2230");
                    socialImageView.setImageResource(R.drawable.social1);
                    socialLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1358/subview.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.social2) {
                    SocialscienceDesc.setText("행정·언론미디어학부에는 행정학 전공, 정치언론학 전공이 있습니다.");
                    social_num.setText("061-450-2240");
                    socialImageView.setImageResource(R.drawable.social2);
                    socialLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1359/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.social3) {
                    SocialscienceDesc.setText("우리나라의 국토 공간을 조사·등록하는 국토정보(지적)의 학문적 이론을 연구·교육하는 학과");
                    social_num.setText("061-450-2250");
                    socialImageView.setImageResource(R.drawable.social3);
                    socialLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://landadm.mokpo.ac.kr/landadm/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.social4) {
                    SocialscienceDesc.setText("따듯한 용기로 세상을 바꾸는 목포대 사회복지학과");
                    social_num.setText("061-450-2270");
                    socialImageView.setImageResource(R.drawable.social4);
                    socialLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://welfare.mokpo.ac.kr/welfare/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }else if (checkedId == R.id.social5) {
                    SocialscienceDesc.setText("관광산업을 선도하고 지역발전을 견인하는 창의융합형 관광인재 양성의 산실");
                    social_num.setText("061-450-2640");
                    socialImageView.setImageResource(R.drawable.social5);
                    socialLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tourism.mokpo.ac.kr/S5/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                SocialscienceDesc.setVisibility(View.VISIBLE);
                socialImageView.setVisibility(View.VISIBLE);
                social_phone.setVisibility(View.VISIBLE);
                social_num.setVisibility(View.VISIBLE);


            }
        });

        social_num.setOnClickListener(new View.OnClickListener() {
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
