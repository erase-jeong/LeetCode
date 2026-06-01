class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sMap=new HashMap<>();
        HashMap<Character,Integer> tMap=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            sMap.put(ch,sMap.getOrDefault(ch,1)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            tMap.put(ch,tMap.getOrDefault(ch,1)+1);
        }

        System.out.println("sMap : "+sMap);
        System.out.println("tMap : "+tMap);

        return sMap.equals(tMap);

    }
}

/*
map1, map2 동일한지 체크하기
=> 근데 어떻게 체크?
HashMap? TreeMap?

*/