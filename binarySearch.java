public static int binarySearch(int[] a, int key)
{
	int hi = a.length()-1;
	int low = 0

	while (low <= high)
	{
		mid = (hi + low)/2;

		if(key < a[mid])
		{
			hi = mid -1;
		}
		else if(key > a[mid])
		{
			low = mid +1;
		}
		else if (key == a[mid])
		{
			return mid;
		}
	}
	return -1;
}