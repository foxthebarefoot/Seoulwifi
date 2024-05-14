package DataBase;

import GetApi.WifiList;

import java.sql.*;
import java.util.ArrayList;

public class DataProcess {

    public static int registerWifiInfo(ArrayList<WifiList> wifiList) {
        String url = "jdbc:mariadb://127.0.0.1:3306/db1";
        String dbUserId = "testuser3";
        String dbPassWord = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int affected = 0;
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassWord);

            String sql = "INSERT INTO db1.SEOUL_WIFI (MGR_NO, GU, WIFI_NAME, ADDR1, ADDR2, INS_FLOOR, INS_TYPE, INS_INSTITUTE, SV_TYPE, CMCWR, INS_YEAR, IN_OUT, WIFI_ENV, LAT, LNT, WORK_DT) " +
                    " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            preparedStatement = connection.prepareStatement(sql);

            for (WifiList wifiLi : wifiList) {
                preparedStatement.setString(1, wifiLi.getX_SWIFI_MGR_NO());
                preparedStatement.setString(2, wifiLi.getX_SWIFI_WRDOFC());
                preparedStatement.setString(3, wifiLi.getX_SWIFI_MAIN_NM());
                preparedStatement.setString(4, wifiLi.getX_SWIFI_ADRES1());
                preparedStatement.setString(5, wifiLi.getX_SWIFI_ADRES2());
                preparedStatement.setString(6, wifiLi.getX_SWIFI_INSTL_FLOOR());
                preparedStatement.setString(7, wifiLi.getX_SWIFI_INSTL_TY());
                preparedStatement.setString(8, wifiLi.getX_SWIFI_INSTL_MBY());
                preparedStatement.setString(9, wifiLi.getX_SWIFI_SVC_SE());
                preparedStatement.setString(10, wifiLi.getX_SWIFI_CMCWR());
                preparedStatement.setString(11, wifiLi.getX_SWIFI_CNSTC_YEAR());
                preparedStatement.setString(12, wifiLi.getX_SWIFI_INOUT_DOOR());
                preparedStatement.setString(13, wifiLi.getX_SWIFI_REMARS3());
                preparedStatement.setString(14, wifiLi.getLAT());
                preparedStatement.setString(15, wifiLi.getLNT());
                preparedStatement.setString(16, wifiLi.getWORK_DTTM());

                preparedStatement.executeUpdate();
                preparedStatement.clearParameters();
                affected++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.isClosed();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.isClosed();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        System.out.println("저장 완료 : " + affected + "개");
        return affected;
    }
}
