package com.fundingtalk.fundingtalk.Main.Loan.Item;

public class Calc extends Loan_Apt_Info{

    public Double min_rate; // 로그인 안됐을 경우 최소 이자 비율을 보여주기 위한 변수
    public Double min_ltv; // 이자가 올라가는 최소 ltv;
    public Double start_ltv; // 선순위 대출을 계산했을 때 나오는 시작 ltv;
    public Double max_ltv;
    public Double apply_ltv;
    public long before_loan;
    public long wish_loan;
    private Double[][] seoul_ltv = new Double[10][2]; // 서울 지역
    private Double[][] specu_ltv = new Double[9][2]; // 투기 과열지역
    private Double[][] revision_ltv = new Double[7][2]; // 조정대상지역
    private Double[][] except_ltv = new Double[5][2]; // 그 외
    private int case_num = 0;
    public Calc(long real_cost, String ltv) {
        super(real_cost, ltv);
        set_ltv();
        setLtvRate();
        max_ltv = max_ltv*100;
        min_ltv = min_ltv*100;
        calc_LtvRate(seoul_ltv);
        calc_LtvRate(specu_ltv);
        calc_LtvRate(revision_ltv);
        calc_LtvRate(except_ltv);
    }
    private void calc_LtvRate(Double[][] table){
        for(int i=0; i<table.length; i++){
            table[i][0] = table[i][0]*100;
            table[i][1] = table[i][1]*100;
        }
    }
    private void set_ltv(){
        switch (ltv){
            case "seoul":
                min_ltv = 0.4;
                max_ltv = 0.9;
                min_rate = 0.083;
                case_num = 1;
                break;
            case "specu-area":
                min_ltv = 0.4;
                max_ltv = 0.85;
                min_rate = 0.0845;
                case_num = 2;
                break;
            case "revision-area":
                min_ltv = 0.5;
                max_ltv = 0.85;
                min_rate = 0.08;
                case_num = 3;
                break;
            case "except-area":
                min_ltv = 0.6;
                max_ltv = 0.85;
                min_rate = 0.0915;
                case_num = 4;
                break;
        }
    }
    private void setLtvRate(){
        //seoul_ltv 비율 계산
        for(int i=0; i<8; i++){
            seoul_ltv[i][0] = 0.4+(i*0.05);
            seoul_ltv[i][1] = 0.083+(i*0.0025);
        }
        seoul_ltv[8][0] = 0.8;
        seoul_ltv[8][1] = 0.115;

        seoul_ltv[9][0] = 0.85;
        seoul_ltv[9][1] = 0.12;

        //투기과열지구 비율 계산
        for(int i=0; i<specu_ltv.length-1; i++){
            specu_ltv[i][0] = 0.4+(i*0.05);
            specu_ltv[i][1] = 0.0845+(i*0.0025);
        }
        specu_ltv[8][0] = 0.8;
        specu_ltv[8][1] = 0.12;

        //조정대상 지구 비율 계산
        revision_ltv[0][0] = 0.5;
        revision_ltv[0][1] = 0.082;
        revision_ltv[1][0] = 0.55;
        revision_ltv[1][1] = 0.0915;
        revision_ltv[2][0] = 0.6;
        revision_ltv[2][1] = 0.095;
        revision_ltv[3][0] = 0.65;
        revision_ltv[3][1] = 0.0965;
        revision_ltv[4][0] = 0.7;
        revision_ltv[4][1] = 0.0995;
        revision_ltv[5][0] = 0.75;
        revision_ltv[5][1] = 0.114;
        revision_ltv[6][0] = 0.8;
        revision_ltv[6][1] = 0.12;

        // 그 외지역

        except_ltv[0][0] = 0.6;
        except_ltv[0][1] = 0.0915;

        except_ltv[1][0] = 0.65;
        except_ltv[1][1] = 0.094;

        except_ltv[2][0] = 0.7;
        except_ltv[2][1] = 0.0965;

        except_ltv[3][0] = 0.75;
        except_ltv[3][1] = 0.1;

        except_ltv[4][0] = 0.8;
        except_ltv[4][1] = 0.1175;
    }
    public long max_cost(){
        // max_ltv는 위에서 정의된 max_ltv로 계산
        // 원하는 대출금액이 max_cost보다 작게 나오면 대출 가능.
        // 최대 대출 금액은 대출 가능액이 가능한지 확인해야함.
        // 만약에, 대출 금액이 넘어간다 ?그렇다면, 적용 LTV 금액에 들어갈 wish_loamn은 Max_cost가 됨
        // 그게 아니라면 작성한 금액 그대로 대출 가능하다고 표시하고,
        long max_cost = (long)((real_cost*(max_ltv*0.01))-before_loan);
        return  max_cost;
     }
    public Double getApply_ltv(){
        // 적용 LTV를 구하는 메소드. 해당 값이 지역별 최대 값보다 넘는지 아닌지 확인한다.
        // 만약에 넘지않으면, min_ltv에서 apply_ltv 까지 %를 구한 뒤, 적용 LTV는 금리 산출에 꼭 필요함.
        //real_cost는 상속받은 real_cost로 계산
        // 이게 몫 계산이라 당연히 0이 나옴.
        this.apply_ltv = (double) ((before_loan + wish_loan)*100 / real_cost);
        //적용 금리가 MAX LTV 를 넘어가면 LTV 는 최대 LTV로 설정한다.
        if(apply_ltv>max_ltv){
            apply_ltv = max_ltv;
        }
        return apply_ltv;
    }
    public void getStart_ltv(){
        // 실제 ltv의 시작점 (%)를 얻는 메소드
        start_ltv = (double) (before_loan*100)/real_cost;
    }
    public Double calc_loan_interest_rate()
    {    // 대출 금리 산정 메소드

        Double[][] rate_table;
        double rate = 0; // 이자를 더하는 변수
        int cnt = 0; // 총 반복문의 횟수와 값을 어떻게 나눌건지
        // 쿼리문을 통해 값을 정리해야함?
        // min_ltv+0.5의 값이 apply_ltv를 넘어가지 않을때까지 반복문을 돌림.
        // 만약에 넘어갔을 경우 -> (apply_ltv - min_ltv)의 단위를 5의 몇 %인지로 나눠야함.
        // 이미 선순위 대출금액을 넘겼다면? 아니지 그건 생각할 필요가 없지
        // 이미 대출 금리 이자를 생각한다는 것은 최소 ltv 부터 적용 ltv 까지 이미 값이 정해져 있다는 말이고, 해당 값에 맞는 비율 테이블을 넣으면 되는걸까?
        // 그치, 이미 대출 금리를 산정한다는 것은 전제 조건으로 대출이 가능한 금액이라고 나타나있는 것이니까 상관ㅇ ㅓㅄ을듯.
        // 학원 갔다 와서 한번 값 체크 해보기
        switch (case_num){
            case 1:
                //서울인 경우
                rate_table = seoul_ltv;
                break;
            case 2:
                //투기
                rate_table= specu_ltv;
                break;
            case 3:
                //조정
                rate_table = revision_ltv;
                break;
            case 4:
                //그외
                rate_table = except_ltv;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + case_num);
        }
        /*
            start_ltv 값이 40%를 넘겼을 때도 계산식 추가할 것.
            그때의 값이 몇부터 시작하는지 알아야 함.
         */

        while (apply_ltv>start_ltv){

            rate += rate_table[cnt][1];
            cnt++;
            // start_ltv의 값이 안넘어야함.
            start_ltv += 5;
        }

        cnt--;
        double temp = rate_table[cnt][1];
        rate -= temp;

        double rest = (apply_ltv - (start_ltv-5))*20*0.01; // 나머지 값 을 나타냄.(%)
        double rest_temp = temp * rest;
        rate+= rest_temp;
        return (rate*100/(cnt+rest))*0.01;
    }
}
