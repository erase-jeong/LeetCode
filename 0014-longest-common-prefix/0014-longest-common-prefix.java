class Solution {
    public String longestCommonPrefix(String[] strs) {

        //최소 길이 구하기
        int minL=201;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minL) minL=strs[i].length();
        }
        System.out.println("minL :"+minL);

        //prefix구하기
        String prefix="";
        int idx=0;
        while(idx<minL){
            //String curr=strs[i].charAt(idx);
            boolean flag=true;
            for(int i=0;i<strs.length-1;i++){
                if(strs[i].charAt(idx)!=strs[i+1].charAt(idx)){
                    flag=false;
                    break;
                }
            }
            if(flag) prefix+=strs[0].charAt(idx);
            else break; //불일치 나오면 더 볼 필요가 없음!!
            idx++;
        }

        return prefix;
    }
}

