package leetcode;

import java.sql.Array;
import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
//        int numCourses = 2;
//        int [][] preReqs = {{0,1}};
//        int numCourses = 3;
//        int [][] preReqs = {{1,0}, {2,1}};
          int numCourses = 2;
          int [][] preReqs = {{0,1}, {1,0}};
        System.out.println(  canFinish(numCourses, preReqs));
        System.out.println(canFinishDFS(numCourses, preReqs));
    }

    public static boolean canFinishDFS(int numCourses, int [][] prerequisites){
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] finished = new boolean[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < prerequisites.length; i++){
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(!dfs(adjList,visited,finished, i)) return false;
        }
        return true;

    }

    private static boolean dfs(ArrayList<Integer> [] adjList, boolean[] visited, boolean[] finished,  int course){
        if(finished[course]) return true;
        if(visited[course]) return false; //if visited again ...! cycle !!!

        visited[course] = true;
        for(int i = 0 ; i < adjList[course].size(); i++){
            if(!dfs(adjList, visited, finished, adjList[course].get(i))){
                return false;
            }
        }
        finished[course] = true;
        visited[course] = false;
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Course> coursesToTake = new LinkedList<>();
        Queue<Course> completed = new LinkedList<>();
        Course [] courses = new Course[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            courses[i] = new Course(i);
        }

        for(int [] pair : prerequisites){
            int course = pair[0];
            int preReq = pair[1];
            courses[preReq].addNextCourse(course);
            courses[course].addPreReqCount();
        }

        for(int i = 0 ; i < numCourses; i++){
            if(courses[i].getPreReqCount() == 0) coursesToTake.add(courses[i]);
        }

        while(!coursesToTake.isEmpty()){
            Course course = coursesToTake.poll();
            for(Integer c : course.getNextCourses()){
                courses[c].minusPreReqCount();
                if(courses[c].getPreReqCount() == 0) coursesToTake.add(courses[c]);
            }
            completed.add(course);
        }
        if(completed.size() == numCourses) return true;
        else return false;
    }
}

class Course{
    int num;
    int preReqs = 0;

    ArrayList<Integer> nextCourses = new ArrayList<>();

    public Course(int num){
        this.num = num;
    }

    public void addNextCourse(int course){
        nextCourses.add(course);
    }

    public void addPreReqCount(){
        preReqs++;
    }

    public void minusPreReqCount(){
        preReqs--;
    }

    public int getPreReqCount(){
        return this.preReqs;
    }

    public ArrayList<Integer> getNextCourses(){
        return nextCourses;
    }

    public int getNum(){
        return this.num;
    }

}
