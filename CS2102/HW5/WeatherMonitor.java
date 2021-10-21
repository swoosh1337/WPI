import java.util.LinkedList;
import java.util.GregorianCalendar;

public class WeatherMonitor {
	//LinkedList<DailyWeatherReport> List = new LinkedList<DailyWeatherReport>();
	IDWContainer reports;
	public WeatherMonitor(IDWContainer reports) {
		this.reports=reports;
	}

	public int averageHighForMonth(int month, int year) throws NoDateFoundException{
		return reports.getAverageHighForMonth(month,year);
		
		}

	double averageLowForMonth(int month, int year) throws NoDateFoundException{
      return reports.getAverageLowForMonth(month, year);
	}

	//  
	void addDailyReport(GregorianCalendar date, LinkedList<Reading> SomeList) {
		Reading highest=SomeList.get(0) ;
		   Reading lowest=SomeList.get(0) ;
		   
		   
		   
		   for(Reading r: SomeList) {
			    if(r.getTemp()> highest.getTemp()) {
			    	highest=r;
			    }
			  for(Reading b:SomeList) {
				  
				  if(b.getTemp()<lowest.getTemp()) {
					  lowest=b;
				  }
			  }
		   }
		  
		reports.addReading(new DailyWeatherReport(date, lowest, highest));
		}
	
	}

