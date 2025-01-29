package jp.co.kiramex.dbSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection con;

//    データベース接続を行うメソッド

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        ドライバのクラスをjavaで読み込む
        Class.forName("com.mysql.cj.jdbc.Driver");
//        DBと接続を行う
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "Kaminnsyou1012"
                );

        return con;
    }

    public static void close() {
        if(con != null) {
            try {
                con.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
