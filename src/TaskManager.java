import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private int nextId = 1;

    //Возможность хранить задачи всех типов

    public void addTask(Task task){
        task.setId(nextId);
        nextId++;
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic epic){
        epic.setId(nextId);
        nextId++;
        epics.put(epic.getId(), epic);

    }

    public void addSubTask(SubTask subTask) {
        subTask.setId(nextId);
        nextId++;

        subTasks.put(subTask.getId(), subTask);

        Integer epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);

        List<Integer> subTaskIds = epic.getSubTaskIds();

        Integer subTaskId = subTask.getId();
        subTaskIds.add(subTaskId);
    }

    //a) получение списка всех задач

    public List<String> getAllTasks(){
        List<String> allTasks = new ArrayList<>();

        for(Task t : tasks.values()){
            allTasks.add(t.getName());

        }
        return allTasks;
    }

    public List<String> getAllEpics(){
        List<String> allEpics = new ArrayList<>();

        for(Epic t : epics.values()){
            allEpics.add(t.getName());

        }
        return allEpics;
    }

    public List<String> getAllSubTasks(){
        List<String> allSubTasks = new ArrayList<>();

        for(SubTask t : subTasks.values()){
            allSubTasks.add(t.getName());

        }
        return allSubTasks;
    }

    //b) удаление всех задач

    public void deleteAllTasks(){
        tasks.clear();
    }

    public void deleteAllEpics(){
        epics.clear();
    }

    public void deleteAllSubTasks(){
        subTasks.clear();
    }


    //с) получение по идентификатору

    public Task getTaskById(int taskId){
        if(tasks.containsKey(taskId)){
            return tasks.get(taskId);
        }
        System.out.println("Задачи с идентификатором " + taskId + " не существует!");
        return null;
    }

    public Epic getEpicById(int epicId){
        if(epics.containsKey(epicId)){
            return epics.get(epicId);
        }
        System.out.println("Эпика с идентификатором " + epicId + " не существует!");
        return null;
    }


    public SubTask getSubTaskById(int subTaskId){
        if(subTasks.containsKey(subTaskId)){
            return subTasks.get(subTaskId);
        }
        System.out.println("Подзадачи с идентификатором " + subTaskId + " не существует!");
        return null;
    }

    //f) удаление по идентификатору
    public void deleteTaskById(int taskId){
        tasks.remove(taskId);

        }

    public void deleteEpicById(int epicId){
        epics.remove(epicId);
    }

    public void deleteSubTaskById(int subTaskId){
        subTasks.remove(subTaskId);
    }

    //e) обновление задачи

    public void updateTask(Task task){
        tasks.put(task.getId(), task);

    }

    public void updateEpic(Epic epic){
        epics.put(epic.getId(), epic);

    }

    public void updateSubTask(SubTask subTask) {
        subTask.setId(nextId);
        nextId++;

        subTasks.put(subTask.getId(), subTask);

        Integer epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);

        List<Integer> subTaskIds = epic.getSubTaskIds();

        Integer subTaskId = subTask.getId();
        subTaskIds.add(subTaskId);
    }



}
