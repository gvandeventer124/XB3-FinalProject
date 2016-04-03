package sortingForFinalProject;

public class eventCalc{
	
	public void eventChance(WeatherEvent[] a){
		int N = a.length;
		String[] events = new String[N];
		
		for(int i = 0; i<N ;i++){
			events[i] = a[i].getType();
		}
		int k = 0;
		String[] uniqueElements = new String[N];
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				if(!events[i].equals(uniqueElements[j])){
					uniqueElements[k] = events[i];
					k++;
					break;
				}
			}
		}
		for(int i =0; i<k; i++){
			int count = 0;
		for(int j = 0; j<N; j++){
			if(uniqueElements[i].equals(events[j]) == true){
				count ++;
			}
			
		}
		double likely = (count*100)/N;
		double rounded = Math.round(likely*100)/100;
		System.out.println("chance of " +uniqueElements[i] + " = " + rounded + "% ");
		}
		
	}
	
	

}
