package dbconsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	//JDBC�h���C�o�̓o�^
	String driver;
	//�f�[�^�x�[�X�̎w��
	String server,dbname, url, user, password;
    Connection con;
    Statement stmt;
    ResultSet rs;
	public MySQL() {
		this.driver = "org.gjt.mm.mysql.Driver";
		this.server = "j11000.sangi01.net";     //MySQL�T�[�o�iIP�܂��̓z�X�g���j
		this.dbname = "50113032";       //�f�[�^�x�[�X��
		this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
		this.user = "50113032"  ;       //�f�[�^�x�[�X�쐬���[�U��
		this.password = "50113032";
		try {
			this.con = DriverManager.getConnection(url,user,password);
			this.stmt = con.createStatement();
		} catch (SQLException e) {               //��O�@SQL�ŃG���[���������ꍇ
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close(){              //�ؒf����֐�
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public ResultSet selectAll(){         //�e�[�u�����炷�ׂĂ̏��������Ă���
	    String sql="SELECT * FROM hamamatsu";  //�e�[�u���uhamamatsu�v
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}    
    
}