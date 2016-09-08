import java.util.Random;

public class Probability {

	Random r = new Random();
	public Probability(){
		
	}
	
	/**
	 * generates a number between 0 to 1.
	 * @return number generated.
	 */
	public double genRanNum(){
	double rValue = (1) * r.nextDouble();
	return rValue;
	}
	
	/**
	 * Bernoulli Distribution based on threshold.
	 * @param p given probability.
	 * @param threshold given probability value for a successful referral.
	 * @return whether it is a successful referral.
	 */
	public boolean yesOrNo(double p, double threshold){
		double range = 1 - threshold;
		if(p >= range){
			return true;
		}
		return false;
	}
	
	/**
	 * calculates the probability of events based for a poisson distribution.
	 * @param lambda average number of events.
	 * @param events number of successful referrals. 
	 * @return probability of successful referrals.
	 */
	public double poissonDistribution(double lambda, double events){
		return (Math.pow(lambda, events) * Math.exp(-lambda))/factorial((int)events);
	}
	
	/**
	 * calculates the factorial given a number.
	 * @param f given number.
	 * @return factorial of f.
	 */
	public double factorial(int f){
		double facto = 1;
		for(int i = 1; i <= f; i++){
			facto *= i;
		}
		return facto;
	}
}
