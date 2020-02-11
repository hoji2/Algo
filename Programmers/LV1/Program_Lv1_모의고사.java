class Program_Lv1_모의고사 {
    public int[] solution(int[] answers) {
        
        int []one={1,2,3,4,5};
        int []sec={2,1,2,3,2,4,2,5};
        int []thir={3,3,1,1,2,2,4,4,5,5};
        
        int v1=0,v2=0,v3=0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i]==one[i%5])
                v1++;
            if(answers[i]==sec[i%8])
                v2++;
            if(answers[i]==thir[i%10])
                v3++;
        }
        
        int max=Math.max(v1,Math.max(v2,v3));
        int size=0;
        
        if(v1==max)
            size++;
        if(v2==max)
            size++;
        if(v3==max)
            size++;
        
        int[]arr=new int[size];
        int cnt=0;
        
        if(v1==max)
            arr[cnt++]=1;
        if(v2==max)
            arr[cnt++]=2;
        if(v3==max)
            arr[cnt++]=3;
        
        return arr;
    }
}