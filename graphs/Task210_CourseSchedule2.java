package graphs;

import java.util.ArrayList;
import java.util.List;

// beats 99%
public class Task210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] condition : prerequisites) {
            int course = condition[0];
            int courseCondition = condition[1];

            graph.get(course).add(courseCondition);
        }

        List<Integer> result = new ArrayList<>();
        int[] visitState = new int[numCourses];


        for (int i = 0; i < graph.size(); i++) {
            if (result.size() == numCourses) {
                break;
            } else if (dfsHasCycle(result, visitState, i, graph)) {
                return new int[0];
            }
        }


        int[] arrayToReturn = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            arrayToReturn[i] = result.get(i);
        }
        return arrayToReturn;
    }

    private boolean dfsHasCycle(List<Integer> result, int[] visitState, int course, List<List<Integer>> graph) {
        if (visitState[course] == 2) {
            return false;
        } else if (visitState[course] == 1) {
            return true;
        }

        if (graph.get(course).isEmpty()) {
            result.add(course);
            visitState[course] = 2;
            return false;
        }

        visitState[course] = 1;

        for (int i = 0; i < graph.get(course).size(); i++) {
            int condition = graph.get(course).get(i);
            if (dfsHasCycle(result, visitState, condition, graph)) {
                return true;
            }
        }

        result.add(course);
        visitState[course] = 2;
        return false;
    }
}
