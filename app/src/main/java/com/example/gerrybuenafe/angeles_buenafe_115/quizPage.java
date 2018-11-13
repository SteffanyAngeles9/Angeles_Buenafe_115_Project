package com.example.gerrybuenafe.angeles_buenafe_115;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quizPage extends AppCompatActivity {
    Button mButton;
    Dialog mDialog;
    TextView mTextView;
    ImageView mImageView;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        mDialog = new Dialog(this);
        mRadioGroup = findViewById(R.id.radioGrp);

        mButton = findViewById(R.id.quizBtn);

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int radioId = mRadioGroup.getCheckedRadioButtonId();
                mRadioButton = findViewById(radioId);
                final String ans = mRadioButton.getText().toString();
                String correctAns = "Choice 3";
                showDialogBox(ans, correctAns);
            }
        });
    }

    public void showDialogBox(String ans, String correctAns){
        mDialog.setContentView(R.layout.custom_dialog);

        mButton = mDialog.findViewById(R.id.ok);
        mTextView = mDialog.findViewById(R.id.yourAns);
        mTextView.setText("Your Answer: " + ans);
        mTextView = mDialog.findViewById(R.id.correctAns);
        mTextView.setText("Correct Answer : " + correctAns);
        mTextView = mDialog.findViewById(R.id.Compare);
        mImageView = mDialog.findViewById(R.id.checkWrong);
        if(correctAns.equalsIgnoreCase(ans)){
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.check));
            mTextView.setText("Correct Answer!!");
        }else {
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.ex));
            mTextView.setText("Wrong Answer!!");
        }
        mImageView = mDialog.findViewById(R.id.close);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();

    }
}