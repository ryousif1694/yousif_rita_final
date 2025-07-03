

import java.util.*;
import java.time.LocalDate;
//Rita Yousif
public class Main {
    public static void main(String[] args) {
        double begin=System.nanoTime();
        //Hash Map creation named projectMap where it creates a key of project and a string array , which is the
        // value of the hash map that are for the skills needed for the project.
        HashMap<Project, String[]> projectMap = new HashMap<>();
        //this is the declaration of the projects with their dates of starting days and endings days
       Project firstProject= new Project(
               LocalDate.of(2026,5,12),
               LocalDate.of(2026,5,22), "firstProject");
        Project secondProject= new Project(
                LocalDate.of(2026,5,12),
                LocalDate.of(2026,5,22), "secondProject");
        Project thirdProject= new Project(
                LocalDate.of(2026,5,12),
                LocalDate.of(2026,5,22), "thirdProject");
        Project fourthProject= new Project(
                LocalDate.of(2026,5,12),
                LocalDate.of(2026,5,22), "fourthProject");
        //this is the requirements of skills for each of the projects
        projectMap.put(firstProject, new String[]{"Arabic", "English"});
        projectMap.put(secondProject, new String[]{"English"});
        projectMap.put(thirdProject, new String[]{"Spanish"});
        projectMap.put(fourthProject, new String[]{"French"});
        //this for loop would iterate through the projectMap that makes a return of a set of keys and values from
        //the map where the key is the object of the project adn values are array of the skills needed
        // which links each project to its needed skill.
        for (Map.Entry<Project, String[]> entry : projectMap.entrySet()) {
            System.out.println("Key: " + entry.getKey().projectName+
                    ", Value: " + Arrays.toString(entry.getValue()));
        }
        //this hash map is made for the intern skills where it contains the key as the name of the intern
        //and the value as the set of string of skills that the intern acquires to know the skills of each intern
        //this would be used to give the intern project using their skills.
        HashMap<String, Set<String>> internSkillsMap = new HashMap<>();
        // this would add to the internSkillsMap the skills of the intern to the intern using their name
        internSkillsMap.put("internA", new HashSet<>(Set.of("English", "Spanish")));
        internSkillsMap.put("InternB", new HashSet<>(Set.of("Arabic", "Chaldean")));
        internSkillsMap.put("internC", new HashSet<>(Set.of("Spanish", "French")));
        internSkillsMap.put("internD", new HashSet<>(Set.of("Turkish", "Protugese")));
        //This is another hash map that is made to make a connection between the skills of the intern and the project
        //that needs that skill.
        HashMap<String, Project> skillsWithProjectsMap = new HashMap<>();
        //This is initialization of projectSkills array in the form of strings where it contains skills for the project
        //I need for all projects where it would give projects to interns using these skills
        String projectSkills[] = {"Arabic", "English", "Chaldean", "Spanish", "French"};
        //this would see if the skill has been given to a project
        Boolean given = false;
        //Basically, this would iterate throughout the projectSkills for each skill, then check projects in map to
        //know if there is a skill needed for that project and then check if there is project that needs a skill to add
        //that to the skillsWithProjectMap in the form of an entry
        //then when a project has a matching skill that is needed for the projectSkill, it gives that project and breaks
        //in order to not give multiple projects using that skill.
        //Then, each of the skills with the project it has get to be printed
        for (String skill : projectSkills) {
            for (Map.Entry<Project, String[]> entry : projectMap.entrySet()) {
                for (String projectSkill : entry.getValue()) {
                    if (projectSkill.equals(skill)) {
                        skillsWithProjectsMap.put(projectSkill, entry.getKey());
                        given = true;
                        break;
                    }
                    if(given) {
                        break;
                    }
                }
            }
        }
        for (Map.Entry<String, Project> entry : skillsWithProjectsMap.entrySet()) {
            System.out.println(entry.getKey() + " →  [ " + entry.getValue().projectName + " ]" );

        }
        //this is using the greedy algorithm where the alg is being used as an instance
        // it is calling the greedy algoirthm function

        GreedyAlgorithm alg = new GreedyAlgorithm();
        HashMap<String, Project> project1Map = alg.greedy(internSkillsMap, skillsWithProjectsMap, projectSkills);

        //this iterating through the project1Map and printing the intern name with the project
        for (Map.Entry<String, Project> entry : project1Map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue().projectName + " → " + entry.getValue().startTime
                    + " → " + entry.getValue().endTime);
        }
        double stop=System.nanoTime();
        double time=stop-begin;

        System.out.println("The runtime of the code is " + time + " in nanoseconds");

    }

}












