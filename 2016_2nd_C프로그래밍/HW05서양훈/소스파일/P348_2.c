#include<stdio.h>

int ** transpose(int(*parr)[4], int * row, int * col)//포인터를 이용해 arr[2][4]의 전치행렬(==p[4][2]) 구현
{
	int ** p;
	int t;
	int i = 0, j = 0;
	p = (int**)malloc(sizeof(int*)* (*col));
	for (i = 0; i < *col; i += 1)
	{
		p[i] = (int*)malloc(sizeof(int)*(*row));
		for(j=0;j< *row;j+=1)
			p[i][j] = parr[j][i];
	}
	t = *row;
	*row = *col;
	*col = t;
	return p;
}
void show_matrix(int ** p, int row, int col)
{
	int i, j;
	for (i = 0; i < row; i += 1)
	{
		for (j = 0; j < col; j += 1)
		{
			printf("%3d", p[i][j]);
		}
		printf("\n");
	}
}
int main(void)
{
	int arr1[2][4];
	int arr2[4][2];
	int ** p;
	int row = 2;
	int col = 4;

	int i = 0, j = 0;
	int value = 1;
	for (i = 0; i < 2; i += 1)
	{
		for (j = 0; j < 4; j += 1)
		{
			arr1[i][j] = value++;
		}
	}

	for (i = 0; i < 2; i += 1)
	{
		for (j = 0; j < 4; j += 1)
			arr2[j][i] = arr1[i][j];
	}

	for (i = 0; i < 2; i += 1)
	{
		for (j = 0; j < 4; j += 1)
		{
			printf("%3d", arr1[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	for (i = 0; i < 4; i += 1)
	{
		for (j = 0; j < 2; j += 1)
		{
			printf("%3d", arr2[i][j]);
		}
		printf("\n");
	}

	printf("Before Transpose\n");
	for (i = 0; i < 2; i += 1)
	{
		for (j = 0; j < 4; j += 1)
		{
			printf("%3d", arr1[i][j]);
		}
		printf("\n");
	}
	printf("After Transpose\n");
	row = 2;
	col = 4;
	p = transpose(arr1, &row,&col);
	show_matrix(p, row, col);
	return 0;
}