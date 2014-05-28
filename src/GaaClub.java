import java.util.ArrayList;

/**
 * @author Colum Foskin
 * version 1 This class is the main class which controls everything that happens within the Gaa club
 */
public class GaaClub {
	private String clubName;
	private String clubAddress;
	private ArrayList<Member> members;
	private ArrayList<Competition> competitions;

	/**
	 * constructor for the club where some competitions are created and 
	 * some members of each type are created for testing purposes.
	 * There is also methods to do this in this class.
	 */
	public GaaClub()
	{
		competitions= new ArrayList<Competition>();
		//creating some competitions 
		Competition one = new Competition("competition number one");
		competitions.add(one);
		Competition two = new Competition("competition number two");
		competitions.add(two);
		Competition three = new Competition("competition number three");
		competitions.add(three);
		Competition four = new Competition("competition number four");
		competitions.add(four);
		Competition five = new Competition("competition number five");
		competitions.add(five);
		Competition six = new Competition("competition number six");
		competitions.add(six);
		// Populating the array of members
		members = new ArrayList<Member>();
		Member a = new Member("memberOne", " jan 1", "waterford");
		members.add(a);
		Member b = new Member("memberTwo", " jan 2", "waterford");
		members.add(b);
		Member c = new StandardPlayer("standardOne", " jan 1","waterford");
		members.add(c);
		Member d = new StandardPlayer("standardTwo", " jan 2", "waterford");
		members.add(d);
		Member e = new ElitePlayer("eliteOne", " jan 1", "waterford", 25,6);
		members.add(e);
		Member f = new ElitePlayer("eliteTwo", " jan 2", "waterford", 30, 4);
		members.add(f);
	}

	/**
	 * @return returns the array competitions
	 */
	public ArrayList<Competition> getCompetitions() {
		return competitions;
	}
	/**
	 * @param competitions 
	 */
	public void setCompetitions(ArrayList<Competition> competitions) {
		this.competitions = competitions;
	}
	/**
	 * @return returns the club name.
	 */
	public String getClubName() {
		return clubName;
	}
	/**
	 * @param clubName sets the club name
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	/**
	 * @return returns the club address
	 */
	public String getClubAddress() {
		return clubAddress;
	}
	/**
	 * @param clubAddress sets the clubs address
	 */
	public void setClubAddress(String clubAddress) {
		this.clubAddress = clubAddress;
	}
	/**
	 * @return returns the array of members
	 */
	public ArrayList<Member> getMembers() {
		return members;
	}
	/**
	 * @param members
	 */
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	
	/**
	 * @param argvs the main method where the app is run.
	 */
	public static void main(String[] argvs) {
		GaaClub app = new GaaClub();
		app.run();
	}
	 
	/**
	 * This is the main run method for the class.
	 */
	private void run() {
		int option = menu();
		while (option != 0) {
			switch (option) {
			case 1:
				createMembers();
				break;
			case 2:
				deleteSomeMembers();
				break;
			case 3:
				StdOut.println(allMembers());
				break;
			case 4: 
				createACompetition();
				break;
			case 5:
				deleteCompetition();					
				break;
			case 6: 
				viewAllCompetitions();			
				break;
			case 7: 
				runEditMembers();			
				break;
			case 8: 
				runClubFinance();		
				break;
			case 9: 
				save();
				break;
			case 10: 
				load();
				break;
			default:
				break;
			}
			option = menu();
		}
		StdOut.println("Exiting... bye");
	}

