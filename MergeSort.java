import java.util.Arrays;

public class MergeSort implements SortingAlgorithm
{
	//from class notes and geeksforgeeks
	public void sort(int [] a)
	{
		//base case for when one item is left
		if (a.length <= 1)
		{
			return;
		}

		//get sizes of left and right sizes
		int left_size = a.length / 2;
		int right_size = a.length - left_size;
		int[] left = new int[left_size];
		int[] right = new int[right_size];

		//put values into left and right arrays
		int rtracker = 0;
		for (int i = 0; i < a.length; ++i)
		{
			if (i < left_size)
			{
				left[i] = a[i];
			}
			else
			{
				right[rtracker++] = a[i];
			}
		}

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