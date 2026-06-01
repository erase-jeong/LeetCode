class Solution {
    public boolean isPalindrome(String s) {
        

        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        System.out.println(s);
        int n=s.length();
        boolean flag=true;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)) flag=false; 
        }
        return flag;
    }
}

/*
자바 String에서 
1. 대문자 -> 소문자로 바꾸기
2. 영문자 아닌 모든 문제 제거하기

*/