/*
	���� 1
		1. int ** parr;
		2. int * (*ptr)[5];
	���� 2
		SimpleFuncOne(int * parr1, int * parr2)
		SimpleFuncTwo(int (*ptr1)[4], int (*ptr2)[4])
	���� 3
		ComplexFuncOne(int ** p1, int *(*ptr)[5])
		ComplexFuncTwo(int *** arr3, int *** (*ptr)[5])
	���� 4
		3 2
		6 4
		5 2
		1 1
	���� 5
		*(arr[1][0]+1)
		*(*(arr+1)+0)[1]
		*(*(*(arr+1)+0)+1)
		*(*(arr[1])+1)
		((*(arr+1))[0][1])
		
*/