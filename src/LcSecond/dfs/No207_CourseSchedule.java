package LcSecond.dfs;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/course-schedule/">课程表</a>
 **/
public class No207_CourseSchedule {

    int[] course;
    HashMap<Integer, ArrayList<Integer>> memo;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        memo = new HashMap<>();
        for (int[] preCourse : prerequisites) {
            int cur = preCourse[0];
            int pre = preCourse[1];
            memo.putIfAbsent(cur, new ArrayList<>());
            memo.get(cur).add(pre);
        }

        course = new int[numCourses];
        // 默认所有课程都没学
        Arrays.fill(course, -1);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                // 任意一门课不能学，则直接返回false
                return false;
            }
        }
        return true;
    }

    /**
     * 查看指定的课程是否可以学
     *
     * @param target
     * @return
     */
    public boolean dfs(int target) {
        if (!memo.containsKey(target) || course[target] == 1) {
            // 如果没有要求，直接返回可以学
            course[target] = 1;
            return true;
        }
        course[target] = 2;
        ArrayList<Integer> preCourses = memo.get(target);
        for (Integer item : preCourses) {
            // 如果前置课程不可学 或者 前置课程处于学习中(有环)，不可学
            if (course[item] == 0 || course[item] == 2) {
                course[target] = 0;
                return false;
            }
            if (!dfs(item)) {
                course[target] = 0;
                return false;
            }
        }
        memo.remove(target);
        course[target] = 1;
        return true;
    }

    @Test(description = "")
    public void test0() throws Exception {
        int numCourse = 2;
        int[][] prerequisites = new int[1][2];
        prerequisites[0] = new int[]{1, 0};
        System.out.println(canFinish(numCourse, prerequisites));
    }

    @Test(description = "")
    public void test() throws Exception {
        int numCourse = 2;
        int[][] prerequisites = new int[2][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{0, 1};
        System.out.println(canFinish(numCourse, prerequisites));
    }
}
