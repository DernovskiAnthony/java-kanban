import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    InMemoryTaskManager taskManager = new InMemoryTaskManager();

    @BeforeAll
    static void createHistoryManger(){
        HistoryManager historyManager;

    }

    @Test
    void addTask() {
        Task task = new Task(0,"TestTask", "TestTask description", TaskStatus.NEW);


    }

    @Test
    void addEpic() {
    }

    @Test
    void addSubTask() {
    }

    @Test
    void getTaskById() {
    }

    @Test
    void getEpicById() {
    }

    @Test
    void getSubTaskById() {
    }

    @Test
    void getHistory() {
    }
}