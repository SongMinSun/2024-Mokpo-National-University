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

public class HumanitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humanities);

        // 스위치를 ID로 찾습니다
        Switch humanitiesSwitch = findViewById(R.id.humanswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup humanitiesRadioGroup = findViewById(R.id.humanrg);
        final TextView humanitiesIntroTextView = findViewById(R.id.human_2);
        final ImageView humanitiesImageView = findViewById(R.id.humanimg);
        final Button humanitiesLinkButton = findViewById(R.id.humanlink);
        final TextView humaitiesNum = findViewById(R.id.humanities_num);

        // TextView를 ID로 찾습니다
        final TextView humanitiesDesc = findViewById(R.id.humanities_desc);
        final TextView human_phone = findViewById(R.id.humanities_phone);

        // btn_back 버튼을 ID로 찾습니다
        Button btn_humanback = findViewById(R.id.humanback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_humanback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HumanitiesActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });


        // 스위치의 상태를 감지하는 리스너를 설정합니다
        humanitiesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    humanitiesRadioGroup.setVisibility(View.VISIBLE);
                    humanitiesIntroTextView.setVisibility(View.VISIBLE);
                    humanitiesImageView.setVisibility(View.VISIBLE);
                    humanitiesLinkButton.setVisibility(View.VISIBLE);
                    humaitiesNum.setVisibility(View.VISIBLE);
                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    humanitiesRadioGroup.setVisibility(View.INVISIBLE);
                    humanitiesIntroTextView.setVisibility(View.INVISIBLE);
                    humanitiesImageView.setVisibility(View.INVISIBLE);
                    humanitiesLinkButton.setVisibility(View.INVISIBLE);
                    humaitiesNum.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    humanitiesDesc.setVisibility(View.INVISIBLE);
                    human_phone.setVisibility(View.VISIBLE);
                }
            }
        });

        // 라디오 버튼 선택 시 해당 학과에 대한 설명을 표시
        humanitiesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.human1) {
                    humanitiesDesc.setText("국어국문·문예창작학부에는 국어국문학 전공, 문예창작 전공이 있습니다.");
                    humanitiesImageView.setImageResource(R.drawable.human1);
                    humaitiesNum.setText("061-450-2110");
                    humanitiesLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1355/subview.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.human2) {
                    humanitiesDesc.setText("글로벌커뮤니케이션학부에는 영어영문학 전공, 동아시아문화 전공, 일어일문학 전공이 있습니다.");
                    humanitiesImageView.setImageResource(R.drawable.human2);
                    humaitiesNum.setText("061-450-2110");
                    humanitiesLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1356/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                } else if (checkedId == R.id.human3) {
                    humanitiesDesc.setText("인문콘텐츠학부에는 문화콘텐츠학 전공, 역사콘텐츠 전공, 문화유산 전공이 있습니다.");
                    humanitiesImageView.setImageResource(R.drawable.human3);
                    humaitiesNum.setText("061-450-2690");
                    humanitiesLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1357/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                humanitiesDesc.setVisibility(View.VISIBLE);
                humanitiesImageView.setVisibility(View.VISIBLE);
                humaitiesNum.setVisibility(View.VISIBLE);
                human_phone.setVisibility(View.VISIBLE);

            }
        });
        humaitiesNum.setOnClickListener(new View.OnClickListener() {
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
