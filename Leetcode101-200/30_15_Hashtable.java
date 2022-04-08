/**
        02.从两数之和进行引申，三数之和可以转化 求两数之和。 
        1）还是需要一次遍历，从i开始，我们寻找满足j+k =（0-i）对应情况下j和k的值，这样就转化为了两数之和的计算方式
     */
    List<List<Integer>> method05(int[] nums){
      //处理特殊情况
      if(nums.length<3) return new ArrayList<List<Integer>>();//实例化只需要最外层指定具体实现集合类
      List<List<Integer>> res = new ArrayList<List<Integer>>();//初始化结果集合
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int target = -nums[i];
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j=i+1;j<nums.length;) {
                //如果存在元素满足条件，执行以下逻辑
                if(set.contains(target-nums[j])){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(target-nums[j]);
                    res.add(tmp);
                    //如果寻找到解，那么不需要将nums[j]加入set，因为此时已经将nums[j]作为答案赋值给res了，nums[j]已经不可能和其他元素搭配组成答案了。
                    //寻找到一个解，如果下一个元素值和当前值一样，那么会出现一个重复的答案，所以直接跳过，直到出现不一样的元素
                    j++;
                    while(j<nums.length&&nums[j]==nums[j-1]){
                        j++;
                    }
                }else{
                    //如果当前元素不存在，同时也不满足解条件，那么将当前元素加入set
                    set.add(nums[j++]);
                }
            }
        }
            return res;
        }

