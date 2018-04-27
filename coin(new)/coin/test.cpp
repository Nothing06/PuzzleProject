#include "stdio.h"
#include "balance.h"
#include<stdlib.h>
#include<string.h>

int main()
{
	//int sample2[3] = { 4,5 };
	int one[2] = { 0,-1 };
	int two[2] = { 1,-1 }; // �迭 ���õ�
	int ret;
	int okay_c_cnt = 0; // ����������
	int not_c_cnt = 0; // ������������
	int idx = 0;
	int okay_idx1 = 0; // ó��ã�� ������ idx
	int okay_idx2 = 0; // �ι�° ã�� ������ idx
	int not_okay_idx = 0; // ó��ã�� �ҷ����� idx
	int balance_call_cnt = 0; // ��Ƚ��

	int idx1 = 0;
	int idx2 = 1;
	int comp[98];
	int bad_cnt = 0;
	int okay_bad[3]; // 7 5
	int cmp[3] = { idx1, idx2, -1 }; // ���ϱ����� �迭(5 5�� 7 7..)
	int coin_arr[100];
	
	int B[2] = { -1,-1 };

	initialize();
	printf("\n*****  1�ܰ� :: one�� two �� ******\n");
	while (okay_c_cnt != 1 && not_c_cnt != 1)
	{
		ret = balance(one, two); balance_call_cnt += 1;
		if (ret == ERROR)
			printf("ERROR\n");
		if (ret == SMALL)
		{
			printf(" �� one : 5		 two : 7\n"); // coin_weight[one[0]] = 5; coin_weight[two[0]] = 7;
			okay_c_cnt += 1; not_c_cnt += 1;
			okay_idx1 = two[0]; not_okay_idx = one[0];
			break;
		}
		if (ret == LARGE)
		{
			printf(" �� one : 7		 two : 5\n");  // coin_weight[one[0]] = 7; coin_weight[two[0]] = 5;
			okay_c_cnt += 1; not_c_cnt += 1;
			okay_idx1 = one[0]; not_okay_idx = two[0];
			break;
		}
		two[0] += 1;

	}/*
	 two[1] = -1;
	 one[1] = -1;
	 printf("\n****** 2�ܰ� :: two�迭�� thr�迭 �� ******\n");
	 if (is_one_smaller == 1)
	 {
	 while (thr[0]<100)
	 {
	 ret = balance(two, thr); balance_call_cnt += 1;
	 //	printf("AAA\n");
	 if (ret == EQUAL && thr[0] != okay_idx1)
	 {
	 okay_idx2 = thr[0]; printf("one : 5		two: 7		three: 7\n"); break;
	 }
	 thr[0] += 1;
	 }
	 }
	 else
	 {
	 while (thr[0]<100)
	 {
	 ret = balance(two, thr); balance_call_cnt += 1;
	 //	printf("AAA\n");
	 if (ret == SMALL && thr[0] != okay_idx1)
	 {
	 okay_idx2 = thr[0]; printf("one : 7		two: 5		three: 7\n");  break;
	 }
	 thr[0] += 1;
	 }
	 }*/
	printf("������ idx: %d / �ҷ����� idx: %d\n", okay_idx1, not_okay_idx);
	printf("\n***** �������ܰ� : 2���� �� ��Ʈ�� ���� ��  ******\n");

	okay_bad[0] = okay_idx1; okay_bad[1] = not_okay_idx; okay_bad[2] = -1;
	cmp[0] = idx1; cmp[1] = idx2; cmp[2] = -1;
	int comp_idx = 0;
	int i = 0;

	while (comp_idx<98)
	{
		if (i == okay_idx1 || i == not_okay_idx)
		{
			i += 1;
			continue;
		}
		comp[comp_idx++] = i; // comp�迭:: okay_bad�� ������(�ε���2��)�� ������ ���ε��� �����̴�.
		i += 1;
	}

	for (int i = 0; i <= 96; i += 2)
	{
		cmp[0] = comp[i];
		cmp[1] = comp[i + 1];
		ret = balance(okay_bad, cmp); balance_call_cnt += 1;
		if (ret == SMALL)
		{
			coin_arr[cmp[0]] = -1;
			coin_arr[cmp[1]] = -1;
		}
		else if (ret == LARGE)
		{
			coin_arr[cmp[0]] = cmp[0]; coin_arr[cmp[1]] = cmp[1];
			bad_cnt += 2;
		}
		else if (ret == EQUAL)
		{
			int * tmp1 = (int*)malloc(sizeof(int) * 2);
			int * tmp2 = (int*)malloc(sizeof(int) * 2);
			tmp1[0] = cmp[0]; tmp1[1] = -1;
			tmp2[0] = cmp[1]; tmp2[1] = -1;
			printf("=================\n");
			ret = balance(tmp1, tmp2); balance_call_cnt += 1;
			if (ret == SMALL)
			{
				coin_arr[tmp1[0]] = tmp1[0];
				coin_arr[tmp2[0]] = -1; // -1�� ������
			}
			else if (ret == LARGE)
			{
				coin_arr[tmp2[0]] = tmp2[0];
				coin_arr[tmp1[0]] = -1; // -1�� ������
			}

			free(tmp1); free(tmp2);
			bad_cnt += 1; printf("=================\n");
		}
		else if (ret == ERROR)
		{
			printf("ERROR\n");
		}
	}
	coin_arr[okay_idx1] = -1;
	coin_arr[not_okay_idx] = not_okay_idx; bad_cnt += 1;

	/*for (int i = 0; i < 100; i += 1)
	{
		if (coin_arr[i] == -1) continue;
		printf("%d ", coin_arr[i]);
	}*/

	printf("\n");
	int * A = (int*)malloc(sizeof(int)*(bad_cnt+1));
	int Aidx = 0;

	for (int i = 0; i < 100; i += 1)
	{
		if (coin_arr[i] == -1)
			continue;
		A[Aidx++] = coin_arr[i];
	}
	A[bad_cnt] = -1;
	 B[1] = -1;
	 ret = balance(A, B); balance_call_cnt += 1;
	if (ret == SUCCESS)
	{
		printf("\n");
		for (int i = 0; i < bad_cnt; i += 1)
		{
			printf("%d  ", A[i]);
		}
	}
	return 0;
}