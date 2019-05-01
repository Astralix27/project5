import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HammingDistancePanel extends JFrame
{	
	HammingDistance stations = new HammingDistance("null");
	
	private ArrayList<String> stationslist = new ArrayList<>(stations.getStations());
	private JComboBox<String> stationSelect = new JComboBox<String>();
	
	private DefaultComboBoxModel<String> getComboBoxModel(List<String> station)
	{
		ArrayList<String> displayNames = new ArrayList<String>();
		for (String stat : station)
		{
			displayNames.add(stat);
		}
		String[] comboBoxModel = displayNames.toArray(new String[displayNames.size()]);
	    return new DefaultComboBoxModel<>(comboBoxModel);
	}
	
	private JButton showStation;
	private JButton calculateHD;
	private JButton addStation;
	private JButton clear;
	
	private JLabel enterHD;
	private JLabel compare;
	private JLabel dist0;
	private JLabel dist1;
	private JLabel dist2;
	private JLabel dist3;
	private JLabel dist4;
	
	private JTextField addStationField;
	private JTextField enterHDField;
	private JTextField dist0Field;
	private JTextField dist1Field;
	private JTextField dist2Field;
	private JTextField dist3Field;
	private JTextField dist4Field;
	
	private JSlider distance;
	
	private JTextArea showStationArea;
	
	private JScrollPane showStationScroll;
	
	private DrawPanel draw;
	
	public HammingDistancePanel()
	{
		super("Hamming Distance");
		
		draw = new DrawPanel();
		draw.addMouseMotionListener(new MouseMotionListener() 
		{
			@Override
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) 
			{
				draw.addPoint(e.getPoint());
				draw.repaint();
			}			
		});
		
		DefaultComboBoxModel<String> comboBoxModel = getComboBoxModel(stationslist);
		stationSelect.setModel(comboBoxModel);
		stationSelect.setSelectedIndex(0);
		stationSelect.addActionListener((e) -> {
			int select = stationSelect.getSelectedIndex();
			this.stationslist.get(select);
		});
		
		distance = new JSlider(1, 4);
		distance.setPaintLabels(true);
		distance.setPaintTrack(true);
		distance.setPaintTicks(true);
		distance.setMajorTickSpacing(1);
		distance.setMinorTickSpacing(1);
		distance.addChangeListener((ChangeListener) new ChangeListener(){
			
			@Override
			public void stateChanged(ChangeEvent e) {
				enterHDField.setText(String.valueOf(distance.getValue()));
			}
		});
		
		showStation = new JButton("Show Station");
		calculateHD = new JButton("Calculate HD");
		addStation = new JButton("Add Station");
		clear = new JButton("Clear");
		
		enterHD = new JLabel("Enter Hamming Dist:");
		compare = new JLabel("Compare with:");
		dist0 = new JLabel("Distance 0");
		dist1 = new JLabel("Distance 1");
		dist2 = new JLabel("Distance 2");
		dist3 = new JLabel("Distance 3");
		dist4 = new JLabel("Distance 4");
		
		addStationField = new JTextField(14);
		addStationField.setEditable(true);
		enterHDField = new JTextField(14);
		enterHDField.setEditable(false);
		dist0Field = new JTextField(14);
		dist0Field.setEditable(false);
		dist1Field = new JTextField(14);
		dist1Field.setEditable(false);
		dist2Field = new JTextField(14);
		dist2Field.setEditable(false);
		dist3Field = new JTextField(14);
		dist3Field.setEditable(false);
		dist4Field = new JTextField(14);
		dist4Field.setEditable(false);
		
		showStationArea = new JTextArea(9, 22);
		
		showStationScroll = new JScrollPane(showStationArea);
		showStationScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		setLayout(new GridBagLayout());
		GridBagConstraints layoutConst = null;
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(2, -85, 2, 2);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		add(enterHD, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(13, -100, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		add(enterHDField, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 10);
		layoutConst.gridx = 2;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 50;
		layoutConst.weightx = 50;
		layoutConst.gridheight = 50;
		draw.setPreferredSize(new Dimension(250, 550));
		draw.setBackground(Color.WHITE);
		add(draw, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(25, 190, 0, 0);
		layoutConst.gridx = 2;
		layoutConst.gridy = 0;
		add(clear, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(-2, 35, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		add(distance, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		add(showStation, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		add(showStationScroll, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 5;
		add(compare, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -120, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 5;
		add(stationSelect, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 6;
		add(calculateHD, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 7;
		add(dist0, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 7;
		add(dist0Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 8;
		add(dist1, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 8;
		add(dist1Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 9;
		add(dist2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 9;
		add(dist2Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 10;
		add(dist3, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 10;
		add(dist3Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 11;
		add(dist4, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 11;
		add(dist4Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -85, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 12;
		add(addStation, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -105, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 12;
		add(addStationField, layoutConst);
		
		showStation.addActionListener((ActionListener) new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String station = String.valueOf(stationSelect.getSelectedItem());
				
				int dist = distance.getValue();
				
				HammingDistance HD = new HammingDistance(station);
				
				showStationArea.selectAll();
				showStationArea.replaceSelection("");
					
				ArrayList<String> stations = HD.calDist(dist);
				
				for (String stationsName : stations) {
			        showStationArea.append(stationsName.toString() + "\n");
				}
			}
		});
		
		calculateHD.addActionListener((ActionListener) new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String station = String.valueOf(stationSelect.getSelectedItem());
			
				HammingDistance HD = new HammingDistance(station);
			
				int[] nodes = HD.getNodes();
				
				String sta1 = String.valueOf(nodes[0]);
				String sta2 = String.valueOf(nodes[1]);
				String sta3 = String.valueOf(nodes[2]);
				String sta4 = String.valueOf(nodes[3]);
			
				dist0Field.setText("1");
				dist1Field.setText(sta1);
				dist2Field.setText(sta2);
				dist3Field.setText(sta3);
				dist4Field.setText(sta4);
				
			}
		});
		
		addStation.addActionListener((ActionListener) new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String stationAdded = addStationField.getText();
				
				String station = stationAdded.toUpperCase();
				
				if (((DefaultComboBoxModel<String>)stationSelect.getModel()).getIndexOf(station) == -1)
				{
					stationslist.add(station);
					Collections.sort(stationslist);
					int point = stationslist.indexOf(station);
					stationSelect.insertItemAt(station, point);
				}
				
			}
		});
		
		clear.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HammingDistancePanel.this.draw.clear();
				HammingDistancePanel.this.draw.repaint();
				
			}
		});
		
		
		pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		HammingDistancePanel HDP = new HammingDistancePanel();
	}
}
