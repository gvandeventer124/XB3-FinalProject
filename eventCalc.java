package sortingForFinalProject;
public class eventCalc{
	
	public static void eventChance(WeatherEvent[] a){
		
		int N = a.length;
		int k = 0;
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
					uniqueElements[k] = events[i];
					k++;
					break;
				}
			}
		}
		
		for(int i =0; i<k; i++){
			int count = 0;
			for(int j = 0; j<N; j++){
				if(uniqueElements[i].equals(events[j])){
					count ++;
				}
			}
			double likely = (count*100.0/N);
			likely = Math.round(likely * 1000.)/1000.;
			System.out.println("chance of " +uniqueElements[i] + " = " + likely + "% ");
		}
		
	}
}
