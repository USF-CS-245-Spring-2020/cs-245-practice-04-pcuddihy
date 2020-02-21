import java.util.Arrays;

public class MergeSort implements SortingAlgorithm
{
	//from class notes and copyOfRange from geeksforgeeks
	public void sort(int [] a)
	{
		//base case for when one item is left
		if (a.length <= 1)
		{
			return;
		}

		//get size of left array
		int left_size = a.length / 2;
		
		//put values into left and right arrays
		int[] left = Arrays.copyOfRange(a, 0, left_size);
		int[] right = Arrays.copyOfRange(a, left_size, a.length);

		//recursive call of sorting left and right, then merge both
		sort(left);
		sort(right);
		merge(a, left, right);
	}

	public void merge(int [] target, int [] left, int [] right)
	{
		int indexL = 0;
		int indexR = 0;
		int indexTarget = 0;

		//check left value against right and put in lower value
		while (indexL < left.length && indexR < right.length)
		{
			if (left[indexL] <= right[indexR])
			{
				target[indexTarget++] = left[indexL++];
			}
			else
			{
				target[indexTarget++] = right[indexR++];
			}
		}

		while (indexL < left.length)
		{
			target[indexTarget++] = left[indexL++];
		}
		while (indexR < right.length)
		{
			target[indexTarget++] = right[indexR++];
		}
	}
}