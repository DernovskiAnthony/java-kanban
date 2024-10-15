public class SubTask extends Task{

    private int epicId;

    public SubTask(int id, String name, String description, TaskStatus status) {
        super(id, name, description, status);
    }

    public int getEpicId() {
        return epicId;
    }
}
