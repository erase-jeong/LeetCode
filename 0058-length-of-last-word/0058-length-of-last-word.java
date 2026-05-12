class Solution {
    public int lengthOfLastWord(String s) {
        //문자열 배열로 쪼갠다
        //맨 마지막 문자열의 길이를 출력한다
        String[] arr=s.split(" "); //구분자를 인자로
        return arr[arr.length-1].length();
    }
}