import java.util.ArrayList;
/**
 * @author Colum Foskin
 * version 1
 *the is the class that stores the information of the Elite players
 */
public class ElitePlayer extends StandardPlayer{
	private int bmi;
	private double height;
	private double membershipSoFar;
	private ArrayList<Competition> eligibleComps;

	/**
	 * @param name
	 * @param dob
	 * @param address
	 * @param bmi
	 * @param height
	 * constructor for the Elite player
	 */
	public ElitePlayer(String name, String dob, String address, int bmi, double height) {
		super(name, dob, address);
		this.bmi=bmi;
		this.height=height;
		membershipSoFar= 0;
		eligibleComps=new ArrayList<Competition>();
	}

	/**
	 *  getter for Array list of eligible competitions
	 */
	public ArrayList<Competition> getEligibleComps()
	{
		return eligibleComps;
	}
	/**
	 * @param eligibleComps
	 * setter for the Arraylist of eligible competitions
	 */
	public void setEligibleComps(ArrayList <Competition> eligibleComps)
	{
		this.eligibleComps = eligibleComps;
	}
	public int getBmi() {
		return bmi;
	}
	/**
	 * @param bmi
	 *  This method sets the bmi of the member to the value passed in as parameter.
	 */
	public void setBmi(int bmi) {
		this.bmi = bmi;
	}
	/**
	 * @return
	 * returns the height of the elite player
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height
	 * this method sets the height of the elite player to the height passed in as a parameter
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return
	 * returns the membership so far
	 */
	public double getMembershipSoFar() {
		return membershipSoFar;
	}
	/**
	 * @param membershipSoFar
	 * This method sets the membership paid so far of the member to 
	 * the value passed in as parameter.
	 */
	public void setMembershipSoFar(double membershipSoFar) {
		this.membershipSoFar = membershipSoFar;
	}

	/**
	 * @return
	 * This method calculates the members fee based on the flat fee multiplied
	 * by the amount of competitions they are in and updates it if the player
	 * has paid some membership already.
	 */	
	public double calculateMembershipFee() 
	{
		double totalFee= 10 + (10 *eligibleComps.size());
		if (membershipSoFar >= totalFee)
		{
			return 0;
		}
		else if (membershipSoFar < totalFee)
		{
			return totalFee- membershipSoFar;
		}
		else
			return totalFee;
	}

	/**
	 * @return 
	 * this method returns the same fee for the player, similar to the calculateMembershipFee() method, 
	 * only the fee returned here does not get updated and is used to calculate 
	 * the target membership in the GaaClub class as the other method reduces the fee accordingly
	 * with the membership collected, this then reduced the target when it should not of had in the targetMembership() method.
	 */
	public double fee()
	{
		return  10 + (10 *eligibleComps.size());
	}

	/**
	 * @param amt
	 * This method takes in the amount paid in and updates the membershipsofar.
	 */
	public void payMembership(double amt) 
	{
		membershipSoFar += amt;
	}

	/**
	 * this method adds the competition passed in and then sorts the array again.
	 */
	public void addCompetiton(Competition c)
	{
		eligibleComps.add(c);
		selectionSort(eligibleComps);
	}

	/**
	 * this method removes the competition and then sorts the array again.
	 */
	public void removeCompetition(Competition c)
	{
		eligibleComps.remove(c);
		selectionSort(eligibleComps);	 
	}

	/**
	 * this method lists the competitions that the player is eligible for and has entered
	 */
	public void viewEligbleComps()
	{  
		if(eligibleComps.size()>0)
		{
			StdOut.println("The list of your eligible competitions sorted by name are: ");
			for (int i = 0; i < eligibleComps.size(); i++)
			{
				selectionSort(eligibleComps);
				StdOut.println(eligibleComps.get(i));
			}
		}
		else StdOut.println("you are not added to any eligble competitions"+ "\n");
	}

	/**
	 * @param eligibleComps The array to be sorted
	 * This method uses the selection sort algorithm to sort the array.  It calls the 
	 * findPosOfLargest method to determine the position of the largest element in the
	 * array.  Each iteration over the array reduces the size of the array by 1 until 
	 * the array is sorted.
	 */
	private void selectionSort(ArrayList<Competition> eligibleComps)
	{
		for (int i = eligibleComps.size(); i > 0; i--)
		{
			int posLargest = findPosOfLargest(eligibleComps, i);
			swapCompetition(eligibleComps, posLargest, i-1);
		}
	}

	/**
	 * @param eligibleComps the array whose elements to search for the largest element
	 * @param size the position of the largest element in the array.
	 * @return returns the position of the largest element in the Array.
	 */
	private int findPosOfLargest(ArrayList<Competition> eligibleComps, int size)
	{
		int largestPosSoFar = 0;
		for (int i = 1; i < size; i++)
		{
			if (eligibleComps.get(i).getName().compareTo(eligibleComps.get(largestPosSoFar).getName()) > 0)
				largestPosSoFar = i;
		}
		return largestPosSoFar;
	}
	/**
	 * @param eligibleComps The array whose elements will be swapped
	 * @param i the first element to be swapped with the second
	 * @param j the second element to be swapped with the first
	 */
	private void swapCompetition(ArrayList<Competition> eligibleComps,int i, int j)
	{
		Competition temp = eligibleComps.get(i);
		eligibleComps.set(i, eligibleComps.get(j) );
		eligibleComps.set(j, temp) ;
	}


	public String toString() {
		return "ElitePlayer  name= " + name
				+ ", dateOfBirth=" + dob + ", address=" + address + "  " + "bmi=" + bmi + ", height=" + height
				+ ", eligibleComps=" + eligibleComps + ", membershipSoFar="
				+ membershipSoFar + ", fee=" + calculateMembershipFee() ;
	}   
}
