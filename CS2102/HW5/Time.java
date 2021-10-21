
public class Time {
private int hours;
private int minutes;

public Time(int hours, int minutes) {
	this.hours=hours;
	this.minutes=minutes;
}

public double getTime() {
	//if 
	return (this.hours+ (this.minutes/100));
}
public int getHours() {
	//if 
	return this.hours;
}
public int getMinutes() {
	//if 
	return this.minutes;
}
}
