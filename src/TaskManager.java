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

        //получить номер эпика из сабтаск
        //получить из хэшМэп нужный эпик по epicId
        //в полученный эпик нужно записать в ArrayList id сабтаски

        //----------------------------------------------------------------------

        //короткая версия
        //epics.get(subTask.getEpicId()).getSubTaskIds().add(subTask.getId());


        //длинная врсия
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




    public void getTasks(){
        for(Integer taskId : tasks.keySet()){

            System.out.println(taskId);

        }


    }








}
