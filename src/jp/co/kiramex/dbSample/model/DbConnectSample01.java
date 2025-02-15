package jp.co.kiramex.dbSample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectSample01 {

    public static void main(String[] args) {

        // 3. データベース接続と結果取得のための変数宣言
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. ドライバのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DBと接続する
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Kaminnsyou1012"
                    );

//            データベースを識別する文字列の書式
//            jdbc:mysql://＜DBのアドレス＞/＜データベース名＞?useSSL=false&allowPublicKeyRetrieval=true

            // 4. DBとやりとりする窓口（Statementオブジェクト）の作成
            stmt = con.createStatement();

            // 5, 6. Select文の実行と結果を格納／代入
            String sql = "SELECT * FROM country LIMIT 50";
            rs = stmt.executeQuery(sql);

            // 7. 結果を表示する
            while(rs.next()) {
                String name = rs.getString("Name");
                int population = rs.getInt("Population");

                System.out.println(name);
                System.out.println(population);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードに失敗しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("データベースに異常が発生しました");
            e.printStackTrace();
        } finally {
            // 8. 接続を閉じる
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("ResulSetを閉じるときにエラーが発生しました");
                    e.printStackTrace();
                }
            }

            if(stmt != null) {
                try {
                    stmt.close();
                } catch(SQLException e) {
                    System.err.println("Statementを閉じる時にエラーが発生しました");
                    e.printStackTrace();
                }
            }

            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("データベース切断時にエラーがはっせいしました");
                    e.printStackTrace();
                }
            }
        }
    }

}
