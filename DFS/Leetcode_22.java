/*
  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



  Example 1:

  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]
  Example 2:

  Input: n = 1
  Output: ["()"]
*/

class Solution {
    private void b(String item, int l, int r, res){
        if(l==0 && r==0){
            res.add(item);
            return;
        }
        
        if(l>0){
            generate(item+"(", l-1, r,res);
        }
        
        if(l < r){
            generate(item+")", l, r-1,res);
        }
    }
    
    public List<String> a(int n){
        List<String> res = new ArrayList<>();
        b("",n,n,res);
        return res;
    }
}
