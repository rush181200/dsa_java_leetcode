class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans  = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0,s,ans,path);
        return ans;
    }

    public void solve(int ind, String s,List<List<String>> ans,  List<String> path){

        if(ind == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=ind;i<s.length();++i){
            if(isPalin(s,ind,i)){
                path.add(s.substring(ind,i+1));
                solve(i+1,s,ans,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalin(String s,int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
         return true;
    }
}