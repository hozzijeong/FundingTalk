package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

public class invest_input_file_Fragment extends Main_BaseFragment {

    private int ok_money = 0;
    private int ok_confirm = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.invest_input_file_fragment,container,false);


            //돈 입력받는 텍스트
            EditText numberText = (EditText)v.findViewById(R.id.input_money);
            EditText confirmtext = (EditText)v.findViewById(R.id.input_confirm);
            confirmtext.setPrivateImeOptions("defaultInputmode=korean; ");

            //투자하기 버튼을 눌렀을 경우
            Button button1 = (Button) v.findViewById(R.id.go_finish) ;
            button1.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try { //숫자말고 다른 것을 입력할때 튕기는것을 방지
                        if ( (Integer.parseInt(numberText.getText().toString()) <= 5000) && (isInteger(numberText.getText().toString()) == true) ) { //나중에 DB값으로 바꾸기
                            ok_money = 1;
//                    Log.d("숫자입력", "숫자 완료");
                        }
                    }
                    catch(NumberFormatException e){
                        Toast myToast = Toast.makeText(getActivity(),"투자금액을 제대로 입력해주세요", Toast.LENGTH_SHORT);
                        myToast.show();
                    }

                    if ( confirmtext.getText().toString().equals("abc")) { //나중에 동의함으로 수정
                        //동의함이 들어오면
                        ok_confirm = 1;
//                    Log.d("입력", "동의함 완료 완료");
                    }
                    else{
                        Log.d("입력", confirmtext.getText().toString());
                    }

                    //모든걸 잘 입력하면
                    if (ok_money == 1 && ok_confirm == 1){
                        numberText.setText("");
                        confirmtext.setText("");
                        mainActivity.changeFragment(R.id.main_layout,mainActivity.invest_finish_Fragment);
//                    Log.d("입력", "완전히 완료");
                    }
                    //한개라도 잘못입력하면
                    else{
                        if(ok_money == 0){
                            Toast myToast = Toast.makeText(getActivity(),"투자금액을 제대로 입력해주세요", Toast.LENGTH_SHORT);
                            myToast.show();
                        }
                        else if(ok_confirm ==0){
                            Toast myToast = Toast.makeText(getActivity(),"동의함을 정확히 입력해주세요", Toast.LENGTH_SHORT);
                            myToast.show();
                        }
                        else if(ok_money ==0 && ok_confirm ==0){
                            Toast myToast = Toast.makeText(getActivity(),"투자금액 및 동의함을 정확히 입력해주세요", Toast.LENGTH_SHORT);
                            myToast.show();

                        }
                    }
                }
            });

            numberText.addTextChangedListener(new TextWatcher() { //나중에 입력하고 나서 경고문 뜨게 하고 싶을때 하기※※※※※※※※※※※
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // 입력이 끝났을 때

                }
            });
        //---
        return v;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
