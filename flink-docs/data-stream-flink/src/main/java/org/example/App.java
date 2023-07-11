package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
/*
        try {
            int nums[]={0,3,1,3,3,3,0,1,0,2,0,3,1,3,-3,2,0,3,1,2,2,-3,2,2,3,3};
            Map<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(mp.containsKey(nums[i])==true){
                    mp.put(nums[i],mp.get(nums[i])+1);
                    System.out.println("if condition "+nums[i]+"   "+mp.get(nums[i]));
                }else{
                    mp.put(nums[i],1);
                    System.out.println("else condition "+nums[i]+"   "+mp.get(nums[i]));
                }
            }
            List<Integer> arr=new ArrayList<>();
            for(Map.Entry<Integer,Integer> kmp:mp.entrySet()){
                arr.add(kmp.getKey());
            }
//            Arrays.sort
            Collections.sort(arr);
            System.out.println("---------------");
            arr.stream().forEach(e->{
                System.out.print(e+" ");
            });
            System.out.println();
            int count=0;
            for(int i=0;i<arr.size()-1;i++){
                if(arr.get(i+1)-arr.get(i)==1){
                    int local_count=0;
                    local_count+=mp.get(arr.get(i));
                    local_count+=mp.get(arr.get(i+1));
                    count=Math.max(local_count,count);
                }
            }
            System.out.println("final count : "+count);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

 */
        HashSet<String> st=new HashSet<>();
        st.add("hello");
        st.add("world");
        st.stream().forEach(e->{
            System.out.println(e);
        });
    }
}
