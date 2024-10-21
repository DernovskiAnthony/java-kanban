import java.util.ArrayList;

public class InMemoryHistoryManager  implements HistoryManager{



    private ArrayList<Task> watchedTasks;


    @Override
    public ArrayList<Task> getHistory() {
        return watchedTasks;
    }

    @Override
    public void add(Task task) {
        watchedTasks = new ArrayList<>(10);
        if(watchedTasks.size() > 10){
            watchedTasks.remove(0);
        } else {
            watchedTasks.add(task);
        }
    }
}
