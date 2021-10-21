import java.util.GregorianCalendar;

public interface IDWContainer {
	public int getAverageHighForMonth(int month, int year) throws NoDateFoundException;
	public int getAverageLowForMonth(int month, int year) throws NoDateFoundException;
	public void addReading(DailyWeatherReport dwr);
}
