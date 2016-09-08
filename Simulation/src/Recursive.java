
public class Recursive {

	/**
	 * Calculates the total revenue earned prior to giving out incentive.
	 * @param n root node.
	 * @param price price of an article.
	 * @return revenue earned by the author.
	 */
	@SuppressWarnings("rawtypes")
	public double authorRevenue(IncentiveNode n, double price){
		return childDesc(n) * price;
	}
	
	/**
	 * Calculates the total profit author gained.
	 * @param n Root node.
	 * @param authorRate allotment rate for the author.
	 * @param price article price.
	 * @return profit of the author.
	 */
	@SuppressWarnings("rawtypes")
	public double authorProfit(IncentiveNode n, double authorRate, double price){
		int numChild = n.children.size();
		int totalDesc = 0;
		for(int i = 0; i < numChild; i++) {
			totalDesc += childDesc((IncentiveNode) n.children.get(i));
		}
		double profit = (numChild * price) + (totalDesc * authorRate * price);
		return profit;
	}
	
	/**
	 * calculates the author's profit in algebraic form.
	 * @param n root node.
	 * @param aRate author's allotment rate.
	 * @param aPrice price of the article.
	 * @return author's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String authorProfitAlgebra(IncentiveNode n, String aRate, String aPrice){
		int numChild = n.children.size();
		int totalDesc = 0;
		for(int i = 0; i < numChild; i++) {
			totalDesc += childDesc((IncentiveNode) n.children.get(i));
		}
		String profit = aPrice + "(" + numChild + "+" + totalDesc+aRate + ")";
		return profit;
	}
	
	/**
	 * user's total incentive rate.
	 * @param n user node.
	 * @param authorRate author's allotment rate.
	 * @return user's total incentive.
	 */
	@SuppressWarnings({ "null", "rawtypes" })
	public double userIncentiveRate(IncentiveNode n, double authorRate){
		double total = 0;
		int nodeDepth = checkLevel(n);
		if(n.parent == null) {
			return 0;
		}
		else if(n.children == null){
			return 0;
		}
		else {
			for(int i = 0; i < n.children.size(); i++) {
				double tots = totalX(n);
				total += ( (1 - authorRate) * (nodeDepth /tots));
				total += userIncentiveRate((IncentiveNode) n.children.get(i), authorRate);
			}
		}
		return total;
	}
	
	/**
	 * returns the allotment rate of the user.
	 * @param n user node.
	 * @return allotment rate of user.
	 */
	@SuppressWarnings({ "rawtypes", "null" })
	public double userAllotment(IncentiveNode n){
		double total = 0;
		int nodeDepth = checkLevel(n);
		if(n.parent == null) {
			return (Double) null;
		}
		else if(n.children == null){
			return 0;
		}
		else {
			for(int i = 0; i < n.children.size(); i++) {
				double tots = totalX(n);
				total += ((nodeDepth /tots));
				total += userAllotment((IncentiveNode) n.children.get(i));
			}
		}
		return total;
	}
	
	/**
	 * calculates the user's profit.
	 * @param n user node.
	 * @param price price of the article.
	 * @param authorRate allotment rate of the author's.
	 * @return profit of the user.
	 */
	@SuppressWarnings("rawtypes")
	public double userProfit(IncentiveNode n, double price, double authorRate) {
		return price*(userIncentiveRate(n, authorRate) - 1);
	}
	
	/**
	 * Calculates the user profit in algebraic form.
	 * @param n user node.
	 * @param price price of the article.
	 * @param authorRate author's allotment rate.
	 * @return profit of the user in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String userProfitAlgebra(IncentiveNode n, String price, String authorRate){
		String profit = price+"("+"("+1+ "-" +authorRate+")"+userAllotment(n)+"-"+1+")";
		return profit;
	}
	/**
	 * calculates user's revenue.
	 * @param n user node.
	 * @param price price of the article.
	 * @param authorRate allotment rate of the author.
	 * @return revenue of the user.
	 */
	@SuppressWarnings("rawtypes")
	public double userRevenue(IncentiveNode n, double price, double authorRate){
		return price * userIncentiveRate(n, authorRate);
	}
	
	/**
	 * calculates the revenue of the user in algebra.
	 * @param n user node.
	 * @param price price of the article.
	 * @param authorRate author's allotment rate.
	 * @return user's revenue in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String userRevenueAlgebra(IncentiveNode n, String price, String authorRate) {
		double allot = userAllotment(n);
		if(allot == 0 ){
			return "0";
		}
		else{
			String revenue = allot+"(" +1 + "-"+ authorRate+ ")"+price;
			return revenue;
		}
	}
	
	/**
	 * calculates the summation for range 1...depth
	 * @param n user node.
	 * @return summation total.
	 */
	@SuppressWarnings("rawtypes")
	public double totalX(IncentiveNode n) {
		int depthOfNode = checkLevel(n);
		int total = 0;
		for(int i = 0; i <= depthOfNode ; i++) {
			total += i;
		}
		return total;
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
	
	/**
	 * calculates the current depth of the node.
	 * @param n user node.
	 * @return depth of node.
	 */
	@SuppressWarnings("rawtypes")
	public int checkLevel(IncentiveNode n){
		int depth = 0;
		while(n.parent != null) {
			depth += 1;
			n = n.parent;
		}
		return depth;
	}
}
