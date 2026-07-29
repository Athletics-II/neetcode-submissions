class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char[] letters = new char[26];
            for (int i=0; i<str.length(); i++) {
                letters[str.charAt(i)-'a']++;
            }
            String s = Arrays.toString(letters);
            mp.putIfAbsent(s, new ArrayList<>());
            mp.get(s).add(str);
        }

        return new ArrayList<>(mp.values());
    }
}
