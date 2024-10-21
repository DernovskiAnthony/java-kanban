public class Managers {


    TaskManager getDefault(){

        TaskManager taskManager = new InMemoryTaskManager();
        return taskManager;

    }

    static HistoryManager getDefaultHistory(){
        return new InMemoryHistoryManager();
    }

}
