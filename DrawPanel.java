import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class DrawPanel extends JPanel
{
	private int pointRadius;
	private ArrayList<Point> points;
	
	public DrawPanel()
	{
		this(5);
	}
	
	public DrawPanel(int radius)
	{
		this.points = new ArrayList<>();
		this.pointRadius = radius;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void addPoint(Point p)
	{	
		points.add(p);
	}
	
	public void clear()
	{
		points.clear();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(5));
		
		for (Point pt : points) g2d.fillOval(pt.x, pt.y, pointRadius, pointRadius);
	}
}
