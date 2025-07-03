import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.*;
//Rita Yousif
public class GreedyAlgorithm {
       // The greedy algorithm class has a function called greedy with the parameters of internSkillsMap
       // and projectSkills. This returns a hashmap keys as intern names and values as the projects.
       // Therefore, the main logic contains the definition of a stack, which stores an entry of the internSkillsMap.
       // Go through the stack while it is not empty and pop the element (internWithSkill) each time and loop over
       // the array of project skills . Then, check if the skillsWithProjectMap has a project with that skill and
       // the intern does not have a project assigned to them previously, and if so, then assign it to the intern.
        public HashMap greedy(HashMap<String, Set<String>> internSkillsMap, HashMap<String, Project> skillsWithProjectsMap, String [] projectSkills) {
                HashMap<String, Project> internWithProjectMap = new HashMap<>();
                Stack<Map.Entry<String, Set<String>>> stack = new Stack<>();
                for (Map.Entry<String, Set<String>> entry : internSkillsMap.entrySet()) {
                        stack.push(entry);
                }
                while (!stack.isEmpty()) {
                        Map.Entry<String, Set<String>> internWithSkill = stack.pop();
                        for (String skill : projectSkills) {
                                if (skillsWithProjectsMap.get(skill) != null && internWithSkill.getValue().contains(skill)) {
                                        internWithProjectMap.put(internWithSkill.getKey(), skillsWithProjectsMap.get(skill));
                                        break;
                                }
                        }
                }
                return internWithProjectMap;
        }
}

