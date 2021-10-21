import java.util.LinkedList;

public class DailyReportList implements IDWContainer {

	LinkedList<DailyWeatherReport> List = new LinkedList<DailyWeatherReport>();

	public int getAverageHighForMonth(int month, int year) throws NoDateFoundException{
			int sum=0;
			int times=0;
			for(int i=0; i<List.size(); i++) {
				if(year == List.get(i).getYear() && month==List.get(i).getMonth()) {
					sum= sum+ List.get(i).getHighest();
					times++;
				}
			}
			if(times!=0)
			{return sum/times;}
			else 
			throw new NoDateFoundException();
	}

	@Override
	public int getAverageLowForMonth(int month, int year) throws NoDateFoundException{
		int sum=0;
		int times=0;
		for(int i=0; i<List.size(); i++) {
			if(year == List.get(i).getYear() && month==List.get(i).getMonth()) {
				sum= sum+ List.get(i).getLowest();
				times++;
			}
		}
		if(times!=0)
		{return sum/times;}
		else 
		throw new NoDateFoundException();
	}

	public void addReading(DailyWeatherReport dwr) {
		List.add(dwr);
		
	}
} 
