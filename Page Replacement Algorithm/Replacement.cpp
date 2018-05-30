#include<bits/stdc++.h>
using namespace std;
#define bug printf("bug check");
int main()
{
    int page, frame, i, len, ar[11],l=0,arr[100][100], frame_Numb=0,c=0 , frame_pages[20]= {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}, mark, j, check, page_fault=0,frame_rate;
    for(i=0; i<100; i++)
    {
        for(j=0; j<100; j++)
            arr[i][j]=-16;
    }
    char ch[200];
    printf("enter pages : \n");
    scanf("%s", ch);
    printf("\n\n");
    len=strlen(ch);
    scanf("%d", &frame_rate);
    for(i=0; i<10; i++)
    {
        ar[i]=0;
    }
    for(i=0; i<len; i++)
    {
        ar[ch[i]-48]+=1;
    }
    for(i=0; i<len; i++)
    {
        ch[i]=ch[i]-48;
        int countt=0;
        for(int k=1; k<=frame_rate; k++)
        {
            if(ch[i]==frame_pages[k])
            {
                arr[0][l]=ch[i];
                for(int m=1; m<=frame_rate; m++)
                {
                    arr[m][l]=-16;
                }
                arr[frame_rate+3][l]=72;
                l+=3;
                c++;
                page_fault++;
                break;
            }
        }
        if(c==0)
        {
            frame_Numb++;
            if(frame_Numb==frame_rate+1)
            {
                check = ar[frame_pages[1]];
                for(j=1; j<frame_rate; j++)
                {
                    if(check>ar[frame_pages[j]] )
                    {
                        check=ar[frame_pages[j]];
                        mark= j;
                        break;
                    }
                    else
                    {
                        mark=1;
                    }
                }
                arr[frame_rate+3][l]=frame_pages[mark];
                frame_pages[mark]=ch[i];
                frame_Numb--;
            }
            else
                frame_pages[frame_Numb]=ch[i];
        }
        if(c==0)
        {
            arr[0][l]=ch[i];
            for(int k=1; k<=frame_rate; k++)
            {
                arr[k][l]=frame_pages[k];
            }

            l+=3;
        }
        else c=0;
    }
    for(i=0; i<=frame_rate+3; i++)
    {
        for(j=0; j<=l+1; j++)
        {
            printf("%c", arr[i][j]+48);
        }
        printf("\n");
    }

    printf("\n\nPAGE FAULT IS %d\n", len-page_fault);
    int a;
    scanf("%d ",a);
    return 0;
}
