package LeetCodeQuestions;

import java.util.*;

public class AlienDictionary
{
    public String alienOrder(String[] words)
    {
        HashMap<Character, Set<Character>> map = new LinkedHashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>();
        String result ="";
        if(words==null || words.length==0) return result;


        for (String s: words)
        {
            for (char c:s.toCharArray())
            {
                indegree.put(c,0);
            }
        }

        for (int i=0;i<words.length-1;i++)
        {
            String curr = words[i];
            String next = words[i+1];
            if (curr.length()>next.length() && curr.startsWith(next))
                return "";
            int len = Math.min(curr.length(),next.length());
            for (int j=0;j<len;j++)
            {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1!=c2)
                {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1))
                        set = map.get(c1);
                    if (!set.contains(c2))
                    {
                        set.add(c2);
                        map.put(c1,set);
                        indegree.put(c2,indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c: indegree.keySet())
        {
            if (indegree.get(c)==0)
                queue.offer(c);
        }

        while (!queue.isEmpty())
        {
            char c = queue.poll();
            result +=c;
            if (map.containsKey(c))
            {
                for (char x: map.get(c))
                {
                    indegree.put(x,indegree.get(x)-1);
                    if (indegree.get(x)==0)
                        queue.offer(x);
                }
            }
        }
        if (result.length()!= indegree.size())
            return "";
        return result;

    }
}
