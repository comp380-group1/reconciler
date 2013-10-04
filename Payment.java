public class Payment implements Comparable<Payment>
{
	private String from;
	private String to;
	private double amount;

	public Payment(String from, String to, double amount)
	{
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public String getFrom()
	{
		return this.from;
	}

	public String getTo()
	{
		return this.to;
	}

	public double getAmount()
	{
		return this.amount;
	}

	public int compareTo(Payment payment)
	{
		return this.from.compareTo(payment.getFrom());
	}
}
