#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	FILE * fp;
	char buf[1000] = { 0, };
	char * t;

	fp = fopen("mystory.txt", "rt");
	if (!fp)
	{
		fprintf(stderr, "fopen() error!\n");
		exit(1);
	}

	while (1)
	{
		memset(buf, 0, 1000);
		t = fgets(buf, 1000, fp);
		if (t == NULL)
		{
			printf("EOF\n");
			break;
		}
		printf("%s", buf);
	}
	fclose(fp);
	return 0;
}