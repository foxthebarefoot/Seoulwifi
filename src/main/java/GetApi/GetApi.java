package GetApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GetApi {

    static String apiKey = "6378495a7473687537354e64785976";

    public static String getApi(int startNo, int endNo) throws IOException {
        String url = "http://openapi.seoul.go.kr:8088/" + apiKey +
                "/json/TbPublicWifiInfo/" + startNo + "/" + endNo;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        String getBody = null;
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                getBody = response.body().string();
            }
        }

        return getBody;
    }

    public static int getTotCnt() throws IOException {
        String getBody = getApi(1, 1);
        // 한 줄만 요청하고, 받아온 json 앞에 있는 받아오기 가능한 데이터 수를 나타내는
        // (list_total_cont) 부분에서 숫자 찾아서 반환하자.

        JsonObject jsonObject = JsonParser.parseString(getBody).getAsJsonObject();
        JsonObject tbPublicWifiInfo = jsonObject.get("TbPublicWifiInfo").getAsJsonObject();
        int listTotalCount = tbPublicWifiInfo.get("list_total_count").getAsInt();

        return listTotalCount;
    }

    public static ArrayList<WifiList> getWifiInfo(int totCnt) throws IOException {
        ArrayList<WifiList> mergedWifiList = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<WifiList>>() {}.getType();

        for (int i = 0; i <= (totCnt-1)/1000; i++) {
            int startNo = (i * 1000) + 1;
            int endNo = (i + 1) * 1000;

            String getBody = getApi(startNo, endNo);
            JsonObject jsonObject = JsonParser.parseString(getBody).getAsJsonObject();
            JsonArray row = jsonObject.get("TbPublicWifiInfo").getAsJsonObject()
                    .get("row").getAsJsonArray();

            ArrayList<WifiList> wifiList = gson.fromJson(row, listType);
            mergedWifiList.addAll(wifiList);


        }

        return mergedWifiList;
    }

}

