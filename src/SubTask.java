public class SubTask extends Task{

    private int epicId;

    public SubTask(int epicId, int id, String name, String description, TaskStatus status) {
        super(id, name, description, status);
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicId=" + epicId +
                '}';
    }

    public int getEpicId() {
        return epicId;
    }
}
