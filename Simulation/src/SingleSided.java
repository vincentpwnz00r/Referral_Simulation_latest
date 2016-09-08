
public class SingleSided {
	
	/**
	 * Empty Constructor
	 */
	public SingleSided(){
		
	}
	
	/**
	 * Calculates the revenue gained from the article
	 * @param n root node
	 * @param price price of the article
	 * @return revenue gained
	 */
	@SuppressWarnings("rawtypes")
	public double authorRevenue(IncentiveNode n, double price) {
		int totalArticles = childDesc(n);
		return totalArticles * price;
	}
	
	/**
	 * Calculates the author's profit.
	 * @param n Root node
	 * @param authourRate author's cut
	 * @param price price of the article
	 * @return profit earned
	 */	
	@SuppressWarnings("rawtypes")
	public double authorProfit(IncentiveNode n, double authourRate, double price){
		int numChild = n.children.size();
		int totalDesc = 0;
		for(int i = 0; i < numChild; i++){
			totalDesc += childDesc((IncentiveNode) n.children.get(i));
		}
		double profit = (numChild * price) + (totalDesc * authourRate * price);
		return profit;
	}

	/**
	 * Calculates the author's profit in algebraic form.
	 * @param n Root node.
	 * @param authRate author's allotment rate in algebraic form.
	 * @param aPrice price of the article in algebraic form.
	 * @return author's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String authorProfitAlgebra(IncentiveNode n, String authRate, String aPrice){
		int numChild = n.children.size();
		int totalDesc = 0;
		for(int i = 0; i < numChild; i++){
			totalDesc += childDesc((IncentiveNode) n.children.get(i));
		}
		String authProf = aPrice+"("+numChild+"+"+totalDesc+authRate+")" ;
		return authProf;
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
	 * Calculates the user revenue.
	 * @param n Node which user is located in.
	 * @param allotRate Allotment rate for the user.
	 * @param price price of the article.
	 * @return the revenue earned by user.
	 */
	@SuppressWarnings("rawtypes")
	public double userProfit(IncentiveNode n, double allotRate, double price){
		int numChild = n.children.size();
		return ((numChild * allotRate * price) - price);
	}
	
	/**
	 * Returns the profit of user in algebraic form.
	 * @param n user node.
	 * @param uRate allotment rate for user.
	 * @param aPrice price of article.
	 * @return user's profit in algebraic form.
	 */
	@SuppressWarnings("rawtypes")
	public String userProfitAlgebra(IncentiveNode n, String uRate, String aPrice) {
		int numChild = n.children.size();
		String uProfit = aPrice+"("+numChild+uRate+"-"+1+")";
		return uProfit;
	}
	
	/**
	 * Calculates the user incentive gained
	 * @param n user node.
	 * @param allotRate
	 * @param price
	 * @return incentive gained.
	 */
	@SuppressWarnings("rawtypes")
	public double userIncentive(IncentiveNode n, double allotRate, double price){
		int numChild = n.children.size();
		return numChild * allotRate * price;
	}
	
	/**
	 * Calculates the user incentive in algebraic form. 
	 * @param n user node.
	 * @param uRate allotment rate for user.
	 * @param aPrice price for article.
	 * @return user's incentive gained.
	 */
	@SuppressWarnings("rawtypes")
	public String userIncentiveAlgebra(IncentiveNode n, String uRate, String aPrice){
		int numChild = n.children.size();
		if(numChild == 0){
			return "0";
		}
		String uRev = numChild+uRate+aPrice;
		return uRev;
	}
}
