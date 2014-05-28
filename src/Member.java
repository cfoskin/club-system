import java.util.ArrayList;
/**
 * @author Colum Foskin
 * version 1
 * This is a class that stores the information of a member
 */
public class Member {

	protected String name;
	protected String dob;
	protected String address;
	private double membershipSoFar;

	/**
	 * @param name
	 * @param dob
	 * @param address
	 * constructor the member
	 */
	public Member(String name, String dob, String address) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		membershipSoFar = 0;
	}

	/**
	 * @return 
	 * returns the members name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name - This method sets the name of the member to 
	 * the value passed in as parameter.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * returns the members date of birth
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 * This method sets the date of birth of the member to 
	 * the value passed in as parameter.
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return
	 * returns the members address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 * This method sets the address of the member to 
	 * the value passed in as parameter.
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @param amt
	 * This method takes in the amount paid in and updates the membershipsofar.
	 */
	public void payMembership(double amt) 
	{
		membershipSoFar += amt;
	}

	/**
	 * @return
	 * This method calculates the members fee and updates it if the member
	 * has paid some membership already
	 */
	public double calculateMembershipFee()
	{
		if (membershipSoFar >= 200)
		{
			return 0;
		}
		else if (membershipSoFar >0 && membershipSoFar < 200)
		{
			return 200- membershipSoFar;
		}
		else
			return 200;
	}

	/**
	 * @return 
	 * this method returns the same fee for the member, similar to the calculateMembershipFee() method, 
	 * only the fee returned here does not get updated and is used to calculate 
	 * the target membership in the GaaClub class as the other method reduces the fee accordingly
	 * with the membership collected, this then reduced the target when it should not of had in the targetMembership() method.
	 */
	public double fee()
	{
		return 200;
	}

	public String toString() {
		return "Member name=" + name + ", dateOfBirth=" + dob
				+ ", address=" + address + ", membershipSoFar="
				+ membershipSoFar + ", fee=" + calculateMembershipFee() ;
	}

	/**
	 * These methods below were put in so that the super class had the same methods as the sub classes as was required.
	 * They serves no purpose other than that. these were put in here empty to help with the functionality
	 */
	public void addCompetiton(Competition c)
	{
	}
	public void removeCompetition(Competition c)
	{
	}
	public ArrayList<Competition> getEligibleComps()
	{
		return null;
	}
	
}
