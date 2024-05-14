package GetApi;

import java.io.IOException;
import java.util.ArrayList;

import static DataBase.DataProcess.registerWifiInfo;
import static GetApi.GetApi.getTotCnt;
import static GetApi.GetApi.getWifiInfo;

public class SaveWifiInfo {
    public static int insertWifiInfo() throws IOException {
        // 현재 서울시 공공와이파이 데이터 전체 열 수를 확인하자.
        int totCnt = getTotCnt();
        System.out.println("totCnt = " + totCnt);

        // totCnt 넣고 전체 데이터를 다 받아서 저장하자.
        ArrayList<WifiList> wifiList = getWifiInfo(totCnt);
        System.out.println("size : " + wifiList.size());

        // DB에 저장
        int affected = registerWifiInfo(wifiList);
        return affected;
    }
}
