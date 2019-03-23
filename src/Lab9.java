import java.util.ArrayList;


public class Lab9 {

	public static void main(String[] args) {
//		ScalesSolution s = new ScalesSolution("11111");
//		s.println();
//		s.SmallChange();
//		s.println();
//		ScalesSolution s1 = new ScalesSolution(10);
//		s1.println();
//		ScalesSolution s2 = new ScalesSolution(s1.GetSol());
//		s2.println();
		ArrayList<Double> weights = new ArrayList<Double>();
		weights.add(1.0);
		weights.add(2.0);
		weights.add(3.0);
		weights.add(4.0);
		weights.add(10.0);
		
		//RMHC(weights,5,10);
		
		weights = CS2004.ReadNumberFile("1000 Primes.txt");
		double avg = 0.0;
		for (int i = 0; i < 10; i++) {
			long startTime = System.nanoTime();
			RMHC(weights, 1000, 1000);
			long endTime = System.nanoTime();
			long elapsedTime = (endTime - startTime);
			System.out.println("Elapsed Time: " + elapsedTime);
		}
	}
	
	public static ScalesSolution RMHC(ArrayList<Double> weights,int n,int iter)
	{
		ScalesSolution oldSol = new ScalesSolution(n);
		double oldFitness = 0.0, avg = 0.0;
		
		for(int i = 0; i < iter; i++)
		{
			ScalesSolution newSol = new ScalesSolution(oldSol.GetSol());
			oldFitness = oldSol.ScalesFitness(weights);
			String z = oldSol.GetSol();
			//System.out.println("Current iteration: " + i + ", Current Fitness: " + oldFitness);
			
			newSol.SmallChange();
			
			double newFitness = newSol.ScalesFitness(weights);
			
			if (newFitness < oldFitness) 
			{
				oldSol = newSol;			
			}
			else 
			{
				ScalesSolution x = new ScalesSolution(z);
			}
		}
		System.out.println(oldFitness);
		return(oldSol);
	}
	
}
