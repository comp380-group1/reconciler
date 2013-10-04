public class Participant implements Comparable<Participant>
{
	private String id;
	private double balance;

	public Participant(String id, double balance)
	{
		this.id = id;
		this.balance = balance;
	}

	public String getId()
	{
		return this.id;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public double getBalance()
	{
		return this.balance;
	}

	public int compareTo(Participant participant)
	{
		if (this.balance < participant.getBalance()) return -1;
		if (this.balance > participant.getBalance()) return 1;
		return 0;
	}
}