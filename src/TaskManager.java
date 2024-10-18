
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TaskManager {

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private int nextId = 1;

    //Возможность хранить задачи всех типов

    public void addTask(Task task){
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        System.out.println(tasks);
    }

    public void addEpic(Epic epic){
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
        System.out.println(epics);

    }

    public void addSubTask(SubTask subTask) {
        subTask.setId(nextId++);
        subTasks.put(subTask.getId(), subTask);

        Integer epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);

        List<Integer> subTaskIds = epic.getSubTaskIds();

        Integer subTaskId = subTask.getId();
        subTaskIds.add(subTaskId);



        for(Integer itemId : subTaskIds){
            ArrayList<TaskStatus> checkStatusOfEpic =  new ArrayList<>();
            TaskStatus anItem = subTasks.get(itemId).getStatus();
            checkStatusOfEpic.add(anItem);
            if(checkStatusOfEpic.contains(TaskStatus.IN_PROGRESS)){
                epic.setStatus(TaskStatus.IN_PROGRESS);
            } else {
                for(TaskStatus status : checkStatusOfEpic){
                    int statusNew = 0;
                    int statusDone = 0;
                    if(status.equals(TaskStatus.NEW)){
                        statusNew++;
                } else if(status.equals(TaskStatus.DONE){
                        statusDone++;
                    }
                    if(statusDone == checkStatusOfEpic.size()){
                        epic.setStatus(TaskStatus.DONE);
                    } else{
                        epic.setStatus(TaskStatus.NEW);
                    }
                }
        }


        }
    }

    //a) получение списка всех задач

    public List<Task> getAllTasks(){
        List<Task> allTasks = new ArrayList<>();

        for(Task t : tasks.values()){
            allTasks.add(t);

        }
        return allTasks;
    }

    public List<Epic> getAllEpics(){
        List<Epic> allEpics = new ArrayList<>();

        for(Epic t : epics.values()){
            allEpics.add(t);

        }
        return allEpics;
    }

    public List<SubTask> getAllSubTasks(){
        List<SubTask> allSubTasks = new ArrayList<>();

        for(SubTask t : subTasks.values()){
            allSubTasks.add(t);

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
        subTask.setId(nextId++);

        subTasks.put(subTask.getId(), subTask);

        Integer epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);

        List<Integer> subTaskIds = epic.getSubTaskIds();

        Integer subTaskId = subTask.getId();
        subTaskIds.add(subTaskId);

        for(Integer itemId : subTaskIds){
            ArrayList<TaskStatus> checkStatusOfEpic =  new ArrayList<>();
            TaskStatus anItem = subTasks.get(itemId).getStatus();
            checkStatusOfEpic.add(anItem);
            if(checkStatusOfEpic.contains(TaskStatus.IN_PROGRESS)){
                epic.setStatus(TaskStatus.IN_PROGRESS);
            } else {
                for(TaskStatus status : checkStatusOfEpic){
                    int statusNew = 0;
                    int statusDone = 0;
                    if(status.equals(TaskStatus.NEW)){
                        statusNew++;
                    } else if(status.equals(TaskStatus.DONE){
                        statusDone++;
                    }
                    if(statusDone == checkStatusOfEpic.size()){
                        epic.setStatus(TaskStatus.DONE);
                    } else{
                        epic.setStatus(TaskStatus.NEW);
                    }
                }
            }


        }


    }



}
