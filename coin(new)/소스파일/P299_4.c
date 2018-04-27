#include<stdio.h>
#include<stdlib.h>

void reverse_int_array(int * p, int len)
{
	int i = 0;
	int * front;
	int * rear;
	int * tmp;
	int t = 0;
	int * parr;
	 
	
		parr = p;
		for (i = 0; i < len / 2; i += 1)
		{
			front = &parr[i];
			rear = &parr[len - 1 - i];
			t = *front;
			*front = *rear;
			*rear = t;

		}
	
	
}
void reverse_str_array(void ** p, int len)
{
	int i = 0;
	char * front;
	char * rear;
	char *t;
	int * parr;
	char ** strArr;

		strArr = (char**)p;
		for (i = 0; i < len / 2; i += 1)
		{
			front = strArr[i];
			rear = strArr[len - 1 - i];
			t = front;
			front = rear;
			rear = t;
			strArr[i] = front;
			strArr[len - 1 - i] = rear;
		}
}
void print_strings(void ** p, int len)
{
	int i = 0;
	int * arr;
	char ** s;


		s = (char**)p;
		for (i = 0; i < len; i += 1)
		{
			printf("strArr[%d] : %s\n", i, s[i]);
		}	
	
}
void print_numbers(void * p, int len )
{
	int i = 0;
	int * arr;
	
	arr = (int*)p;
	for (i = 0; i < len; i += 1)
	{
		printf("arr[%d] : %d\n", i, arr[i]);
	}
}


int main(void)
{
	int arr[6] = { 1,2,3,4,5,6 };
	char * strArr[6] = { "Hello", "Man", "ManKind", "server", "ally", "Water" };
	int i = 0;
	int len = sizeof(arr) / sizeof(int);

	printf(" * Before Reversing\n");
	print_numbers(arr, len);
	print_strings((void**)strArr, len);

	reverse_int_array(arr, len);
	reverse_str_array((void**)strArr, len); 
	printf("\n");

	printf(" * After Reversing\n");
	print_numbers(arr, len);
	print_strings((void**)strArr, len);

	return 0;
}