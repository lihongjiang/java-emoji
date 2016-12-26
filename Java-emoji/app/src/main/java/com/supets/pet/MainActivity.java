package com.supets.pet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.supets.pet.core.EmojiMap;
import com.supets.pet.java_emoji.R;
import com.supets.pet.utls.DataBaseCopyUtils;
import com.supets.pet.utls.EmojiHtmlDbUtils;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{


    private EditText mInput;
    private Button mEncode;
    private Button mDecode;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // EmojiMap.initData();
        // DataBaseCopyUtils.copyDBToSDcrad();

        mInput = (EditText) findViewById(R.id.input);
        mEncode = (Button) findViewById(R.id.encode);
        mDecode = (Button) findViewById(R.id.decode);
        mResult = (TextView) findViewById(R.id.result);

        mEncode.setOnClickListener(this);
        mDecode.setOnClickListener(this);

        EmojiHtmlDbUtils.insertEmojiData();

    }

    @Override
    public void onClick(View v) {

        if (v==mEncode){
            mResult.setText(EmojiMap.utf8ToHtml(mInput.getText().toString()));
        }

        if (v==mDecode){
            String  text=EmojiMap.utf8ToHtml(mInput.getText().toString());
            text=EmojiMap.htmlToUtf8(text);
            mResult.setText(text);
        }

    }
}
