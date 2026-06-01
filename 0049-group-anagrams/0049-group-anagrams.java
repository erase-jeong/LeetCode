class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer=new ArrayList<>();
        String[] sorted=new String[strs.length];
        Set<String> set=new HashSet<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            s=new String(arr);
            sorted[i]=s;
            set.add(s);
        }

        for(String x: set){
            System.out.println(x);
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<strs.length;i++){
                if(x.equals(sorted[i])){
                    tmp.add(strs[i]);
                }
            }
            answer.add(tmp);
        }

        return answer; 
    }
}
