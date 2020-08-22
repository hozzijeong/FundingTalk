package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Loan_BaseFragment;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Loan_Base_Info_Fragment extends Loan_BaseFragment implements View.OnClickListener{

    @BindView(R.id.loan_user_name_et) EditText name;
    @BindView(R.id.loan_user_birth_et) EditText birth;
    @BindView(R.id.loan_user_phone_et) EditText phone;
    @BindView(R.id.loan_user_mail_et) EditText mail;
    @BindView(R.id.loan_specific_btn) Button next_page;
    @BindView(R.id.loan_user_use_et) EditText use;
    @BindView(R.id.loan_live_ok) RadioButton ok;
    @BindView(R.id.loan_live_no) RadioButton no;
    @BindView(R.id.loan_back_activity) Button back;
    private boolean possible = true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loan01_base_info_fragment,container,false);
        ButterKnife.bind(this,v);
        next_page.setOnClickListener(this);
        back.setOnClickListener(this);
        return v;
    }
    private boolean next_state(){
        int check_cnt = 0;
        if (name.getText().toString().length()>1){
            check_cnt++;
        }
        loanActivity.show_Log("이름: "+check_cnt);
        if(birth.getText().toString().length() == 8){
            check_cnt++;
        }
        loanActivity.show_Log("birth: "+check_cnt);

        if (phone.getText().toString().length() == 10 ||
                phone.getText().toString().length() == 11) {
            check_cnt++;
        }
        loanActivity.show_Log("phone: "+check_cnt);
        if(mail.getText().toString().length()>6){
            check_cnt++;
        }
        loanActivity.show_Log("mail: "+check_cnt);
        if(ok.isChecked() || no.isChecked()){
            check_cnt++;
        }
        loanActivity.show_Log("check: "+check_cnt);
        if(!(use.getText().toString().contains("주택")
                && use.getText().toString().contains("구매"))){
            check_cnt++;
        }
        loanActivity.show_Log("use: "+check_cnt);

        if(check_cnt == 6){
            possible = true;
        }else {
            possible = false;
        }

        return possible;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loan_specific_btn:
                loanActivity.show_Log("다음 단계: "+next_state());
//                if(next_state()){
                    loanActivity.changeFragment(R.id.loan_main_layout,loanActivity.loan_specific_info_fragment);
//                }else{
                    Toast.makeText(loanActivity,"정보 입력을 확인해주세요.",Toast.LENGTH_LONG).show();
//                }
                break;
            case R.id.loan_back_activity:
                loanActivity.changeActivity(loanActivity, MainActivity.class);
                loanActivity.finish();
                break;
        }
    }
}
