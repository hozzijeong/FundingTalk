package com.fundingtalk.fundingtalk.Main.Loan.Item;

import java.util.ArrayList;

public class City_First extends City{
    /*
        도시 검색에서 얻어오는 조건들을 저장하는 클래스.
        도시 이름들을 나타내고, 해당 정보가 가지고 있는 index를 이용해서
        first -> second -> third 순으로 연계 하게끔 설정함.
        지정되는 도시는 특정구역 하나밖에 없기 때문에 리스트가 아닌 단일 클래스로 사용함.
        접근 방식은 . . . 으로 계속해서 접근 가능.

        지역코드와 구역 구분은 시/군/구 까지만 하면 나오기 때문에 해당 클래스에 따로 변수로 저장함.

        City를 상속받아서, 공통된 부분을 최소화 시킨다.(name,idx)

     */

    public City_Second city_second;
    public City_First(String name,long index) {
        super(name,index);
    }

    public ArrayList<City> second_info = new ArrayList<>();
}
