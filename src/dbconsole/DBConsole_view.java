package dbconsole;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class DBConsole_view extends Frame implements ActionListener,WindowListener{
	
	//�R�����g
	MySQL mysql=new MySQL();
	ResultSet rs=mysql.selectAll();
	double temperature;
	String month;
	private Button hama=new Button("�l��");

	
	private TextArea text= new TextArea(); 
	
	
	
	
	
	
	
	public DBConsole_view(){
		
		addWindowListener(this);
		setTitle("DataBase");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(hama);
		add(text);
		hama.addActionListener(this);	//�{�^��[�l��]����������actionPerformed���쓮
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset data=new DefaultCategoryDataset();
		try {
			while(rs.next()){
				month = rs.getString("month");
				temperature = rs.getDouble("temperature");
				text.append("���F" + month+"\n");
				text.append("�C���F" + temperature+"\n\n");
				//�O���t��`��
				data.addValue(temperature,"HAMAMATSU",month);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		JFreeChart chart=
				ChartFactory.createLineChart("average temperature","month","average temperature",data,PlotOrientation.VERTICAL,true,false,false);
		ChartPanel cpanel=new ChartPanel(chart);
		add(cpanel,BorderLayout.CENTER);
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
