class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();       //소문자로 변환
        s=s.replaceAll("[^a-z0-9]","");   //영어, 숫자 제외하고 제거

        int left=0;
        int right=s.length()-1;
        
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}