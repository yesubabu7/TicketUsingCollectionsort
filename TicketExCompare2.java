import java.util.*;
import java.io.*;
class Ticket {
    public static int c=1;
	int trainNo;
	String srcStation, destStation, travelDate, ticketClass;
	float totalfare;
    //TreeSet<Passenger> a=new TreeSet<Passenger>();
    
	ArrayList<Passenger> passDetails;

	public Ticket(int trainNo, String srcStation, String destStation, String travelDate, String ticketClass,
			  ArrayList<Passenger> pd) {
		this.trainNo = trainNo;
		this.srcStation = srcStation;
		this.destStation = destStation;
		this.travelDate = travelDate;
		this.ticketClass = ticketClass;
		this.passDetails = pd;
	
	}
	public void displayDetails() {
		System.out.println("Train no : " + trainNo);
		System.out.println("Train source : " + srcStation);
		System.out.println("Train destination : " + destStation);
		System.out.println("Travel Date : " + travelDate);
		System.out.println("Ticket Class : " + ticketClass);
		System.out.println("Passenger Details : ");
		for (Passenger p : passDetails){
			System.out.println(
					p.getName() + " " + p.getAge() + " " + p.getGender() + " " + p.getPrefBerth() + " " + p.ticketCost);
					//a.add((p));
					this.totalfare+=p.ticketCost;
					
		}
		//System.out.println(a);
		
	}

}
class Passenger {
	static float basePrice = 350;
	String name;
	int age;
	char gender;
	String prefBerth;
	float ticketCost;

	public Passenger(String name, int age, char gender, String prefBerth) {
		//super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.prefBerth = prefBerth;
		if ((age > 65 && gender == 'm') || (age > 58 && gender == 'f'))
			ticketCost = basePrice * 75.0f;
		else if (age < 5)
			ticketCost = 0;
		else if (age < 12)
			ticketCost = basePrice * 0.50f;
		else
			ticketCost = basePrice;
	}
public String getName() {
		return name;
}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPrefBerth() {
		return prefBerth;
	}

	public void setPrefBerth(String prefBerth) {
		this.prefBerth = prefBerth;
	}
}
/*class PassengerDetails extends ArrayList<Passenger> {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Haii vamsi thanku ";
	}

}
*/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Passenger p1 = new Passenger("p1", 80, 'f', "Lower");
		Passenger p2 = new Passenger("p2", 70, 'm', "Lower");
		Passenger p3 = new Passenger("p3", 60, 'f', "Middle");
		Passenger p4 = new Passenger("p4", 50, 'm', "Upper");
		Passenger p5 = new Passenger("p5", 97, 'f', "Upper");
		// ArrayList<Passenger> pd = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
		
		//PassengerDetails pd = new PassengerDetails();
		ArrayList<Passenger> pd=new ArrayList<Passenger>();
		pd.addAll(Arrays.asList(p1, p2, p3, p4, p5));
		// Passenger pd[] = { p1, p2, p3, p4, p5 };
		Ticket t1 = new Ticket(101, "Vzg", "Tpg", "24-03-2023", "AC", pd);
		//t1.displayDetails();
		ArrayList<Passenger> pd1=new ArrayList<Passenger>();
		
		Passenger p11 = new Passenger("p11", 90, 'f', "Lower");
		Passenger p12 = new Passenger("p12", 30, 'f', "Lower");
		Passenger p13 = new Passenger("p13", 100, 'm', "Middle");
		Passenger p14 = new Passenger("p14", 59, 'm', "Upper");
		pd1.addAll(Arrays.asList(p11,p12,p13,p14));
		Ticket t2 = new Ticket(103, "mumbai", "macherla", "02-07-2022", "Ac", pd1);
        //t2.displayDetails();
       
        ArrayList<Ticket> tt=new ArrayList<>();
        tt.addAll(Arrays.asList(t1,t2));
        //Collections.sort(tt);
        Collections.sort(tt,new Mycomparator());
        
	for(Ticket t:tt){
		t.displayDetails();
		System.out.println(t.totalfare);
	}
}
}
class Mycomparator implements Comparator{
    public int compare(Object ob1,Object ob2){
        Ticket s1=(Ticket)ob1;
        Ticket s2=(Ticket)ob2;
        Float i1=(Float)s1.totalfare;
        Float i2=(Float)s2.totalfare;
        return i1.compareTo(i2);
        }
    
    
}


