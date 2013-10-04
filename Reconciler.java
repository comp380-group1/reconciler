import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reconciler
{
	private static void EvenOut(List<Participant> input, List<Payment> output)
	{
		Collections.sort(input);
		for (int i = 0; i < input.size() && input.get(i).getBalance() < 0; i++)
		{
			for (int j = input.size() - 1; j > i && input.get(j).getBalance() > 0; j--)
			{
				double result = input.get(i).getBalance() + input.get(j).getBalance();
				if (result == 0 && input.get(i).getBalance() != 0 && input.get(j).getBalance() != 0)
				{
					output.add((new Payment(input.get(j).getId(), input.get(i).getId(), input.get(j).getBalance())));
					input.get(i).setBalance(0);
					input.get(j).setBalance(0);
					break;
				}
			}
		}
		Collections.sort(input);
	}

	public static void Reconcile(List<Participant> input, List<Payment> output)
	{
		EvenOut(input, output);
		for (int i = 0; i < input.size() && input.get(i).getBalance() < 0; i++)
		{
			for (int j = input.size() - 1; j > i && input.get(j).getBalance() > 0; j--)
			{
				double result = input.get(i).getBalance() + input.get(j).getBalance();
				if (result < 0 && input.get(i).getBalance() != 0 && input.get(j).getBalance() != 0)
				{
					output.add(new Payment(input.get(j).getId(), input.get(i).getId(), input.get(j).getBalance()));
					input.get(i).setBalance(result);
					input.get(j).setBalance(0);
					EvenOut(input, output);
					i = 0;
					j = input.size();
				}
				else if (result > 0 && input.get(i).getBalance() != 0 && input.get(j).getBalance() != 0)
				{
					output.add(new Payment(input.get(j).getId(), input.get(i).getId(), Math.abs(input.get(i).getBalance())));
					input.get(i).setBalance(0);
					input.get(j).setBalance(result);
					EvenOut(input, output);
					i = 0;
					j = input.size();
				}
			}
		}
	}
}