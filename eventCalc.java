package sortingForFinalProject;
public class eventCalc{
	
	public static void eventChance(WeatherEvent[] a){
		
		final int TOTAL = 10;
		int N = a.length;			//length of a; presumably 10
		int n = 0;					//number of event types, excluding clear days
		String[] events = new String[N];
		String[] uniqueElements = new String[N];

		for(int i = 0; i<N ;i++){
			events[i] = a[i].getType();
		}

		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				if (events[i].equals(uniqueElements[j]))
					break;
				else if (uniqueElements[j] == null){
					uniqueElements[n] = events[i];
					n++;
					break;
				}
			}
		}
		
		for(int i =0; i<n; i++){
			int count = 0;
			for(int j = 0; j<N; j++){
				if(uniqueElements[i].equals(events[j])){
					count ++;
				}
			}
			double likely = (count*100.0/TOTAL);
			likely = Math.round(likely * 1000.)/1000.;
			System.out.println("chance of " +uniqueElements[i] + " = " + likely + "% ");
		}
		
		double likely = (TOTAL - n)*100.0/TOTAL;
		likely = Math.round(likely * 1000.)/1000.;
		System.out.println("chance of a clear day = " + likely + "% ");
		
	}
}