	/**
	 * this is the menu for the run method
	 * @return returns the int option
	 */
	private int menu() {
		StdOut.println(" Welcome to the Club menu." + "\n"
				+ "Please select an option" + "\n"
				+ "=========================>>>>");
		StdOut.println("1) Add a member");
		StdOut.println("2) delete a member");
		StdOut.println("3) list all members");
		StdOut.println("4) Create a competition");
		StdOut.println("5) Delete a competition");
		StdOut.println("6) list all competitions");
		StdOut.println("7) Enter the edit members menu");
		StdOut.println("8) Enter the club finances menu");
		StdOut.println("9) save");
		StdOut.println("10) load");
		StdOut.println("0) Exit ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}
	
	/**
	 * this is the run method for the cub finances menu
	 */
	private void runClubFinance() {
		int option = menuClubFinances();
		while (option != 0) {
			switch (option) {
			case 1:
				if(members.size()>0)
				{
				totalAmountOwed();
				}
				break;
			case 2:
				if(members.size()>0)
				{
					totalMemberShipCollected();
				}
				else StdOut.println("please add members first");
				break;
			case 3:
				if(members.size()>0)
				{
					targetMembership();
				}
				else StdOut.println("please add members first");
				break;
			case 4:
				if(members.size()>0)
				{
					StdOut.println(membersOwingMembership());
				}
				else StdOut.println("please add members first");
				break;
			case 5:
				if(members.size()>0)
				{
					StdOut.println(whoOwesWhatSummary());
				}
				else StdOut.println("please add members first");
				break;
			default:
				break;
			}
			option = menuClubFinances();
		}
		StdOut.println("Exiting..." + "\n");
	}

	/**
	 * this is the menu for the club finances run method
	 * @return returns the int option
	 */
	private int menuClubFinances() {
		StdOut.println(" Welcome to the club finances menu." + "\n"
				+ "Please select an option" + "\n"
				+ "=========================>>>>");
		StdOut.println("1) check the total Amount Owed");
		StdOut.println("2) check the total MemberShip Collected");
		StdOut.println("3) check the target membership");
		StdOut.println("4) list the members Owing Membership");
		StdOut.println("5) see what each type of members owe");
		StdOut.println("0) Exit to main menu ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}
	
	/**
	 * this is the run method which allows the member to select what they want to be edited
	 * it also gives them access to pay fees and add or remove competitions
	 */
	private void runEditMembers() {
		int option = menuEditPlayer();
		while (option != 0) {
			switch (option) {
			case 1:
				edit();
				break;
			case 2:
				payFee();
				break;
			case 3:
				addCompToPlayer();
				break;
			case 4:
				showEligbleComps();
				break;
			case 5:
				removeCompetitionFromPlayer();
				break;
			default:
				break;
			}
			option = menuEditPlayer();
		}
		StdOut.println("Exiting..." + "\n");
	}

	/**
	 * this is the menu for the run edit method
	 * @return returns the int option
	 */
	private int menuEditPlayer() {
		StdOut.println(" Welcome to the players editing menu." + "\n"
				+ "Please select an option" + "\n"
				+ "=========================>>>>");
		StdOut.println("1) edit members personal details");
		StdOut.println("2) Pay fees");
		StdOut.println("3) add player to competitions");
		StdOut.println("4) view players eligible comps");
		StdOut.println("5) remove a competition form a player");
		StdOut.println("0) Exit and return to club menu ==>>" + "\n");
		int option = StdIn.readInt();
		return option;
	}
	
	/**
	 * this method allows the user to edit any of their details
	 */
	private void edit()
	{
		StdOut.println(allMembers());
		StdOut.println("Enter the index of the member you wish to edit");
		int index=StdIn.readInt();
		Member member = members.get(index);
		if (member instanceof Member || member instanceof StandardPlayer)// standard player and member have the same fields to be edited
		{
			StdOut.println(member.getName()+" enter new name");
			String newName=StdIn.readString();
			member.setName(newName);
			StdOut.println(member.getName()+ " enter new address");
			String address=StdIn.readString();
			member.setAddress(address);
			StdOut.println("your new details are: " + member);
			selectionSort(members);
		}
		else if (member instanceof ElitePlayer)// Elite players have extra fields so require extra options to the 2 above
		{
			ElitePlayer theMember = (ElitePlayer) members.get(index);
			StdOut.println(theMember.getName() + " enter new name");
			String newName=StdIn.readString();
			theMember.setName(newName);
			StdOut.println(theMember.getName()+ " enter new address");
			String address=StdIn.readString();
			theMember.setAddress(address);
			StdOut.println(theMember.getName()+" enter new bmi");
			int bmi =StdIn.readInt();
			theMember.setBmi(bmi); 
			StdOut.println(theMember.getName()+ " enter new height");
			double height =StdIn.readDouble();
			theMember.setHeight(height); 
			StdOut.println("your new details are: " + theMember);
			selectionSort(members);
		}
	}
	
	/**
	 * this method allows the user to select which type of member they would to create and
	 *  then calls the correct method for that type of member
	 */
	private void createMembers() {
		StdOut.println("Please enter the type of member you want to add: (1 = member, 2 = standard player or 3 = elite player) ");
		String reply = StdIn.readString();
		if (reply.contains("1")) {
			addAMember();
		} else if (reply.contains("2")) {
			addStandardPlayer();
		} else if (reply.contains("3")) {
			addElitePlayer();
		}
	}

	/**
	 * @param member
	 * adds the member passed in and then sorts the members array
	 */
	private void addMember(Member member) {
		members.add(member);
		selectionSort(members);
	}

	/**
	 * this method allows the user to add a Member
	 */
	private void addAMember() {
		StdOut.println("You have chosen to add a Member " + "\n");
		StdOut.println("Please enter the members name: ");
		String name = StdIn.readString();
		StdOut.println("Please enter the members date of birth: ");
		String dateOfBirth = StdIn.readString();
		StdOut.println("Please enter the members address: ");
		String address = StdIn.readString();
		Member member = new Member(name, dateOfBirth, address);
		addMember(member);
		StdOut.println("Member added!: " + "\n");
	}

	/**
	 * this method allows the user to add a Standard player
	 */
	private void addStandardPlayer() {
		StdOut.println("You have chosen to add a Standard player " + "\n");
		StdOut.println("Please enter the standard players name: ");
		String name = StdIn.readString();
		StdOut.println("Please enter the standard players  date of birth: ");
		String dateOfBirth = StdIn.readString();
		StdOut.println("Please enter the standard players  address: ");
		String address = StdIn.readString();
		Member player = new StandardPlayer(name, dateOfBirth, address);
		addMember(player);
		StdOut.println("Standard player added!: " + "\n");
	}

	/**
	 * this method allows the user to add an Elite player
	 */
	private void addElitePlayer() {
		StdOut.println("You have chosen to add an Elite player " + "\n");
		StdOut.println("Please enter the elite players name: ");
		String name = StdIn.readString();
		StdOut.println("Please enter the elite players date of birth: ");
		String dateOfBirth = StdIn.readString();
		StdOut.println("Please enter the elite players address: ");
		String address = StdIn.readString();
		StdOut.println("Please enter the elite players BMI: ");
		int bmi = StdIn.readInt();
		StdOut.println("Please enter the elite players height: ");
		double height = StdIn.readDouble();
		Member elite = new ElitePlayer(name, dateOfBirth, address, bmi, height);
		members.add(elite);
		StdOut.println("Elite player added!: " + "\n");
	}

	/**
	 * @return returns a string of all the members
	 */
	private String allMembers() 
	{  
		selectionSort(members);
		String str ="";   
		StdOut.println("The list of members sorted by name is: ");
		for (int i = 0; i < members.size(); i++)
		{
			str+=   i + "" + members.get(i)+ "\n";
		}
		if (members.isEmpty()) 
		{
			return "No members, Please add some first!" + "\n";
		} else
			return str;
	}

	/**
	 * this method is for creating a competition
	 * the members can then be added to one if they are eligible
	 */
	private void createACompetition()
	{
		StdOut.println("Please enter the name of the competition you want to create");
		String name = StdIn.readString();
		Competition comp = new Competition(name);
		competitions.add(comp);
		sortCompetitions(competitions);
	}
	
	/**
	 * this method lists all the competitions that they have created
	 */
	private void viewAllCompetitions()
	{		
		sortCompetitions(competitions);
		StdOut.println("The list of competitions sorted by name are: ");
		for(int i=0; i< competitions.size();i++)
		{
			StdOut.println(i + "" + competitions.get(i)) ;
		}
	}
	
	/**
	 * this method allows the user to delete a competition created by the club
	 */
	private void deleteCompetition()
	{
		viewAllCompetitions();
		StdOut.println("Please enter the index of the competition you want to delete");
		int index = StdIn.readInt();
		competitions.remove(index);
		StdOut.println("you have deleted : " + competitions.get(index).getName());
		sortCompetitions(competitions);
	}

	/**
	 * this method allows the user to add a competition if they are eligible for it
	 */
	private void addCompToPlayer()
	{    
		StdOut.println("select the index of the player you want to add to a competition: "+ "\n");
		StdOut.println(allMembers());
		int index= StdIn.readInt();
		if(members.get(index) instanceof StandardPlayer || members.get(index) instanceof ElitePlayer)
		{
			viewAllCompetitions();// listing the competitions to choose form
			StdOut.println(" select the index of the competition"+"\n");
			int cIndex = StdIn.readInt();
			StdOut.println(members.get(index).getName() +"  Are you eligible for " + competitions.get(cIndex).getName() + " y/n ? " + "\n");
			String reply= StdIn.readString();// asking the user if they are eligible
			if(reply.contains("y"))
			{
			members.get(index).addCompetiton(competitions.get(cIndex));
			String name= members.get(index).getName();
			StdOut.println(name+ "you have been added to: "+ competitions.get(cIndex).getName() +"\n");
			}
			else StdOut.println("You must be eligible to enter");
		}
		else
			StdOut.println("you must be a standard player or elite player to be eligble for the competitions!!"+ "\n");
	}
	
	/**
	 * this method allows the user to remove a competition if they are already added to one.
	 */
	private void removeCompetitionFromPlayer()
	{
		StdOut.println("select the index of the player you want to remove from a competition: ");
		StdOut.println(allMembers());
		int index= StdIn.readInt();
		if(index <= members.size())
		{
			if(members.get(index) instanceof StandardPlayer || members.get(index) instanceof ElitePlayer && 
			   members.get(index).getEligibleComps().size()>=0) 
			{
				StdOut.println("select the index of the competition you want to remove: ");
				for(int i=0;i< members.get(index).getEligibleComps().size();i++)
				{
				StdOut.println( i +" "+members.get(index).getEligibleComps().get(i) + "\n");
				}
				int cIndex = StdIn.readInt();
				String compName= members.get(index).getEligibleComps().get(cIndex).getName();
				StdOut.println("do you want to remove: " +compName + " y/n ?" + "\n");
                String reply= StdIn.readString();
                if(reply.contains("y"))
                {
			     members.get(index).removeCompetition(members.get(index).getEligibleComps().get(cIndex));
				String name= members.get(index).getName();
				StdOut.println(name + "  you have been removed from: "+ compName+"\n");
                }
                else 
                	StdOut.println("You have not been removed - please try again.");
			}
			 else 
             	StdOut.println("You have not been removed - please try again.");
		}
		else  StdOut.println("please select an index within the range given" + "\n");
	}

	/**
	 * This is a method that allows the user to view the list of competitions that a member is in.
	 */
	private void showEligbleComps()
	{
		if(competitions.size() >0 && members.size()>0)
		{
			StdOut.println("select the index of the player you want to view eligible competitions for: "+ "\n");
			for(int i=0; i<members.size();i++)
			{
				StdOut.println(i + ": "+ members.get(i).getName());
			}
			int index= StdIn.readInt();
			if(index > members.size())// this is to avoid breaking the app if the user enters an index outside of the range.
			{			
				StdOut.println("please select an index within the range given" + "\n");
			}
			else
			{
				if(members.get(index) instanceof StandardPlayer)
				{
					((StandardPlayer)members.get(index)).viewEligbleComps(); 

				}
				else if(members.get(index) instanceof ElitePlayer)
				{
					((ElitePlayer)members.get(index)).viewEligbleComps(); 
				}
				else
					StdOut.println("you can only view the eligible competitions for a standard player or elite player!"+ "\n");
			}
		}
			else StdOut.println("please add members and competitions first");
	}

	/**
	 * this method allows the user to pay membership fees
	 */
	private void payFee() {
		if(members.size()>0)
		{
			StdOut.println(allMembers());
			StdOut.println("Enter the index of the member you wish to pay a fee for");
			int i=StdIn.readInt();
			if(i> members.size())
			{			
				StdOut.println("please select an index within the range given" + "\n");
			}
			else
			{
				Member aMember = members.get(i);
				double fee=aMember.calculateMembershipFee();
				StdOut.println(aMember.getName() + "you owe : "+ fee +  "   Enter amount you wish to pay: ");
				double amt = StdIn.readDouble();
				if(amt>0 && amt<fee)
				{
					aMember.payMembership(amt);
					StdOut.println(aMember.getName() + " you have paid: " + amt + "\n");
				}
				else if(amt == fee)
				{
					aMember.payMembership(amt);
					StdOut.println(aMember.getName()+ " you have paid: " + amt + "and all your fees are paid. Thank you" + "\n" );
				}
				else if(amt>fee)
				{
					StdOut.println(aMember.getName() +"  you are owe less then you are trying to pay! please start again and pay the correct fee" +"\n");
				}
			}
		}
			else StdOut.println("no members! please add members first" + "\n");
		}

	/**
	 * this method calculates the total amount of money the club is owed
	 * @return returns double clubtotalOwed 
	 */
	private double totalAmountOwed()
	{
		double clubTotalOwed = 0;
		if (members.size() > 0) 
		{
			for (Member aMember : members)
			{
				double feeOwed=aMember.calculateMembershipFee();
				clubTotalOwed += feeOwed;
			}
			if (clubTotalOwed > 0)
				StdOut.println("total amount owed is: " + clubTotalOwed);
			else
				StdOut.println("no money owed");
		}
		return clubTotalOwed;
	}

	/**
	 * this method calculates the total amount of membership the club has collected
	 * @return returns the clubTotalCollected
	 */
	private double totalMemberShipCollected()
	{
		double clubTotalCollected = 0;
		if(members.size()>0)
		{
			for (Member aMember : members) 
			{
				double feesPaid = aMember.getMembershipSoFar();
				clubTotalCollected += feesPaid;
			}
			if (clubTotalCollected > 0) 
				StdOut.println("total amount of money collected is: " + clubTotalCollected);
			else 
				StdOut.println( "money has been collected so far is " + 0.0);
		}
		return clubTotalCollected;
	}

	/**
	 * this method calculates the target membership for the club.
	 * @return returns double clubtargetFees
	 */
	private double targetMembership()
	{
		double clubTargetFees = 0;
		if(members.size()>0)
		{
			for (Member aMember : members)
			{
				double feeOwed = aMember.fee();
		        clubTargetFees += feeOwed;
			}
			if(clubTargetFees >0)
			StdOut.println("The clubs target membership is: " + clubTargetFees);
		}
		else 
		{
			StdOut.println("The club has no members and does not have a target membership yet");
		}
		return clubTargetFees;
	}

	/**
	 * @return returns a string of the members who still owe money
	 */
	private String membersOwingMembership()
	{
		String str = "";
		for (Member aMember : members)
		{
			double fee=aMember.calculateMembershipFee();
			double feePaidSoFar = aMember.getMembershipSoFar();
			double feeOwed= fee - feePaidSoFar;
			if (feePaidSoFar < fee) 
			{
				str += (aMember.getName() + "you owe : "+ feeOwed +  " and are on the list of people who owe money" + "\n");
			}
		}
		if (str.equals("")) 
		{
			return "No members owe money";
		}
		else
			return str;
	}

	/**
	 * @return returns a string of how much each type of members owe the club
	 */
	private String whoOwesWhatSummary() { 
		String str = "";
		double totalMembersFeesOwed = 0;
		double totalStandardPlayerFeesOwed = 0;
		double totalElitePlayerFeesOwed = 0;   
		for (Member aMember : members) {
			double fee = aMember.calculateMembershipFee();
			double feePaidSoFar = aMember.getMembershipSoFar();
			double feeOwed= 0;
			if (feePaidSoFar < fee && aMember instanceof Member && !((aMember) instanceof StandardPlayer)) {
				feeOwed = fee - feePaidSoFar;
				totalMembersFeesOwed += feeOwed;
			}
			if (feePaidSoFar < fee && aMember instanceof StandardPlayer && !((aMember) instanceof ElitePlayer)) {
				feeOwed = fee - feePaidSoFar;

				totalStandardPlayerFeesOwed += feeOwed;
			}
			if (feePaidSoFar < fee && aMember instanceof ElitePlayer) {
				feeOwed = fee - feePaidSoFar;
				totalElitePlayerFeesOwed += feeOwed;
			}
			str = "Standard members owe: " + totalMembersFeesOwed + "\n"
					+ "Standard players owe: " + totalStandardPlayerFeesOwed
					+ "\n" + "Elite players owe: " + totalElitePlayerFeesOwed
					+ "\n";
		}
		if (str.equals("")) {
			return "No members owe money";
		} else
			return str;
	}
	
	/**
	 * @param name
	 * @return returns an int of the position in the members array where a
	 * particular member is if they exist. other wise -1 is returned
	 */
	private int searchForMember(String name) 
	{
		for (int i=0 ; i<members.size(); i++) 
			if (members.get(i).getName().equals(name)) 
			return i; 
			return -1;
	}
	
	/**
	 * this method allows a member to be deleted after being searched for by name if found.
	 */
	public void deleteSomeMembers()
	{
		if(members.size()>0)
		{
			StdOut.println("You have chosen to delete a Member " + "\n");
			for(int i=0;i<members.size();i++)
			{
				StdOut.println(members.get(i).getName());
			}
			StdOut.println("Please enter the members name you wish to delete: ");
			String name = StdIn.readString();
			searchForMember(name);
			deleteMember(name);
			StdOut.println("Member: " +name + " has been deleted: " + "\n");
			selectionSort(members);
		}
		else  StdOut.println("No members yet, please add some");
	}

	/**
	 * @param name 
	 * @return returns the member
	 */
	private Member deleteMember(String name)
	{
		int index = searchForMember(name);
		if(index >= 0)
		{
			Member member = members.get(index);
			removeMember(name);
			return member;
		}
		else
		return null;
	}
	
	/**
	 * @param name
	 * removes the member 
	 */
	private void removeMember(String name) {
		if(searchForMember(name)>=0)
		{
		members.remove(searchForMember(name));
		}
		else StdOut.print("cant remove this member");
	}
	
	/**
	 * @param members The array to be sorted
	 * This method uses the selection sort algorithm to sort the array.  It calls the 
	 * findPosOfLargest method to determine the position of the largest element in the
	 * array.Each iteration over the array reduces the size of the array by 1 until 
	 * the array is sorted.
	 */
	private void selectionSort(ArrayList<Member> members)
	   {
	      for (int i = members.size(); i > 0; i--)
	      {
	         int posLargest = findPosOfLargest(members, i);
	         swapMember(members, posLargest, i-1);
	      }
	  }

	 /**
	 * @param members The array whose elements to search for the largest element
	 * @param size The position of the largest element in the array.
	 * @return returns the position of the largest element in the Array.
	 */
	private int findPosOfLargest(ArrayList<Member> members, int size)
	    {
	       int largestPosSoFar = 0;
	       for (int i = 1; i < size; i++)
	       {
	          if (members.get(i).getName().compareTo(members.get(largestPosSoFar).getName()) > 0)
	            largestPosSoFar = i;
	       }
	       return largestPosSoFar;
	   }
	 
	/**
	 * @param members The array whose elements will be swapped
	 * @param i the first element to be swapped with the second
	 * @param j the second element to be swapped with the first
	 * */
	private void swapMember(ArrayList<Member> members,int i, int j)
	{
		Member temp = members.get(i);
		members.set(i, members.get(j) );
		members.set(j, temp) ;
	}
	
	/**
	 * @param competitions The array to be sorted
	 * This method uses the selection sort algorithm to sort the array.  It calls the 
	 * findPosOfLargestComp method to determine the position of the largest element in the
	 * array.Each iteration over the array reduces the size of the array by 1 until 
	 * the array is sorted.
	 * */
	private void sortCompetitions(ArrayList<Competition> competitions)
	   {
	      for (int i = competitions.size(); i > 0; i--)
	      {
	         int posLargest = findPosOfLargestComp(competitions, i);
	         swapCompetition(competitions, posLargest, i-1);
	      }
	  }

	 /**
	 * @param competitions The array whose elements to search for the largest element
	 * @param size  The position of the largest element in the array.
	 * @return  returns the position of the largest element in the Array.
	 */
	private int findPosOfLargestComp(ArrayList<Competition> competitions, int size)
	    {
	       int largestPosSoFar = 0;
	       for (int i = 1; i < size; i++)
	       {
	          if (competitions.get(i).getName().compareTo(competitions.get(largestPosSoFar).getName()) > 0)
	            largestPosSoFar = i;
	       }
	       return largestPosSoFar;
	   }
	 
	/**
	 * @param competitions The array whose elements will be swapped
	 * @param i the first element to be swapped with the second
	 * @param j the second element to be swapped with the first
	 * */
	private void swapCompetition(ArrayList<Competition> competitions,int i, int j)
	{
		Competition temp = competitions.get(i);
		competitions.set(i, competitions.get(j) );
		competitions.set(j, temp) ;
	}
	
	/**
	 * save method for the .xml file
	 */
	private void save() {
		StdStream.saveToFile(members, "myMembers.xml");
	}

	/**
	 * load method for the .xml file
	 */
	private void load() {
		members = (ArrayList<Member>) StdStream.readFromFile("myMembers.xml");
	}

	public String toString() {
		return "Gaaclub clubName=" + clubName + ", clubAddress=" + clubAddress
				+ ", members=" + members;
	}
}