public class QuickSort implements SortingAlgorithm
{
	//from programcreek.com
	public void sort(int [] a)
	{
		qs(a, 0, a.length - 1);
	}

	public int partition(int [] a, int start, int end)
	{
		int pivot = a[end];

		for (int i = start; i < end; i++)
		{
			if (a[i] < pivot)
			{
				int temp = a[start];
				a[start] = a[i];
				a[i] = temp;
				start++;
			}
		}

		int temp = a[start];
		a[start] = pivot;
		a[end] = temp;

		return start;
	}

	public void qs(int [] a, int start, int end)
	{
		if (start < end)
		{
			int p = partition(a, start, end);
			qs(a, start, p - 1);
			qs(a, p + 1, end);
		}
	}
}