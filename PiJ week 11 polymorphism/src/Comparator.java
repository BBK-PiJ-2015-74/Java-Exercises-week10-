
public class Comparator {
	
	public double getMax(double d1, double d2) {
		if (d1 > d2 ) {
			return d1;
		} else {
			return d2;
		}
	}

	public int getMax(int n,int m){
		//double x = (double) n;
		//double y = (double) m;
		// return (int) getMax (x,y);
		return (int) getMax((double) n, (double) m);
	}
	
	public String getMax(String number1, String number2) {
		int n1 = Integer.parseInt(number1);
		int n2 = Integer.parseInt(number2);
		return Integer.toString(getMax(n1,n2));
	}
	

//	public int getMax(double n, double m) {
//		return (int) getMax(n,m);
//	}

}

//Ginestra - 24
//Hussain - 04
