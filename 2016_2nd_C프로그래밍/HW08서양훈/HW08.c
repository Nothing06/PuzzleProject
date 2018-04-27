#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define EXT 100
int freq[1000] = { 0, };

void init_words_memory(char *** t)
{
	int i = 0;
	*t = (char**)malloc(sizeof(char*) * 100);
	for (i = 0; i < 100; i += 1)
	{
		(*t)[i] = (char*)malloc(100);
		memset((*t)[i], 0, 100);
	}
}
void extend_mem(char *** t, int s)
{
	int i = 0;
	char ** tmp;

	tmp = *t;
	*t = (char**)malloc(sizeof(char*) * (s+EXT));
	for (i=0; i < s+EXT; i += 1)
	{
		(*t)[i] = (char*)malloc(100);
		memset((*t)[i], 0, 100);
	}
	for (i = 0; i < s; i += 1)
	{
		memcpy((*t)[i], tmp[i], strlen(tmp[i]));
	}
//	printf("HELLO\n");
	for (i = 0; i < s; i += 1)
	{
		free(tmp[i]);
	}
	free(tmp);
//	printf("HELLO\n");
}
void print_words(char ** t, int cnt)
{
	int i = 0;
	for (i = 0; i < cnt; i += 1)
	{
		printf("%5d\t%s\n", freq[i], t[i]);
	}
//	printf("===========================\n");
//	printf("단어: %d개\n", cnt);
}
void sort_words(char ** t, int cnt)
{
	int i = 0;
	int j = 0;
	char * b;
	int a = 0;
	
	for (i = 0; i < cnt - 1; i += 1)
	{
		for (j = 0; j < cnt - i - 1; j += 1)
		{
		if (strcmp(t[j], t[j+1]) > 0)
		{
		b = t[j];
		t[j] = t[j + 1];
		t[j + 1] = b;

		a = freq[j];
		freq[j] = freq[j + 1];
		freq[j + 1] = a;
		}
		}
	}
	//print_words(t, cnt);
	for (i = 0; i < cnt - 1; i += 1)
	{
		for (j = 0; j < cnt - i -1; j += 1)
		{
			if (freq[j] < freq[j+1])
			{
				b = t[j];
				t[j] = t[j + 1];
				t[j + 1] = b;

				a = freq[j];
				freq[j] = freq[j + 1];
				freq[j + 1] = a;
			}
		}
	}
	
}
int check_dup(char ** t,int idx, char * buf)
{
	int i, j;

	for (i = 0; i <= idx; i += 1)
	{
		if (!strcmp(t[i], buf))
		{
			freq[i] += 1;
			return 1;
		}
	}
	return 0;
}
int main(void)
{
	char filename[100] = { 0, };
	FILE * fp;
	char buf[1000] = { 0, };
	char ** tmp;
	int ret = 0;
	int i = 0;
	int cnt = 0;
	int is_dup = 0;
	int include_dup_cnt = 0;

	printf("파일명입력: ");
	fgets(filename, 100, stdin);
	filename[strlen(filename) - 1] = 0;

	fp = fopen(filename, "rt");
	if (!fp)
	{
		printf("fp fopen() error!\n");
		exit(1);
	}
	init_words_memory(&tmp);
	while (1)
	{
		memset(buf, 0, sizeof(buf));
		ret = fscanf(fp, "%s", buf);
		if (ret == -1)
		{
			break;
		}
		
		if (i % 100 == 0 && i >= 100)
		{
			extend_mem(&tmp, i);
		}
		is_dup = check_dup(tmp,i, buf);
		if (is_dup == 0)
		{
			strcpy(tmp[i], buf);
			freq[i] += 1;
			//printf("HELLO%d\n",i);
			i += 1;
		}
		include_dup_cnt += 1;
	}
	cnt = i;
	fclose(fp);
	//print_words(tmp,cnt);

	sort_words(tmp, cnt);
	//printf("\n * After Sorting\n");
	print_words(tmp, cnt);
//	printf("중복포함 총 단어의 수 : %d개\n", include_dup_cnt);
	return 0;
}