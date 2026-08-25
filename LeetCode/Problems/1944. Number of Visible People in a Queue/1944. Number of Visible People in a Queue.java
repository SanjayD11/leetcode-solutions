
   public int[] canSeePersonsCount(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[heights.length];
    result[heights.length-1]=0;
    stack.push(heights.length-1);
    for(int i=heights.length-2;i>=0;i--){
      if(!stack.isEmpty() && heights[i]>heights[stack.peek()]){
        int count=0;
        int lastMax=0;
        while(!stack.isEmpty() && heights[i]>heights[stack.peek()]){
          if(heights[stack.peek()]>lastMax) count++;
          lastMax=Math.max(lastMax,heights[stack.peek()]);
          stack.pop();
        }
        if(stack.isEmpty()) result[i]=count;
        else { result[i]=count+1;}

      }else{
        result[i]=1;
      }
      stack.push(i);
    }
    return result;
    }

