public class Stations
{	
	private String station;
	
	public Stations(MesoStation mesoStation)
	{
		this.station = mesoStation.getStID();
	}

	public int calAverage()
	{
		double average = 0;
		
		for (int i = 0; i < station.length(); i++)
		{
			average += station.charAt(i);
		}
		
		average = average / station.length();
		
		int finalAverage = (int)Math.ceil(average);
		
		return finalAverage;
	}
}
