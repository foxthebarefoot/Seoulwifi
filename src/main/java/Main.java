import static DataBase.DataProcess.registerWifiInfo;
import static GetApi.GetApi.getTotCnt;
import static GetApi.GetApi.getWifiInfo;

import java.io.IOException;
import java.util.ArrayList;

import GetApi.WifiList;

public class Main {
	public static void main(String[] args) throws IOException {
		int totCnt = getTotCnt();
        System.out.println("totCnt = " + totCnt);

        // totCnt 넣고 전체 데이터를 다 받아서 저장하자.
        ArrayList<WifiList> wifiList = getWifiInfo(totCnt);
        System.out.println("size : " + wifiList.size());

        // DB에 저장
        int affected = registerWifiInfo(wifiList);
        System.out.println(affected);
	}
}
