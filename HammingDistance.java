import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDistance
{	
	private ArrayList<String> stations = new ArrayList<String>();
	
	private String stID;
	private int[] nodes;
	
	private ArrayList<String> distString1 = new ArrayList<String>();
	private ArrayList<String> distString2 = new ArrayList<String>();
	private ArrayList<String> distString3 = new ArrayList<String>();
	private ArrayList<String> distString4 = new ArrayList<String>();
	
	public HammingDistance(String stID)
	{
		attemptToRead("Mesonet.txt");
		
		this.stID = stID;
		
		this.nodes = getNode(stID);
	}

	public void attemptToRead(String filename)
    {
    	try
    	{
    		read(filename);
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error reading from file!\n");
    		e.printStackTrace();
    	}
    }
	
	public void read(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String strg = br.readLine();
    
		while (strg != null)
		{
			stations.add(strg);
			strg = br.readLine();
		}
    
		br.close();
	}

	public ArrayList<String> calDist(int distance)
	{	
			
		for (int i = 0; i < stations.size(); i++)
		{
			int dist = getDist(this.stID, stations.get(i));
			
			if(dist == 1)
			{
				distString1.add(stations.get(i));
			}
			else if (dist == 2)
			{
				distString2.add(stations.get(i));
			}
			else if (dist == 3)
			{
				distString3.add(stations.get(i));
			}
			else if (dist == 4)
			{
				distString4.add(stations.get(i));
			}
		}
		
		if (distance == 1)
		{
			return distString1;
		}
		else if (distance == 2)
		{
			return distString2;
		}
		else if (distance == 3)
		{
			return distString3;
		}
		else
		{
			return distString4;
		}
	}
	
	 
	public int getDist(String a, String b)
	{
		int distance = 0;
		
		for (int i = 0; i < a.length(); i++)
		{
			if (a.charAt(i) != b.charAt(i))
				{
					distance++;
				}
		}
		
		return distance;
	}

	
	public int[] getNode(String station)
	{
		int[] nodes = new int[4];
		int dist;
		for (int i = 0; i < stations.size(); i++)
		{
			dist = getDist(station, stations.get(i));
			if (dist != 0)
			{
				nodes[dist - 1]++;
			}
		}
		return nodes;
	}
	
	public ArrayList<String> getStations()
	{
		return stations;
	}
	
	public int[] getNodes()
	{
		return nodes;
	}
}
