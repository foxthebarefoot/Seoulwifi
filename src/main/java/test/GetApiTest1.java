package test;

import GetApi.WifiList;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetApiTest1 {

    public static void main(String[] args) throws IOException {

        String apiKey = "6378495a7473687537354e64785976";
        int startN = 1;
        int endN = 2;
        String url = "http://openapi.seoul.go.kr:8088/" + apiKey +
                "/json/TbPublicWifiInfo/" + startN + "/" + endN;

        // https://square.github.io/okhttp/
        // https://square.github.io/okhttp/recipes/#__tabbed_2_2

        // OkHttpClient 객체 생성
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        String getBody;
        try (Response response = client.newCall(request).execute()) {
            System.out.println("response success:" + response.isSuccessful());
//            ResponseBody body = response.body();
//            getBody = body.string();
            // ResponseBody에 대해 읽어보자.
            // https://square.github.io/okhttp/5.x/okhttp/okhttp3/-response-body/index.html
            getBody = response.body().string();
        }

//        System.out.println(getBody);

        JsonObject jsonObject = JsonParser.parseString(getBody).getAsJsonObject();
        System.out.println("jsonObject : " + jsonObject);
        JsonObject tbPublicWifiInfo = jsonObject.get("TbPublicWifiInfo").getAsJsonObject();
        System.out.println("tbPublicWifiInfo : " + tbPublicWifiInfo);
        int listTotalCount = tbPublicWifiInfo.get("list_total_count").getAsInt();
        System.out.println("totalcnt : " + listTotalCount);
        JsonArray row = tbPublicWifiInfo.get("row").getAsJsonArray();
        System.out.println("row : " + row);

        // isSuccesful ?? -> 설명 참조 boolean - True 로 요청이 성공적이었는지 확인해줌
        // https://square.github.io/okhttp/3.x/okhttp/okhttp3/Response.html

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<WifiList>>() {}.getType();
        
        ArrayList<WifiList> wifiList = gson.fromJson(row, listType);
        WifiList wifiLi1 = wifiList.get(0);
        System.out.println(wifiLi1.getX_SWIFI_MAIN_NM());
    }
}
