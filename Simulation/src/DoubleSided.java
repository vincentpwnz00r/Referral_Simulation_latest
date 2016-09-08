
public class DoubleSided {

	/**
	 * Empty Constructor
	 */
	public DoubleSided(){
		
	}
	
	/**
	 * Calculates the total revenue earned prior to paying for incentive to users.
	 * @param n Root node.
	 * @param price Price of the article.
	 * @return total revenue.
	 */
	@SuppressWarnings("rawtypes")
	public double authorRevenue(IncentiveNode n, double price){
		return childDesc(n) * price;
	}
	
	/**
	 * Calculates the author's profit based on the referral tree.
	 * @param n Root node.
	 * @param authorRate Author's allotment rate.
	 * @param price price of the article.
	 * @return profit earned for the articles sold.
	 */
	@SuppressWarnings("rawtypes")
	public double authorProfit(IncentiveNode n, double authorRate, double price){
		int numChild = n.children.size();
		int totalDesc = 0;
		for(int i = 0; i < numChild; i++){
			totalDesc += childDesc((IncentiveNode) n.children.get(i));
		}
		double profit = (numChild * price) + (totalDesc * authorRate * price);
		return profit;
	}
	
	/**
	 * Calculates the author's profit in algebraic form.
	 * @param n root node.
	 * @param aRate author's allotment rate.
	 * @param aPrice price of the article.
	 * @return author's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String authorProfitAlgebra(IncentiveNode n, String aRate, String aPrice){
		int numChild = n.children.size();
		int totalDesc = 0;
		for(int i = 0; i < numChild; i++){
			totalDesc += childDesc((IncentiveNode) n.children.get(i));
		}
		String profit = aPrice + "("+ numChild + "+" + totalDesc +aRate +")";
		return profit;
	}
	
	/**
	 * Calculates the total incentive gained for a user based on the number of successful referrals.
	 * @param n User node.
	 * @param refRate allotment rate gained when successfully referred.
	 * @param acceptRate allotment rate when given user accepts the referral.
	 * @param price price of the article.
	 * @return total amount of incentive revenue gained.
	 */
	@SuppressWarnings("rawtypes")
	public double userIncentive(IncentiveNode n, double refRate, double acceptRate, double price){
		IncentiveNode p = n.parent;
		int numChild = n.children.size();
		if(p.parent == null){
			return numChild * refRate * price;
		}
		else {
			double totalIncentive = (acceptRate * price) + (numChild * refRate * price);
			return totalIncentive;
		}
	}
	
	/**
	 * Calculates the user's incentive in algebraic form.
	 * @param n user node.
	 * @param refRate allotment rate for successful referral.
	 * @param acceptRate allotment rate for accepting the referral.
	 * @param aPrice price of the article.
	 * @return user's incentive in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String userIncentiveAlgebra(IncentiveNode n, String refRate, String acceptRate, String aPrice){
		String zero = "0";
		IncentiveNode p = n.parent;
		int numChild = n.children.size();
		String revenue;
		if(p.parent == null){
			if(numChild == 0) {
				return zero;
			}
			else{
				revenue = numChild+refRate+aPrice;
			}
			return revenue;
		}
		else {
			if (numChild > 0){
				revenue = aPrice + "(" + acceptRate + "+" + numChild+refRate+ ")";
			}
			else{
				revenue = aPrice + "(" + acceptRate + ")";
			}
			return revenue;
		}
	}
	
	/**
	 * Calculates the amount of profit the user gained through the whole referral process.
	 * @param n User node.
	 * @param refRate allotment rate gained when successfully referred.
	 * @param acceptRate allotment rate when given user accepts the referral.
	 * @param price price of the article.
	 * @return profit earned.
	 */
	@SuppressWarnings("rawtypes")
	public double userProfit(IncentiveNode n, double refRate, double acceptRate, double price){
		return (userIncentive(n, refRate, acceptRate, price) - price);
	}
	
	/**
	 * Calculates the user's profit in algebraic form.
	 * @param n user node.
	 * @param refRate allotment rate gained when successfully referred.
	 * @param acceptRate allotment rate when given user accepts the referral.
	 * @param aPrice price of the article.
	 * @return user's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String userProfitAlgebra(IncentiveNode n, String refRate, String acceptRate, String aPrice){
		IncentiveNode p = n.parent;
		int numChild = n.children.size();
		String profit;
		if(p.parent == null){
			profit = aPrice + "(" + numChild+refRate + "-" + 1 + ")";
			return profit;
		}
		else {
			profit = aPrice + "(" + acceptRate + "+" + numChild+refRate +" -" + + 1 + ")";
			return profit;
		}
	}
	
	/**
	 * Returns the number of children and descendants the node has.
	 * @param n Node 
	 * @return number of children and descendants.
	 */
	@SuppressWarnings("rawtypes")
	public int childDesc(IncentiveNode n){
		int counter = 0;
		int numChild = n.children.size();
		counter += numChild;
		for(int i = 0; i < n.children.size(); i++) {
			IncentiveNode c = (IncentiveNode) n.children.get(i);
			counter += childDesc(c);
		}
		return counter;
	}
}
