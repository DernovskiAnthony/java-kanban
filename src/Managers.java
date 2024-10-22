public class Managers {


    private TaskManager getDefault(){
        return new InMemoryTaskManager();
    }

    private static HistoryManager getDefaultHistory(){
        return new InMemoryHistoryManager();
    }

}
