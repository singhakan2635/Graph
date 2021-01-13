package GraphBuilder;

import java.util.*;


public class GraphBuilder
    {
        HashMap<Integer, List<Integer>> mapInt;

        public GraphBuilder() {
            this.mapInt = new HashMap<>();
        }

        public void addEdge(int n, int edge)
        {
            if (!mapInt.containsKey(n))
            {
                mapInt.put(n,new LinkedList<>());
            }
            if (!mapInt.containsKey(edge))
            {
                mapInt.put(edge,new LinkedList<>());
            }
            mapInt.get(n).add(edge);
            mapInt.get(edge).add(n);
        }
        public int getFanOuts(int n)
        {
            return mapInt.get(n).size();
        }

        public int getEdge(int n,int i)
        {
            return mapInt.get(n).get(i);
        }
        public int getSize()
        {
            return mapInt.size();
        }

        public void printGraph()
        {
            for (Map.Entry<Integer,List<Integer>> entry: mapInt.entrySet())
            {
                System.out.println("Node "+ entry.getKey()+" -> " + entry.getValue());
            }
        }
    }


