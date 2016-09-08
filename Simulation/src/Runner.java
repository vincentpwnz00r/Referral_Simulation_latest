import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		IncentiveNode<Integer> n = new IncentiveNode();
		Probability p = new Probability();
		
		SingleSided s = new SingleSided();
		DoubleSided ds = new DoubleSided();
		Recursive rec = new Recursive();
		Shapley shap = new Shapley();

		Scanner keyboard = new Scanner(System.in);
/**
		//Scenario for incentive and Author profit calculation
		String alphaOne = "a_1";
		String alphaTwo = "a_2";
		String price = "c";
		String authorRate = "b";
		
		IncentiveNode<Integer> root = new IncentiveNode<Integer>(1);
		root.addChild(2);
		root.addChild(3);
		root.addChild(4);
		root.addChild(5);
		root.children.get(0).addChild(6);
		root.children.get(0).addChild(7);
		root.children.get(2).addChild(8);
		root.children.get(3).addChild(9);
		root.children.get(3).addChild(10);
		IncentiveNode<Integer> two = root.children.get(0);
		IncentiveNode<Integer> three = root.children.get(1);
		IncentiveNode<Integer> four = root.children.get(2);
		IncentiveNode<Integer> five = root.children.get(3);
		IncentiveNode<Integer>  six = two.children.get(0);
		IncentiveNode<Integer>  seven = two.children.get(1);;
		two.children.get(0).addChild(11);
		

		//Single Sided Author Profit and incentive
		System.out.println("Single Sided Refferal System");
		//L = 0
		System.out.println(s.authorProfitAlgebra(root,authorRate,price));
		//L = 1
		System.out.println(s.userIncentiveAlgebra(root.children.get(0), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(root.children.get(1), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(root.children.get(2), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(root.children.get(3), alphaOne, price));
		//L = 2
		System.out.println(s.userIncentiveAlgebra(two.children.get(0), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(two.children.get(1), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(four.children.get(0), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(five.children.get(0), alphaOne, price));
		System.out.println(s.userIncentiveAlgebra(five.children.get(1), alphaOne, price));
		//L = 3
		System.out.println(s.userIncentiveAlgebra(six.children.get(0), alphaOne, price));
		
		//Double Sided Author Profit and incentive
		System.out.println("Doule Sided Referral System");
		//L = 0
		System.out.println(ds.authorProfitAlgebra(root, authorRate, price));
		//L = 1
		System.out.println(ds.userIncentiveAlgebra(root.children.get(0), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(root.children.get(1), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(root.children.get(2), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(root.children.get(3), alphaOne, alphaTwo, price));
		//L = 2
		System.out.println(ds.userIncentiveAlgebra(two.children.get(0), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(two.children.get(1), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(four.children.get(0), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(five.children.get(0), alphaOne, alphaTwo, price));
		System.out.println(ds.userIncentiveAlgebra(five.children.get(1), alphaOne, alphaTwo, price));
		//L = 3
		System.out.println(ds.userIncentiveAlgebra(six.children.get(0), alphaOne, alphaTwo, price));
		
		
		//Recursive Author profit and incentive
		System.out.println("Recursive Referral System");
		//L = 0
		System.out.println(rec.authorProfitAlgebra(root, authorRate, price));
		//L = 1
		System.out.println(rec.userRevenueAlgebra(root.children.get(0), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(root.children.get(1), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(root.children.get(2), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(root.children.get(3), price, authorRate));
		//L = 2
		System.out.println(rec.userRevenueAlgebra(two.children.get(0), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(two.children.get(1), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(four.children.get(0), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(five.children.get(0), price, authorRate));
		System.out.println(rec.userRevenueAlgebra(five.children.get(1), price, authorRate));
		//L =3
		System.out.println(rec.userRevenueAlgebra(six.children.get(0), price, authorRate));
		
		//Shapley Value Author profit and incentive
		System.out.println("Shapley Referral System");
		//L = 0
		System.out.println(shap.authorProfitAlgebra(root, price));
		//L = 1
		System.out.println(shap.calculateUserRevenueAlgebra(root.children.get(0), price));
		System.out.println(shap.calculateUserRevenueAlgebra(root.children.get(1), price));
		System.out.println(shap.calculateUserRevenueAlgebra(root.children.get(2), price));
		System.out.println(shap.calculateUserRevenueAlgebra(root.children.get(3), price));
		//L = 2
		System.out.println(shap.calculateUserRevenueAlgebra(two.children.get(0), price));
		System.out.println(shap.calculateUserRevenueAlgebra(two.children.get(1), price));
		System.out.println(shap.calculateUserRevenueAlgebra(four.children.get(0), price));
		System.out.println(shap.calculateUserRevenueAlgebra(five.children.get(0), price));
		System.out.println(shap.calculateUserRevenueAlgebra(five.children.get(1), price));
		//L = 3
		System.out.println(shap.calculateUserRevenueAlgebra(six.children.get(0), price));
		
		System.out.println(n.deepestDepth(root, 0));
		//System.out.println("Total amount of incentive in single sided gained is :" + numNodesSS(root, 1, s));
		//System.out.println("total number of nodes at level is :" + numNodes(root,2));
		//System.out.println("Total amount of incentive in double sided gained is:" + numNodesDS(root,1,ds));
		//System.out.println("Total amount of incentive in recursive gained is:" + numNodesRec(root,1,rec));
		//System.out.println("Total amount of incentive in Shapley gained is:" + numNodesShap(root,1,shap));
**/
		System.out.println("maximum nodes are:"+maximumNodes(30));
		double ran1, ran2, ran3;
		Boolean  pB,iB,tB;
		double priceThreshold = 0.0;
		double incentiveThreshold = 0.0;
		double typeThreshold = 0.0;
		double afterSimNodes = 0;
		double afterSimDepth = 0;
		double afterSimSSAuthorProfit = 0;
		double afterSimDSAuthorProfit = 0;
		double afterSimRecAuthorProfit = 0;
		double afterSimShapAuhtorProfit = 0;
		double afterSimSSFirst = 0,afterSimSSSecond = 0,afterSimSSThird = 0,afterSimSSFourth = 0,afterSimSSFifth = 0;
		double afterSimDSFirst = 0,afterSimDSSecond = 0,afterSimDSThird = 0,afterSimDSFourth = 0,afterSimDSFifth = 0;
		double afterSimRECFirst = 0,afterSimRECSecond = 0,afterSimRECThird = 0,afterSimRECFourth = 0,afterSimRECFifth = 0;
		double afterSimShapFirst = 0,afterSimShapSecond = 0,afterSimShapThird = 0,afterSimShapFourth = 0,afterSimShapFifth = 0;
		double numNodesInFirst = 0, numNodesInSecond = 0, numNodesInThird = 0, numNodesInFourth = 0, numNodesInFifth = 0;

		Boolean SS =false, DS = false, REC = false, SHAP = false;
		System.out.println("Please select the type of referral method to run. (ss for single sided, ds for double sided, rec for recursive, shap for Shapley)");
		String answer = keyboard.next();
		if(answer.equals("ss")){
			SS= true;
		}
		else if(answer.equals("ds")){
			DS = true;
		}
		else if(answer.equals("rec")){
			REC = true;
		}
		else {
			SHAP = true;
		}

		System.out.println("Please key in the probability for price: ");
		priceThreshold = keyboard.nextDouble();

		System.out.println("Please key in the probability for incentive: ");
		incentiveThreshold = keyboard.nextDouble();

		System.out.println("Please key in the probability for type of referral: ");
		typeThreshold = keyboard.nextDouble();


		for(int z = 0; z < 100; z++) {
			int counter = 1;
			IncentiveNode<Integer> rootSim = new IncentiveNode<Integer>(counter);
			IncentiveNode<Integer> holder;
			counter++;
			for (int i = 0; i < 4; i++) {
				ran1 = p.genRanNum();
				pB = p.yesOrNo(ran1, priceThreshold);
				if (pB == true) {
					rootSim.addChild(counter);
					counter++;
				}
			}

			addChildProb(rootSim, p, priceThreshold, incentiveThreshold, typeThreshold, counter);

			afterSimDepth += (n.deepestDepth(rootSim, 0) - 1);
			afterSimNodes += ds.childDesc(rootSim);
			afterSimSSAuthorProfit += s.authorProfit(rootSim,1,1)- numNodes(rootSim,1);
			afterSimDSAuthorProfit += ds.authorProfit(rootSim,1,1)- numNodes(rootSim,1);
			afterSimRecAuthorProfit += rec.authorProfit(rootSim,1,1)- numNodes(rootSim,1);
			afterSimShapAuhtorProfit += shap.authorProfit(rootSim,1)- numNodes(rootSim,1);

			numNodesInFirst += numNodes(rootSim,1);
			numNodesInSecond += numNodes(rootSim,2);
			numNodesInThird += numNodes(rootSim,3);
			numNodesInFourth += numNodes(rootSim,4);
			numNodesInFifth += numNodes(rootSim,5);

			afterSimSSFirst += numNodesSS(rootSim,1,s);
			afterSimSSSecond +=numNodesSS(rootSim,2,s);
			afterSimSSThird += numNodesSS(rootSim,3,s);
			afterSimSSFourth +=  numNodesSS(rootSim,4,s);
			afterSimSSFifth +=  numNodesSS(rootSim,5,s);

			afterSimDSFirst += numNodesDS(rootSim,1,ds);
			afterSimDSSecond += numNodesDS(rootSim,2,ds) - 1;
			afterSimDSThird += numNodesDS(rootSim,3,ds) - 1;
			afterSimDSFourth += numNodesDS(rootSim,4,ds) -1;
			afterSimDSFifth += numNodesDS(rootSim,5,ds) - 1;

			afterSimRECFirst += numNodesRec(rootSim,1,rec);
			afterSimRECSecond += numNodesRec(rootSim,2,rec);
			afterSimRECThird += numNodesRec(rootSim,3,rec);
			afterSimRECFourth += numNodesRec(rootSim,4,rec);
			afterSimRECFifth += numNodesRec(rootSim,5,rec);

			afterSimShapFirst += numNodesShap(rootSim,1,shap);
			afterSimShapSecond += numNodesShap(rootSim,2,shap);
			afterSimShapThird += numNodesShap(rootSim,3,shap);
			afterSimShapFourth += numNodesShap(rootSim,4,shap);
			afterSimShapFifth += numNodesShap(rootSim,5,shap);

		}
		afterSimSSFirst = afterSimSSFirst/numNodesInFirst;
		afterSimSSSecond = afterSimSSSecond/numNodesInSecond;
		afterSimSSThird = afterSimSSThird/numNodesInThird;
		afterSimSSFourth =afterSimSSFourth/numNodesInFourth;
		afterSimSSFifth = afterSimSSFifth/numNodesInFifth;

		afterSimDSFirst = afterSimDSFirst/numNodesInFirst;
		afterSimDSSecond = afterSimDSSecond/numNodesInSecond;
		afterSimDSThird = afterSimDSThird/numNodesInThird;
		afterSimDSFourth =afterSimDSFourth/numNodesInFourth;
		afterSimDSFifth = afterSimDSFifth/numNodesInFifth;

		afterSimRECFirst = afterSimRECFirst/numNodesInFirst;
		afterSimRECSecond = afterSimRECSecond/numNodesInSecond;
		afterSimRECThird = afterSimRECThird/numNodesInThird;
		afterSimRECFourth =afterSimRECFourth/numNodesInFourth;
		afterSimRECFifth = afterSimRECFifth/numNodesInFifth;

		afterSimShapFirst = afterSimShapFirst/numNodesInFirst;
		afterSimShapSecond = afterSimShapSecond/numNodesInSecond;
		afterSimShapThird = afterSimShapThird/numNodesInThird;
		afterSimShapFourth =afterSimShapFourth/numNodesInFourth;
		afterSimShapFifth = afterSimShapFifth/numNodesInFifth;

		System.out.println("Average depth is :" + afterSimDepth/100.0);
		System.out.println("Average nodes is :" +(afterSimNodes - 100.0)/100.0);




		if(SS == true) {
			System.out.println("Average profit for author in Single Sided:" + afterSimSSAuthorProfit / 100.0);
			System.out.println("SS Average revenue for users at L =1: " + afterSimSSFirst / 100.0);
			System.out.println("SS Average revenue for users at L =2: " + afterSimSSSecond / 100.0);
			System.out.println("SS Average revenue for users at L =3: " + afterSimSSThird / 100.0);
			System.out.println("SS Average revenue for users at L =4: " + afterSimSSFourth / 100.0);
			System.out.println("SS Average revenue for users at L =5: " + afterSimSSFifth / 100.0);
		}
		else if(DS == true ) {
			System.out.println("Average profit for author in Double Sided:" + afterSimDSAuthorProfit / 100.0);
			System.out.println("DS Average revenue for users at L =1: " + afterSimDSFirst / 100.0);
			System.out.println("DS Average revenue for users at L =2: " + afterSimDSSecond / 100.0);
			System.out.println("DS Average revenue for users at L =3: " + afterSimDSThird / 100.0);
			System.out.println("DS Average revenue for users at L =4: " + afterSimDSFourth / 100.0);
			System.out.println("DS Average revenue for users at L =5: " + afterSimDSFifth / 100.0);
		}
		else if(REC == true) {
			System.out.println("Average profit for author in Recursive:" + afterSimRecAuthorProfit / 100.0);
			System.out.println("REC Average revenue for users at L =1: " + afterSimRECFirst / 100.0);
			System.out.println("REC Average revenue for users at L =2: " + afterSimRECSecond / 100.0);
			System.out.println("REC Average revenue for users at L =3: " + afterSimRECThird / 100.0);
			System.out.println("REC Average revenue for users at L =4: " + afterSimRECFourth / 100.0);
			System.out.println("REC Average revenue for users at L =5: " + afterSimRECFifth / 100.0);
		}
		else {
			System.out.println("Average profit for author in Shapley:" + afterSimShapAuhtorProfit / 100.0);
			System.out.println("SHAP Average revenue for users at L =1: " + afterSimShapFirst / 100.0);
			System.out.println("SHAP Average revenue for users at L =2: " + afterSimShapSecond / 100.0);
			System.out.println("SHAP Average revenue for users at L =3: " + afterSimShapThird / 100.0);
			System.out.println("SHAP Average revenue for users at L =4: " + afterSimShapFourth / 100.0);
			System.out.println("SHAP Average revenue for users at L =5: " + afterSimShapFifth / 100.0);
		}

	}
	
	public static void addChildProb(IncentiveNode<Integer> iN, Probability p, double priceThreshold, double incentiveThreshold, double typeThreshold, int counter){
		double ran1, ran2, ran3;
		Boolean  pB,iB,tB;
		for(int i = 0; i < iN.children.size(); i++) {
			for(int j = 0; j < 3; j++){
				ran1 = p.genRanNum();
				ran2 = p.genRanNum();
				ran3 = p.genRanNum();
				pB = p.yesOrNo(ran1, priceThreshold);
				iB = p.yesOrNo(ran2, incentiveThreshold);
				tB = p.yesOrNo(ran3, typeThreshold);
				if(pB == true && iB == true && tB == true) {
					iN.children.get(i).addChild(counter);
					counter++;
				}	
			}

		}
		if(iN.deepestDepth(iN, 0) < 31){
			for(int i = 0 ; i < iN.children.size(); i++) {
				addChildProb(iN.children.get(i),p,priceThreshold,incentiveThreshold,typeThreshold,counter);
			}
		}

	}

	public static long maximumNodes(int max){
		int currentDepth = 0;
		long total = 0;
		if(currentDepth == 0 && currentDepth <= max){
			total += 1;
			currentDepth++;
		}
		if(currentDepth == 1 && currentDepth <= max){
			total += 4;
			currentDepth++;
		}
		int sub = 4,newNodes;
		for(int i = currentDepth; i<= max; i++){
			newNodes = sub * 3;
			total += newNodes;
			sub = newNodes;
		}
		return total;
	}

	public static double numNodesSS(IncentiveNode<Integer> n, int depth, SingleSided s){
		double total = 0;
		for(int i = 0; i < n.children.size(); i++){
			IncentiveNode<Integer> current = n.children.get(i);
			int cD = n.currentDepth(current) - 1;
			if(cD == depth) {
				total += s.userIncentive(current,1,1);
			}
			total += numNodesSS(current, depth, s);
		}
		return total;
	}

	public static double numNodesDS(IncentiveNode<Integer> n, int depth, DoubleSided ds){
		double total = 0;
		for(int i = 0; i < n.children.size(); i++){
			IncentiveNode<Integer> current = n.children.get(i);
			int cD = n.currentDepth(current) - 1;
			if(cD == depth) {
				total += ds.userIncentive(current, 1, 1, 1);
			}
			total+= numNodesDS(current,depth,ds);
		}
		return total;
	}

	public static double numNodesRec(IncentiveNode<Integer> n, int depth, Recursive rec){
		double total = 0;
		for(int i = 0; i < n.children.size(); i++){
			IncentiveNode<Integer> current = n.children.get(i);
			int cD = n.currentDepth(current) - 1;
			if(cD == depth) {
				total += rec.userRevenue(current,1,0);
			}
			total+= numNodesRec(current,depth,rec);
		}
		return total;
	}

	public static double numNodesShap(IncentiveNode<Integer> n, int depth, Shapley sP){
		double total = 0;
		for(int i = 0; i < n.children.size(); i++){
			IncentiveNode<Integer> current = n.children.get(i);
			int cD = n.currentDepth(current) - 1;
			if(cD == depth){
				total +=  sP.calculateUserRevenue(current, 1);
			}
			total += numNodesShap(current, depth, sP);
		}
		return total;
	}

	/**
	 * gets the number of nodes at L = depth
	 * @param n root node
	 * @param depth level of the node to be found.
	 * @return number of nodes at depth desired.
	 */
	public static double numNodes(IncentiveNode<Integer> n , int depth) {
		double total = 0;
		for(int i = 0; i < n.children.size(); i++){
			IncentiveNode<Integer> current = n.children.get(i);
			int cD = n.currentDepth(current) - 1;
			if(cD == depth) {
				total += 1;
			}
			total += numNodes(current, depth);
		}
		return total;
	}

}
