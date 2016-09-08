
public class Shapley {
	
	@SuppressWarnings("rawtypes")
	IncentiveNode emp = new IncentiveNode();
	
	/**
	 * calculates the total allotment rate of the user
	 * @param n user node.
	 * @return total allotment of the user.
	 */
	@SuppressWarnings({ "rawtypes" })
	public double calculateAllotment(IncentiveNode n){
		double total = 0;
		IncentiveNode p = n.parent;
		double depth = checkLevel(n);
		double allotment = 1/depth;
		if(p.parent != null){
			total += allotment;
		}
		if(n.children != null) {
			depth += 1;
			for(int i = 0; i < n.children.size(); i++) {
				total += 1/depth;
				total += calculateAllotment((IncentiveNode) n.children.get(i));
			}
		}
		return total;
	}
	
	/**
	 * calculates the allotment rate of the author.
	 * @param n root node.
	 * @param price price of the article.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public double authorProfit(IncentiveNode n, double price){
		double directChildren = n.children.size();
		double directPrice = directChildren * price;
		double totalAllotment = 0;
		for(int i = 0; i < directChildren; i++) {
			totalAllotment += calculateAllotment((IncentiveNode) n.children.get(i));
		}
		double p = directPrice + (totalAllotment * price);
		return p;
	}
	
	/**
	 * Calculates the author's profit in algebraic form.
	 * @param n root node.
	 * @param price price of the article.
	 * @return author's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String authorProfitAlgebra(IncentiveNode n, String price){
		double directChildren = n.children.size();
		double totalAllotment = 0;
		for(int i = 0; i < directChildren; i++) {
			totalAllotment += calculateAllotment((IncentiveNode) n.children.get(i));
		}
		double total = directChildren + totalAllotment;
		String profit = total+price;
		return profit;
	}
	
	/**
	 * calculates the user's profit.
	 * @param n user node.
	 * @param price price of the article.
	 * @return user's profit.
	 */
	@SuppressWarnings("rawtypes")
	public double calculateUserProfit(IncentiveNode n, double price) {
		return price * (calculateAllotment(n) - 1);
	}
	
	/**
	 * calculates the user's profit in algebraic form.
	 * @param n user node.
	 * @param price price of the article in algebraic form
	 * @return user's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String calculateUserProfitAlgebra(IncentiveNode n, String price) {
		double total = (calculateAllotment(n) - 1);
		String uProfit = total+ price;
		return uProfit;
	}
	
	/**
	 * calculate the user's revenue earned
	 * @param n user node.
	 * @param price price of the article.
	 * @return user's revenue.
	 */
	@SuppressWarnings("rawtypes")
	public double calculateUserRevenue(IncentiveNode n, double price) {
		return price * calculateAllotment(n);
	}
	
	/**
	 * calculate the user's revenue in algebraic form.
	 * @param n user node.
	 * @param price price of the article in algebraic form.
	 * @return user's revenue in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String calculateUserRevenueAlgebra(IncentiveNode n, String price){
		double allotment = calculateAllotment(n);
		if(allotment == 0) {
			return "0";
		}
		String revenue = allotment + price;
		return revenue;
	}
	
	/**
	 * calculates the current depth of the node.
	 * @param n user node.
	 * @return depth of node.
	 */
	@SuppressWarnings("rawtypes")
	public double checkLevel(IncentiveNode n){
		double depth = 1;
		while(n.parent != null) {
			depth += 1;
			n = n.parent;
		}
		return depth;
	}
}
