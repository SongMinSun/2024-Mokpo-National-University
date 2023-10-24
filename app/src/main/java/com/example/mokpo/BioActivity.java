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

public class BioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio);

        // 스위치를 ID로 찾습니다
        Switch bioSwitch = findViewById(R.id.bioswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup bioRadioGroup = findViewById(R.id.biorg);
        final TextView bioIntroTextView = findViewById(R.id.bio_2);
        final ImageView bioImageView = findViewById(R.id.bioimg);
        final Button bioLinkButton = findViewById(R.id.biolink);
        final TextView bio_num = findViewById(R.id.bio_num);


        // TextView를 ID로 찾습니다
        final TextView bioDesc = findViewById(R.id.bio_desc);
        final TextView bio_phone = findViewById(R.id.bio_phone);


        // btn_back 버튼을 ID로 찾습니다
        Button btn_bioback = findViewById(R.id.bioback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_bioback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BioActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });

        // 스위치의 상태를 감지하는 리스너를 설정합니다
        bioSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    bioRadioGroup.setVisibility(View.VISIBLE);
                    bioIntroTextView.setVisibility(View.VISIBLE);
                    bioImageView.setVisibility(View.VISIBLE);
                    bioLinkButton.setVisibility(View.VISIBLE);
                    bio_num.setVisibility(View.VISIBLE);

                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    bioRadioGroup.setVisibility(View.INVISIBLE);
                    bioIntroTextView.setVisibility(View.INVISIBLE);
                    bioImageView.setVisibility(View.INVISIBLE);
                    bioLinkButton.setVisibility(View.INVISIBLE);
                    bio_num.setVisibility(View.INVISIBLE);
                    // TextView를 숨깁니다
                    bioDesc.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        bioRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.bio1) {
                    bioDesc.setText("식품ㆍ제약공학부에는 식품공학 전공, 제약공학 전공이 있습니다.");
                    bio_num.setText("061-450-2420");
                    bioImageView.setImageResource(R.drawable.bio1);
                    bioLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1360/subview.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.bio2) {
                    bioDesc.setText("원예산림학부에는 산림자원 전공, 원예전공 전공이 있습니다.");
                    bio_num.setText("061-450-2660");
                    bioImageView.setImageResource(R.drawable.bio2);
                    bioLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1361/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.bio3) {
                    bioDesc.setText("해양수산과학분야에 전문성과 자질있는 인력 배출");
                    bio_num.setText("061-450-2390");
                    bioImageView.setImageResource(R.drawable.bio3);
                    bioLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://marine.mokpo.ac.kr/marine/index.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.bio4) {
                    bioDesc.setText("창의적 사고력, 탐구능력을 지닌 전문간호인 양성");
                    bio_num.setText("061-450-2670");
                    bioImageView.setImageResource(R.drawable.bio4);
                    bioLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nurse.mokpo.ac.kr/nurse/index.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                bioDesc.setVisibility(View.VISIBLE);
                bioImageView.setVisibility(View.VISIBLE);
                bio_phone.setVisibility(View.VISIBLE);
                bio_num.setVisibility(View.VISIBLE);

            }
        });
        bio_num.setOnClickListener(new View.OnClickListener() {
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
