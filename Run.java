import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run
{
	public static void main(String[] args)
	{
		List<Payment> output = new ArrayList<Payment>();
		List<Participant> input = new ArrayList<Participant>();
		input.add(new Participant("a", 50));
		input.add(new Participant("b", 20));
		input.add(new Participant("c", 23));
		input.add(new Participant("d", 17));
		input.add(new Participant("e", -25));
		input.add(new Participant("f", -20));
		input.add(new Participant("g", -75.5));
		input.add(new Participant("h", 10.5));
		for (int i = 0; i < input.size(); i++)
			System.out.println("ID: " + input.get(i).getId() + "\tBalance: " + input.get(i).getBalance());
		System.out.println("---------------------------------------------------------");
		Reconciler.Reconcile(input, output);
		for (int i = 0; i < output.size(); i++)
			System.out.println("From: " + output.get(i).getFrom() + "\tTo: " + output.get(i).getTo() + "\tAmount: " + output.get(i).getAmount());
		System.out.println("---------------------------------------------------------");
		Collections.sort(output);
		for (int i = 0; i < output.size(); i++)
			System.out.println("From: " + output.get(i).getFrom() + "\tTo: " + output.get(i).getTo() + "\tAmount: " + output.get(i).getAmount());

	}
}