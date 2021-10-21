import java.util.GregorianCalendar;

	public class DailyWeatherReport{
		 private GregorianCalendar date; // year, month, day
		 private Reading Lowest;
		 private Reading Highest;
		 
		 DailyWeatherReport(GregorianCalendar date, Reading Lowest, Reading Highest){
			 this.date=date;
			 this.Lowest=Lowest;
			 this.Highest=Highest;
		 }
		 public int getHighest() {
			 return this.Highest.getTemp();
		 }
		 public int getLowest() {
			 return this.Lowest.getTemp();
		 }
		 public int getMonth() {
			 return this.date.get(GregorianCalendar.MONTH);
		 }
		 public int getYear() {
			 return this.date.get(GregorianCalendar.YEAR);
		 }
		 public int getDay() {
			 return this.date.get(GregorianCalendar.DAY_OF_MONTH);
		 }
	}
