#include<stdio.h>
#include<stdlib.h>
#include<string.h>


long GetFileSize(FILE * fp)
{
	long fpos;
	long fsize;
	fpos = ftell(fp);
	fseek(fp, 0, SEEK_END);
	fsize = ftell(fp);
	fseek(fp, fpos, SEEK_SET);
	return fsize;
}
int main(void)
{
	FILE * fp;
	long fsize = 0;
	char filename[100] = { 0, };

	strcpy(filename, "mystory.txt");
	fp = fopen(filename, "rt");
	if (!fp)
	{
		fprintf(stderr, "fopen() error!\n");
		exit(1);
	}

	fsize = GetFileSize(fp);
	printf("%s 파일크기: %ldByte\n",filename, fsize);
	return 0;
}