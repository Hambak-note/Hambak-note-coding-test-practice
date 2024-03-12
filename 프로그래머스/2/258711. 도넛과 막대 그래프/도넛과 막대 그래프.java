import java.util.*;


class Solution {

        private int generatedVertex;

        private int numberOfGraph;
        private int numberOfDonut;
        private int numberOfStick;
        private int numberOfEight;

        private Map<Integer, Integer> ins = new HashMap<>();
        private Map<Integer, Integer> outs = new HashMap<>();
        private Set<Integer> vertices = new HashSet<>();



        public int[] solution(int[][] edges) {

            for (int[] edge : edges) {
                int out = edge[0];
                int in = edge[1];

                if(ins.containsKey(in)) {
                    int count = ins.get(in);
                    ins.put(in, count+1);
                } else {
                    ins.put(in, 1);
                }

                if(outs.containsKey(out)) {
                    int count = outs.get(out);
                    outs.put(out, count+1);
                } else {
                    outs.put(out, 1);
                }

                vertices.add(out);
                vertices.add(in);
            }

            findGeneratedVertex();
            findEight();
            findStick(edges);
            findDonut();
            System.out.println(numberOfDonut);



            return new int[]{generatedVertex, numberOfDonut, numberOfStick, numberOfEight};
        }

        private void findGeneratedVertex() {

            for (Integer out : outs.keySet()) {
                int count = outs.get(out);
                if(count >= 2 && !ins.containsKey(out)) {
                    generatedVertex = out;
                    numberOfGraph = outs.get(out);
                    return;
                }
            }
        }

        private void findEight() {

            for (Integer in : ins.keySet()) {
                int inCount = ins.get(in);
                if(inCount == 2 || inCount == 3) {
                    if(outs.containsKey(in) && outs.get(in) == 2) {
                        numberOfEight++;
                    }
                }
            }
        }

        private void findStick(int[][] edges) {

            for (int[] edge : edges) {
                int out = edge[0];
                int in = edge[1];
                if(out == generatedVertex) {
                    int inCount = ins.get(in);
                    if(inCount == 1) ins.remove(in);
                }
            }

            for (Integer vertex : vertices) {
                if(!ins.containsKey(vertex) && vertex != generatedVertex) {
                    numberOfStick++;
                }
            }
        }

        private void findDonut() {
            numberOfDonut = numberOfGraph - (numberOfStick + numberOfEight);
        }
    }