package dbconsole;

import java.sql.ResultSet;
import java.sql.SQLException;


//ボタン[浜松]を押すと、浜松市の平均気温の表がデータベースから
//テキストエリアに出力され、グラフが出力される

public class DBConsole_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConsole_view frame=new DBConsole_view();
		frame.setBounds(5,5,1000,700);
		frame.setVisible(true);

	}

}
