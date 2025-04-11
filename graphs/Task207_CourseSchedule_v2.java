package graphs;

import java.util.ArrayList;
import java.util.List;
// beats 99.9% runtime - 3 ms
public class Task207_CourseSchedule_v2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] conditionPair : prerequisites) {
            int course = conditionPair[0];
            int condition = conditionPair[1];

            graph.get(course).add(condition);
        }

        int[] visitationReference = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visitationReference[i] == 0 && hasCycles(visitationReference, i, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycles(int[] visitationReference, int course, List<List<Integer>> graph) {
        if (visitationReference[course] == 2) {
            return false;
        } else if (visitationReference[course] == 1) {
            return true;
        }

        visitationReference[course] = 1;

        for (int i = 0; i < graph.get(course).size(); i++) {
            int condition = graph.get(course).get(i);
            if (hasCycles(visitationReference, condition, graph)) {
                return true;
            }
        }

        visitationReference[course] = 2;
        return false;
    }
}
