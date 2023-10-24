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

public class BusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business);

        // 스위치를 ID로 찾습니다
        Switch businessSwitch = findViewById(R.id.businessswitch);

        // 보이거나 감출 다른 뷰들을 찾습니다
        final RadioGroup businessRadioGroup = findViewById(R.id.businessrg);
        final TextView businessIntroTextView = findViewById(R.id.business_2);
        final ImageView businessImageView = findViewById(R.id.businessimg);
        final Button businessLinkButton = findViewById(R.id.businesslink);
        final TextView business_num = findViewById(R.id.business_num);


        // TextView를 ID로 찾습니다
        final TextView businessDesc = findViewById(R.id.business_desc);
        final TextView business_phone = findViewById(R.id.business_phone);


        // btn_back 버튼을 ID로 찾습니다
        Button btn_businessback = findViewById(R.id.businessback);
        // 이전으로 버튼을 누르면 GradeActivity로 이동
        btn_businessback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusinessActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });

        // 스위치의 상태를 감지하는 리스너를 설정합니다
        businessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치가 체크된 경우, 뷰들의 가시성을 VISIBLE로 설정합니다
                if (isChecked) {
                    businessRadioGroup.setVisibility(View.VISIBLE);
                    businessIntroTextView.setVisibility(View.VISIBLE);
                    businessImageView.setVisibility(View.VISIBLE);
                    businessLinkButton.setVisibility(View.VISIBLE);
                    business_num.setVisibility(View.VISIBLE);
                } else {
                    // 스위치가 체크되지 않은 경우, 뷰들의 가시성을 INVISIBLE로 설정합니다
                    businessRadioGroup.setVisibility(View.INVISIBLE);
                    businessIntroTextView.setVisibility(View.INVISIBLE);
                    businessImageView.setVisibility(View.INVISIBLE);
                    businessLinkButton.setVisibility(View.INVISIBLE);
                    business_num.setVisibility(View.INVISIBLE);

                    // TextView를 숨깁니다
                    businessDesc.setVisibility(View.INVISIBLE);
                }
            }
        });

        businessRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 선택된 라디오 버튼에 따라 해당 학과 설명을 표시
                if (checkedId == R.id.business1) {
                    businessDesc.setText("경영학부에는 경영학 전공, 금융보험학 전공이 있습니다.");
                    business_num.setText("061-450-2610");
                    businessImageView.setImageResource(R.drawable.business1);
                    businessLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1366/subview.do"));
                            startActivity(urlintent);
                        }
                    });

                } else if (checkedId == R.id.business2) {
                    businessDesc.setText("경제무역학부에는 경제학 전공, 무역학 전공이 있습니다.");
                    business_num.setText("061-450-2210");
                    businessImageView.setImageResource(R.drawable.business2);
                    businessLinkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mokpo.ac.kr/ipsi/1367/subview.do"));
                            startActivity(urlintent);
                        }
                    });
                }
                // TextView를 보이게 합니다
                businessDesc.setVisibility(View.VISIBLE);
                businessImageView.setVisibility(View.VISIBLE);
                business_phone.setVisibility(View.VISIBLE);
                business_num.setVisibility(View.VISIBLE);
            }
        });
        business_num.setOnClickListener(new View.OnClickListener() {
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
